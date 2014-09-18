/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.model.spia.supportTools;

import model.spia.supportTools.analisiFrequenze.AnalisiFrequenze;
import model.spia.supportTools.analisiFrequenze.Replacer;

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
        Replacer tool1 = new Replacer();
        String edit = msg;
        edit = tool1.start(edit, 'e', 'F');
        System.out.println(msg + "\nSostituzione e con F \n" + edit);
        tool.start(edit);
        // TODO code application logic here
    }
    
}
