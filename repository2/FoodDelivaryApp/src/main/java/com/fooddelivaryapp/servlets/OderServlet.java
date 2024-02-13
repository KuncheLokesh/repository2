package com.fooddelivaryapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivaryapp.daoimpl.MenuDaoImpl;
import com.fooddelivaryapp.model.Cart;
import com.fooddelivaryapp.model.CartItem;
import com.fooddelivaryapp.model.Menu;


@WebServlet("/cart")
public class OderServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
//		HttpSession session = req.getSession();
//		LinkedHashMap<Integer,Integer> map =(LinkedHashMap<Integer,Integer>)session.getAttribute("cart");
//		
//		map.put(Integer.parseInt(req.getParameter("menuId")),Integer.parseInt(req.getParameter("quantity")));
//		
//		
//		RequestDispatcher dis = req.getRequestDispatcher("cart.jsp");
//		dis.include(req, resp);
//		

		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart1");
		
		
		if(cart==null) {
			cart=new Cart();
			session.setAttribute("cart1", cart);
		}
		MenuDaoImpl menudao=new MenuDaoImpl();
		Menu menu=menudao.getMenu(Integer.parseInt(req.getParameter("menuId")));
		CartItem item=new CartItem(menu.getMenuId(),menu.getRestaurantId(),menu.getItemName(),menu.getPrice(),Integer.parseInt(req.getParameter("quantity")));

		cart.addCart(item);
		req.setAttribute("restaurantId", menu.getRestaurantId());
		session.setAttribute("restaurantId", menu.getRestaurantId());
		RequestDispatcher dis = req.getRequestDispatcher("cart.jsp");
		dis.include(req, resp);
		
		
	}

}
