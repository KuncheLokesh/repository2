package com.fooddelivaryapp.model;

import java.util.Date;

public class OrderHistory {
	
	private int orderHistoryId;
	private int userId;
	private int orderId;
	private Date orderDate;
	private double orderTotalAmount;
	private String status;
	
	
	
	public OrderHistory() {
		super();
	}



	public OrderHistory(int orderHistoryId, int userId, int orderId, Date orderDate, double orderTotalAmount,
			String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderTotalAmount = orderTotalAmount;
		this.status = status;
	}



	public int getOrderHistoryId() {
		return orderHistoryId;
	}



	public int getUserId() {
		return userId;
	}



	public int getOrderId() {
		return orderId;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public double getOrderTotalAmount() {
		return orderTotalAmount;
	}



	public String getStatus() {
		return status;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public void setOrderTotalAmount(double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
