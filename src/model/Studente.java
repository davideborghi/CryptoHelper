/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//import static controller.Controller.connect;
import db.DbManager;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;

/**
 *
 * @author MASTER
 */
public class Studente {
  
    private static Studente loggato = null;
    
    public static void setLoggato( Studente s ) {
      loggato = s;
    }
    public static Studente getLoggato() {
      return loggato;
    }
    
    private String nome;
    private String cognome;
    private String id;
    private String login;
    private String pwd;
    private DbManager DbManager0;
    
    public Studente(String user){
        this.login = user;
    }
    
    public Studente(String nome, String cognome, String id, String user, String password){
        this.login = user;
        this.pwd = password;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }
    
    public Studente(String user, String password){
        this.login = user;
        this.pwd = password;
    }
    
    public boolean login(){
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("SELECT * FROM user WHERE username = ? and password = ?");
            q.setString(1, this.getLogin());
            q.setString(2, this.getPwd());
            
            QueryResult rs = db.execute(q);
            if( rs.next() ) {
              this.id = rs.getString("id");
              this.loggato = new Studente("", "", this.id, this.getLogin(), this.getPwd());
            return true;
            } else {
              return false;
            }
        }
         catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
    }
    
    public static boolean registra(String nome, String password){
        
        /*DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`user` (`username`, `password`, `nome`, `cognome`) VALUES ('" +this.login+"', '"+this.pwd+"', NULL, NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
        }

        // Ora chiudo la connessione col Database:
        db.disconnetti();*/
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`user` (`username`, `password`, `nome`, `cognome`) VALUES ('" +nome+"', '"+password+"', NULL, NULL);");
            q.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        return true;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String toString(){
        return this.getLogin();
    }

  /**
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * @return the cognome
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * @return the login
   */
  public String getLogin() {
    return login;
  }

  /**
   * @return the pwd
   */
  public String getPwd() {
    return pwd;
  }

  /**
   * @return the DbManager0
   */
  public DbManager getDbManager0() {
    return DbManager0;
  }
}
