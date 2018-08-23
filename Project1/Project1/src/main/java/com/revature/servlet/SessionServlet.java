package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":\"" + session.getAttribute("username") + "\", "
					+ "\"password\":\"" + session.getAttribute("password") + "\", " 
					+ "\"firstName\":\"" + session.getAttribute("firstName") + "\", " 
					+ "\"lastName\":\"" + session.getAttribute("lastName") + "\", " 
					+ "\"email\":\"" + session.getAttribute("email") + "\", " 
					+ "\"Manager\":\"" + session.getAttribute("manager") + "\", " 
					+ "\"isManager\":\"" + session.getAttribute("isManager") + "\"} "); 
		
		}else {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\": null}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
