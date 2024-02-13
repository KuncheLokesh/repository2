package com.fooddelivaryapp.model;

import java.util.Date;

public class OrderTable {

	private int orderId;
	private int userId;
	private int restaurantId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	private String paymentMethod;
	
	
	
	public OrderTable() {
		
	}

	

	public OrderTable(int userId, int restaurantId, double totalAmount,String paymentMethod) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.paymentMethod=paymentMethod;
		
	}



	public OrderTable(int orderId, int userId, int restaurantId, Date orderDate, double totalAmount, String status,
			String paymentMethod) {
		
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}

	public OrderTable(int orderId, int userId, int restaurantId, double totalAmount, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
	}


	public int getOrderId() {
		return orderId;
	}



	public int getUserId() {
		return userId;
	}






	public int getRestaurantId() {
		return restaurantId;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public String getStatus() {
		return status;
	}



	public String getPaymentMethod() {
		return paymentMethod;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	
	
}
