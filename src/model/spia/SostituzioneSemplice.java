/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.spia;

import GUI.spia.SostituzioneSempliceGUI;


/**
 *
 * @author davide
 */
public class SostituzioneSemplice implements StrumentoDiManipolazione {
  private static String sostituisci(String msg, char from, char to){
        to = Character.toUpperCase(to);
        msg = msg.replace(from, to);
        return msg;
    }

  @Override
  public void elabora(Sessione sessione) {
    final Sessione s = sessione;
    new Thread( new Runnable() {
      @Override
      public void run() {
        char[] array = SostituzioneSempliceGUI.getCaratteriDaSostituire();

        if( array != null && array.length == 2 ) {
          char crypt = array[0];
          char plain = array[1];

          Ipotesi ipotesiCorrente = s.getIpotesiCorrente();
          String messaggio = ipotesiCorrente.getMessaggioParzialmenteDecifrato();

          messaggio = sostituisci(messaggio, crypt, plain);

          Ipotesi nuova = new Ipotesi( crypt+" -> "+plain, messaggio);
          s.add(nuova);
        }
      }
    }).start();
  }
  
}
