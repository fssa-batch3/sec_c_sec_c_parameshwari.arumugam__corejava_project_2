package com.fssa.flowerybouquet.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.InvalidCategoryException;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.util.Logger;
import com.google.protobuf.ServiceException;

/**
 * This class contains JUnit test methods to verify the functionality of the
 * ProductService class. It tests various operations such as adding, updating,
 * deleting, and retrieving product information. The tests use sample Product
 * instances created by the test methods.
 */

class TestProductService {

	/**
	 * Generates and returns a sample Product instance with predefined attributes
	 * for testing purposes.
	 *
	 * @return A sample Product instance.
	 */

	public Product getProduct() {

		Product product = new Product();
		product.setProductName("Love Bouquet");
		product.setProductPrice(650);
		product.setProductImageURL("https://iili.io/H8VBZdJ.jpg");
		product.setProductCategory("AnniversaryBouquetWithCake");

		return product;

 
	}

	/**
	 * Creates and returns an instance of the ProductService class for testing
	 * purposes.
	 *
	 * @return An instance of the ProductService class.
	 */

	public Product updateProductWithId() {

		Product product = new Product();
		product.setProductId(5);
		product.setProductName("Lovely Bouquet");
		product.setProductPrice(1000.0);
		product.setProductImageURL("https://iili.io/H8V74Xs.jpg");
		product.setProductCategory("AnniversaryBouquetWithCake");

		return product;

	}

	public ProductService getProductService() {

		ProductService productService = new ProductService();
		return productService;

	}

	/**
	 * Tests the addProduct method of the ProductService class. It validates whether
	 * a Product can be successfully added using the service.
	 *
	 * @throws DAOException If there's an issue with the data access layer.
	 * @throws SQLException If an SQL-related error occurs.
	 */

	@Test

	void testAddProduct() throws DAOException, SQLException {
//		Product product = getProduct();
		Assertions.assertTrue(getProductService().addProduct(getProduct()));
	}

	/**
	 * Tests the updateProduct method of the ProductService class. It validates
	 * whether a Product can be successfully updated using the service.
	 *
	 * @throws DAOException If there's an issue with the data access layer.
	 * @throws SQLException If an SQL-related error occurs.
	 */

	@Test

	void testUpdateProduct() throws DAOException, SQLException {
		Product product = updateProductWithId();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.updateProduct(product));
	}

	/**
	 * Tests the deleteProduct method of the ProductService class. It validates
	 * whether a Product can be successfully deleted using the service.
	 *
	 * @throws DAOException If there's an issue with the data access layer.
	 * @throws SQLException If an SQL-related error occurs.
	 */
	@Test 

	void testDeleteProduct() throws DAOException, SQLException {
		Product product = updateProductWithId();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.deleteProduct(3));
	}

	/**
	 * Tests the getAllProductDetails method of the ProductService class. It
	 * validates whether a list of Product instances can be successfully retrieved
	 * using the service.
	 *
	 * @throws DAOException If there's an issue with the data access layer.
	 * @throws SQLException If an SQL-related error occurs.
	 */

	@Test

	void testgetAllProductDetails() throws DAOException, SQLException {
		ProductService productService = getProductService();
		List<Product> productList = productService.getAllProductDetails();
		for (Product e : productList) {
			Logger.info(e);
		}

	}
	
	@Test
	void testFindProductByCategory() throws ServiceException, DAOException, SQLException, InvalidCategoryException {
		try {
			List<Product> productList = ProductService.findAllProductByCategory("AnniversaryBouquet");
			for (Product url : productList) {
				Logger.info(url);
			} 
			Assertions.assertNotNull(productList);
		} catch (ServiceException e) { 
			Logger.info(e.getMessage());
		}
	}

}
