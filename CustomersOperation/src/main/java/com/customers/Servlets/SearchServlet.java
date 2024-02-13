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

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchBy=req.getParameter("searchBy");
		String value=req.getParameter("searchValue");

		HttpSession session = req.getSession();
		CustomerDaoImpl customerdaoimpl=new CustomerDaoImpl();
		List<Customer> allCustomers = customerdaoimpl.getAllCustomers(searchBy, value);
		session.setAttribute("customerlist", allCustomers);

		req.getRequestDispatcher("index.jsp").include(req, resp);
	}

}
