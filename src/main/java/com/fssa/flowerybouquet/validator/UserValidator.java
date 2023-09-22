package com.fssa.flowerybouquet.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.flowerybouquet.exception.InvalidUserException;
import com.fssa.flowerybouquet.model.User;

public class UserValidator {

	public static boolean validate(User user) throws InvalidUserException {

//		idValidator(user.getId());
		firstNameValidator(user.getFirstName());
//		lastNameValidator(user.getLastName());
		emailValidator(user.getEmail());
		passwordValidator(user.getPassword());
		

		return true;
	}

	public static boolean validateUpdate(User user) throws InvalidUserException {

		firstNameValidator(user.getFirstName());
//		lastNameValidator(user.getLastName());
		emailValidator(user.getEmail());
		phoneValidator(user.getPhonenumber());
		validateAddress(user.getAddress());
		validateState(user.getState());
		validateCity(user.getCity());
		validatePincode(user.getPincode());
		
		return true;
	}
	
	// id validate

//	public static boolean idValidator(int id) throws IllegalArgumentException {
//
//		if (id <= 0) {
//			throw new IllegalArgumentException("Id is invalid");
//		}
//		return true;
//
//	}

	private static void firstNameValidator(String firstName) {
		// TODO Auto-generated method stub

	}

	public static boolean passwordValidator(String password) throws InvalidUserException {
		if (password == null) {
			throw new InvalidUserException("password is invalid");
		}
		// At least one uppercase letter
		Pattern uppercasePattern = Pattern.compile(".*[A-Z].*");

		// At least one lowercase letter
		Pattern lowercasePattern = Pattern.compile(".*[a-z].*");

		// At least one digit
		Pattern digitPattern = Pattern.compile(".*[0-9].*");

		// At least one special character
		Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()_+{}\\[\\]:;\"'<>,.?/~].*");

		// No whitespaces
		Pattern noWhitespacePattern = Pattern.compile("\\S*");

		// Match each pattern against the password
		boolean isUppercaseValid = uppercasePattern.matcher(password).matches();
		boolean isLowercaseValid = lowercasePattern.matcher(password).matches();
		boolean isDigitValid = digitPattern.matcher(password).matches();
		boolean isSpecialCharValid = specialCharPattern.matcher(password).matches();
		boolean isNoWhitespaceValid = noWhitespacePattern.matcher(password).matches();

		if (password.isEmpty()) {
			throw new InvalidUserException("User password is empty");
		}

		if (password.length() < 8) {
			throw new InvalidUserException("length must should be 8");
		}

		if (!isDigitValid) {
			throw new InvalidUserException("password is invalid");
		}

		if (!isSpecialCharValid) {
			throw new InvalidUserException("password is invalid");
		}

		if (!isUppercaseValid) {
			throw new InvalidUserException("password is invalid");
		}

		if (!isLowercaseValid) {
			throw new InvalidUserException("password is invalid");
		}

		if (!isNoWhitespaceValid) {
			throw new InvalidUserException("password is invalid");
		}

		return true;
	}

	public static boolean validateUserFirstName(String firstname) throws InvalidUserException {
		firstname = firstname.trim();

		if (firstname == null) {
			throw new InvalidUserException("user name is invalid");
		}

		if (firstname.isEmpty()) {
			throw new InvalidUserException("user name is invalid");
		}

		if (firstname.length() < 2) {
			throw new InvalidUserException("user name is invalid");
		}

		if (firstname.matches(".*\\d.*")) {
			throw new InvalidUserException("user name is invalid");
		}

		if (firstname.matches(".*[^a-zA-Z0-9].*")) {
			throw new InvalidUserException("user name is invalid");
		}

		return true;
	}

//	// lastName validate
//	public static boolean lastNameValidator(String lastName) throws IllegalArgumentException {
//
//		String nameregex = "^[A-Za-z]{2,}$";
//		Pattern pattern = Pattern.compile(nameregex);
//		Matcher matcher = pattern.matcher(lastName);
//		Boolean isMatch = matcher.matches();
//
//		if (!isMatch) {
//			throw new IllegalArgumentException("The name should be in minimum 2 letters");
//
//		}
//
//		return true;
//
//	} 

	// email validate
	public static boolean emailValidator(String email) throws InvalidUserException {

		String emailregex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailregex);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new InvalidUserException("The email is invalid");

		}

		return true;
	}

	public static boolean phoneValidator(String password) throws InvalidUserException {
		String numberregex = "[2-9][0-9]{9}";
		Pattern pattern = Pattern.compile(numberregex);
		Matcher matcher = pattern.matcher(password);
		Boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new InvalidUserException("The Phonenumber is invalid");

		}

		return true;

	}

	public static boolean validateAddress(String address) throws InvalidUserException {
	    if (address == null || address.isEmpty()) {
	        throw new InvalidUserException("invalid address");
	    }
	    return true;
	}
	
	public static boolean validateState(String state) throws  InvalidUserException {
		if (state == null) {
			throw new InvalidUserException("invalid state");
		}

		// Below the code for REGEX
		String regex = "^[A-Za-z\\s-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(state);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(state) || state.trim().length() > 15 || state.trim().length() < 4 || !isMatch) {
			throw new InvalidUserException("invalid state");
		}
		return true;
	}

	public static boolean validateCity(String city) throws InvalidUserException {
		if (city == null) {
			throw new InvalidUserException("invalid city");
		}

		// Below the code for regex
		String regex = "^[A-Za-z\\s]+$|^$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(city);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(city) || city.trim().length() > 15 || city.trim().length() < 4 || !isMatch) {
			throw new InvalidUserException("invalid city");
		}
		return true;
	}

	
	public static boolean validatePincode(String pincode) throws InvalidUserException {
		if (pincode == null) {
			throw new InvalidUserException("invalid pincode");
		}

		// below the code for regex
		String regex = "^\\d{6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pincode);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(pincode) || pincode.trim().length() > 6 || !isMatch) {
			throw new InvalidUserException("invalid pincode");
		}
		return true;
	}

	
}
