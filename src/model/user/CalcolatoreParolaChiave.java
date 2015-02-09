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
        for (int i = 0; i < s.length(); i++){
            mappaInversa[i] = s.charAt(i); //assegna i caratteri della stringa s
        }
        //devo partire dall'ultimo carattere della parola chiave e andare in ordine alfabetico togliendo i caratteri della pseudocasuale
        int position = searchCharInArray(s.charAt(s.length()-1)); //prendo l'indice dell'ultimo carattere della stringa
        
        //comincio il ciclo dalla prima cella vuota della mappatura inversa che corrisponde con la lunghezza della stringa
        Mappatura m = new Mappatura (mappaInversa);
        int j = position, i = s.length(); 
        // j usato per ciclare sulla mappa
        // i usato per ciclare sulla mappaInversa
        j++;
        System.out.println("carattere della mappa da cui iniziare" + mappa[position]);
        while (i < mappaInversa.length){
            System.out.println("Mappatura in posizione " + j + "\n" +m.toString());
            System.out.println("carattere letto " + mappa[j] + " " +s.indexOf(mappa[j]));
            //System.out.println(s.charAt(mappa[j]));
            if (s.indexOf(mappa[j]) == -1){        //se il carattere letto non era nella parola chiave
                mappaInversa[i] = mappa[j];     // aggiungilo alla mappatura
                System.out.println("aggiunto in posizione "+i);
                i++;
            }
            else {
                System.out.println("non aggiunto");
            }
            if (j == mappa.length-1)   //se sono arrivato in fondo alla mappa originale
                j=0;                //ricomincio con la mappatura dall'inizio
            else
                j++;                //altrimenti prosegui semplicemente
        }
        return new Mappatura(mappaInversa);
    }
    /**
     * metodo ausialiario per la ricerca della posizione del carattere nella mappa
     * @param c
     * @return posizione del carattere nella mappa, -1 se non esiste
     */
    private int searchCharInArray(char c){
        for (int i = 0; i < mappa.length; i ++){
            if (mappa[i]==c)
                return i;
        }
        return -1;
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
