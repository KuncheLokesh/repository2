package com.fooddelivaryapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivaryapp.daoimpl.OderDaoImpl;
import com.fooddelivaryapp.model.Cart;
import com.fooddelivaryapp.model.CartItem;
import com.fooddelivaryapp.model.OrderTable;
import com.fooddelivaryapp.model.User;
import com.fooddelivaryapp.utilities.AutoGenerateId;


@WebServlet("/orderTable")
public class OderStatusServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		int resid = (Integer)session.getAttribute("restaurantId");
		User user=(User)session.getAttribute("user");
		
		Cart cart =(Cart) session.getAttribute("cart1");
		
		double amount=0;
		for(CartItem c: cart.getItems().values()) {
			amount +=c.getQuantity()*c.getPrice();
		}
		int id=AutoGenerateId.generateId();
		OrderTable oder =new  OrderTable(id,user.getUserId(), resid, amount,req.getParameter("paymentMethod"));
		
		OderDaoImpl oderimpl=new OderDaoImpl();
		oderimpl.addOder(oder);
		
		req.setAttribute("oderId", id);
		
		req.getRequestDispatcher("oderItem").forward(req, resp);
	}
}
