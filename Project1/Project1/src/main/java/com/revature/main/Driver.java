package com.revature.main;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeDAO test = new EmployeeDAOImpl();
		
		
		System.out.println(test.getEmployees());
		System.out.println(test.getEmployeeByID(1));
		System.out.println(test.getEmployeeByUsername("admin"));
		if(test.isValidEmployee("admin", "pass"))
			System.out.println("valid");
		else {
			System.out.println("negative");
		}
		
		
	}

}
