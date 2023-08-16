package com.fssa.flowerybouquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.flowerybouquet.logger.Logger;
import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidatorError;

// Create product Query 
public class ProductDao {

	public boolean addProduct(Product product) throws DAOException, SQLException {

		String query = "INSERT INTO product (id, name, url, price, category) VALUES (?, ?, ?, ?, ?)";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

				preparedStatement.setInt(1, (product.getProductId()));
				preparedStatement.setString(2, product.getProductName());
				preparedStatement.setString(3, product.getProductImageURL());
				preparedStatement.setDouble(4, (product.getProductPrice()));
				preparedStatement.setString(5, product.getProductCatagory());
				preparedStatement.executeUpdate();
				Logger.info("Product Added");
			}
		} catch (SQLException ex) {
			throw new DAOException("Add Product Method is Failed");
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
				pst.setString(4, product.getProductCatagory());
				pst.executeUpdate();
				Logger.info("Product Update");
			} catch (SQLException e) {
				throw new DAOException("Error Updating product: ", e);
			}
		}
		return true;

	}

//Delete product Query	
	public boolean deleteProduct(int productId) throws DAOException, SQLException {

		if (productId <= 0) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_PRODUCTID);
		}

		String query = "DELETE FROM product WHERE id = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pt = con.prepareStatement(query)) {

				pt.setInt(1, productId);
				pt.executeUpdate();
				Logger.info("Product Deleted");
			} catch (SQLException e) {
				throw new DAOException("Error Deleting product: ", e);
			}
		}
		return true;

	}

	// read product query

	public boolean getAllProductDetails() throws SQLException {

		try (Connection con = ConnectionUtil.getConnection()) {
			final String query = "SELECT * FROM product";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						Logger.info("ID:" + rs.getInt("id") + ",Name :" + rs.getString("name") + ",Price :"
								+ rs.getDouble("price") + ",URL :" + rs.getString("url") + ",Category :"
								+ rs.getString("category"));
					}
					Logger.info("Got All Product Details Successfully");
				}
			}
		} catch (Exception ex) {
			Logger.info(ex.getMessage());
			throw new SQLException("Get All Product Details Method Is Failed");
		}
		return true;
	}

}
