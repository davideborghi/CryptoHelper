/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author MASTER
 */
public class Session {
    private static String loggedUser;
    private static String id;
    private String username, nome, cognome;
    
    public Session(String id, String user){
        this.id = id;
        this.loggedUser = user;
    }
    
    public static String getLoggedUser(){
        return loggedUser;
    }
    
    public static String getIdLoggedUser(){
        return id;
    }
}
