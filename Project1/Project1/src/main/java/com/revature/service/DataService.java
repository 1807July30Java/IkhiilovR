package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class DataService {


	private EmployeeDAO  ed = new EmployeeDAOImpl();

	public List<Employee> allEmployeesForManager(String username){
		return ed.getEmployeesForManager(username);
	}

}
