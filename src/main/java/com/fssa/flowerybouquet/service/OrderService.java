package com.fssa.flowerybouquet.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.flowerybouquet.dao.DAOException;
import com.fssa.flowerybouquet.dao.OrderDAO;
import com.fssa.flowerybouquet.exception.OrderInvalidException;
import com.fssa.flowerybouquet.model.Order;
import com.fssa.flowerybouquet.validator.OrderValidator;

public class OrderService {

	public static boolean addOrder(Order order) throws DAOException, OrderInvalidException, SQLException {

		if (OrderValidator.validateOrder(order)) {

			OrderDAO.addOrder(order);
			return true;
		}
		return false;

	}

	public static ArrayList<Order> getOrderById(int orderId) throws DAOException, OrderInvalidException, SQLException {

		OrderDAO orderDao = new OrderDAO();
		return orderDao.getOrderById(orderId);

	}
	
	
	public static void deleteOrderedProductsByOrderId(int orderId) throws DAOException, OrderInvalidException, SQLException {
		OrderDAO.deleteOrderedProductsByOrderId(orderId);
	}

	public static boolean cancelOrder(int orderId) throws DAOException, OrderInvalidException, SQLException {
		
	return OrderDAO.cancelOrder(orderId);

	}
}
