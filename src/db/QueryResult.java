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
public interface QueryResult extends ResultSet {
  public Query getQuery();
}
