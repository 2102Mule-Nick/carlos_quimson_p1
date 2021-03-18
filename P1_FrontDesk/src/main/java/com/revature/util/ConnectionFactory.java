package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionFactory {

	private Logger log = Logger.getRootLogger();
	
	private static ConnectionFactory connection = null;
	
	public Connection establishConnection() {

		String forName = "org.postgresql.Driver";
		
		String databaseName = "postgres";
		
		String defaultConnection = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/" + databaseName + "?";
		
		String dbUsername = System.getenv("DB_USERNAME");
		
		String dbPassword = System.getenv("DB_PASS");
		
		Properties props = new Properties();
		props.setProperty("user", dbUsername);
		props.setProperty("password", dbPassword);
		props.setProperty("currentSchema", System.getenv("DB_SCHEMA"));
		
		try {
			Class.forName(forName);
			
			return DriverManager.getConnection(defaultConnection, props);
		} catch (SQLException e) {
			log.warn("Error connecting with Postgres DB", e);
		} catch (Exception e) {
			log.error("A different exception has been thrown", e);
		}
		
		return null;
	}
	
	public static synchronized Connection getConnection() {
		if (connection == null) {
			connection = new ConnectionFactory();
		}
		
		return connection.establishConnection();
	}
	
	public ConnectionFactory() {
		super();
	}
	
}
