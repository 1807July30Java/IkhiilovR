package com.revature.beans;

public class Reimburse {

	public Reimburse(int process, int employeeID) {
		super();
		this.process = process;
		this.employeeID = employeeID;
	}
	public Reimburse(int id, int process, int employeeID) {
		super();
		this.id = id;
		this.process = process;
		this.employeeID = employeeID;
	}
	private int id;
	private int process;
	private int employeeID;
	
	//value
	//type
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProcess() {
		return process;
	}
	public void setProcess(int process) {
		this.process = process;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	@Override
	public String toString() {
		return "Reimburse [id=" + id + ", process=" + process + ", employeeID=" + employeeID + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + id;
		result = prime * result + process;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimburse other = (Reimburse) obj;
		if (employeeID != other.employeeID)
			return false;
		if (id != other.id)
			return false;
		if (process != other.process)
			return false;
		return true;
	}
	
	
}
