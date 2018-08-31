package com.revature.dao;

import java.io.InputStream;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimburse;

public interface ReimburseDAO {

	public List<Reimburse> getReimburseByEmployee(Employee e);
	public List<Reimburse> getReimburseByEmployeeID(int id);
	public Reimburse getReimburseByID(int id);
	public String getImage(int id);
	public boolean addNewRequest(Reimburse r);
	public byte[] getImageBytes(int id);
	public boolean approveRequest(int id);
	public boolean declineRequest(int id);
}
