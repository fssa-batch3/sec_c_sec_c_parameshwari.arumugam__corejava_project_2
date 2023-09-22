package com.fssa.flowerybouquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.flowerybouquet.model.User;
import com.fssa.flowerybouquet.util.ConnectionUtil;
import com.fssa.flowerybouquet.util.Logger;

public class UserDAO {

	public boolean userSignIn(User user) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO users (first_name, last_name, email, password , phone_number, address,city,state,pincode) VALUES (?, ?, ?, ?,?,?,?,?,?)";
			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
				psmt.setString(1, user.getFirstName());
				psmt.setString(2, user.getLastName());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getPassword());
				psmt.setString(5, user.getPhonenumber());
				psmt.setString(6, user.getAddress());
				psmt.setString(7, user.getState());
				psmt.setString(8, user.getCity());
				psmt.setString(9, user.getPincode());

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

	public User loginUser(String emailId) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String selectQuery = "SELECT user_id, email,first_name, last_name, password, phone_number,address,city,state,pincode FROM users WHERE email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);
				Logger.info(emailId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("user_id"));
						user.setEmail(rs.getString("email"));
						user.setFirstName(rs.getString("first_name"));
						user.setLastName(rs.getString("last_name"));
						user.setPassword(rs.getString("password"));
						user.setPhonenumber(rs.getString("phone_number"));
						user.setAddress(rs.getString("address"));
						user.setCity(rs.getString("city"));
						user.setState(rs.getString("state"));
						user.setPincode(rs.getString("pincode"));
						Logger.info(user);
						Logger.info("kachak");
						return user;
					} else {
						throw new DAOException("User not found");
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Database Connection Error: " + e.getMessage());
		}
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

	public static int getUserIdByEmail(String emailId) throws DAOException {
		int userId = -1; // Default value if the email is not found or an error occurs.
		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to retrieve the user ID by email.
			String query = "SELECT user_id FROM users WHERE email=?";
			try (PreparedStatement psmt = con.prepareStatement(query)) {
				
				// Set the email parameter in the PreparedStatement.
				psmt.setString(1, emailId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						userId = rs.getInt("user_id");
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return userId;
	}
	
	
	public boolean updateuser(String email, User user) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String getUserQuery = "UPDATE users SET first_name =?,last_name =?, phone_number =? ,email =?  ,state =? , city =? , pincode =? ,address =? WHERE email = ? ";
			try (PreparedStatement psmt = connection.prepareStatement(getUserQuery)) {
				psmt.setString(1, user.getFirstName());
				psmt.setString(2, user.getLastName());
				psmt.setString(3, user.getPhonenumber());
				psmt.setString(4, user.getEmail());
				psmt.setString(5, user.getState());
				psmt.setString(6, user.getCity());
				psmt.setString(7, user.getPincode());
				psmt.setString(8, user.getAddress());
				psmt.setString(9, email);

				int rowAffected = psmt.executeUpdate();
				Logger.info(user);

				if (rowAffected > 0) {
					Logger.info("Success updated");
					return true;
				} else {
					Logger.info("error while update the row");

				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while getting the connection" + e.getMessage());
		}
		return false;
	}
}
