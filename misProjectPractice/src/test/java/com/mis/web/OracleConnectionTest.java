package com.mis.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectionTest {
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1522:XE";
	private static final String USER = "mis";
	private static final String PW = "1234";

	@Test
	public void testConnection() throws Exception {
		
		Class.forName(DRIVER);
		
		try (Connection con = DriverManager.getConnection(URL, USER, PW)){
			
			System.out.println("JUNIT:" + con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
