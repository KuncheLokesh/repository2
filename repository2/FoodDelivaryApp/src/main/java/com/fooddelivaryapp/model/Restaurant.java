package com.fooddelivaryapp.model;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String cuisineType;
	private int eta;
	private String address;
	private int adimUserId;
	private float rating;
	private boolean isActive;
	private String imagePath;
	
	
	
	public Restaurant() {
		
	}
	



	public Restaurant(int restaurantId, String name, String cuisineType, int eta, String address, int adimUserId) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.eta = eta;
		this.address = address;
		this.adimUserId = adimUserId;
	}




	public Restaurant(int restaurantId, String name, String cuisineType, int eta, String address, int adimUserId,
			float rating, boolean isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.eta = eta;
		this.address = address;
		this.adimUserId = adimUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}



	public int getRestaurantId() {
		return restaurantId;
	}



	public String getName() {
		return name;
	}



	public String getCuisineType() {
		return cuisineType;
	}



	public int getEta() {
		return eta;
	}



	public String getAddress() {
		return address;
	}



	public int getAdimUserId() {
		return adimUserId;
	}



	public float getRating() {
		return rating;
	}



	public boolean getisActive() {
		return isActive;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}



	public void setEta(int eta) {
		this.eta = eta;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setAdimUserId(int adimUserId) {
		this.adimUserId = adimUserId;
	}



	public void setRating(float rating) {
		this.rating = rating;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}




	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisineType=" + cuisineType + ", eta="
				+ eta + ", address=" + address + ", adimUserId=" + adimUserId + ", rating=" + rating + ", isActive="
				+ isActive + ", imagePath=" + imagePath + "]";
	}
	
	
	
}
