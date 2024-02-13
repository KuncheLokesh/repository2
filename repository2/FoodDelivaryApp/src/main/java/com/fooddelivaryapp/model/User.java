package com.fooddelivaryapp.model;

import java.util.Date;

public class User {
	
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String role;
	
	
	
	public User(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}



	public User(String userName, String password, String email, String address, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}
	
	
	
	public User(int userId,String userName, String password, String email) {
		super();
		this.userId=userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		
	}
	
	public User(int userId,String userName, String password, String email,String address,String role) {
		super();
		this.userId=userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address=address;
		this.role=role;
		
	}


	public int getUserId() {
		return userId;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public String getAddress() {
		return address;
	}


	public String getRole() {
		return role;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	


}
