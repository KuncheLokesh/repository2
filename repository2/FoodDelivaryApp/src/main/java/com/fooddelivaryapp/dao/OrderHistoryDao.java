package com.fooddelivaryapp.dao;

import java.util.List;

import com.fooddelivaryapp.model.OrderHistory;

public interface OrderHistoryDao {
	
	void addOderHistory(OrderHistory oderHistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderHistoryDao);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getAllOrderHistory(int userId);
	
}
