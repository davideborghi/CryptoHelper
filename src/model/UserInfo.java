/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//import static controller.Controller.connect;
import db.DbManager;
import db.DbManager;
import db.Query;
import db.QueryResult;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author MASTER
 */
public class UserInfo {
    private String id;
    private String username, nome, cognome;
    
    public UserInfo(String id){
        /*this.id = id;
        DbManager db = connect();
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`user` WHERE id = '" + id + "'");
        this.username = ((String[]) v.elementAt(0))[1];
        this.nome = ((String[])v.elementAt(0))[3];
        this.cognome = ((String[]) v.elementAt(0))[4];*/
        this.id = id;
        try{
            DbManager db = DbManager.getInstance();
            Query q = db.createQuery("SELECT * FROM `cryptohelper`.`user` WHERE id = '" + id + "'");
            QueryResult rs = db.execute(q);
            rs.next();
            this.username = rs.getString(2);
            this.nome = rs.getString(4);
            this.cognome = rs.getString(5);
        }
         catch(SQLException ex){
            throw new RuntimeException( ex.getMessage(), ex );
        }
    }
    
    public UserInfo(String id, String user){
        this.id = id;
        this.username = user;
    }
    
    public String getId(){
        return this.id;
    }
}
