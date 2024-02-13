package com.customers.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customers.daoimpl.CustomerDaoImpl;
import com.customers.model.Customer;


@WebServlet("/AddCustomerServlet")
public class addCustomerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();

		Customer customer=new Customer();

		customer.setFirstName(req.getParameter("firstName"));
		customer.setLastName(req.getParameter("lastName"));
		customer.setCity(req.getParameter("city"));
		customer.setStreet(req.getParameter("street"));
		customer.setState(req.getParameter("state"));
		customer.setAddress(req.getParameter("address"));
		customer.setEmail(req.getParameter("email"));
		customer.setPhone(req.getParameter("phone"));

		customerDaoImpl.addCustomer(customer);

		req.getRequestDispatcher("customerList").forward(req, resp);


	}

}
