package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimburse;
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
	
	public List<Reimburse> allReimbursementsForEmployee(int id){
		return rd.getReimburseByEmployeeID(id);
	}
	
	public boolean getisAcceptRequest(int id) {
		return rd.approveRequest(id);
	}
	public boolean getisDeclineRequest(int id) {
		return rd.declineRequest(id);
	}

	public boolean addEmployee(Employee e) {
		return ed.addEmployee(e);
	}

	public boolean updateEmployee(String field, String value, int id) {
		return ed.updateEmployee(field, value, id);
	}
}
