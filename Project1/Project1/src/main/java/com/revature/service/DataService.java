package com.revature.service;

import java.io.InputStream;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimburseDAO;
import com.revature.dao.ReimburseDAOImpl;

public class DataService {


	private EmployeeDAO  ed = new EmployeeDAOImpl();
	private ReimburseDAO rd = new ReimburseDAOImpl();

	public List<Employee> allEmployeesForManager(String username){
		return ed.getEmployeesForManager(username);
	}
	
	public String getImageForRequest(int id) {
		return rd.getImage(id);
	}

}
