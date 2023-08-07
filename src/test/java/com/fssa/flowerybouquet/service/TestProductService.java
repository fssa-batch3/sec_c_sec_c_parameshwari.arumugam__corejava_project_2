package com.fssa.flowerybouquet.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.flowerybouquet.dao.CreateProductDao;
import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidator;

public class TestProductService {

	public Product getProduct() {

		Product product = new Product(

				"Red rose Bouquet", "https://iili.io/Hijmt2a.jpg", 1800, "Anniversary Bouquet with Cake");
		return product;

	}

	public Product getProduct1() {

		Product product = new Product(4, "RedroseBouquet", "https://iili.io/Hijmt2a.jpg", 800,
				"Anniversary Bouquet with Cake");
		return product;

	}

	public ProductService getProductService() {

		ProductValidator productValidator = new ProductValidator();
		CreateProductDao createproductdao = new CreateProductDao();
		ProductService productService = new ProductService(productValidator, createproductdao);
		return productService;

	} 

	@Test

	public void testAddProduct() throws DAOException, SQLException {
		Product product = getProduct();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.addProduct(product));
	}

	@Test

	public void testUpdateProduct() throws DAOException, SQLException {
		Product product = getProduct1();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.updateProduct(product));
	}

	@Test

	public void testDeleteProduct() throws DAOException, SQLException {
		Product product = getProduct1();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.deleteProduct(1));
	}

	@Test

	public void testgetAllProductDetails() throws DAOException, SQLException {
		Product product = getProduct();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.getAllProductDetails());
	}

}
