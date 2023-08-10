package com.fssa.flowerybouquet.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.flowerybouquet.model.Product;

public class ProductValidator {

	// Object null validate
	public static boolean validate(Product Product) throws IllegalArgumentException {
		if (Product == null) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCT_NULL);
		}

		productNameValidator(Product.getProductName());
		productImageValidator(Product.getProductImageURL());
		productPriceValidator(Product.getProductPrice());

		return true;

	}

	// Method to check the valid product id
	public static boolean validateProductId(int id) throws IllegalArgumentException {
		// ProductId cannot be less than or equal to 0
		// ProductId cannot more than 500
		if (id <= 0 || id > 500) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCT_ID);
		}
		return true;

	}

	// name validate

	public static boolean productNameValidator(String ProductName) throws IllegalArgumentException {

		if (ProductName == null || ProductName.trim().equals("")) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTNAME_NULL);
		}

		String nameregex = "^[a-zA-Z ]{10,100}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(ProductName);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTNAME);

		} 

		return true;

	}

	// product image validate
	public static boolean productImageValidator(String productimage) throws IllegalArgumentException {

		if (productimage == null) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTIMAGE_NULL);
		}

		String intregex = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
		Pattern pattern = Pattern.compile(intregex);
		Matcher matcher = pattern.matcher(productimage);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTIMAGE);

		}

		return true;

	}

	// Price validate
	public static boolean productPriceValidator(double productPrice) throws IllegalArgumentException {

		if (productPrice > 500 && productPrice < 2000) {
			return true;
		} else {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTPRICE);
		}
	}

}
