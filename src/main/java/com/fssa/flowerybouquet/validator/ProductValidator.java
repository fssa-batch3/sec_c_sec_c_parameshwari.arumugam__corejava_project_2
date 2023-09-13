package com.fssa.flowerybouquet.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.flowerybouquet.model.Product;

public class ProductValidator {

	// Object null validate
	public static boolean validate(Product product) throws IllegalArgumentException {
		if (product == null) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCT_NULL);
		}

		productNameValidator(product.getProductName());
		productImageValidator(product.getProductImageURL());
		productPriceValidator(product.getProductPrice());

		return true;

	}

	// Method to check the valid product id
	public static boolean validateProductId(int id) throws IllegalArgumentException {
		// ProductId cannot be less than or equal to 0
		// ProductId cannot more than 500
		if (id <= 0) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCT_ID);
		}
		return true;

	}

	// name validate

	public static boolean productNameValidator(String productName) throws IllegalArgumentException {

		if (productName == null || "".equals(productName.trim())) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTNAME_NULL);
		}

		String nameregex = "^[a-zA-Z ]{10,100}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productName);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTNAME);

		}

		return true;

	}

	// product image validate
	public static boolean productImageValidator(String productImage) throws IllegalArgumentException {

		if (productImage == null) {
			throw new IllegalArgumentException(ProductValidatorError.INVALID_PRODUCTIMAGE_NULL);
		}

		String urlregex = "https?://[^\"']*\\.(?:png|jpe?g|gif|svg|webp)";
		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(productImage);
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
