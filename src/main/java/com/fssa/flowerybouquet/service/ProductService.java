package com.fssa.flowerybouquet.service;

import java.sql.SQLException;

import com.fssa.flowerybouquet.dao.CreateProductDao;
import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidator;

public class ProductService {
	private static ProductValidator productValidator;
	private static CreateProductDao createProductDao;

	public static void setDependencies(ProductValidator validator, CreateProductDao dao) {
		productValidator = validator;
		createProductDao = dao;
	}

	public static boolean addProduct(Product product) throws DAOException, SQLException {
		if (productValidator.validate(product)) {
			createProductDao.addProduct(product);
		}
		return true;
	}

	public static boolean updateProduct(Product product) throws DAOException, SQLException {
		if (productValidator.validate(product)) {
			createProductDao.updateProduct(product);
		}
		return true;
	}

	public static boolean deleteProduct(int productId) throws DAOException, SQLException {
		ProductValidator productValidator = new ProductValidator();
		if (productValidator.validateProductId(productId)) {
			createProductDao.deleteProduct(productId);
		}
		return true;
	}

	public static boolean getAllProductDetails() throws DAOException, SQLException {
		CreateProductDao createProductDao = new CreateProductDao();
		createProductDao.getAllProductDetails();
		return true;
	}
}
