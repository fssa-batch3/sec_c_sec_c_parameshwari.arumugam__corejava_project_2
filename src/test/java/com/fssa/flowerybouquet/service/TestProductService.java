package com.fssa.flowerybouquet.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
 
import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.ProductDao;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidator;

class TestProductService {

	public Product getProduct() {

		Product product = new Product(

				"Red rose Bouquet", "https://iili.io/Hijmt2a.jpg", 1800, "Anniversary Bouquet with Cake");
		return product;

	}

	public Product getProduct1() {

		Product product = new Product(2, "Red rose Bouquet", "https://iili.io/Hijmt2a.jpg", 800, "Anniversary");
		return product;

	}

	public ProductService getProductService() {

		ProductValidator productValidator = new ProductValidator();
		ProductDao createproductdao = new ProductDao();
		ProductService productService = new ProductService();
		return productService;

	} 

	@Test

	void testAddProduct() throws DAOException, SQLException {
		Product product = getProduct();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.addProduct(product));
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
		Product product = getProduct();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.getAllProductDetails());
	}

}
