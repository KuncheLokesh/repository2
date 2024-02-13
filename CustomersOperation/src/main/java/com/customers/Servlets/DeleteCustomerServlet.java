package com.customers.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customers.daoimpl.CustomerDaoImpl;
import com.customers.model.Customer;


@WebServlet("/deleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
		Customer customer = customerDaoImpl.getCustomerById(Integer.parseInt(req.getParameter("id")));
		customerDaoImpl.deleteCustomer(customer);
		req.getRequestDispatcher("index.jsp").include(req, resp);

	}

}
