package com.CRUD.girmiti.DaoInterface;

import java.util.List;

import com.CRUD.girmiti.girmiti_emp_model.Girmiti_emp_pojo;
 
public interface Girmiti_emp_daoInterface 
{
	public void insertEmployee(Girmiti_emp_pojo gep);
	public void deleteEmployeeRecord(int id);
	public void updateEmployeerecord(Girmiti_emp_pojo ugep);
	public Girmiti_emp_pojo viewById(int id);
	public List<Girmiti_emp_pojo> viewEmployee();
	
	public Girmiti_emp_pojo getUserBypassword(String pswrd);
	public Girmiti_emp_pojo getUserByname(String n);
	public boolean loginPassMatch(Girmiti_emp_pojo gemployee,Girmiti_emp_pojo u);
	public boolean loginnameMatch(Girmiti_emp_pojo gemp,Girmiti_emp_pojo n);
	

	
}
