/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//import static controller.Controller.connect;
import db.DbManager;
import db.DbManager0;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author MASTER
 */
public class SistemaCifratura {
    private String id;
    private String chiave;
    private String metodo;
    private UserInfo creatore;
    private CalcolatoreMappatura c;
    private Mappatura m;
    
    public String toString(){
        return "Sistema di cifratura: creato da " + creatore.getId() + ", cifratura con " + metodo + " e chiave " + chiave;
    }
    
    public static void caricaSistemaCifratura(Studente s){
        
    }
    
    public Mappatura getMappatura(){
        return this.m;
    }
    
    /*public static SistemaCifratura load(String user1, String user2){
        
        return new SistemaCifratura();
    }*/
    
    public static SistemaCifratura load(String id){
        /*DbManager db = connect();
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`sistemacifratura` WHERE id = '" + id + "'");
        return new SistemaCifratura(((String[])v.elementAt(0))[0], ((String[])v.elementAt(0))[1], ((String[])v.elementAt(0))[2], new UserInfo(((String[])v.elementAt(0))[3]));*/
        try{
            DbManager0 db = DbManager0.getInstance();
            Query q = db.createQuery("SELECT * FROM `cryptohelper`.`sistemacifratura` WHERE id = '" + id + "'");
            QueryResult rs = db.execute(q);
            rs.next();
            return new SistemaCifratura(rs.getString(1), rs.getString(2), rs.getString(3), new UserInfo(rs.getString(4)));
        }
         catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
    }
    
    public String getSdc(){
        return this.metodo;
    }
    
    public String getId(){
        return this.id;
    }
    public SistemaCifratura(String id, String chiave, String metodo){
        this.id = id;
        this.chiave = chiave;
        this.metodo = metodo;
    }
    
    public SistemaCifratura(String id, String chiave, String metodo, UserInfo creatore){
        this.id = id;
        this.chiave = chiave;
        this.metodo = metodo;
        this.creatore = creatore;
    }
    
    public SistemaCifratura(String chiave, String metodo){
        this.chiave = chiave;
        this.metodo = metodo;
        this.creatore = new UserInfo(Session.getIdLoggedUser()); 
        try{
            DbManager0 db = DbManager0.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`sistemacifratura` (`id`, `chiave`, `metodo`, `idcreatore`) VALUES (NULL, '" +chiave+"', '"+metodo+"', '" + Session.getIdLoggedUser() + "')");
            q.executeUpdate();
            q = db.createQuery("SELECT * FROM `cryptohelper`.`sistemacifratura` ORDER BY id DESC");
            QueryResult rs = db.execute(q);
            rs.next();
            this.id = rs.getInt(1) + "";
        }
         catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        /*DbManager db = connect();
        System.out.println("INSERT INTO `cryptohelper`.`sistemacifratura` (`id`, `chiave`, `metodo`, `idcreatore`) VALUES (NULL, '" +chiave+"', '"+metodo+"', '" + Session.getIdLoggedUser() + "')");
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`sistemacifratura` (`id`, `chiave`, `metodo`, `idcreatore`) VALUES (NULL, '" +chiave+"', '"+metodo+"', '" + Session.getIdLoggedUser() + "')")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
        }
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`sistemacifratura` ORDER BY id DESC");
        this.id = (((String[])v.elementAt(0))[0]);
        */
    }
    
    public SistemaCifratura(){
        /*query result*/
    }
    
    public String prova(String testo){
        return "";
    }
    
    public void calcolaMappatura(){
        switch(metodo) {
            case "Sistema di cesare":
                c = new CalcolatoreCesare();
                break;
            case "Pseudocasuale":
                c = new CalcolatorePseudocasuale();
                break;
            case "Parola chiave":
                c = new CalcolatoreParolaChiave();
                break;
            default:
                break;
        }
        this.m = c.calcola(this.chiave);
        System.out.println(m);
    }
    
    public void save(){
        
    }
}
