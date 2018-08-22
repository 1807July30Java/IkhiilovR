package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimburse;

public interface ReimburseDAO {

	public List<Reimburse> getReimburseByEmployee(Employee e);
	public Reimburse getReimburseByID(int id);
}
