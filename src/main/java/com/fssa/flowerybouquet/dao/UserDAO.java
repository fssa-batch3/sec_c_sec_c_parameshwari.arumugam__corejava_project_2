package com.fssa.flowerybouquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.flowerybouquet.model.User;
import com.fssa.flowerybouquet.util.ConnectionUtil;

public class UserDAO {

	public boolean userSignIn(User user) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO users (first_name, last_name, email, password , phone_number, address) VALUES (?, ?, ?, ?,?,?)";
			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
				psmt.setString(1, user.getFirstName());
				psmt.setString(2, user.getLastName());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getPassword());
				psmt.setString(5, user.getPhonenumber());
				psmt.setString(6, user.getAddress());

				int rowsAffected = psmt.executeUpdate();
				return rowsAffected > 0;
			} catch (SQLException e) {
				// Handle any SQLException that may occur during PreparedStatement execution
				throw new DAOException("Error while executing the insert query: " + e.getMessage(), e);
			}
		} catch (SQLException e) {
			// Handle any SQLException that may occur during database connection
			throw new DAOException("Error while connecting to the database: " + e.getMessage(), e);
		}
	}

	public boolean deleteUser(String emailId) throws DAOException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String deleteQuery = "DELETE FROM users WHERE email = ?";

			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {

				psmt.setString(1, emailId);
				int rowAffected = psmt.executeUpdate();
				return rowAffected > 0;
			}
		}
	}
	
public boolean userLogin(String emailId, String password) throws DAOException, SQLException {
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			String selectQuery = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
			
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);
				psmt.setString(2, password);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						int count = rs.getInt(1);
						return count==1 ; // Return true if count is greater than 0 (successful login)
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while checking login for email: " + emailId, e);
		}
		

		// Return false if no user with the given email and password was found
		return false;
	}
	

	public boolean emailExists(String emailId) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement psmt = connection.prepareStatement("SELECT user_id FROM users WHERE email = ?")) {

			psmt.setString(1, emailId);

			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) {
					// If a row with the given email exists, return true
					return true;
				}
			} catch (SQLException e) {
				// Handle any SQLException that may occur during result set processing
				throw new DAOException("Error while processing the result set: " + e.getMessage(), e);
			}
		} catch (SQLException e) {
			// Handle any SQLException that may occur during database connection or
			// statement creation
			throw new DAOException("Error while checking email existence: " + e.getMessage(), e);
		}

		// If no matching email was found, return false
		return false;
	}

	public User getUserByEmail(String emailId) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String selectQuery = "SELECT user_id, first_name, last_name, password FROM users WHERE email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("user_id"));
						user.setFirstName(rs.getString("firs_tname"));
						user.setLastName(rs.getString("last_name"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null; // User not found
	}
	
	public boolean updateUserProfile(User user) throws DAOException {
		String updateQuery = "UPDATE users SET first_name = ?,last_name = ?, password = ? WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				
				PreparedStatement psmt = connection.prepareStatement(updateQuery)) {

			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getPassword());

			int rowsUpdated = psmt.executeUpdate();

			return rowsUpdated > 0;

		} catch (SQLException e) {
			throw new DAOException("Error updating user profile: " + e.getMessage());
		}
	}
	
}
