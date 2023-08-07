package com.fssa.flowerybouquet.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.flowerybouquet.dao.InvalidCategoryException;
import com.fssa.flowerybouquet.model.Product;

public class TestProductValidator {

	Product product = new Product(1, "RedRoseBouquet", "https://iili.io/Hijmt2a.jpg", 1000.0, "Anniversary");

	// Product object valide.
	@Test
	public void testValidProduct() { 
		Assertions.assertTrue(ProductValidator.validate(product));
	}

	// Product object Invalide.

	@Test
	public void testProductValidator() {

		try {
 
			ProductValidator.validate(null);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCT_NULL, e.getMessage());
		}
	}
 
	// 2---test case for product id

	@Test

	public void testValidProductId() {
		int productId = 55; // valid product id
		Assertions.assertTrue(ProductValidator.validateProductId(productId));
	}

	@Test

	public void testInValidProductId() {
		try {
			int productId = -5; // Invalid product id
			ProductValidator.validateProductId(productId);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(ex.getMessage(), ProductValidatorError.INVALID_PRODUCT_ID);
		}
	}

	// product validname validator.

	@Test
	public void testValidName() {
		Assertions.assertTrue(ProductValidator.productNameValidator("RedRoseBouquet"));
	}

	// product invalidname validator.

	@Test
	public void testInvalidName() {

		try {

			ProductValidator.productNameValidator("red");
			Assertions.fail("Validatename failed");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTNAME, ex.getMessage());
		}
	}

	// product name null validator.

	@Test
	void testInvalidNullProductName() {
		try {
			ProductValidator.productNameValidator(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTNAME_NULL, ex.getMessage());
		}
	}
	// product validImage validator.

	@Test
	public void testValidIamge() {
		Assertions.assertTrue(ProductValidator.productImageValidator("https://iili.io/HZHkOzl.jpg"));
	}

	// product InvalidImage validator.

	@Test
	public void testInvalidIamge() {
		try {
			ProductValidator.productImageValidator("https://iili.io/HZHkOzl.https");
			Assertions.fail("Validate image failed");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTIMAGE, ex.getMessage());
		}
	}

	// product null image validator.
	@Test
	void testInvalidNullProductImage() {
		try {
			ProductValidator.productImageValidator(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTIMAGE_NULL, ex.getMessage());
		}
	}

	// product validPrice validator.
	@Test
	public void testValidPrice() {
		Assertions.assertTrue(ProductValidator.productPriceValidator(501));
	}
	// product InvalidPrice validator.

	@Test
	public void testInvalidPrice() {
		try {
			ProductValidator.productPriceValidator(100);
			Assertions.fail("Validateprice failed");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTPRICE, ex.getMessage());
		}
	}

	@Test
	public void testCategory() {

		String mainCategory = "Anniversary";
		Assertions.assertTrue(EnumsValidator.isValidMainCategory(mainCategory));

		String mainCategory2 = "Birthday";
		Assertions.assertTrue(EnumsValidator.isValidMainCategory(mainCategory2));

		String mainCategory3 = "Flowers";
		Assertions.assertTrue(EnumsValidator.isValidMainCategory(mainCategory3));

	}

	@Test
	public void testInvalidCategory() {

		try {
			EnumsValidator.isValidMainCategory(null);
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_MAIN_PRODUCTCATEGORY_NULL, ex.getMessage());
		}

		try {
			EnumsValidator.isValidMainCategory("Reception");
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_MAIN_PRODUCTCATEGORY, ex.getMessage());
		}

	}

	@Test
	public void testAnniversaryCategory() {

		Product p = new Product();
		p.setProductCatagory("Bouquet with cake");
		String anniversaryCategory = p.getProductCatagory();
		Assertions.assertTrue(EnumsValidator.isValidAnniversaryCategory(anniversaryCategory));

	}

	@Test
	public void testInvalidAnniversayCategory() {

		try {
			EnumsValidator.isValidAnniversaryCategory(null);
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_ANNIVERSARY_PRODUCTCATEGORY_NULL, ex.getMessage());
		}

		try {
			EnumsValidator.isValidAnniversaryCategory("gifts");
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_ANNIVERSARY_PRODUCTCATEGORY, ex.getMessage());
		}

	}

	@Test
	public void testBirthdayCategory() {

		String birthdayCategory = "Bouquet";
		Assertions.assertTrue(EnumsValidator.isValidBirthdayCategory(birthdayCategory));

	}

	@Test
	public void testInvalidBirthdayCategory() {

		try {
			EnumsValidator.isValidBirthdayCategory(null);
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_BIRTHDAY_PRODUCTCATEGORY_NULL, ex.getMessage());
		}

		try {
			EnumsValidator.isValidBirthdayCategory("Gifts");
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_BIRTHDAY_PRODUCTCATEGORY, ex.getMessage());
		}

	}

	@Test
	public void testFlowersCategory() {

		String flowersCategory = "Red bouquet";
		Assertions.assertTrue(EnumsValidator.isValidFlowersCategory(flowersCategory));

	}

	@Test
	public void testInvalidFlowersCategory() {

		try {
			EnumsValidator.isValidFlowersCategory(null);
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_FLOWERS_PRODUCTCATEGORY_NULL, ex.getMessage());
		}

		try {
			EnumsValidator.isValidFlowersCategory("White");
			Assertions.fail("Failed");
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_FLOWERS_PRODUCTCATEGORY, ex.getMessage());
		}

	}

	// Validate Getter and Setters
	@Test
	public void testValidProductUsingGtAndSt() {
		Product p = new Product();
		p.setProductId(1);
		p.setProductName("RedRoseBouquet");
		p.setProductPrice(510);
		p.setProductImageURL("https://iili.io/Hijmt2a.jpg");
		p.setProductCatagory("Anniversary");

		Assertions.assertTrue(ProductValidator.validate(p));
	}

}
