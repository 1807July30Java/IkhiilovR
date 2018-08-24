package com.revature.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.service.Authentication;



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
				
				HttpSession session = req.getSession();
				//System.out.println(new File(".").getAbsoluteFile());
				//PrintWriter pw = resp.getWriter();
				resp.setContentType("text/html");
				// grab params from request
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				if (Authentication.isValidUser(username, password)) {
//					pw.println("welcome, " + username);
//					pw.println("<a href=\"login\"> Go Back </a>");
					
					EmployeeDAO empDao = new EmployeeDAOImpl();
		            Employee e = empDao.getEmployeeByUsername(username);
					
					session.setAttribute("username", username);
					session.setAttribute("password", password);
		            session.setAttribute("firstName", e.getName());
		            session.setAttribute("lastName", e.getLastname());
		            session.setAttribute("manager", e.getManager());
		            session.setAttribute("isManager", e.getIsManager());
		            session.setAttribute("id", e.getId());
		            session.setAttribute("email", e.getEmail());
		            session.setAttribute("problem", null);
		            
		            if (e.getIsManager() == 1) {
		            	resp.sendRedirect("managerProfile");
		            }else {
		            	resp.sendRedirect("profile");
		            }
				}else {
					resp.sendRedirect("login");
				}
				
			}

	
}
