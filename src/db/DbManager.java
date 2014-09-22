/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BobCaSUaL <casual4free@gmail.com>
 */
public class DbManager {

  /********** static part *********/
  private static DbManager instance = null;
  
  public static synchronized DbManager getInstance() throws SQLException {
    if( null == instance ) {
      instance = new DbManager();
    }
    return instance;
  }
  
  
  /******* object definition *******/
  
  private String schema = "cryptohelper"; // Nome del Database a cui connettersi
  private String uname = "cryptohelper"; // Nome utente utilizzato per la connessione al Database
  private String passw = "cryptohelper"; // Password usata per la connessione al Database
  
  private Connection engine; // La connessione col Database
  
  
  /******* internal classes *******/
  
  public class QueryImpl extends QueryAbstract {
    String sql;
    public QueryImpl( String sql ) throws SQLException {
      super( engine.prepareStatement(sql), sql );
    }
  }
  public class QueryResultImpl extends QueryResultAbstract {

    public QueryResultImpl(Query q) throws SQLException {
      super(q.executeQuery(), q);
    }
  }
  
  /*public class QueryResultImpl2 extends QueryResultAbstract {

    public QueryResultImpl2(Query q) throws SQLException {
      super(q.executeUpdate(), q);
    }
  }*/
  
  private DbManager() throws SQLException {
    DriverManager.registerDriver( new com.mysql.jdbc.Driver() );
    engine = DriverManager.getConnection("jdbc:mysql://localhost/" + schema, uname, passw);
  }
  
  public Query createQuery( String sql ) throws SQLException {
    return new QueryImpl( sql );
  }
  public QueryResult execute( Query q ) throws SQLException {
    return new QueryResultImpl( q );
  }
  
  public void executeUpdate( Query q ) throws SQLException {
    q.executeUpdate();
  }
  
}
