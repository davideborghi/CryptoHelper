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
public class Cifratore {
    public static String cifra(String testo, Mappatura map){
        String testoCifrato = "";
        char c;
        for(int i=0; i<testo.length(); i++){    //per ogni carattere del testo
            c = testo.charAt(i);                //prende il char in posizione i
            if((int)c==32){                     //se convertito in int vale 32 allora è uno spazio
                testoCifrato += " ";
            }
            else{
                for(int j=0; j<map.getMap().length; j++){
                    if(map.getMap()[j] == c)                    //scorri la mappatura, cerca la posizione di c
                        testoCifrato += map.getInverseMap()[j]; //quando lo trova in posizione j aggiunge il carattere cifrato di c al testo cifrato
                        //break;
                }
            }
        }
        return testoCifrato;
       
    }
    
    public static String decifra(String testo, Mappatura map){
        return "";
    }
}
