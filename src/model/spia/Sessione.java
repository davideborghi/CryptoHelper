package model.spia;


import GUI.GenericSelector;
import java.util.List;
import model.Messaggio;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Sessione {
    
    public static class Properties extends java.util.Hashtable<String, Object> {}
    
    public static Sessione startNewSessione() {
        List<Messaggio> options = Messaggio.getMessaggi();
        for( Messaggio m: options ) {
            m.setToStringF("%lingua%, %testoCif%");
        }
        return new Sessione( GenericSelector.selectOptions( options ) );
    }
    
    public static Sessione restoreSessione() {
        //DO CODE
        return new Sessione( (Properties)null );
    }
    public static void deleteSessione( Sessione sessione ) {
        //DO CODE
    }
    
    public static void saveSession( Sessione sessione ) {
        //DO CODE
    }
    
    
    private Ipotesi root;
    private Ipotesi ipCorrente;
    
    private Properties properties;
    
    public Sessione( Properties p ) {
        this.properties = p;
    }
    public Sessione( Messaggio m ) {
        this( new Properties() );
        this.properties.put("messaggio", m);
    }
    
    public Ipotesi getIpotesiRadice() {
        return root;
    }
    public Ipotesi getIpotesiCorrente() {
        return ipCorrente;
    }
    public Properties getProperties() {
        return properties;
    }
    
    public void start() {
        //DO CODE
    }
}
