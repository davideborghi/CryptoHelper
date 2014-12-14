/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.user.SistemaCifratura;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MASTER
 */
public class MessaggioTest {
    
    Messaggio m = new Messaggio(null, null, null, null);
    
    public MessaggioTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Inizio test");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("prima del test");
    }
    
    @After
    public void tearDown() {
        System.out.println("dopo il test");
        //m = new Messaggio(null, null, null, null);
    }

    /**
     * Test of setLingua method, of class Messaggio.
     */
    @Test
    public void testSetLingua() {
        System.out.println("setLingua");
        String l = "prova";
        m.setLingua(l);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(l, m.getLingua());
    }

    /**
     * Test of setTesto method, of class Messaggio.
     */
    @Test
    public void testSetTesto() {
        System.out.println("setTesto");
        String text = "setTesto";
        m.setTesto(text);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(text, m.getTesto());
    }

    /**
     * Test of setDestinatario method, of class Messaggio.
     */
    @Test
    public void testSetDestinatario() {
        System.out.println("setDestinatario");
        UserInfo d = new UserInfo("id", "prova");
        m.setDestinatario(d);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(d, m.getDestinatario());
    }

    /**
     * Test of setMittente method, of class Messaggio.
     */
    @Test
    public void testSetMittente() {
        System.out.println("setMittente");
        UserInfo d = new UserInfo("id", "prova");
        m.setMittente(d);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(d, m.getMittente());
    }

    /**
     * Test of getSdc method, of class Messaggio.
     */
    @Test
    public void testGetSdc() {
        System.out.println("getSdc");
        SistemaCifratura expResult = new SistemaCifratura("id", "chiave", "metodo");
        m.setSdc(expResult);
        SistemaCifratura result = m.getSdc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSdc method, of class Messaggio.
     */
    @Test
    public void testSetSdc() {
        System.out.println("setSdc");
        SistemaCifratura s = new SistemaCifratura("id", "chiave", "metodo");
        m.setSdc(s);
        assertEquals(s, m.getSdc());
    }

    /**
     * Test of caricaIniviati method, of class Messaggio.
     */
    /*@Test
    public void testCaricaIniviati() {
        System.out.println("caricaIniviati");
        Studente s = null;
        List<Messaggio> expResult = null;
        List<Messaggio> result = Messaggio.caricaIniviati(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of caricaBozze method, of class Messaggio.
     */
    /*@Test
    public void testCaricaBozze() {
        System.out.println("caricaBozze");
        Studente s = null;
        Messaggio[] expResult = null;
        Messaggio[] result = Messaggio.caricaBozze(s);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getMessaggi method, of class Messaggio.
     */
    /*@Test
    public void testGetMessaggi() {
        System.out.println("getMessaggi");
        List<Messaggio> expResult = null;
        List<Messaggio> result = Messaggio.getMessaggi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of caricaRicevuti method, of class Messaggio.
     */
    /*@Test
    public void testCaricaRicevuti() {
        System.out.println("caricaRicevuti");
        Studente s = null;
        MessaggioDestinatario[] expResult = null;
        MessaggioDestinatario[] result = Messaggio.caricaRicevuti(s);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of elimina method, of class Messaggio.
     */
    /*@Test
    public void testElimina() {
        System.out.println("elimina");
        Messaggio instance = null;
        boolean expResult = false;
        boolean result = instance.elimina();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setBozza method, of class Messaggio.
     */
    /*@Test
    public void testSetBozza() {
        System.out.println("setBozza");
        boolean b = false;
        Messaggio instance = null;
        instance.setBozza(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of cifra method, of class Messaggio.
     */
    /*@Test
    public void testCifra() {
        System.out.println("cifra");
        Messaggio instance = null;
        instance.cifra();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of isBozza method, of class Messaggio.
     */
    /*@Test
    public void testIsBozza() {
        System.out.println("isBozza");
        Messaggio instance = null;
        boolean expResult = false;
        boolean result = instance.isBozza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of save method, of class Messaggio.
     */
    /*@Test
    public void testSave() {
        System.out.println("save");
        Messaggio instance = null;
        boolean expResult = false;
        boolean result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }/*

    /**
     * Test of isLetto method, of class Messaggio.
     */
    /*@Test
    public void testIsLetto() {
        System.out.println("isLetto");
        Messaggio instance = null;
        boolean expResult = false;
        boolean result = instance.isLetto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setToStringF method, of class Messaggio.
     */
    /*@Test
    public void testSetToStringF() {
        System.out.println("setToStringF");
        String f = "";
        Messaggio instance = null;
        String expResult = "";
        String result = instance.setToStringF(f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of toString method, of class Messaggio.
     */
    /*@Test
    public void testToString() {
        System.out.println("toString");
        Messaggio instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of send method, of class Messaggio.
     */
    /*@Test
    public void testSend() {
        System.out.println("send");
        Messaggio instance = null;
        boolean expResult = false;
        boolean result = instance.send();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getId method, of class Messaggio.
     */
    /*@Test
    public void testGetId() {
        System.out.println("getId");
        Messaggio instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getMittente method, of class Messaggio.
     */
    /*@Test
    public void testGetMittente() {
        System.out.println("getMittente");
        Messaggio instance = null;
        UserInfo expResult = null;
        UserInfo result = instance.getMittente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getDestinatario method, of class Messaggio.
     */
    /*@Test
    public void testGetDestinatario() {
        System.out.println("getDestinatario");
        Messaggio instance = null;
        UserInfo expResult = null;
        UserInfo result = instance.getDestinatario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getTesto method, of class Messaggio.
     */
    /*@Test
    public void testGetTesto() {
        System.out.println("getTesto");
        Messaggio instance = null;
        String expResult = "";
        String result = instance.getTesto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getTestoCifrato method, of class Messaggio.
     */
    /*@Test
    public void testGetTestoCifrato() {
        System.out.println("getTestoCifrato");
        Messaggio instance = null;
        String expResult = "";
        String result = instance.getTestoCifrato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getLingua method, of class Messaggio.
     */
    /*@Test
    public void testGetLingua() {
        System.out.println("getLingua");
        Messaggio instance = null;
        String expResult = "";
        String result = instance.getLingua();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getTitolo method, of class Messaggio.
     */
    /*@Test
    public void testGetTitolo() {
        System.out.println("getTitolo");
        Messaggio instance = null;
        String expResult = "";
        String result = instance.getTitolo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getToStringF method, of class Messaggio.
     */
    /*@Test
    public void testGetToStringF() {
        System.out.println("getToStringF");
        Messaggio instance = null;
        String expResult = "";
        String result = instance.getToStringF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
