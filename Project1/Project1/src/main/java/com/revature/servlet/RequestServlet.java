package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.Employee;
import com.revature.beans.Reimburse;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimburseDAO;
import com.revature.dao.ReimburseDAOImpl;

/**
 * Servlet implementation class RequestServlet
 */
@MultipartConfig
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		// check whether a Session exists
		if (session != null && session.getAttribute("username") != null) {
			
			String description = request.getParameter("description");
			String value = request.getParameter("value");
			Part filePart = request.getPart("file");
			//String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		
			InputStream fileContent = filePart.getInputStream();
			
			System.out.println(description);
			System.out.println(value);
			System.out.println(fileContent);
			
			ReimburseDAO newReimburse = new ReimburseDAOImpl();
			EmployeeDAO getID = new EmployeeDAOImpl();
			int employeeId = getID.getEmployeeByUsername(session.getAttribute("username").toString()).getId();
			newReimburse.addNewRequest(new Reimburse(employeeId, Double.parseDouble(value), description, fileContent));
			
			
		}
	}

}
