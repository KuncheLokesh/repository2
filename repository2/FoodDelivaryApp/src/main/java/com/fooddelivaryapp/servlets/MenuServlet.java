package com.fooddelivaryapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivaryapp.daoimpl.MenuDaoImpl;
import com.fooddelivaryapp.model.Menu;


@WebServlet("/menu1")
public class MenuServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenuDaoImpl menu1=new MenuDaoImpl();
		List<Menu> allMenuByRestaurant = menu1.getAllMenuByRestaurant(Integer.parseInt(req.getParameter("restaurantId")));
		
		req.setAttribute("menu", allMenuByRestaurant);
		RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
		HttpSession session = req.getSession();
		session.setAttribute("restaurandId", Integer.parseInt(req.getParameter("restaurantId")));
		dispatcher.forward(req, resp);
		
	}
}
