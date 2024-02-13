package com.customers.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customers.daoimpl.CustomerDaoImpl;
import com.customers.model.Customer;


@WebServlet("/updateCustomerServlet")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
		Customer customerById = customerDaoImpl.getCustomerById(Integer.parseInt(req.getParameter("id")));

		customerById.setFirstName(req.getParameter("firstName"));
		customerById.setLastName(req.getParameter("lastName"));
		customerById.setCity(req.getParameter("city"));
		customerById.setStreet(req.getParameter("street"));
		customerById.setState(req.getParameter("state"));
		customerById.setAddress(req.getParameter("address"));
		customerById.setEmail(req.getParameter("email"));
		customerById.setPhone(req.getParameter("phone"));

		customerDaoImpl.updateCustomer(customerById);

		req.getRequestDispatcher("customerList").forward(req, resp);
	}

}
