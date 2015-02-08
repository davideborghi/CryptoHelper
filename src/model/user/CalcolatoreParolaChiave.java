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
public class CalcolatoreParolaChiave implements CalcolatoreMappatura{
    
    /*private String c;
    
    public CalcolatoreParolaChiave(String c){
        this.c = c;
    }*/
    
    public Mappatura calcola(String s){
        System.out.println("parola chiave" + s);
        s = eliminaDoppie(s);
        System.out.println("parola chiave senza doppie" + s);
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++){
            mappaInversa[i] = s.charAt(i); //assegna i caratteri della stringa s
            lastIndex = i;
        }
        //devo partire dall'ultimo carattere della parola chiave e andare in ordine alfabetico togliendo i caratteri della pseudocasuale
        char last = s.charAt(s.length()-1); //prendo l'ultimo carattere della stringa
        int j = lastIndex+1;
        do{
            mappaInversa[j] = mappa[j];
            j++;
        }
        while(last!=s.charAt(mappa[j]));
        for (int i = s.length(); i < mappaInversa.length; i++){
            
        }
        //return new Mappatura();
        return null;
    }
    
    /**
     * il cifratore a parola chiave ha bisogno di eliminare eventuali doppie dalla parola chiave
     * @param s stringa iniziale
     * @return String senza doppie
     */
    public String eliminaDoppie(String s){
        String senzaDoppie=""; 
        for (int i = 0; i < s.length(); i++){
            if (senzaDoppie.indexOf(s.charAt(i)) == -1) //controllo se il singolo carattere della parola chiave è già stato inserito
                senzaDoppie+=s.charAt(i);               //se non è stato trovato lo stesso carattere, allora aggiungo il carattere alla parola chiave
        }
        return senzaDoppie;
    }
}
