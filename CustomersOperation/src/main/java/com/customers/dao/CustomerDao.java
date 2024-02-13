package com.customers.dao;

import java.util.List;

import com.customers.model.Customer;

public interface CustomerDao {

	public int addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public int deleteCustomer(Customer c);
	public List<Customer> getAllCustomers(String sortBy,String value);

}
