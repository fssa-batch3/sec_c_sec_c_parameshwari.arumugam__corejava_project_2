package com.fssa.flowerybouquet.service;

import java.sql.SQLException;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.ProductDao;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidator;

public class ProductService {
	private static ProductValidator productValidator;
	private static ProductDao ProductDao;

	public void setDependencies(ProductValidator validator, ProductDao dao) {
		productValidator = validator;
		ProductDao = dao; 
	}  

	public boolean addProduct(Product product) throws DAOException, SQLException {
		if (productValidator.validate(product)) {
			ProductDao.addProduct(product);
		}
		return true;
	}

	public boolean updateProduct(Product product) throws DAOException, SQLException {
		if (productValidator.validate(product)) {
			ProductDao.updateProduct(product);
		}
		return true;
	}

	public boolean deleteProduct(int productId) throws DAOException, SQLException {
		ProductValidator productValidator = new ProductValidator();
		if (productValidator.validateProductId(productId)) {
			ProductDao.deleteProduct(productId);
		}
		return true;
	}

	public boolean getAllProductDetails() throws DAOException, SQLException {
		ProductDao ProductDao = new ProductDao();
		ProductDao.getAllProductDetails();
		return true;
	}
}
