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
    private String nome;
    private String cognome;
    private String id;
    private String login;
    private String pwd;
    private DbManager DbManager0;
    
    public Studente(String user){
        this.login = user;
    }
    
    public Studente(String id, String user){
        this.id = id;
        this.login = user;
    }
    
    public Studente(String nome, String cognome, String id, String user, String password){
        this.login = user;
        this.pwd = password;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }
    
    public Studente(String user, String password, boolean b){
        this.login = user;
        this.pwd = password;
    }
    
    public boolean login(){
        /*DbManager db = connect();
        System.out.println(login + " " + pwd);
        Vector v = db.eseguiQuery("SELECT * FROM user WHERE username = '"+this.login+"' and password = '"+this.pwd+"';");
        if(v.size() <= 0) return false;
        String s = ((String[])v.elementAt(0))[0];
        this.id = s;
        return true;*/
        try{
            DbManager db = DbManager0.getInstance();
            Query q = db.createQuery("SELECT * FROM user WHERE username = '"+this.login+"' and password = '"+this.pwd+"';");
            QueryResult rs = db.execute(q);
            rs.next();
            if(rs.wasNull()) return false;
            this.id = rs.getInt("id")+"";
            return true;
        }
         catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
    }
    
    public boolean registra(){
        
        /*DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`user` (`username`, `password`, `nome`, `cognome`) VALUES ('" +this.login+"', '"+this.pwd+"', NULL, NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
        }

        // Ora chiudo la connessione col Database:
        db.disconnetti();*/
        try{
            DbManager db = DbManager0.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`user` (`username`, `password`, `nome`, `cognome`) VALUES ('" +this.login+"', '"+this.pwd+"', NULL, NULL);");
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
        return this.login;
    }
}
