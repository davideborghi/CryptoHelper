/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

/**
 *
 * @author MASTER
 */
public class CalcolatoreCesare implements CalcolatoreMappatura {
    //private String chiave;
    
    /*public CalcolatoreCesare(String c){
        this.chiave = c;
    }*/
    
    public Mappatura calcola(String c){
        Mappatura m = new Mappatura();
        m.map(c);
        return m;
    }
}
