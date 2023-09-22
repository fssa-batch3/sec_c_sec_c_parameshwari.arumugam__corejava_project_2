//package com.fssa.flowerybouquet.validator;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//
//import com.fssa.flowerybouquet.exception.InvalidUserException;
//
//public class TestUserValidator {
//	@Test
//
//	void testUserValidator() throws InvalidUserException {
//		/**
//		 * Validate that ProductValidator throws an exception when a null product is
//		 * provided
//		 */
//		
//		try {
//			UserValidator.validate(null);
//			Assertions.fail("invalid user");
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals("invalid user", e.getMessage());
//		}
//	}
//	/**
//	 * Test method for adding a valid user name
//	 */
//	
//	@Test
//
//	void testValidUserName() throws InvalidUserException {
//		Assertions.assertTrue(UserValidator.validateUserFirstName("paramu"));
//	}
//	/**
//	 * for invalid user name when the user name is null
//	 */
//	
//	@Test
//
//	void testInvalidUserName() throws InvalidUserException {
//		try {
//		  UserValidator.validateUserFirstName(null);
//			Assertions.fail("invalid Firstname");
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals("invalid user name", e.getMessage());
//		}
//		/**
//		 * for invalid user name when the user name is under 2 letters or above 15
//		 */
//		try {
//			UserValidator.validateUserFirstName("j");
//			Assertions.fail("invalid name");
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals("invalid user name", e.getMessage());
//		}
//	}
//	
//	/**
//	 * test for valid user address
//	 */
//	
//	@Test
//	void testValidUserAddress() throws InvalidUserException {
//		Assertions.assertTrue(
//				UserValidator.AddressValidator("invalid adress"));
//	}
//	/**
//	 * test for invalid user address when it is null.
//	 */
//	
//	@Test
//
//	void testInvalidUserAddress() throws InvalidUserException {
//		try {
//			UserValidator.AddressValidator(null);
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals(UserValidateErrors.INVALID_USERADDRESS_NULL, e.getMessage());
//		}
//		/**
//		 * test for invalid user address when it is minimum 15 and maximum 100
//		 */
//		try {
//			UserValidator.AddressValidator(ProductValidateConstants.PRODUCT_INVALID_DESCRIPTION);
//			Assertions.fail(ProductValidateErrors.INVALID_PRODUCTDESCRIPTION);
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals(UserValidateErrors.INVALID_USERADDRESS, e.getMessage());
//		}
//	}
//	/**
//	 * test for valid user email
//	 */
//	
//	@Test
//	void testValidUserEmail() throws InvalidUserException {
//		Assertions.assertTrue(
//				UserValidator.emailValidator("paramu@gmail.com"));
//	}
//	/**
//	 * test for invalid user email when it is null.
//	 */
//	
//	@Test
//
//	void testInvalidUserEmail() throws InvalidUserException {
//		try {
//			UserValidator.emailValidator(null);
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals("invalid emailid", e.getMessage());
//		}
//		UserValidator.emailValidator("h.co,");
//		Assertions.fail("invalid email");
//	}
//	
//	
//	/**
//	 * test for valid user password
//	 */
//	
//	@Test
//	void testValidUserPassword() throws InvalidUserException {
//		Assertions.assertTrue(
//				UserValidator.passwordValidator("Jaleela@123"));
//	}
//	/**
//	 * test for invalid user password when it is null.
//	 */
//	
//@Test
//
//	void testInvalidUserPassword() throws InvalidUserException {
//		try {
//			UserValidator.passwordValidator(null);
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals(UserValidateErrors.INVALID_USERPASSWORD_NULL, e.getMessage());
//		}
//		/**
//		 * test for invalid user password
//		 */
//		try {
//			UserValidator.passwordValidator("jal21");
//			Assertions.fail(ProductValidateErrors.INVALID_PRODUCTDESCRIPTION);
//		} catch (InvalidInputException e) {
//			Assertions.assertEquals(UserValidateErrors.INVALID_USERPASSWORD_PATTERN, e.getMessage());
//		}
//	}
//	
//	/**
//	 * test for valid user phone number
//	 */
//	
//@Test
//	void testValidUserPhoneNumber() throws InvalidUserException {
//		Assertions.assertTrue(
//				UserValidator.phoneNumberValidator("9876543210"));
//	}
//	/**
//	 * test for invalid user password when it is null.
//	 */
//	
//@Test
//
//	void testInvalidUserPhoneNumber() throws InvalidUserException {
//		try {
//			UserValidator.phoneNumberValidator(null);
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals(UserValidateErrors.INVALID_PHONENUMBER_NULL, e.getMessage());
//		}
//		/**
//		 * test for invalid user password
//		 */
//		try {
//			UserValidator.phoneNumberValidator("jal21");
//			Assertions.fail(ProductValidateErrors.INVALID_PRODUCTDESCRIPTION);
//		} catch (InvalidUserException e) {
//			Assertions.assertEquals(UserValidateErrors.INVALID_PHONENUMBER, e.getMessage());
//		}
//	}
//
//}
