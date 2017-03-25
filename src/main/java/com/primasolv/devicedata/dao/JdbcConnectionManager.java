package com.primasolv.devicedata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.RowSetDynaClass;

import com.primasolv.devicedata.util.DeviceManagerUtil;
import com.primasolv.devicedata.util.PropertiesReader;


@SuppressWarnings("rawtypes")
public class JdbcConnectionManager {

    private Connection conn = null;

    public Connection setConnection(String schema) {
        PropertiesReader pr = new PropertiesReader();
        
        if(DeviceManagerUtil.IsEmpty(schema)) {
        	schema = pr.getPropertyValue("database.schema");
        }
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println(pr.getPropertyValue("database.schema"));
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

    public void commit() {
        try {
            conn.commit();
        } catch (Exception e) {
        }
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }



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


    /**
     * Test main method
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
    	String testSchema = "dm_latamtest";
        JdbcConnectionManager jcm = new JdbcConnectionManager();
        jcm.setConnection(testSchema);
        try {
            Collection result = jcm.execute("select * from wt2_dm");
            for (Object aResult : result) {
                DynaBean bean1 = (DynaBean) aResult;
                System.out.println(bean1);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            jcm.closeConnection();
        }
    }
}
