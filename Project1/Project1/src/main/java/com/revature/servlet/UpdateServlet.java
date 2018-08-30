package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.DataService;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// check whether a Session exists
		if (session != null && session.getAttribute("username") != null) {

			request.getRequestDispatcher("views/update.html").forward(request, response);

		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataService ds = new DataService();

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("username") != null) {
			response.setContentType("text/html");
			// grab params from request

			int id = Integer.parseInt(session.getAttribute("id").toString());

			if (request.getParameter("username") != null) {
				String username = request.getParameter("username").toString();
				if (ds.updateEmployee("USERNAME",username , id)) {
					session.setAttribute("username", username);
					response.sendRedirect("profile");
				}
			} else if (request.getParameter("password") != null) {
				String password = request.getParameter("password").toString();
				if (ds.updateEmployee("PASSWORD", password, id)) {
					session.setAttribute("password", password);
					response.sendRedirect("profile");
				}
			} else if (request.getParameter("firstName") != null) {
				String firstName = request.getParameter("firstName").toString();
				if (ds.updateEmployee("EMLOYEE_NAME", firstName, id)) {
					session.setAttribute("firstName", firstName);
					response.sendRedirect("profile");
				}
			} else if (request.getParameter("lastName") != null) {
				String lastName = request.getParameter("lastName").toString();
				if (ds.updateEmployee("EMPLOYEE_LASTNAME", lastName, id)) {
					session.setAttribute("lastName", lastName);
					response.sendRedirect("profile");
				}
			} else if (request.getParameter("email") != null) {
				String email = request.getParameter("email").toString();
				if (ds.updateEmployee("EMPLOYEE_EMAIL", email, id)) {
					session.setAttribute("email", email);
					response.sendRedirect("profile");
				}
			}

		}
	}

}
