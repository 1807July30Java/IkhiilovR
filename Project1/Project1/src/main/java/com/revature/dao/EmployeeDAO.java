package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee getEmployeeByID(int id);
	public Employee getEmployeeByUsername(String Username);
	public boolean isValidEmployee(String username, String password);
	public List<Employee> getEmployeesForManager(String username);
}
