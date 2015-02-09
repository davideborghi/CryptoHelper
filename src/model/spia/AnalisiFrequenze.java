/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.spia;
import java.util.HashMap;
/**
 *
 * @author davide
 */
public class AnalisiFrequenze implements StrumentoDiSupporto {
    private HashMap<Character, Integer> table;
    private int msgLength;
    
    @Override
    public void start (String messaggio) {
        table = new HashMap<Character, Integer>();
//        msg = msg.toLowerCase();
        messaggio = messaggio.replaceAll("\\s", ""); /*rimuove gli spazi*/
        this. msgLength = messaggio.length();
        System.out.println(messaggio);
        for(int i = 0; i < messaggio.length(); i++){
            Character c = messaggio.charAt(i);
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
    @Override
    public String toString() {
        String frequencyTable = "Numero lettere nel messaggio " + this.getMsgLength()+"\n";
        for(Character currentKey : table.keySet()){
            Integer occurence =table.get(currentKey);
            frequencyTable += currentKey + " numero occorrenze " + occurence + " percentuale " + (double)occurence/this.getMsgLength()*100+"\n";
        }
        return frequencyTable;
        //return table.size()+" numero lettere "+this.getMsgLength();
    }
    
    private int getMsgLength(){
        return this.msgLength;
    }
}
