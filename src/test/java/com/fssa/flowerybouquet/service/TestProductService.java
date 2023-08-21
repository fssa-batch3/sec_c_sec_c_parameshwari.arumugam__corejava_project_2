package com.fssa.flowerybouquet.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.logger.Logger;
import com.fssa.flowerybouquet.model.Product;

class TestProductService {

	public Product getProduct() {

		Product product = new Product("Red rose Bouquet", "https://iili.io/Hijmt2a.jpg", 1800,
				"Anniversary Bouquet with Cake");
		return product;

	}

	public Product getProduct1() {

		Product product = new Product(2, "Red rose Bouquet", "https://iili.io/Hijmt2a.jpg", 800, "Anniversary");
		return product;

	}

	public ProductService getProductService() {

		ProductService productService = new ProductService();
		return productService;

	}

	@Test

	void testAddProduct() throws DAOException, SQLException {
//		Product product = getProduct();
		Assertions.assertTrue(getProductService().addProduct(getProduct()));
	}

	@Test

	void testUpdateProduct() throws DAOException, SQLException {
		Product product = getProduct1();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.updateProduct(product));
	}

	@Test

	void testDeleteProduct() throws DAOException, SQLException {
		Product product = getProduct1();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.deleteProduct(36));
	}

	@Test

	void testgetAllProductDetails() throws DAOException, SQLException {
		ProductService productService = getProductService();
		List<Product> productList = productService.getAllProductDetails();
		for (Product e : productList) {
			Logger.info(e);
		}

	}

}
