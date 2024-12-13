package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverClass {
	public static Connection getConnection() throws SQLException {
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","1232");
		System.out.println("Connection Successful...");
		con.setAutoCommit(false);
		return con;
	}
}
