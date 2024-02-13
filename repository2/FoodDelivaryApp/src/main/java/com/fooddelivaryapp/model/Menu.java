package com.fooddelivaryapp.model;

public class Menu {
	
	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private double price;
	private boolean isAvialable;
	
	
	
	
	
	public Menu(int menuId, int restaurantId, String itemName, double price) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
	}

	public Menu() {
			
	}

	public Menu(int menuId, int restaurantId, String itemName, String description, double price, boolean isAvialable) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvialable = isAvialable;
	}
	
	public int getMenuId() {
		return menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public boolean getisAvialable() {
		return isAvialable;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setAvialable(boolean isAvialable) {
		this.isAvialable = isAvialable;
	}
	
	
	

}
