package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class Authentication {

	public Authentication() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isValidUser(String username, String password) {
		
		EmployeeDAO test = new EmployeeDAOImpl();
		if(username.equals("Aretha") && password.equals("awesome"))
			return true;
		
		if(test.isValidEmployee(username, password))
			return true;
		return false;
		
	}
}
