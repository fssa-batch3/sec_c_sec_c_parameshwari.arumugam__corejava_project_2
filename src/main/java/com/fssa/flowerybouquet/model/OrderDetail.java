package com.fssa.flowerybouquet.model;

public class OrderDetail {

	private int productId;
	private double productPrice;
	private int quantity;
	private String productImage;
	private double totalAmount;

	

	public OrderDetail(int productId, double productPrice, int quantity, String productImage, double totalAmount) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.productImage = productImage;
		this.totalAmount = totalAmount;
	}

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
}
