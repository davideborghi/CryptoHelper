/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.spia;

import model.Messaggio;
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
public class SessioneTest {
    
    public SessioneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recuperaSessione method, of class Sessione.
     */
    @Test
    public void testRecuperaSessione() throws Exception {
        System.out.println("recuperaSessione");
        Spia owner = null;
        Sessione expResult = null;
        Sessione result = Sessione.recuperaSessione(owner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startNewSessione method, of class Sessione.
     */
    @Test
    public void testStartNewSessione() {
        System.out.println("startNewSessione");
        Spia owner = null;
        Sessione expResult = null;
        Sessione result = Sessione.startNewSessione(owner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restoreSessione method, of class Sessione.
     */
    @Test
    public void testRestoreSessione() {
        System.out.println("restoreSessione");
        Sessione s = null;
        Sessione expResult = null;
        Sessione result = Sessione.restoreSessione(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSessione method, of class Sessione.
     */
    @Test
    public void testDeleteSessione() {
        System.out.println("deleteSessione");
        Sessione sessione = null;
        Sessione.deleteSessione(sessione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSessione method, of class Sessione.
     */
    @Test
    public void testSaveSessione() {
        System.out.println("saveSessione");
        Sessione sessione = null;
        Sessione.saveSessione(sessione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIpotesiRadice method, of class Sessione.
     */
    @Test
    public void testGetIpotesiRadice() {
        System.out.println("getIpotesiRadice");
        Sessione instance = null;
        Ipotesi expResult = null;
        Ipotesi result = instance.getIpotesiRadice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIpotesiCorrente method, of class Sessione.
     */
    @Test
    public void testGetIpotesiCorrente() {
        System.out.println("getIpotesiCorrente");
        Sessione instance = null;
        Ipotesi expResult = null;
        Ipotesi result = instance.getIpotesiCorrente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIpotesiCorrente method, of class Sessione.
     */
    @Test
    public void testSetIpotesiCorrente() {
        System.out.println("setIpotesiCorrente");
        Ipotesi ip = null;
        Sessione instance = null;
        instance.setIpotesiCorrente(ip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessaggio method, of class Sessione.
     */
    @Test
    public void testGetMessaggio() {
        System.out.println("getMessaggio");
        Sessione instance = null;
        Messaggio expResult = null;
        Messaggio result = instance.getMessaggio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Sessione.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Ipotesi nuova = null;
        Sessione instance = null;
        instance.add(nuova);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Sessione.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Sessione instance = null;
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
