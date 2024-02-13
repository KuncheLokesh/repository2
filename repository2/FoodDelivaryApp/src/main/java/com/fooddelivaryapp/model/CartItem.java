package com.fooddelivaryapp.model;

public class CartItem {
	private int itemId;
	private int restaurantId;
	private String name;
	private double price;
	private int quantity;
	
	
	public CartItem() {
		super();
	}


	public CartItem(int itemId, int restaurantId, String name, double price, int quantity) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}


	public int getItemId() {
		return itemId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	
}
