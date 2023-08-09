package com.fssa.flowerybouquet.model;

public class Product {

	private int productId;
	private String productName;
	private String productImageURL;
	private double productPrice;
	private String productCatagory;
//	private float productRatings;

	public Product(String productName, String productImageURL, double productPrice, String productCatagory) {

		this.productName = productName; 
		this.productImageURL = productImageURL; 
		this.productPrice = productPrice;
		this.productCatagory = productCatagory;
//		this.productRatings = productRatings; 

	}

	public Product(int productId, String productName, String productImageURL, double productPrice,
			String productCatagory) {

		this.productId = productId;
		this.productName = productName;
		this.productImageURL = productImageURL;
		this.productPrice = productPrice;
		this.productCatagory = productCatagory;
//		this.productRatings = productRatings; 

	}

	//Default Constructor
	
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

	public String getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}

}
