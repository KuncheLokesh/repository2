package com.customers.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customers.daoimpl.CustomerDaoImpl;
import com.customers.model.Customer;

@WebServlet("/customerList")
public class CustomerList extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDaoImpl customerdaoimpl=new CustomerDaoImpl();
		List<Customer> allCustomers = customerdaoimpl.getAllCustomers();

		HttpSession session = req.getSession();
		session.setAttribute("customerlist", allCustomers);
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}


}
