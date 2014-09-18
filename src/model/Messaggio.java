/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.user.Cifratore;
import model.user.SistemaCifratura;
import static controller.Controller.*;
import db.DbManager;
import db.DbManager0;
import db.Query;
import db.QueryResult;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author MASTER
 */
public class Messaggio implements MessaggioMittente, MessaggioDestinatario{
    private int id;
    private UserInfo mittente, destinatario;
    private SistemaCifratura sdc;
    private String testo, testoCifrato, lingua, titolo;
    private boolean bozza, letto;
    
    public Messaggio(){
        /*QUERY RESULT*/
    }
    
    public Messaggio(String testo, String lingua, UserInfo mittente, UserInfo destinatario){
        this.testo = testo;
        this.lingua = lingua;
        this.mittente = mittente;
        this.destinatario = destinatario;
    }
    
    public Messaggio(String testo, String lingua, UserInfo mittente, UserInfo destinatario, SistemaCifratura sdc){
        this.testo = testo;
        this.lingua = lingua;
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.sdc = sdc;
    }
    
    public void setLingua(String l){
        this.lingua = l;
    }
    
    public void setTesto(String text){
        this.testo = text;
    }
    
    public void setDestinatario(UserInfo d){
        this.destinatario = d;
    }
    
    public void setMittente(UserInfo m){
        this.mittente = m;
    }
    
    public SistemaCifratura getSdc(){
        return this.sdc;
    }
    
    public void setSdc(SistemaCifratura s){
        this.sdc = s;
    }
    
    /*public static Messaggio load(int id){
        DbManager db = connect();
        Messaggio m;
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`messaggio` WHERE id = " + id);
        if(v.size()<= 0) return new Messaggio();
        else{
            p = new Proposta[v.size()];
            for(int i = 0; i < v.size(); i++){
                p[i] = new Proposta(Integer.parseInt(((String[])v.elementAt(i))[0]), new UserInfo(Integer.parseInt(((String[])v.elementAt(i))[1])), new UserInfo(Integer.parseInt(((String[])v.elementAt(i))[2])), ((String[])v.elementAt(i))[3]);
            }
            //return v;
        }
    }//carica il messaggio*/
    
    public static List caricaIniviati(Studente s){
        return new List();
    }
    
    public static List caricaBozze(Studente s){
        return new List();
    }
    
    public static MessaggioDestinatario[] caricaRicevuti(){
        ArrayList<MessaggioDestinatario> result = new ArrayList<>();
        try{
            DbManager0 db = DbManager0.getInstance();
            Query q = db.createQuery("SELECT * FROM `cryptohelper`.`messaggio` WHERE id_destinatario = " + Session.getIdLoggedUser());
            QueryResult rs = db.execute(q);
            while( rs.next() ){
                UserInfo mittente = new UserInfo(rs.getString(2));
                UserInfo destinatario = new UserInfo(rs.getString(3));
                String testo = rs.getString(4);
                String lingua = rs.getString(6);
                result.add(new Messaggio(testo, lingua, mittente, destinatario));
            }
        }
        catch (SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        return result.toArray( new MessaggioDestinatario[result.size()] );
        /*DbManager db = connect();
        MessaggioDestinatario[] m;
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`messaggio` WHERE id_destinatario = " + Session.getIdLoggedUser());
        if(v.size()<= 0) return new MessaggioDestinatario[0];
        else{
            m = new MessaggioDestinatario[v.size()];
            for(int i = 0; i < v.size(); i++){
                m[i] = new Messaggio(((String[])v.elementAt(i))[3], ((String[])v.elementAt(i))[5], new UserInfo(((String[])v.elementAt(i))[1]), new UserInfo(((String[])v.elementAt(i))[2]));
            }
            return m;
        }*/
    }
    
    public boolean elimina(){
        return true;
    }
    
    public void setBozza(boolean b){
        this.bozza = b;
    }
    
    public void cifra(){
        //SistemaCifratura.load(this.mittente, this.destinatario);
        this.sdc.calcolaMappatura(); //sdc ha ora un oggetto mappatura
        this.testoCifrato = Cifratore.cifra(this.testo, this.sdc.getMappatura()); 
    }
    
    public boolean isBozza(){
        return true;
    }
    
    public boolean save(){
        /*DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`messaggio` (`id`, `id_mittente`, `id_destinatario`, `testo`, `testoCifrato`, `lingua`, `titolo`, `bozza`, `letto`) VALUES (NULL, '" +this.mittente.getId()+"', '"+this.destinatario.getId()+"', '" + this.testo + "', '" + this.testoCifrato + "' , '" + this.lingua + "', 'titoloDiProva', " + this.bozza + ", false);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        System.out.println("sgsgf");
        return true;*/
        try{
            DbManager0 db = DbManager0.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`messaggio` (`id`, `id_mittente`, `id_destinatario`, `testo`, `testoCifrato`, `lingua`, `titolo`, `bozza`, `letto`) VALUES (NULL, '" +this.mittente.getId()+"', '"+this.destinatario.getId()+"', '" + this.testo + "', '" + this.testoCifrato + "' , '" + this.lingua + "', 'titoloDiProva', " + this.bozza + ", false);");
            q.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        return true;
    }
    
    public boolean isLetto(){
        return true;
    }
    
    public String toString(){
        return "Messaggio in lingua:" + lingua + "inviato da utente con id " + this.mittente.getId() + " ad utente con id " + this.destinatario.getId() + " e testo: " + this.testo;
    }
    
    public boolean send(){
        this.setBozza(false);
        this.save();
        return true;
    }
    
}
