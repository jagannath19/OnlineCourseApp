package com.course.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	static Connection connection = null;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/dbtraining";
		String username = "root";
		String password = "root";

		try {
			connection = DriverManager.getConnection(url, username, password);
//			PreparedStatement ps = connection.prepareStatement(Queries.createQuery);
//			boolean val = ps.execute();
//			System.out.println(val);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
