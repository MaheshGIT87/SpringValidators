package com.fidelity.aws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.beanutils.RowSetDynaClass;

import com.fidelity.aws.util.DeviceManagerUtil;
import com.fidelity.aws.util.JSONReader;
import com.fidelity.aws.util.PropertiesReader;

/**
 * 
 * @author kiran
 *
 */
@SuppressWarnings("rawtypes")
public class JdbcConnectionManager {

    private Connection conn = null;

    /**
     * Set connection
     * @param schema
     * @return
     */
    public Connection setConnection(String schema) {
        PropertiesReader pr = new PropertiesReader();
        
        if(DeviceManagerUtil.IsEmpty(schema)) {
        	schema = pr.getPropertyValue("database.schema");
        }
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection(
                    pr.getPropertyValue("database.url")+schema,
                    pr.getPropertyValue("database.user"),
                    pr.getPropertyValue("database.password"));
        } catch (Exception e) {
            System.out.println("Unable to establish connection to mysql: " + e);
        }
        return conn;
    }
    
    /**
     * Set connection
     * @param schema
     * @return
     */
    public Connection setNewConnection(String schema) {
    	JSONReader jsonReader = new JSONReader();
        if(jsonReader.getSchemaDetails(schema) != null) {
        	Map<String, Object> schemaDetails = jsonReader.getSchemaDetails(schema);
//        	System.out.println(schemaDetails);
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            this.conn = DriverManager.getConnection(
	            		(String)schemaDetails.get("url")+(String)schemaDetails.get("schema"),
	            		(String)schemaDetails.get("user"),
	            		(String)schemaDetails.get("password"));
	        } catch (Exception e) {
	            System.out.println("Unable to establish connection to mysql: " + e);
	        }
        }
        return conn;
    }

    /**
     * 
     * @param sql
     * @param values
     * @return
     * @throws Exception
     */
    public int executeUpdate(String sql, Object[] values) throws Exception {
        int autoIncKey = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                autoIncKey = rs.getInt(1);
            }
        } finally {
            if (ps != null) ps.close();
        }
        return autoIncKey;
    }

    /**
     * 
     * @param sql
     * @return
     * @throws Exception
     */
    public Collection execute(String sql) throws Exception {
        ResultSet resultSet = null;
        Collection result = null;
        try {
            resultSet = conn.createStatement().executeQuery(sql);
            RowSetDynaClass rsdc = new RowSetDynaClass(resultSet);
            result = rsdc.getRows();
        } finally {
            if (resultSet != null) resultSet.close();
        }
        return result;
    }
    
    /**
     * Execute the SQL query
     * @param sql
     * @return
     * @throws Exception
     */
	public Collection executeQuery(String sql) throws Exception {
        ResultSet resultSet = null;
        Collection result = null;
        try {
            resultSet = conn.createStatement().executeQuery(sql);
            RowSetDynaClass rsdc = new RowSetDynaClass(resultSet);
            result = rsdc.getRows();
        } finally {
            if (resultSet != null) resultSet.close();
        }
        return result;
    }

	/**
	 * Execute SQL query with values
	 * @param sql
	 * @param values
	 * @return
	 * @throws Exception
	 */
    public Collection execute(String sql, Object[] values) throws Exception {
        PreparedStatement ps = null;
        Collection result = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }
            RowSetDynaClass rsdc = new RowSetDynaClass(ps.executeQuery());
            result = rsdc.getRows();
        } finally {
            if (ps != null) ps.close();
        }
        return result;
    }

    /**
     * Commit the transaction
     */
    public void commit() {
        try {
            conn.commit();
        } catch (Exception e) {
        }
    }

    /**
     * Close the connection
     */
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }


    /**
     * Execute SQL query
     * @param sql
     * @return
     * @throws Exception
     */
    public boolean executeSql(String sql) throws Exception {
        boolean isSuccess = false;
        Statement st = null;
        try {
            st = conn.createStatement();
            isSuccess = st.execute(sql);
        } finally {
            if (st != null) st.close();
        }
        return isSuccess;
    }

}
