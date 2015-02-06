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
        //Mappatura m = new Mappatura();
        int chiave = Integer.parseInt(c);
        //mappaInversa = new char[mappa.length];
        for(int i=0; i<mappa.length; i++){
            /*if ((mappa[i]+chiave)<= 'z')
                mappaInversa[i] = (char)((mappa[i] + chiave)); //riempie mappa inversa fino a z
            else{
                for (int j = 0; j < chiave; j++)
                    mappaInversa[i++] = (char)(mappa[j]); //riempie mappa inversa da 'a' fino alla dimensione dello s
            }*/
                mappaInversa[i] = (char)(mappa[(i + chiave)%26]);
        }
        //return mappaInversa;*/
        return new Mappatura(mappaInversa);
    }
}
