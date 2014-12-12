/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

//import static controller.Controller.connect;
import db.DbManager;
import db.DbManager;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import java.util.Vector;
import model.Studente;
import model.UserInfo;

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
        return "Sistema di cifratura: creato da " + creatore.getId() + ", cifratura con " + this.metodo + " e chiave " + this.chiave;
    }
    
    public static void caricaSistemaCifratura(Studente s){
        /** TODO **/
    }
    
    public Mappatura getMappatura(){
        return this.m;
    }
    
    
    public static SistemaCifratura load(String id){
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("SELECT * FROM `cryptohelper`.`sistemacifratura` WHERE id = '" + id + "'");
            QueryResult rs = db.execute(q);
            if( rs.next() ) {
                return new SistemaCifratura(rs.getString(1), rs.getString(2), rs.getString(3), new UserInfo(rs.getString(4)));
            } else {
                return null;
            }
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
    public void setCreatore( UserInfo creatore ) {
      this.creatore = creatore;
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
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`sistemacifratura` (`id`, `chiave`, `metodo`, `idcreatore`) VALUES (NULL, '" +chiave+"', '"+metodo+"', '" + creatore.getId() + "')");
            q.executeUpdate();
            q = db.createQuery("SELECT * FROM `cryptohelper`.`sistemacifratura` ORDER BY id DESC");
            QueryResult rs = db.execute(q);
            rs.next();
            this.id = rs.getInt(1) + "";
        }
         catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
    }
}
