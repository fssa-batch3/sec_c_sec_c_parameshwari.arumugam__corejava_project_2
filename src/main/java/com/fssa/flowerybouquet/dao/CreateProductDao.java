package com.fssa.flowerybouquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.flowerybouquet.model.Product;
import com.fssa.flowerybouquet.validator.ProductValidatorError;

// Create product Query 
public class CreateProductDao {

	public static boolean addProduct(Product product) throws DAOException, SQLException {

		Connection con = null;
 
		try {

			String query = "INSERT INTO product (id, name, url, price, category) VALUES (?, ?, ?, ?, ?)";
			con = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setInt(1, (product.getProductId()));
			preparedStatement.setString(2, product.getProductName()); 
			preparedStatement.setString(3, product.getProductImageURL());
			preparedStatement.setDouble(4, (product.getProductPrice()));
			preparedStatement.setString(5, product.getProductCatagory());
			preparedStatement.executeUpdate();
			System.out.println("Product Added");
		} catch (SQLException ex) {
//			ex.printStackTrace();
			throw new DAOException("Add Product Method is Failed");
		}

		finally {
			ConnectionUtil.close(con, null, null);
		}

		return true;
	}

	// Update product Query
	public static boolean updateProduct(Product product) throws DAOException, SQLException {

		if (product.getProductId() <= 0) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_PRODUCTID);
		}

		Connection con = null;

		try {

			String query = "UPDATE product SET name = ? , url = ? , price = ? , category = ? WHERE id = ?";
			con = ConnectionUtil.getConnection();

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(5, (product.getProductId()));
			pst.setString(1, (product.getProductName()));
			pst.setString(2, product.getProductImageURL());
			pst.setDouble(3, (product.getProductPrice()));
			pst.setString(4, product.getProductCatagory());
			pst.executeUpdate();
			System.out.println("Product Update");
		} catch (SQLException e) {
			throw new DAOException("Error Updating product: ", e);
		} finally {
			ConnectionUtil.close(con, null, null);
		}

		return true;

	}

//Delete product Query	
	public static boolean deleteProduct(int productId) throws DAOException, SQLException {

		if (productId <= 0) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_PRODUCTID);
		}

		Connection con = null;

		try {

			String query = "DELETE FROM product WHERE id = ?";
			con = ConnectionUtil.getConnection();

			PreparedStatement pt = con.prepareStatement(query);
			pt.setInt(1, productId);
			pt.executeUpdate();
			System.out.println("Product Deleted");
		} catch (SQLException e) {
			throw new DAOException("Error Deleting product: ", e);
		} finally {
			ConnectionUtil.close(con, null, null);
		}

		return true;

	}

	// read product query

	public static boolean getAllProductDetails() throws DAOException, SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			final String query = "SELECT * FROM product";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						System.out.println("ID:" + rs.getInt("id") + ",Name :" + rs.getString("name") + ",Price :"
								+ rs.getDouble("price") + ",URL :" + rs.getString("url") + ",Category :"
								+ rs.getString("category"));
					}
					System.out.println("Got All Product Details Successfully");
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new SQLException("Get All Product Details Method Is Failded");
		}

		return true; 
	}

	// main method

	public static void main(String[] args) throws DAOException, SQLException {

//		Product p1 = new Product();
//
//		p1.setProductName("Love Bouquet");
//		p1.setProductImageURL("https://iili.io/Hijmt2a.jpg");
//		p1.setProductPrice(500);
//		p1.setProductCatagory("Yellow Bouquet");
//
//		addProduct(p1);

//		Product p2 = new Product();
//
//		p2.setProductId(4);
//		p2.setProductName("Love Bouquet");
//		p2.setProductImageURL("https://iili.io/Hijmt2a.jpg");
//		p2.setProductPrice(500);
//		p2.setProductCatagory("Anniversary Bouquet with Cake");
//
//		updateProduct(p2);

//      deleteProduct(18);

//		getAllProductDetails(); 

	}
}
