package model.spia;

import GUI.GenericSelector;
import GUI.spia.CicloDiAnalisi;
import db.DbManager;
import db.Query;
import db.QueryResult;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
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

  public static Sessione recuperaSessione(Studente s) throws SQLException {
    Sessione result = null;
    ArrayList<String> optionList = new ArrayList<>();

    //seleziona la key di una sessione salvata
    DbManager db = DbManager.getInstance();
    Query q = db.createQuery("SELECT `key` FROM `Sessione` WHERE `userId` = ?");
    q.setString(1, s.getId());
    QueryResult rs = db.execute(q);
    while (rs.next()) {
      optionList.add(rs.getString("key"));
    }
    String key = GenericSelector.selectOptions(optionList);

    //In base alla key scelta deserializza la Sessione dal database
    Query u = db.createQuery("SELECT `sessione` FROM `Sessione` WHERE `userId` = ? AND `key` = ? LIMIT 1");
    u.setString(1, s.getId());
    u.setString(2, key);
    QueryResult qr = db.execute(u);

    if (qr.next()) {
      result = qr.getObject("sessione", Sessione.class);
    }
    return result;
  }

  public static Sessione startNewSessione() {
    List<Messaggio> options = Messaggio.getMessaggi();
    for (Messaggio m : options) {
      m.setToStringF("%lingua%, %testoCif%");
    }
    Messaggio selectedMsg = GenericSelector.selectOptions(options);
    Sessione s = new Sessione(selectedMsg);
    s.start();
    return s;
  }

  public static Sessione restoreSessione(Sessione s) {
    s.start();
    return s;
  }

  public static void deleteSessione(Sessione sessione) {
    try {
      DbManager db = DbManager.getInstance();
      Query q = db.createQuery("DELETE FROM `Sessione` WHERE `id` = ? AND `userId` = ?");
      q.setString(1, Studente.getLoggato().getId());
      q.setInt(2, sessione.id);
      QueryResult rs = db.execute(q);

    } catch (SQLException ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  public static void saveSession(Sessione sessione) {
    try {
      DbManager db = DbManager.getInstance();
      Query q = db.createQuery("INSERT INTO `Sessione`(`userId`,`key`,`session`) VALUES( ?, ?, ? )");
      q.setString(1, Studente.getLoggato().getId());
      q.setString(2, sessione.key);
      q.setObject(3, sessione);
      QueryResult rs = db.execute(q);

    } catch (SQLException ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  private int id;
  private String key;

  private Ipotesi root;
  private Ipotesi ipCorrente;

  private Messaggio messaggio;

  public Sessione(Messaggio m) {
    this.messaggio = m;
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
    try {
      wait();
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
    System.out.println("SALVARE SESSIONE");
  }
}
