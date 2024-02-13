package com.fooddelivaryapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivaryapp.model.Cart;



@WebServlet("/processPayment")
public class CheckOutCart extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart1");
		if(session.getAttribute("user")==null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else if(session.getAttribute("cart")==null) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("orderTable").forward(req, resp);
		}
		
		
	}
}
