package com.fooddelivaryapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivaryapp.daoimpl.UserDaoImpl;
import com.fooddelivaryapp.model.User;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!req.getParameter("password").equals(req.getParameter("confirmPassword"))) {
			resp.sendRedirect("signup.jsp");
			
		}
		else {
			String us=req.getParameter("username");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			String confirmPassword=req.getParameter("confirmPassword");
			
			User user=new User(us, confirmPassword, email);
			
			UserDaoImpl userdao=new UserDaoImpl();
			
			List<User> allUsers = userdao.getAllUsers();
			for(User u:allUsers) {
				if(u.getUserName().equals(us)) {
					
					RequestDispatcher dis = req.getRequestDispatcher("signup.jsp");
					req.setAttribute("warning", "User name already exists");
					dis.forward(req, resp);
					return;
				}else {
					userdao.addUser(user);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
					
				}
			}
			
			resp.sendRedirect("checklgoin");
			
			
		}
		
		
		
	}
	
}
