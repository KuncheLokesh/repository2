package com.fooddelivaryapp.dao;

import java.util.List;

import com.fooddelivaryapp.model.OrderTable;

public interface OderDao {
	void addOder(OrderTable oder);
	OrderTable getOder(int oderId);
	void updateOrder(OrderTable order);
	void deleteOrder(int orderId);
	List<OrderTable> getAllOrder();
	
	
}
