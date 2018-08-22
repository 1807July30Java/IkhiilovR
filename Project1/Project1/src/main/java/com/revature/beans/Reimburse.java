package com.revature.beans;

public class Reimburse {

	public Reimburse(int process, int employeeID, double value, String type) {
		super();
		this.process = process;
		this.employeeID = employeeID;
		this.value = value;
		this.type = type;
	}
	public Reimburse(int id, int process, int employeeID, double value, String type) {
		super();
		this.id = id;
		this.process = process;
		this.employeeID = employeeID;
		this.value = value;
		this.type = type;
	}
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
	private double value;
	private String type;
	
	 
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
		return "Reimburse [id=" + id + ", process=" + process + ", employeeID=" + employeeID + ", value=" + value
				+ ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + id;
		result = prime * result + process;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
