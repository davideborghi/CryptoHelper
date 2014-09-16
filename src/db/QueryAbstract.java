/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.PreparedStatement;

/**
 *
 * @author BobCaSUaL <casual4free@gmail.com>
 */
public abstract class QueryAbstract extends PreparedStatementWrapper implements Query {
  private String sql;
  
  public QueryAbstract( PreparedStatement stmt, String sql ) {
    super(stmt);
    this.sql = sql;
  }

  public String getSqlCode() {
    return this.sql;
  }
}
