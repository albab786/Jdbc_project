package com.jsp.jdbc_project_architecture_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class UserConnection {

	public static Connection getUserConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
