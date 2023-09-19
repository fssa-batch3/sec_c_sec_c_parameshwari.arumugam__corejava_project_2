package com.fssa.flowerybouquet.service;

import java.sql.SQLException;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.UserDAO;
import com.fssa.flowerybouquet.exception.InvalidUserException;
import com.fssa.flowerybouquet.model.User;
import com.fssa.flowerybouquet.validator.UserValidator;
import com.google.protobuf.ServiceException;

public class UserService {

	UserDAO userDAO = new UserDAO();

	public boolean userSignUp(User user) throws ServiceException, InvalidUserException {
		try {
			if (UserValidator.validate(user)) {
				return userDAO.userSignIn(user);
			}
		} catch (DAOException e) {
			throw new ServiceException("Error during user sign-up: " + e.getMessage(), e);
		}
		return false;

	}

	public boolean deleteUser(String emailId) throws ServiceException {
		try {
			if (!UserValidator.emailValidator(emailId)) {
				throw new InvalidUserException("Invalid email format: " + emailId);
			}

			if (!userDAO.emailExists(emailId)) {
				throw new ServiceException("Email Not Found: " + emailId);
			}

			return userDAO.deleteUser(emailId);
		} catch (InvalidUserException e) {
			// Handle validation errors
			throw new ServiceException(e.getMessage());
		} catch (DAOException | SQLException e) {
			// Handle database access errors
			throw new ServiceException("Error while accessing the database: " + e.getMessage());
		}
	}

	
	public boolean userLogin(String emailId, String password)
			throws ServiceException, DAOException, SQLException {
		
		try {
		if (userDAO.emailExists(emailId)) {
			return userDAO.userLogin(emailId, password);
		} 
		
		}catch (Exception e) {
		throw new ServiceException("Error updating user profile: " + e.getMessage());
	}
		return false;

	}

	public User getUserByEmail(String emailId) throws ServiceException, SQLException, InvalidUserException {
		try {
			if (UserValidator.emailValidator(emailId)) {
				if (userDAO.emailExists(emailId)) {
					return userDAO.getUserByEmail(emailId);
				} else {
					throw new DAOException("User not found for email: " + emailId);
				}
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return null; // Invalid email format
	}

	public boolean updateUserProfile(User user) throws ServiceException, SQLException {
		try {
			if (UserValidator.validate(user)) {
				if (userDAO.emailExists(user.getEmail())) {
					return userDAO.updateUserProfile(user);
				} else {
					throw new DAOException("Email not found: " + user.getEmail());
				}
			}
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException("Error updating user profile: " + e.getMessage());
		}
		return false;
	}

}
