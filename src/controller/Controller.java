/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import db.DbManager;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Studente;
import model.UserInfo;
import model.user.Proposta;
/**
 *
 * @author MASTER
 */
public class Controller {
    
    /*public static DbManager connect(){
        DbManager db = new DbManager("cryptohelper", "root", "root");
        if (!db.connetti()) {
            System.out.println("Errore durante la connessione.");
            System.out.println(db.getErrore());
            System.exit(0);
        }
        return db;
    }*/
    
    
    
    /*public static boolean inserisciProposta(UserInfo user, UserInfo partner, String sdc){
        DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`proposta` (`id`, `id_mittente`, `id_destinatario`, `metodo_cifratura`, `stato`, `notificata`) VALUES (NULL, '" +user.getId()+"', '"+partner.getId()+"', '" + sdc + "', 'in attesa', NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        
        return true;
    }*/
    
    public static boolean accettaProposta(Proposta p){
        //DbManager db = connect();
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("UPDATE `cryptohelper`.`proposta` SET `stato` = 'accettata' WHERE `proposta`.`id` = " + p.getId());
            q.executeUpdate();
        }
        catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        /*if (!db.eseguiAggiornamento("UPDATE `cryptohelper`.`proposta` SET `stato` = 'accettata' WHERE `proposta`.`id` = " + p.getId())) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }*/
        return true;
    }
    
    public static boolean rifiutaProposta(Proposta p){
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("UPDATE `cryptohelper`.`proposta` SET `stato` = 'rifiutata' WHERE `proposta`.`id` = " + p.getId());
            q.executeUpdate();
        }
        catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        /*if (!db.eseguiAggiornamento("UPDATE `cryptohelper`.`proposta` SET `stato` = 'accettata' WHERE `proposta`.`id` = " + p.getId())) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }*/
        return true;
    }
    
    /*public static boolean nuovoMessaggio(String id_destinatario){
        DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`messaggio` (`id`, `id_mittente`, `id_destinatario`, `metodo_cifratura`, `stato`, `notificata`) VALUES (NULL, '" +user.getId()+"', '"+partner.getId()+"', '" + sdc + "', 'in attesa', NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        
        return true;
    }*/
    
    
    
    
    public static UserInfo[] recuperaUtenti( Studente s ){
        ArrayList<UserInfo> result = new ArrayList<>();
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("SELECT * FROM user where username <> '" + s.getId() + "'");
            QueryResult rs = db.execute( q );
            while( rs.next() ) {
                String id = rs.getString(1);
                String user = rs.getString(2);
                result.add( new UserInfo( id, user  ) );
            }
        }
        catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        return result.toArray( new UserInfo[result.size()] );
    }
}
