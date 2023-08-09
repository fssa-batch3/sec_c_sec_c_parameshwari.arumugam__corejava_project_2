package com.fssa.flowerbouquet.Dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.flowerybouquet.dao.CreateProductDao;
import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.InvalidCategoryException;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidatorError;

public class TestProductDao {

	public static Product validProduct() {

		Product product = new Product();
		product.setProductId(3);
		product.setProductName("Red Bouquet with Black forestCake");
		product.setProductPrice(1700.0);
		product.setProductImageURL("https://iili.io/Hijmt2a.jpg");
		product.setProductCatagory("Anniversary Bouquet with Cake");

		return product;

	}

	public static Product validProduct1() {

		Product product = new Product();

		product.setProductName("Red Rose Bouquet");
		product.setProductPrice(800.0);
		product.setProductImageURL("https://iili.io/Hijmt2a.jpg");
		product.setProductCatagory("Anniversary");

		return product;

	}

	public static Product InvalidProduct() {

		Product product = new Product();
		product.setProductId(-1);
		return product;

	}

	// Test the addProduct method with a valid Product
	@Test
	void testValidAddProduct() throws SQLException, DAOException {
		Assertions.assertTrue(CreateProductDao.addProduct(validProduct1()));
	}

	// Test the updateProduct method with a valid Product
	@Test
	void testValidUpdateProduct() throws SQLException, DAOException {
		Assertions.assertTrue(CreateProductDao.updateProduct(validProduct()));
	}

	// Test the deleteProduct method with a valid Product ID
	@Test
	void testValidDeleteProduct() throws SQLException, DAOException {
		Assertions.assertTrue(CreateProductDao.deleteProduct(validProduct().getProductId()));
	}

	// Test the getAllProductDetails method to get all product details
	@Test
	void testValidGetProductDetails() throws SQLException, DAOException {
		TestProductDao pd = new TestProductDao();
		Assertions.assertTrue(CreateProductDao.getAllProductDetails());
	}

	// Test the addProduct method with an invalid Product
	@Test
	void testInvalidAddProduct() throws SQLException, DAOException {
		try {
			CreateProductDao.addProduct(InvalidProduct());
		} catch (DAOException ex) {
			Assertions.assertEquals("Add Product Method is Failed", ex.getMessage());
		}

	}

	// Test the update method with an invalid Product
	@Test
	void testInvalidUpdateAppointment() throws SQLException, DAOException {
		try {
			Product product = new Product();
			product.setProductId(-1);
			CreateProductDao.updateProduct(product);
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTID, ex.getMessage());

		}
	}

	// Test the Delete method with an invalid Product
	@Test
	void testInvalidDeletAppointment() throws SQLException, DAOException {
		try {
			CreateProductDao.deleteProduct(InvalidProduct().getProductId());
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTID, ex.getMessage());
		}
	}
}