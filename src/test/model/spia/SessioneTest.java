/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.model.spia;

import model.spia.Sessione;

/**
 *
 * @author user
 */
public class SessioneTest {
    public static void main( String[] args ) {
        Sessione s = Sessione.startNewSessione( null );
        System.out.println(s);
    }
}
