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
public class CalcolatorePseudocasuale implements CalcolatoreMappatura{
    
    /*private String chiave;
    
    
    public CalcolatorePseudocasuale(String c){
        this.chiave = c;
    }*/
    
    public Mappatura calcola(String s){
        //s = calcolaParolaChiave(s);
        //System.out.println(s);
        CalcolatoreParolaChiave calcParChiave = new CalcolatoreParolaChiave();
        return calcParChiave.calcola(s);
    }

    public String calcolaParolaChiave(String s) {
        int length = Integer.parseInt(s);
        s="";
        java.util.Random rand = new java.util.Random(); //estraggo un numeri compresi tra 0 e 25 (122-97 -> lettere minuscole dalla z alla a)
        for (int i = 0; i<length; i++){
            int x = rand.nextInt(25)+97;
            s += (char) x;
        }
        return s;
    }
}
