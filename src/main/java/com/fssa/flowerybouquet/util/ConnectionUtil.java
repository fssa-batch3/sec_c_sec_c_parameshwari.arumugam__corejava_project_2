package com.fssa.flowerybouquet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.flowerybouquet.dao.DAOException;

public class ConnectionUtil {

	private ConnectionUtil() {
		// Private constructor to prevent instantiation
		throw new UnsupportedOperationException("Cannot instantiate this class");
	}

	public static Connection getConnection() {
		Connection con = null;

		String url;
		String userName;
		String passWord; 

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");

//		url = "jdbc:mysql://localhost:3306/flowery_Bouquet";
//		userName = "root";
//		passWord = "123456";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}

	public static void close(Connection conn, Statement stmt, PreparedStatement ps, ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DAOException("Unable to close to the database");

		}
	}

}
