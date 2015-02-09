/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;


public class PreparedStatementWrapper implements PreparedStatement {
	private PreparedStatement wrapped;

  public PreparedStatementWrapper( PreparedStatement stmt ) {
    this.wrapped = stmt;
  }
// <editor-fold defaultstate="collapsed" desc="PreparedStatement interface methods">
	public void addBatch() throws SQLException {
		wrapped.addBatch();
	}

	public void addBatch(String arg0) throws SQLException {
		wrapped.addBatch(arg0);
	}

	public void cancel() throws SQLException {
		wrapped.cancel();
	}

	public void clearBatch() throws SQLException {
		wrapped.clearBatch();
	}

	public void clearParameters() throws SQLException {
		wrapped.clearParameters();
	}

	public void clearWarnings() throws SQLException {
		wrapped.clearWarnings();
	}

	public void close() throws SQLException {
		wrapped.close();
	}

	public void closeOnCompletion() throws SQLException {
		wrapped.closeOnCompletion();
	}

	public boolean execute() throws SQLException {
		return wrapped.execute();
	}

	public boolean execute(String arg0, int arg1) throws SQLException {
		return wrapped.execute(arg0, arg1);
	}

	public boolean execute(String arg0, int[] arg1) throws SQLException {
		return wrapped.execute(arg0, arg1);
	}

	public boolean execute(String arg0, String[] arg1) throws SQLException {
		return wrapped.execute(arg0, arg1);
	}

	public boolean execute(String arg0) throws SQLException {
		return wrapped.execute(arg0);
	}

	public int[] executeBatch() throws SQLException {
		return wrapped.executeBatch();
	}

	public ResultSet executeQuery() throws SQLException {
		return wrapped.executeQuery();
	}

	public ResultSet executeQuery(String arg0) throws SQLException {
		return wrapped.executeQuery(arg0);
	}

	public int executeUpdate() throws SQLException {
		return wrapped.executeUpdate();
	}

	public int executeUpdate(String arg0, int arg1) throws SQLException {
		return wrapped.executeUpdate(arg0, arg1);
	}

	public int executeUpdate(String arg0, int[] arg1) throws SQLException {
		return wrapped.executeUpdate(arg0, arg1);
	}

	public int executeUpdate(String arg0, String[] arg1) throws SQLException {
		return wrapped.executeUpdate(arg0, arg1);
	}

	public int executeUpdate(String arg0) throws SQLException {
		return wrapped.executeUpdate(arg0);
	}

	public Connection getConnection() throws SQLException {
		return wrapped.getConnection();
	}

	public int getFetchDirection() throws SQLException {
		return wrapped.getFetchDirection();
	}

	public int getFetchSize() throws SQLException {
		return wrapped.getFetchSize();
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return wrapped.getGeneratedKeys();
	}

	public int getMaxFieldSize() throws SQLException {
		return wrapped.getMaxFieldSize();
	}

	public int getMaxRows() throws SQLException {
		return wrapped.getMaxRows();
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		return wrapped.getMetaData();
	}

	public boolean getMoreResults() throws SQLException {
		return wrapped.getMoreResults();
	}

	public boolean getMoreResults(int arg0) throws SQLException {
		return wrapped.getMoreResults(arg0);
	}

	public ParameterMetaData getParameterMetaData() throws SQLException {
		return wrapped.getParameterMetaData();
	}

	public int getQueryTimeout() throws SQLException {
		return wrapped.getQueryTimeout();
	}

	public ResultSet getResultSet() throws SQLException {
		return wrapped.getResultSet();
	}

	public int getResultSetConcurrency() throws SQLException {
		return wrapped.getResultSetConcurrency();
	}

	public int getResultSetHoldability() throws SQLException {
		return wrapped.getResultSetHoldability();
	}

	public int getResultSetType() throws SQLException {
		return wrapped.getResultSetType();
	}

	public int getUpdateCount() throws SQLException {
		return wrapped.getUpdateCount();
	}

	public SQLWarning getWarnings() throws SQLException {
		return wrapped.getWarnings();
	}

	public boolean isCloseOnCompletion() throws SQLException {
		return wrapped.isCloseOnCompletion();
	}

	public boolean isClosed() throws SQLException {
		return wrapped.isClosed();
	}

	public boolean isPoolable() throws SQLException {
		return wrapped.isPoolable();
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return wrapped.isWrapperFor(iface);
	}

	public void setArray(int arg0, Array arg1) throws SQLException {
		wrapped.setArray(arg0, arg1);
	}

	public void setAsciiStream(int arg0, InputStream arg1, int arg2)
			throws SQLException {
		wrapped.setAsciiStream(arg0, arg1, arg2);
	}

	public void setAsciiStream(int arg0, InputStream arg1, long arg2)
			throws SQLException {
		wrapped.setAsciiStream(arg0, arg1, arg2);
	}

	public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
		wrapped.setAsciiStream(arg0, arg1);
	}

	public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
		wrapped.setBigDecimal(arg0, arg1);
	}

	public void setBinaryStream(int arg0, InputStream arg1, int arg2)
			throws SQLException {
		wrapped.setBinaryStream(arg0, arg1, arg2);
	}

	public void setBinaryStream(int arg0, InputStream arg1, long arg2)
			throws SQLException {
		wrapped.setBinaryStream(arg0, arg1, arg2);
	}

	public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
		wrapped.setBinaryStream(arg0, arg1);
	}

	public void setBlob(int arg0, Blob arg1) throws SQLException {
		wrapped.setBlob(arg0, arg1);
	}

	public void setBlob(int arg0, InputStream arg1, long arg2)
			throws SQLException {
		wrapped.setBlob(arg0, arg1, arg2);
	}

	public void setBlob(int arg0, InputStream arg1) throws SQLException {
		wrapped.setBlob(arg0, arg1);
	}

	public void setBoolean(int arg0, boolean arg1) throws SQLException {
		wrapped.setBoolean(arg0, arg1);
	}

	public void setByte(int arg0, byte arg1) throws SQLException {
		wrapped.setByte(arg0, arg1);
	}

	public void setBytes(int arg0, byte[] arg1) throws SQLException {
		wrapped.setBytes(arg0, arg1);
	}

	public void setCharacterStream(int arg0, Reader arg1, int arg2)
			throws SQLException {
		wrapped.setCharacterStream(arg0, arg1, arg2);
	}

	public void setCharacterStream(int arg0, Reader arg1, long arg2)
			throws SQLException {
		wrapped.setCharacterStream(arg0, arg1, arg2);
	}

	public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
		wrapped.setCharacterStream(arg0, arg1);
	}

	public void setClob(int arg0, Clob arg1) throws SQLException {
		wrapped.setClob(arg0, arg1);
	}

	public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
		wrapped.setClob(arg0, arg1, arg2);
	}

	public void setClob(int arg0, Reader arg1) throws SQLException {
		wrapped.setClob(arg0, arg1);
	}

	public void setCursorName(String arg0) throws SQLException {
		wrapped.setCursorName(arg0);
	}

	public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
		wrapped.setDate(arg0, arg1, arg2);
	}

	public void setDate(int arg0, Date arg1) throws SQLException {
		wrapped.setDate(arg0, arg1);
	}

	public void setDouble(int arg0, double arg1) throws SQLException {
		wrapped.setDouble(arg0, arg1);
	}

	public void setEscapeProcessing(boolean arg0) throws SQLException {
		wrapped.setEscapeProcessing(arg0);
	}

	public void setFetchDirection(int arg0) throws SQLException {
		wrapped.setFetchDirection(arg0);
	}

	public void setFetchSize(int arg0) throws SQLException {
		wrapped.setFetchSize(arg0);
	}

	public void setFloat(int arg0, float arg1) throws SQLException {
		wrapped.setFloat(arg0, arg1);
	}

	public void setInt(int arg0, int arg1) throws SQLException {
		wrapped.setInt(arg0, arg1);
	}

	public void setLong(int arg0, long arg1) throws SQLException {
		wrapped.setLong(arg0, arg1);
	}

	public void setMaxFieldSize(int arg0) throws SQLException {
		wrapped.setMaxFieldSize(arg0);
	}

	public void setMaxRows(int arg0) throws SQLException {
		wrapped.setMaxRows(arg0);
	}

	public void setNCharacterStream(int arg0, Reader arg1, long arg2)
			throws SQLException {
		wrapped.setNCharacterStream(arg0, arg1, arg2);
	}

	public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
		wrapped.setNCharacterStream(arg0, arg1);
	}

	public void setNClob(int arg0, NClob arg1) throws SQLException {
		wrapped.setNClob(arg0, arg1);
	}

	public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
		wrapped.setNClob(arg0, arg1, arg2);
	}

	public void setNClob(int arg0, Reader arg1) throws SQLException {
		wrapped.setNClob(arg0, arg1);
	}

	public void setNString(int arg0, String arg1) throws SQLException {
		wrapped.setNString(arg0, arg1);
	}

	public void setNull(int arg0, int arg1, String arg2) throws SQLException {
		wrapped.setNull(arg0, arg1, arg2);
	}

	public void setNull(int arg0, int arg1) throws SQLException {
		wrapped.setNull(arg0, arg1);
	}

	public void setObject(int arg0, Object arg1, int arg2, int arg3)
			throws SQLException {
		wrapped.setObject(arg0, arg1, arg2, arg3);
	}

	public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
		wrapped.setObject(arg0, arg1, arg2);
	}

	public void setObject(int arg0, Object arg1) throws SQLException {
		wrapped.setObject(arg0, arg1);
	}

	public void setPoolable(boolean arg0) throws SQLException {
		wrapped.setPoolable(arg0);
	}

	public void setQueryTimeout(int arg0) throws SQLException {
		wrapped.setQueryTimeout(arg0);
	}

	public void setRef(int arg0, Ref arg1) throws SQLException {
		wrapped.setRef(arg0, arg1);
	}

	public void setRowId(int arg0, RowId arg1) throws SQLException {
		wrapped.setRowId(arg0, arg1);
	}

	public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
		wrapped.setSQLXML(arg0, arg1);
	}

	public void setShort(int arg0, short arg1) throws SQLException {
		wrapped.setShort(arg0, arg1);
	}

	public void setString(int arg0, String arg1) throws SQLException {
		wrapped.setString(arg0, arg1);
	}

	public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
		wrapped.setTime(arg0, arg1, arg2);
	}

	public void setTime(int arg0, Time arg1) throws SQLException {
		wrapped.setTime(arg0, arg1);
	}

	public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2)
			throws SQLException {
		wrapped.setTimestamp(arg0, arg1, arg2);
	}

	public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
		wrapped.setTimestamp(arg0, arg1);
	}

	public void setURL(int arg0, URL arg1) throws SQLException {
		wrapped.setURL(arg0, arg1);
	}

	public void setUnicodeStream(int arg0, InputStream arg1, int arg2)
			throws SQLException {
		wrapped.setUnicodeStream(arg0, arg1, arg2);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return wrapped.unwrap(iface);
	}
  
//</editor-fold>
}
