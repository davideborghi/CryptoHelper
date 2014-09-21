/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.spia;

/**
 *
 * @author davide
 */
public class SostituzioneSemplice {
    public String start(String msg, char from, char to){
        to = Character.toUpperCase(to);
        msg = msg.replace(from, to);
        return msg;
    }
}
