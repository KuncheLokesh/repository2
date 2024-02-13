package com.fooddelivaryapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivaryapp.model.Restaurant;
import com.fooddelivaryapp.utilities.SortRestaurants;


@WebServlet("/sort")
public class SortingServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Restaurant> restaurants = SortRestaurants.sort(req.getParameter("cuisine"));
		HttpSession session = req.getSession();
		session.setAttribute("restaurants", restaurants);
		req.getRequestDispatcher("home.jsp").forward(req, resp);;
		
	}
}
