package com.fooddelivaryapp.model;

public class OrderItem {
	
	private int orderItemId;
	private int orderId;
	private int menuId;
	private int quantity;
	private double itemToatal;
	
	
	
	
	public OrderItem() {
		super();
	}


	public OrderItem(int orderItemId, int orderId, int menuId, int quantity, double itemToatal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemToatal = itemToatal;
	}
	
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getItemToatal() {
		return itemToatal;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setItemToatal(double itemToatal) {
		this.itemToatal = itemToatal;
	}
	
	
}
