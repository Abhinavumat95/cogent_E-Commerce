package com.cogent.Ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

	static final String DB_URL = "jdbc:mysql://localhost/batch65";
	static final String USER = "root";
	static final String PASS = "Abhinav@1995";
	static Connection conn = null;

	public static Connection connectSetUp() {

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}