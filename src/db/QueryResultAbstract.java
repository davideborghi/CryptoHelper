/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.ResultSet;

/**
 *
 * @author BobCaSUaL <casual4free@gmail.com>
 */
public abstract class QueryResultAbstract extends ResultSetWrapper implements QueryResult {
  private Query query;
    
  public QueryResultAbstract( ResultSet rs, Query q ) {
    super( rs );
    this.query = q;
  }
  /**
   * @return the query
   */
  public Query getQuery() {
    return query;
  }
}
