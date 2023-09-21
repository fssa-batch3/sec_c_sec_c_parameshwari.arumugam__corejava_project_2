package com.fssa.flowerybouquet.validator;

import java.time.LocalDate;
import java.util.List;

import com.fssa.flowerybouquet.enums.OrderStatus;
import com.fssa.flowerybouquet.exception.OrderInvalidException;
import com.fssa.flowerybouquet.model.Order;
import com.fssa.flowerybouquet.model.OrderDetail;

public class OrderValidator {

	Order order = new Order();

	// Set the properties of the order
	public static boolean validateOrder(Order order) throws OrderInvalidException {
		if (order == null) {
			throw new OrderInvalidException("Order is null");
		}

		validateTotalAmount(order.getTotalAmount());
		validateProductsList(order.getProductsList());
		validateOrderedDate(order.getOrderedDate());
		validateStatus(order.getStatus());
		return true;
	}

	public static boolean validateTotalAmount(double totalAmount) throws OrderInvalidException {
		// Check if the price is non-positive
		if (totalAmount <= 0) {
			throw new OrderInvalidException("Invalid Total Ammount");
		}
		return true;
	}

	public static boolean validateProductsList(List<OrderDetail> list) throws OrderInvalidException {
		if (list == null || list.isEmpty()) {
			throw new OrderInvalidException("Invalid productlist");
		}
		return true;
	}

	public static boolean validateOrderedDate(LocalDate orderedDate) throws OrderInvalidException {
		if (orderedDate == null) {
			throw new OrderInvalidException("Invalid order Date");
		}

		LocalDate currentDate = LocalDate.now();

		if (orderedDate.isAfter(currentDate)) {
			throw new OrderInvalidException("Invalid order Date in future");
		}
		return true;
	}

	public static boolean validateStatus(OrderStatus status) throws OrderInvalidException {

		if (status == null) {
			throw new OrderInvalidException("Invalid order Status");
		}
		return false;
	}

	

	public static boolean validateAddress(String address) throws OrderInvalidException {

		if (address != null && !address.isEmpty() && address.length() > 5) {
			throw new OrderInvalidException("Invalid order Address");
		}

		return true;

	}

}
