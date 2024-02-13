package com.fooddelivaryapp.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	
	
	static int restaurantId;
	Map<Integer,CartItem> items;

	public Cart() {
		items=new LinkedHashMap<Integer,CartItem>();
	}
	
	public void  addCart(CartItem cartItem) {
		if(items.containsKey(cartItem.getItemId())) {
			cartItem.setQuantity(items.get(cartItem.getItemId()).getQuantity()+cartItem.getQuantity());
			items.put(cartItem.getItemId(), cartItem);
		}
		else {
			items.put(cartItem.getItemId(), cartItem);
		}
	}
	
	public void updatecart(CartItem cartItem,int quantity) {
		cartItem.setQuantity(quantity+cartItem.getQuantity());
	}
	
	public Map<Integer,CartItem> getItems(){
		return items;
	}
	
	public void clear() {
		items.clear();
	}
	
	public void romveItem(int itemId) {
		items.remove(itemId);
	}
	
}
