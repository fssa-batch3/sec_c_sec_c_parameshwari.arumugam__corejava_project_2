package com.fssa.flowerybouquet.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.exception.InvalidUserException;
import com.fssa.flowerybouquet.model.User;
import com.google.protobuf.ServiceException;

public class TestUserService {
  
	
	 UserService userService = new UserService();

	    private User getUser() {
	        User user = new User();
	        user.getFirstName();
	        user.getEmail();
	        user.setPassword("Test@123");
	        user.getAddress();
	        user.getPhonenumber();

	        return user;
	    }
	    
	    @Test
	    void testValidUserSignUp() {
	        User user = getUser();
	        user.setFirstName("Paramu");
	        user.setLastName("Arumugam");
	        user.setEmail("paramu@gmail.com");
	        user.setPassword("Paramu@2004");
	        user.setPhonenumber("9876543210");
	        user.setAddress("14th cross anna nagar ,chennai");
	        assertDoesNotThrow(() -> userService.userSignUp(user));
	    }
	    
	    @Test
	    void testValidUserLogin() throws ServiceException, InvalidUserException, DAOException, SQLException {
	    	
	    	assertThrows(ServiceException.class, () -> userService.userLogin("paramu@gmail.com"));
	    }
	    
	    @Test
	    void testUserLoginInvalidInput()   {
	    
	        assertThrows(ServiceException.class, () -> userService.userLogin(" "));
	    }
//	    
	    
	    @Test
	    void testDeleteUserValidInput() { 
	       
	        assertDoesNotThrow(() -> userService.deleteUser("paramu@gmail.com"));
	    }
	    
	    @Test
	    void testDeleteUserInvalidInput() {
	        
	        assertThrows(ServiceException.class, () -> userService.deleteUser("email@gmail.com"));
	    }

	    
}

