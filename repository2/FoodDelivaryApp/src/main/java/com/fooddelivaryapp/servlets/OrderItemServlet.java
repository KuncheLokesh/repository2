package com.fooddelivaryapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivaryapp.daoimpl.OrderItemDaoImpl;
import com.fooddelivaryapp.model.Cart;
import com.fooddelivaryapp.model.CartItem;
import com.fooddelivaryapp.model.OrderItem;


@WebServlet("/oderItem")
public class OrderItemServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int oderId = (int)req.getAttribute("oderId");
		HttpSession session = req.getSession();
		Cart cart =(Cart) session.getAttribute("cart1");
		
		for(CartItem c: cart.getItems().values()) {
			OrderItem od=new OrderItem(c.getItemId(),oderId,c.getRestaurantId(),c.getQuantity(),c.getQuantity()*c.getPrice());
			OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
			orderItemDaoImpl.addOderItem(od);
		}
		
		req.getRequestDispatcher("ordered.jsp").forward(req, resp);
	}
}
