package com.fssa.flowerybouquet.model;

public class Product {

	private int productId;
	private String productName;
	private String productImageURL;
	private double productPrice;
	private String productCategory;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productImageURL="
				+ productImageURL + ", productPrice=" + productPrice + ", productCatagory=" + productCategory + "]";
	}

	public Product(String productName, String productImageURL, double productPrice,  String productCategory) {

		this.productName = productName;
		this.productImageURL = productImageURL;
		this.productPrice = productPrice;
		this.productCategory = productCategory;

	}

	public Product(int productId, String productName, String productImageURL, double productPrice,
			 String productCategory) {

		this.productId = productId;
		this.productName = productName;
		this.productImageURL = productImageURL;
		this.productPrice = productPrice;
		this.productCategory = productCategory;

	}

	// Default Constructor

	public Product() {

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImageURL() {
		return productImageURL;
	}

	public void setProductImageURL(String productImageURL) {
		this.productImageURL = productImageURL;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCatagory) {
		this.productCategory = productCatagory;
	}

}
