package com.fssa.flowerbouquet.Dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.InvalidCategoryException;
import com.fssa.flowerybouquet.dao.ProductDao;
import com.fssa.flowerybouquet.logger.Logger;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidatorError;

class TestProductDao {

	public static Product validProductWithId() {

		Product product = new Product();
		product.setProductId(3);
		product.setProductName("Red Bouquet with Black forestCake");
		product.setProductPrice(1700.0);
		product.setProductImageURL("https://iili.io/Hijmt2a.jpg");
		product.setProductCategory("Anniversary Bouquet with Cake");

		return product;

	}

	public static Product validProduct() {

		Product product = new Product();

		product.setProductName("Red Rose Bouquet");
		product.setProductPrice(800.0);
		product.setProductImageURL("https://iili.io/Hijmt2a.jpg");
		product.setProductCategory("Anniversary");

		return product;

	}

	public static Product InvalidProduct() {

		Product product = new Product();
		product.setProductId(-1);
		return product;

	}

	// Test the addProduct method with a valid Product
	@Test
	void testValidAddProduct() throws DAOException, SQLException {
		ProductDao productDao = new ProductDao();
		Assertions.assertTrue(productDao.addProduct(validProduct()));
	}

	// Test the updateProduct method with a valid Product
	@Test
	void testValidUpdateProduct() throws SQLException, DAOException {
		ProductDao productDao = new ProductDao();
		Assertions.assertTrue(productDao.updateProduct(validProductWithId()));
	}

	// Test the deleteProduct method with a valid Product ID
	@Test
	void testValidDeleteProduct() throws SQLException, DAOException {
		ProductDao productDao = new ProductDao();
		Assertions.assertTrue(productDao.deleteProduct(validProductWithId().getProductId()));
	}

	// Test the getAllProductDetails method to get all product details
	@Test
	void testValidGetProductDetails() throws SQLException, DAOException {
		ProductDao productDao = new ProductDao();
		List<Product> productList = productDao.getAllProductDetails();
		for (Product e : productList) {
			Logger.info(e);
		}
	}

	// Test the update method with an invalid Product
	@Test
	void testInvalidUpdateAppointment() throws SQLException, DAOException {
		try {
			Product product = new Product();
			ProductDao productDao = new ProductDao();
			product.setProductId(-1);
			productDao.updateProduct(product);
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTID, ex.getMessage());

		}
	}

	// Test the Delete method with an invalid Product
	@Test
	void testInvalidDeletAppointment() throws SQLException, DAOException {
		try {
			ProductDao productDao = new ProductDao();
			productDao.deleteProduct(InvalidProduct().getProductId());
		} catch (InvalidCategoryException ex) {
			Assertions.assertEquals(ProductValidatorError.INVALID_PRODUCTID, ex.getMessage());
		}
	}
}