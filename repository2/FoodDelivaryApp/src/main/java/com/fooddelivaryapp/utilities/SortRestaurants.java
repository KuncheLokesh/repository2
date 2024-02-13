package com.fooddelivaryapp.utilities;

import java.util.ArrayList;
import java.util.List;

import com.fooddelivaryapp.daoimpl.RestaurantDaoImpl;
import com.fooddelivaryapp.model.Restaurant;

public class SortRestaurants {

	public static List<Restaurant> sort(String cuisine){
		
		List<Restaurant> restaurants=new ArrayList<Restaurant>();
		RestaurantDaoImpl resturantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> allRestaurant = resturantDaoImpl.getAllRestaurant();
		for(Restaurant res:allRestaurant) {
			if(res.getCuisineType().equals(cuisine)) {
				restaurants.add(res);
			}
		}
		
		for(Restaurant res:allRestaurant) {
			if(!res.getCuisineType().equals(cuisine)) {
				restaurants.add(res);
			}
		}
		return restaurants;
		
		
	}
}
