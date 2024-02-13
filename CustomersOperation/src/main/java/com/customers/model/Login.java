package com.customers.model;

public class Login {
	private String loginid;
	private String Password;







	public Login(String loginid, String password) {
		super();
		this.loginid = loginid;
		Password = password;
	}


	public String getLoginid() {
		return loginid;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}



}
