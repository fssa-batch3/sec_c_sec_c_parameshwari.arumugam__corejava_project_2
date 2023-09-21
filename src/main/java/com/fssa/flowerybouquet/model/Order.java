package com.fssa.flowerybouquet.model;

import java.time.LocalDate;
import java.util.List;

import com.fssa.flowerybouquet.enums.OrderStatus;

public class Order {

	private int userID;
	private int OrderId;
	private double totalAmount;
	List<OrderDetail> productsList;
	private LocalDate orderedDate;
	private OrderStatus status;
	private String address;

	public Order(int userID, int orderId, double totalAmount, List<OrderDetail> productsList, LocalDate orderedDate,
			OrderStatus status, String address) {
		super();
		this.userID = userID;
		OrderId = orderId;
		this.totalAmount = totalAmount;
		this.productsList = productsList;
		this.orderedDate = orderedDate;
		this.status = status;
		this.address = address;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderDetail> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<OrderDetail> productsList) {
		this.productsList = productsList;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
