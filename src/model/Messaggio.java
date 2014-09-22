/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import db.DbManager;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.user.Cifratore;
import model.user.SistemaCifratura;

/**
 *
 * @author MASTER
 */
public class Messaggio implements MessaggioMittente, MessaggioDestinatario {
    private int id;
    private UserInfo mittente, destinatario;
    private SistemaCifratura sdc;
    private String testo, testoCifrato, lingua, titolo;
    private boolean bozza, letto;
    
    public Messaggio(QueryResult rs) throws SQLException {
        this.id = rs.getInt(1);
        this.mittente = new UserInfo(rs.getString(2));
        this.destinatario = new UserInfo(rs.getString(3));
        this.testo = rs.getString(4);
        this.lingua = rs.getString(6);
        this.testoCifrato = rs.getString(5);
        this.sdc = SistemaCifratura.load( rs.getString("idsistemacifratura") ); 
        this.bozza = rs.getBoolean(8);
        this.letto = rs.getBoolean(9); 
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
    
    public static List<Messaggio> caricaIniviati(Studente s){
        return null;
    }
    
    public static List<Messaggio> caricaBozze(Studente s){
        return null;
    }
    
    public static List<Messaggio> getMessaggi(){
        ArrayList<Messaggio> result = new ArrayList<>();
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("SELECT * FROM `cryptohelper`.`messaggio`");
            QueryResult rs = db.execute(q);
            while( rs.next() ){
                
                result.add( new Messaggio(rs) );
            }
        }
        catch (SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
        return result;
    }
    
    public static MessaggioDestinatario[] caricaRicevuti(){
        ArrayList<MessaggioDestinatario> result = new ArrayList<>();
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("SELECT * FROM `messaggio` WHERE id_destinatario = " + Studente.getLoggato().getId());
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
    }
    
    public boolean elimina(){
        return true;
    }
    
    public void setBozza(boolean b){
        this.bozza = b;
    }
    
    public void cifra(){
        this.getSdc().calcolaMappatura(); //sdc ha ora un oggetto mappatura
        this.testoCifrato = Cifratore.cifra(this.getTesto(), this.getSdc().getMappatura()); 
    }
    
    public boolean isBozza(){
        return true;
    }
    
    public boolean save(){
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`messaggio` (`id`, `id_mittente`, `id_destinatario`, `testo`, `testoCifrato`, `lingua`, `titolo`, `bozza`, `letto`) VALUES (NULL, '" +this.getMittente().getId()+"', '"+this.getDestinatario().getId()+"', '" + this.getTesto() + "', '" + this.getTestoCifrato() + "' , '" + this.getLingua() + "', 'titoloDiProva', " + this.isBozza() + ", false);");
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
    
    private String toStringF = "Messaggio in lingua: %lingua% inviato da utente con id %mittenteID% ad utente con id %destinatario% e testo: %testo%";
    public String setToStringF( String f ) {
        String result = getToStringF();
        this.toStringF = f;
        return result;
    }
    public String toString(){
        String result = getToStringF();
        result = result.replaceAll("%lingua%", getLingua());
        result = result.replaceAll("%mittenteID%", getMittente().getId());
        result = result.replaceAll("%destinatarioID%", getDestinatario().getId());
        result = result.replaceAll("%testo%", getTesto());
        result = result.replaceAll("%testoCif%", getTestoCifrato());
        return result; 
    }
    
    public boolean send(){
        this.setBozza(false);
        this.save();
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the mittente
     */
    public UserInfo getMittente() {
        return mittente;
    }

    /**
     * @return the destinatario
     */
    public UserInfo getDestinatario() {
        return destinatario;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @return the testoCifrato
     */
    public String getTestoCifrato() {
        return testoCifrato;
    }

    /**
     * @return the lingua
     */
    public String getLingua() {
        return lingua;
    }

    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @return the toStringF
     */
    public String getToStringF() {
        return toStringF;
    }
    
}
