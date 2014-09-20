/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.spia.supportTools.analisiFrequenze;
import java.util.HashMap;
/**
 *
 * @author davide
 */
public class AnalisiFrequenze {
    private HashMap<Character, Integer> table;
    private int msgLength;
    public void start (String msg) {
        table = new HashMap<Character, Integer>();
//        msg = msg.toLowerCase();
        msg = msg.replaceAll("\\s", ""); /*rimuove gli spazi*/
        this. msgLength = msg.length();
        System.out.println(msg);
        for(int i = 0; i < msg.length(); i++){
            Character c = msg.charAt(i);
            if (table.containsKey(c)){
                Integer occorrenze = (Integer)table.get(c)+1;
                table.put(c, occorrenze);
            }
            else{
                table.put(c, new Integer(1));
            }
        }
        System.out.println(/*table + " size " + */this.toString());
    }
    public String toString() {
        String frequencyTable = "Numero lettere nel messaggio " + this.getMsgLength()+"\n";
        for(Character currentKey : table.keySet()){
            Integer occurence =table.get(currentKey);
            frequencyTable += currentKey + " numero occorrenze " + occurence + " percentuale " + (double)occurence/this.getMsgLength()*100+"\n";
        }
        return frequencyTable;
        //return table.size()+" numero lettere "+this.getMsgLength();
    }
    public int getMsgLength(){
        return this.msgLength;
    }
    
}
