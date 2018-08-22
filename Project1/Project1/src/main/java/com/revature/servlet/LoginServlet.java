package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;



public class LoginServlet extends HttpServlet{

	// return login page for GET request
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 5998678913965369616L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			req.getRequestDispatcher("views/index.html").forward(req, resp);
		}
		
		// perform authentication for POST request
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
				PrintWriter pw = resp.getWriter();
				resp.setContentType("text/html");
				// grab params from request
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				EmployeeDAO authentication = new EmployeeDAOImpl();
				if (authentication.isValidEmployee(username, password)) {
					pw.println("welcome, " + username);
					pw.println("<a href=\"hello\"> Go Back </a>");
				}else {
					resp.sendRedirect("login");
				}
				
			}

	
}
