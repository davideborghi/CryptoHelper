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
public interface Query extends PreparedStatement {
  public String getSqlCode();
}
