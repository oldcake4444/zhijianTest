package com.test.db.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;


import org.junit.Test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;
import com.test.Util.FileUtil;
import com.test.Util.GetConfigProperties;

public class DbConnector {
	
	static Logger log = Logger.getLogger("DbConnector.class");
	private static String dbConfigPath = "/Configuration/db.properties";
	
	public static int connectToForwardHost(String host, int port, String usrName, String keyPath, String dbHost, int dbPort) throws JSchException {
		JSch jsch = new JSch();
		Session session = null;
		jsch.addIdentity(keyPath);
		session = jsch.getSession(usrName, host, port);
		Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		
		session.connect();		
		log.info(session.getServerVersion());
		
		Channel channel = session.openChannel("session");
		channel.connect();
		int assinged_port = session.setPortForwardingL(33609, dbHost, dbPort);
		
		return assinged_port;
		
	}
	
	public static Connection dbConn(int dbLPort, String dataBase, String usr, String psw) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName).newInstance();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:" + dbLPort + "/" + dataBase + "?characterEncoding=utf-8";
		conn = DriverManager.getConnection(url, usr, psw);
	    return conn;
	}
	
	public static Connection connectToTestDB() throws JSchException, NumberFormatException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int lPort = connectToForwardHost(GetConfigProperties.getValue(dbConfigPath, "forwardHost"),
				Integer.valueOf(GetConfigProperties.getValue(dbConfigPath, "forwardHostPort")),
				GetConfigProperties.getValue(dbConfigPath, "forwardHostUsr"),
				GetConfigProperties.getValue(dbConfigPath, "privateKeyPath"),
				GetConfigProperties.getValue(dbConfigPath, "testDbHost"),
				Integer.valueOf(GetConfigProperties.getValue(dbConfigPath, "testDbPort"))
				);
		
		Connection conn = dbConn(lPort, GetConfigProperties.getValue(dbConfigPath, "testZhijian2"), 
				GetConfigProperties.getValue(dbConfigPath, "testUsr"),
				GetConfigProperties.getValue(dbConfigPath, "testPsw")
				);	
		return conn;	
	}
	
	public static Connection connectToProdDB() throws JSchException, NumberFormatException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int lPort = connectToForwardHost(GetConfigProperties.getValue(dbConfigPath, "forwardHost"),
				Integer.valueOf(GetConfigProperties.getValue(dbConfigPath, "forwardHostPort")),
				GetConfigProperties.getValue(dbConfigPath, "forwardHostUsr"),
				GetConfigProperties.getValue(dbConfigPath, "privateKeyPath"),
				GetConfigProperties.getValue(dbConfigPath, "prodDbHost"),
				Integer.valueOf(GetConfigProperties.getValue(dbConfigPath, "prodDbPort"))
				);
		
		Connection conn = dbConn(lPort, GetConfigProperties.getValue(dbConfigPath, "prodZhijian2"), 
				GetConfigProperties.getValue(dbConfigPath, "prodUsr"),
				GetConfigProperties.getValue(dbConfigPath, "prodPsw")
				);	
		return conn;	
	}
	
	@SuppressWarnings("null")
	@Test
	public void testDbConn() throws SQLException, JSchException, InstantiationException, IllegalAccessException, ClassNotFoundException, NumberFormatException, IOException {
		int lPort = connectToForwardHost(GetConfigProperties.getValue(this.dbConfigPath, "forwardHost"),
				Integer.valueOf(GetConfigProperties.getValue(this.dbConfigPath, "forwardHostPort")),
				GetConfigProperties.getValue(this.dbConfigPath, "forwardHostUsr"),
				GetConfigProperties.getValue(this.dbConfigPath, "privateKeyPath"),
				GetConfigProperties.getValue(this.dbConfigPath, "prodDbHost"),
				Integer.valueOf(GetConfigProperties.getValue(this.dbConfigPath, "prodDbPort"))
				);
		


		Connection conn = dbConn(lPort, GetConfigProperties.getValue(this.dbConfigPath, "prodZhijian2"), 
				GetConfigProperties.getValue(this.dbConfigPath, "prodUsr"),
				GetConfigProperties.getValue(this.dbConfigPath, "prodPsw")
				);
		
		
//		if (conn != null && !conn.isClosed()) {
//            Statement stmt = (Statement) conn.createStatement();
//            String query = DbQuery.dbQuery("src/main/resources/TestData/DbQuery/query1");
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                String a = rs.getString(1);
//                String b = rs.getString(2);
//                System.out.println(a + ',' + b);
//            }
//            System.out.println("Closing Database Connection");
//            conn.close();
//        }
		
		
		if (conn != null && !conn.isClosed()) {
            Statement stmt = (Statement) conn.createStatement();
            String query = DbQuery.dbQuery("src/main/resources/TestData/DbQuery/yfFrontPage001/query3");
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnCount());
            
            while (rs.next()) {
            	for(int i = 1; i <= rsmd.getColumnCount(); i++) {
            		System.out.println(rsmd.getColumnName(i));
            		String a = rs.getString(i);
            		System.out.println(a);
            	}
            }
            System.out.println("Closing Database Connection");
            conn.close();
        }
		
	}

}
