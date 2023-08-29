package com.fssa.flowerybouquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.util.ConnectionUtil;
import com.fssa.flowerybouquet.util.Logger;
import com.fssa.flowerybouquet.validator.ProductValidatorError;

// Create product Query  
public class ProductDao {

	public boolean addProduct(Product product) throws DAOException, SQLException {
		
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO product (name, url, price, category) VALUES (?, ?, ?, ?)";

			try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

				preparedStatement.setString(1, product.getProductName());
				preparedStatement.setString(2, product.getProductImageURL());
				preparedStatement.setDouble(3, product.getProductPrice());
				preparedStatement.setString(4, product.getProductCategory());
				preparedStatement.executeUpdate();
				
			}
		} catch (SQLException ex) {
			throw new DAOException("Add Product Method is Failed" + ex.getMessage());
		}

		return true;
	}

	// Update product Query
	public boolean updateProduct(Product product) throws DAOException, SQLException {

		if (product.getProductId() <= 0) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_PRODUCTID);
		}

		String query = "UPDATE product SET name = ? , url = ? , price = ? , category = ? WHERE id = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(5, (product.getProductId()));
				pst.setString(1, (product.getProductName()));
				pst.setString(2, product.getProductImageURL());
				pst.setDouble(3, (product.getProductPrice()));
				pst.setString(4, product.getProductCategory());
				pst.executeUpdate();

			} catch (SQLException e) {
				throw new DAOException("Error Updating product: ", e);
			}
		}
		return true;

	}

//Delete product Query	
	public boolean deleteProduct(int productId) throws DAOException, SQLException {

		String query = "DELETE FROM product WHERE id = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pt = con.prepareStatement(query)) {

				pt.setInt(1, productId);
				pt.executeUpdate();

			} catch (SQLException e) {
				throw new DAOException("Error Deleting product: ", e);
			}
		}
		return true;

	}

	// read product query

	public List<Product> getAllProductDetails() throws SQLException {

		List<Product> productList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection()) {
			final String query = "SELECT * FROM product";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						Product product = new Product();
						product.setProductId(rs.getInt("id"));
						product.setProductName(rs.getString("name"));
						product.setProductImageURL(rs.getString("url"));
						product.setProductPrice(rs.getDouble("price"));
						product.setProductCategory(rs.getString("category"));
						productList.add(product);
					}

				}
			}
		} catch (Exception ex) {
			Logger.info(ex.getMessage());
			throw new SQLException("Get All Product Details Method Is Failed");
		}
		return productList;
	}

}
