package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

		public static Connection createConnection() throws ClassNotFoundException,SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			return connection;
	}
}
