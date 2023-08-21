package com.fssa.flowerybouquet.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.ProductDao;
import com.fssa.flowerybouquet.logger.Logger;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidator;

public class ProductService {
//	
	public boolean addProduct(Product product) throws DAOException, SQLException {
		if (ProductValidator.validate(product)) {
			ProductDao productDao = new ProductDao();
			productDao.addProduct(product);
			Logger.info("Product Added");
		}
		return true;
	}

	public boolean updateProduct(Product product) throws DAOException, SQLException {
		if (ProductValidator.validate(product)) {
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
}
