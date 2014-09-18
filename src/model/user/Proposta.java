/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import controller.Controller;
//import static controller.Controller.connect;
import db.DbManager;
import db.DbManager0;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import model.UserInfo;

/**
 *
 * @author MASTER
 */
public class Proposta {
    protected int id;
    protected UserInfo proponente, partner;
    protected String stato;
    protected SistemaCifratura s;
    protected boolean notificata;
    
    public Proposta(int id, UserInfo proponente, UserInfo partner, SistemaCifratura sdc){
        this.id = id;
        this.proponente = proponente;
        this.partner = partner;
        this.s = sdc;
        this.stato = "in attesa";
    }
    
    public Proposta(){
        /*query result*/
    }
    
    public SistemaCifratura getSdc(){
        return this.s;
    }
    
    public UserInfo getPartner(){
        return this.partner;
    }
    
    public boolean save(){
        /*DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`proposta` (`id`, `id_mittente`, `id_destinatario`, `idsistemacifratura`, `stato`, `notificata`) VALUES (NULL, '" +this.proponente.getId()+"', '"+this.partner.getId()+"', '" + Integer.parseInt(this.s.getId()) + "', 'in attesa', NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        System.out.println("sgsgf");
        return true;*/
        try{
            DbManager0 db = DbManager0.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`proposta` (`id`, `id_mittente`, `id_destinatario`, `idsistemacifratura`, `stato`, `notificata`) VALUES (NULL, '" +this.proponente.getId()+"', '"+this.partner.getId()+"', '" + Integer.parseInt(this.s.getId()) + "', 'in attesa', NULL);");
            q.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        return true;
    }
    
    public boolean accetta(){
        return Controller.accettaProposta(this);
    }
    
    public boolean rifiuta(){
        return Controller.rifiutaProposta(this);
    }
    
    public static void load(int id){
        
    }
    
    public  static void caricaAttiva(int idProp, int idPartner){
        
    }
    
    public int getId(){
        return this.id;
    }
    
    /*public String getMetodo(){
        return this.
    }*/
    
    public String toString(){
        return "Utente con id " + proponente.getId() + " vuole scambiare un messaggio utilizzando " + s.getSdc();
    }
    
}
