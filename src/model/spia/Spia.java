package model.spia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.GenericSelector;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author user
 */
public class Spia extends Studente {

    public Spia(String user) {
        super(user);
    }
    public Spia( String user, String password ){
        super( user, password );
    }
    public Spia(String nome, String cognome, String id, String user, String password){
      super( nome, cognome, id, user, password );
    }
    
    public Sessione startNewSessione( Messaggio selectedMsg ) {
      Sessione s = new Sessione(this, selectedMsg);
      s.start();
      return s;
    }
    
    public Sessione restoreSessione() {
      try {
        Sessione recuperata = Sessione.recuperaSessione(this);
        Sessione s = Sessione.restoreSessione( recuperata );
        return s;
      } catch (SQLException ex) {
        throw new RuntimeException( ex.getMessage(), ex );
      }
    }
    
    public Sessione deleteSessione() {
      try {
        Sessione s = Sessione.recuperaSessione( this );
        Sessione.deleteSessione( s );
        return s;
      } catch (SQLException ex) {
        throw new RuntimeException( ex.getMessage(), ex );
      }
    }
    
}
