package com.fssa.flowerybouquet.service;

import java.sql.SQLException;

import com.fssa.flowerybouquet.dao.CreateProductDao;
import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidator;

public class ProductService {

	private ProductValidator productvalidator;
	private CreateProductDao createproductdao;

	public ProductService(ProductValidator productvalidator, CreateProductDao createproductdao) {
		super();
		this.productvalidator = productvalidator;
		this.createproductdao = createproductdao;
	}

	public ProductService() {
 
	}

	public boolean addProduct(Product product) throws DAOException, SQLException {
		if (this.productvalidator.validate(product)) {
			this.createproductdao.addProduct(product); 
		}
		return true;

	}

	public boolean updateProduct(Product product) throws DAOException, SQLException {
		if (this.productvalidator.validate(product)) {
			this.createproductdao.updateProduct(product);
		}
		return true;

	}

	public boolean deleteProduct(int ProductId) throws DAOException, SQLException {
		ProductValidator productvalidate = new ProductValidator();
		if (productvalidate.validateProductId(ProductId)) {
			this.createproductdao.deleteProduct(ProductId);
		}
		return true;

	}

	public boolean getAllProductDetails() throws DAOException, SQLException {
		CreateProductDao createproductdao = new CreateProductDao();
		createproductdao.getAllProductDetails();
		return true;
	}

}
