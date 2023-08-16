package com.fssa.flowerybouquet.service;

import java.sql.SQLException;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.ProductDao;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidator;

public class ProductService {
//	private static ProductDao productDao;

//	public void setDependencies(ProductValidator validator, ProductDao dao) {
//		productValidator = validator;
//		ProductDao = dao; 
//	}  

	public boolean addProduct(Product product) throws DAOException, SQLException {
		if (ProductValidator.validate(product)) {
			ProductDao productDao = new ProductDao();
			productDao.addProduct(product);
		}
		return true; 
	}

	public boolean updateProduct(Product product) throws DAOException, SQLException {
		if (ProductValidator.validate(product)) {
			ProductDao productDao = new ProductDao();
			productDao.updateProduct(product);
		}
		return true;
	}

	public boolean deleteProduct(int productId) throws DAOException, SQLException {
		if (ProductValidator.validateProductId(productId)) {
			ProductDao productDao = new ProductDao();
			productDao.deleteProduct(productId);
		}
		return true;
	}

	public boolean getAllProductDetails() throws DAOException, SQLException {
		ProductDao productDao = new ProductDao();
		productDao.getAllProductDetails();
		return true;
	}
}
