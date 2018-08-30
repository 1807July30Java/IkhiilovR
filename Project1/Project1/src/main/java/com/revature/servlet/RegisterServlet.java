package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.service.DataService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
			request.getRequestDispatcher("views/registerEmployee.html").forward(request, response);
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

		if (session != null && session.getAttribute("isManager").equals(1)) {
			response.setContentType("text/html");
			// grab params from request
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			int manager = Integer.parseInt(session.getAttribute("id").toString());

			System.out.println(username);
			System.out.println(password);
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(email);
			System.out.println(manager);

			if (ds.addEmployee(new Employee(username, password, firstName, lastName, manager, email))) {
				response.sendRedirect("managersEmployees");
			} else {
				response.sendError(403, "You do not have permission to register an Employee!"
						+ "Stay out of the forest, you can't handle the dementors!");
			}
		}

	}

}
