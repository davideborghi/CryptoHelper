/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author MASTER
 */
public class Cifratore {
    public static String cifra(String testo, Mappatura map){
        String testoCifrato = "";
        char c;
        for(int i=0; i<testo.length(); i++){  //per ogni carattere del testo
            c = testo.charAt(i);
            if((int)c==32){
                testoCifrato += " ";
            }
            else{
                for(int j=0; j<map.getMap().length; j++){
                    if(map.getMap()[j] == c)
                        testoCifrato += map.getInverseMap()[j];
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
