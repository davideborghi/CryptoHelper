/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.model.spia;

import model.spia.AnalisiFrequenze;
import model.spia.SostituzioneSemplice;

/**
 *
 * @author davide
 */
public class TesterAnalisiFrequenze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnalisiFrequenze tool = new AnalisiFrequenze();
        String msg = "hello analisi frequenze";
        tool.start(msg);
        SostituzioneSemplice tool1 = new SostituzioneSemplice();
        String edit = msg;
        edit = tool1.start(edit, 'e', 'F');
        System.out.println(msg + "\nSostituzione e con F \n" + edit);
        tool.start(edit);
        // TODO code application logic here
    }
    
}
