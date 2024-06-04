package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	

	public static void openConnection(String DB_URL,String USER_NAME,String PASSWORD) 
			throws SQLException {
		
		connection = DriverManager.getConnection
				(DB_URL, USER_NAME, PASSWORD);//fixed connectivity
		
	}
	public static Connection getConnection() {
		return connection;
	}
	//add a static method to close connection
	public static void closeConnection() throws SQLException{
		if(connection != null)
			connection.close();
		System.out.println("db cn closed !");
	}
}
