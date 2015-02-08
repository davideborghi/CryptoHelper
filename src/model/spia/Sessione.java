package model.spia;

import GUI.GenericSelector;
import GUI.PopUpViewer;
import GUI.spia.CicloDiAnalisi;
import db.DbManager;
import db.Query;
import db.QueryResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import model.Messaggio;
import model.Studente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Sessione extends Observable implements Serializable {
  
  public static class Properties extends java.util.Hashtable<String, Object> {
  }

  public static Sessione recuperaSessione(Spia owner) throws SQLException {
    Sessione result = null;
    ArrayList<String> optionList = new ArrayList<>();

    //seleziona la key di una sessione salvata
    DbManager db = DbManager.getInstance();
    Query q = db.createQuery("SELECT `key` FROM `Sessione` WHERE `userId` = ?");
    q.setString(1, owner.getId());
    QueryResult rs = db.execute(q);
    while (rs.next()) {
      optionList.add(rs.getString("key"));
    }
    String key = GenericSelector.selectOptions(optionList);

    //In base alla key scelta deserializza la Sessione dal database
    Query u = db.createQuery("SELECT `id`, `session` FROM `Sessione` WHERE `userId` = ? AND `key` = ? LIMIT 1");
    u.setString(1, owner.getId());
    u.setString(2, key);
    QueryResult qr = db.execute(u);

    if (qr.next()) {
      
      try {
      ByteArrayInputStream bais;
      ObjectInputStream ins;
      bais = new ByteArrayInputStream(qr.getBytes("session"));
      ins = new ObjectInputStream(bais);
      result =(Sessione)ins.readObject();
      
      } catch( IOException | ClassNotFoundException ex ) {
        throw new RuntimeException( ex.getMessage(), ex );
      }
      
      result.id = qr.getInt("id");
      result.owner = owner;
      
      Query w = db.createQuery("SELECT * FROM `messaggio` WHERE `id` = ?");
      w.setInt(1, result.messaggioID);
      QueryResult qu = db.execute( w );
      
      if( qu.next() ) {
        result.messaggio = new Messaggio( qu );
      } else {
        throw new RuntimeException("il messaggion con id "+result.messaggioID+"non è stato trovato nel database");
      }
      
    }
    return result;
  }

  public static Sessione restoreSessione(Sessione s) {
    s.start();
    return s;
  }

  public static void deleteSessione(Sessione sessione) {
    try {
      DbManager db = DbManager.getInstance();
      Query q = db.createQuery("DELETE FROM `Sessione` WHERE `id` = ? AND `userId` = ?");
      q.setInt(1, sessione.id);
      q.setString(2, sessione.owner.getId());
      db.executeUpdate(q);

    } catch (SQLException ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  public static void saveSessione(Sessione sessione) {
    
    //i set a null sono essenziali per la serializzazione della classe
    Spia owner = sessione.owner;
    sessione.owner = null;
    sessione.messaggioID = sessione.messaggio.getId();
    sessione.messaggio = null;
       
    try {
      
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      oos.writeObject(sessione);
      oos.flush();
      oos.close();
      bos.close();
      byte[] data = bos.toByteArray();
    
      DbManager db = DbManager.getInstance();
      Query q = db.createQuery("INSERT INTO `Sessione`(`userId`,`key`,`session`) VALUES( ?, ?, ? ) ON DUPLICATE KEY UPDATE `session` = ?");
      q.setString(1, owner.getId());
      q.setString(2, sessione.key);
      q.setObject(3, data);
      q.setObject(4, data);
      
      db.executeUpdate(q);
      System.out.println("Sessione salvata correttamente");
    } catch (IOException | SQLException ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  private int id;
  private String key;
  private Spia owner;

  private Ipotesi root;
  private Ipotesi ipCorrente;

  private int messaggioID; //utilizzato per recuperare il messaggio deserializzato
  private Messaggio messaggio;

  public Sessione(Spia owner, Messaggio m) {
    this.messaggio = m;
    this.messaggioID = m.getId();
    
    this.owner = owner;
    
    this.key = new java.sql.Timestamp(new java.util.Date().getTime()).toString();
    
    this.root = new Ipotesi("radice", m.getTestoCifrato());
    this.ipCorrente = this.root;
  }

  public Ipotesi getIpotesiRadice() {
    return root;
  }

  public Ipotesi getIpotesiCorrente() {
    return ipCorrente;
  }
  public void setIpotesiCorrente( Ipotesi ip ) {
    this.ipCorrente = ip;
    this.setChanged();
    this.notifyObservers();
  }

  public Messaggio getMessaggio() {
    return this.messaggio;
  }

  public void add( Ipotesi nuova ) {
    this.ipCorrente.add( nuova );
    ipCorrente = nuova;
    
    this.setChanged();
    this.notifyObservers();
  }
  public synchronized void start() {

    final Sessione self = this;
    new Thread(new Runnable() {
      public void run() {
        new CicloDiAnalisi(self).setVisible(true);
      }
    }).start();
    
    try { wait(); }
    catch (InterruptedException ex) { throw new RuntimeException(ex.getMessage(), ex); }
    
    try {
      saveSessione( this );
      new PopUpViewer("la sessione è stata salvata").setVisible(true);
    } catch( RuntimeException ex ) {
      new PopUpViewer("La sessione non è stata salvata: \n\n"+ex.getMessage()).setVisible(true);
      throw ex;
    }
    
  }
}
