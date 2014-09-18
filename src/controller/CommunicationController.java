/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import db.DbManager;
import db.DbManager0;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Messaggio;
import model.user.Proposta;
import model.user.PropostaConfermata;
import model.user.SistemaCifratura;
import model.Studente;
import model.UserInfo;

/**
 *
 * @author MASTER
 */
public class CommunicationController extends Controller{
    public static boolean inviaProposta(String id_user, String id_partner, SistemaCifratura sdc){ //invio della proposta di cifratura
        Proposta p = new Proposta(0, new UserInfo(id_user), new UserInfo(id_partner), sdc);
        p.save();
        return true;
    }
    
    public static Proposta[] getProposte(String id_user) { //proposte pendenti
        ArrayList<Proposta> result = new ArrayList<>();
        
        try {
          DbManager0 db = DbManager0.getInstance();

          Query q = db.createQuery("SELECT * FROM `cryptohelper`.`proposta` WHERE id_destinatario = " + id_user + " && stato = 'in attesa'");
          QueryResult rs = db.execute( q );

          while( rs.next() ) {
            UserInfo ui1 = new UserInfo( rs.getString(2) );
            UserInfo ui2 = new UserInfo( rs.getString(2) );
            SistemaCifratura sc = SistemaCifratura.load( rs.getString(4) );

            result.add( new Proposta( rs.getInt(1), ui1, ui2, sc ) );
          }
        } catch( SQLException ex ) {
          throw new RuntimeException( ex.getMessage(), ex );
        }
        
        return result.toArray( new Proposta[result.size()] );
    }
    
    public static PropostaConfermata[] getProposteAccettate(String id_user){ //proposte pendenti
        /*DbManager db = connect();
        PropostaConfermata[] p;
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`proposta` WHERE id_mittente = " + id_user + " && stato = 'accettata'");
        if(v.size()<= 0) return new PropostaConfermata[0];
        else{
            p = new PropostaConfermata[v.size()];
            for(int i = 0; i < v.size(); i++){
                p[i] = new PropostaConfermata(Integer.parseInt(((String[])v.elementAt(i))[0]), new UserInfo(((String[])v.elementAt(i))[1]), new UserInfo(((String[])v.elementAt(i))[2]), SistemaCifratura.load(((String[])v.elementAt(i))[3]));
            }
            return p;
        }*/
        ArrayList<PropostaConfermata> result = new ArrayList<>();
        
        try {
          DbManager0 db = DbManager0.getInstance();

          Query q = db.createQuery("SELECT * FROM `cryptohelper`.`proposta` WHERE id_mittente = " + id_user + " && stato = 'accettata'");
          QueryResult rs = db.execute( q );

          while( rs.next() ) {
            UserInfo ui1 = new UserInfo( rs.getString(2) );
            UserInfo ui2 = new UserInfo( rs.getString(3) );
            SistemaCifratura sc = SistemaCifratura.load( rs.getString(4) );

            result.add( new PropostaConfermata( rs.getInt(1), ui1, ui2, sc ) );
          }
        } catch( SQLException ex ) {
          throw new RuntimeException( ex.getMessage(), ex );
        }
        
        return result.toArray( new PropostaConfermata[result.size()] );
    }
    
    public static boolean inviaDecisione(Proposta p, String decisione){
        if(decisione.equals("accettata"))
            p.accetta();
        else p.rifiuta();
        return true;
    }
    
    public boolean getAccettazione(String user){
        return true;
    }
    
    public Studente[] getDestinatari(){
        return new Studente[4];
    }
    
    public static boolean send(Messaggio m){
        m.send();
        System.out.println(m);
        return true;
    }
    
    public Messaggio apriMessaggioRicevuto(int id){
        return new Messaggio();
    }
    
}
