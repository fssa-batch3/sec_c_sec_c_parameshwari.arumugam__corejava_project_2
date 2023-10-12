package com.fssa.flowerybouquet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.ProductDao;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.util.Logger;
import com.fssa.flowerybouquet.validator.EnumsValidator;
import com.fssa.flowerybouquet.validator.ProductValidator;
import com.google.protobuf.ServiceException;

public class ProductService {
//	
	public boolean addProduct(Product product) throws DAOException, SQLException,IllegalArgumentException {
		if (ProductValidator.validate(product)) {
			ProductDao productDao = new ProductDao(); 
			productDao.addProduct(product);
		}
		return true;
	}

	public boolean updateProduct(Product product) throws DAOException, SQLException {
		if (ProductValidator.validate(product) && ProductValidator.validateProductId(product.getProductId())) {
			ProductDao productDao = new ProductDao();
			productDao.updateProduct(product);
			Logger.info("Product Update");
		}
		return true;
	}

	public boolean deleteProduct(int productId) throws DAOException, SQLException {
		if (ProductValidator.validateProductId(productId)) {
			ProductDao productDao = new ProductDao();
			productDao.deleteProduct(productId);
			Logger.info("Product Deleted");
		}
		return true;
	}

	public List<Product> getAllProductDetails() throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.getAllProductDetails();

	}
	public static List<Product> findAllProductByCategory(String productCatagory) throws ServiceException {
		try {
			return ProductDao.findProductByCategory(productCatagory);
		} catch (DAOException e) {
			throw new ServiceException("Error while find All Product By Category: " + e.getMessage());
		}
	}
	
	
	public static Product getProductById(int productId) throws SQLException, DAOException {
		return ProductDao.getProductById(productId); // Get the artist's posts from the database
	}
	
}
