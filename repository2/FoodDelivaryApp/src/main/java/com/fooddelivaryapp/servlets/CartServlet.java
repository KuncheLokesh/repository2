package com.fooddelivaryapp.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivaryapp.model.Cart;
import com.fooddelivaryapp.model.CartItem;


@WebServlet("/oder")
public class CartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if(req.getParameter("action").equalsIgnoreCase("Update")) {
			
			Cart cart = (Cart)session.getAttribute("cart1");
			Map<Integer, CartItem> items = cart.getItems();
			
			if(Integer.parseInt(req.getParameter("quantity"))==0) {
				items.remove(Integer.parseInt(req.getParameter("itemId")));
			}
			else {
				CartItem cartItem = items.get(Integer.parseInt(req.getParameter("itemId")));
				cartItem.setQuantity(Integer.parseInt(req.getParameter("quantity")));
				items.put(cartItem.getItemId(), cartItem);
				
			}
			
		}
		else if(req.getParameter("action").equalsIgnoreCase("remove")) {
			
			Cart cart = (Cart)session.getAttribute("cart1");
			Map<Integer, CartItem> items = cart.getItems();
			
			items.remove(Integer.parseInt(req.getParameter("itemId")));
			
		}
		req.setAttribute("restuarantId", req.getParameter("restuarantId"));
		RequestDispatcher dis = req.getRequestDispatcher("cart.jsp");
		dis.include(req, resp);
	}
}
