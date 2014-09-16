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
public class Mappatura {
    private char[] mappa = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] mappaInversa;
    
    public char[] getMap(){
        return this.mappa;
    }
    
    public char[] getInverseMap(){
        return this.mappaInversa;
    }
    
    public char[] map(String c){
        int chiave = Integer.parseInt(c);
        mappaInversa = new char[mappa.length];
        for(int i=0; i<mappa.length; i++){
            mappaInversa[i] = (char)(((int)(mappa[i]) + chiave));
        }
        return mappaInversa;
    }
    
    public char[] inverseMap(String c){
        return new char[4];
    }
    
    public String toString(){
        String s = "";
        for(int i=0; i<mappa.length; i++){
            s += mappa[i];
        }
        s += "\n";
        for(int i=0; i<mappa.length; i++){
            s += mappaInversa[i];
        }
        s += "\n";
        return s;
    }
}
