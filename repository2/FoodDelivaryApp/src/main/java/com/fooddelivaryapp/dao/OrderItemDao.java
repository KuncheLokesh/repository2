package com.fooddelivaryapp.dao;

import java.util.List;

import com.fooddelivaryapp.model.OrderItem;

public interface OrderItemDao {
	
	void addOderItem(OrderItem oderItem);
	OrderItem getOderItem(int oderItemId);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrder(int orderItemId);
	List<OrderItem> getAllOrderItem(int OrderId);
	
}
