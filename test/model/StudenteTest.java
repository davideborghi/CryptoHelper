/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DbManager;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roberto
 */
public class StudenteTest {

    public StudenteTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("INSERT INTO `cryptohelper`.`user` (`id`, `username`, `password`, `nome`, `cognome`) VALUES (NULL, 'studenteTest', 'prova', 'test', 'junit');");
            q.executeUpdate();
        } catch (SQLException s) {
        }
        

    }

    @AfterClass
    public static void tearDownClass() {

        try {
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("DELETE FROM `cryptohelper`.`user` WHERE `user`.`id` = 49");
            QueryResult rs = db.execute(q);
        } catch (SQLException s) {
        }

    }

    /**
     * Test of login method, of class Studente.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Studente s = new Studente("test", "junit", null, "studenTetest", "prova");
        boolean result = s.login();
        assertTrue(result);
    }

    /**
     * Test of registra method, of class Studente.
     */
    @Test
    public void testRegistra() {
        System.out.println("registra");
        String nome = "prova";
        String password = "riprova";
        boolean result = Studente.registra(nome, password);
        assertTrue(result);
    }

    /**
     * Test of getId method, of class Studente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Studente instance = new Studente(null, null, "40", null, null);
        String expResult = "40";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Studente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Studente instance = new Studente("nome", "cognome", "40", "user", "psw");
        String expResult = "user";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNome method, of class Studente.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Studente instance = new Studente("nome", null, "40", null, null);
        String expResult = "nome";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCognome method, of class Studente.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Studente instance = new Studente(null, "cognome", "40", null, null);
        String expResult = "cognome";
        String result = instance.getCognome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLogin method, of class Studente.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Studente instance = new Studente(null, null, "40", "login", null);
        String expResult = "login";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPwd method, of class Studente.
     */
    @Test
    public void testGetPwd() {
        System.out.println("getPwd");
        Studente instance = new Studente(null, null, "40", null, "password");
        String expResult = "password";
        String result = instance.getPwd();
        assertEquals(expResult, result);
    }

}
