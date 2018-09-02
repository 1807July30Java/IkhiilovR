package com.revature.beans;

import java.io.InputStream;

public class Reimburse {
	
	public Reimburse(int id, int status, int employeeID, double value, String type) {
		super();
		this.id = id;
		this.status = status;
		this.employeeID = employeeID;
		this.value = value;
		this.type = type;
	}
	public Reimburse(int status, int employeeID, double value, String type, InputStream image) {
		super();
		this.status = status;
		this.employeeID = employeeID;
		this.value = value;
		this.type = type;
		this.image = image;
	}
	public Reimburse(int employeeID, double value, String type, InputStream image) {
		super();
		this.employeeID = employeeID;
		this.value = value;
		this.type = type;
		this.image = image;
		this.status = 0;
	}
	public Reimburse(int id, int status, int employeeID, double value, String type, InputStream image) {
		super();
		this.id = id;
		this.status = status;
		this.employeeID = employeeID;
		this.value = value;
		this.type = type;
		this.image = image;
	}

	
	private int id;
	private int status;
	private int employeeID;
	private double value;
	private String type;
	private InputStream image;
	
	
	@Override
	public String toString() {
		return "Reimburse [id=" + id + ", status=" + status + ", employeeID=" + employeeID + ", value=" + value
				+ ", type=" + type + ", image=" + image + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + id;
		result = prime * result + status;
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
		if (status != other.status)
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
	

	
}
