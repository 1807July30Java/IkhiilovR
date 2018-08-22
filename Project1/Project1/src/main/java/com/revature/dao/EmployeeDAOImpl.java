package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static String filename = "connection.properties";
	private static Logger log = Logger.getRootLogger();

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> el = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM EMPLOYEE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("EMPLOYEE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD"); 
				String name = rs.getString("EMLOYEE_NAME");
				String lastname = rs.getString("EMPLOYEE_LASTNAME");
				int isManager = rs.getInt("EMPLOYEE_IS_MANAGER");
				int manager = rs.getInt("EMPLOYEE_MANAGER");
				String email = rs.getString("EMPLOYEE_EMAIL");
			
				el.add(new Employee(id, username, password, name, lastname, isManager, manager, email));
				log.info("retrieved employee with id: " + id);
			}
			
			con.close();
		} catch (SQLException e) {
			log.info("Error getting employees sqltrace: " + e);
			//e.printStackTrace();
		} catch (IOException e) {
			log.info("Error getting employees iotrace: " + e);
			//e.printStackTrace();
		}
		return el;
	}

	@Override
	public Employee getEmployeeByID(int id) {

		Employee e = null;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD"); 
				String name = rs.getString("EMLOYEE_NAME");
				String lastname = rs.getString("EMPLOYEE_LASTNAME");
				int isManager = rs.getInt("EMPLOYEE_IS_MANAGER");
				int manager = rs.getInt("EMPLOYEE_MANAGER");
				String email = rs.getString("EMPLOYEE_EMAIL");
				
				e = new Employee(id, username, password, name, lastname, isManager, manager, email);
				log.info("retrieved employee account: " + e.toString());
			} else {
				log.warn("no matching employee found for id: " + id);
			}

		} catch (SQLException ex) {
			log.info("Error getting employee id: " + id + "\nsqltrace: " + ex);
			//ex.printStackTrace();
		} catch (IOException ex) {
			log.info("Error getting employee id: " + id + "\niotrace: " + ex);
			//ex.printStackTrace();
		}

		return e;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {

		Employee e = null;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				String password = rs.getString("PASSWORD"); 
				String name = rs.getString("EMLOYEE_NAME");
				String lastname = rs.getString("EMPLOYEE_LASTNAME");
				int isManager = rs.getInt("EMPLOYEE_IS_MANAGER");
				int manager = rs.getInt("EMPLOYEE_MANAGER");
				String email = rs.getString("EMPLOYEE_EMAIL");
				
				e = new Employee(id, username, password, name, lastname, isManager, manager, email);
				log.info("retrieved employee account: " + e.toString());
			} else {
				log.warn("no matching employee found for username: " + username);
			}

		} catch (SQLException ex) {
			log.info("Error getting employee username: " + username + "\nsqltrace: " + ex);
			//ex.printStackTrace();
		} catch (IOException ex) {
			log.info("Error getting employee username: " + username + "\niotrace: " + ex);
			ex.printStackTrace();
		}

		return e;
	}

}
