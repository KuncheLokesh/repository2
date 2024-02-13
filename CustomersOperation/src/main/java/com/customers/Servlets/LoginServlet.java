package com.customers.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customers.daoimpl.LoginDaoImpl;
import com.customers.model.Login;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userid = req.getParameter("username");
		String password=req.getParameter("password");




		if (isValidUser(userid, password)) {
            // Authentication successful
            req.getSession(true);
            HttpSession session = req.getSession();
            session.setAttribute("user", userid);

            // Redirect to the home page or any other secure page after login
            resp.sendRedirect("customerList");
        } else {
            // Authentication failed

            req.setAttribute("loginError", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private boolean isValidUser(String username, String password) {
        // Replace this with your actual authentication logic, e.g., database check


    	LoginDaoImpl logindaoimpl=new LoginDaoImpl();
    	Login loginData = logindaoimpl.getLoginData();



        return loginData.getLoginid().equals(username) && loginData.getPassword().equals(password);
    }

}
