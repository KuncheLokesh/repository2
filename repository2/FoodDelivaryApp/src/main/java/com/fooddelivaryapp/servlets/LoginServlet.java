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

import com.fooddelivaryapp.daoimpl.UserDaoImpl;
import com.fooddelivaryapp.model.User;


@WebServlet("/checklgoin")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDaoImpl userdao=new UserDaoImpl();
		List<User> allUsers = userdao.getAllUsers();
		boolean find=false;
		
		
		
		for(User u:allUsers) {
//			System.out.print(u.getUserName()+" " +u.getPassword()+"\n");
			if(u.getUserName().equals(req.getParameter("username"))) {
				if(u.getPassword().equals(req.getParameter("password"))) {
					HttpSession session = req.getSession();
					session.setAttribute("user", u);
					RequestDispatcher dis = req.getRequestDispatcher("home.jsp");
					dis.forward(req, resp);
					find=true;
				}
				
			}
		}
		if(!find) {
			RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
			dis.forward(req, resp);
		}
		
		
		
	}



}
