package com.CRUD.girmiti.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.girmiti.DaoInterface.Girmiti_emp_daoInterface;
import com.CRUD.girmiti.girmiti_emp_model.Girmiti_emp_pojo;
import com.CRUD.girmiti.service.Serv;


@Service
public class ServClass implements Serv
{
   @Autowired
   Girmiti_emp_daoInterface d;
   
   
	public void insertEmployee(Girmiti_emp_pojo g) 
	{
		d.insertEmployee(g);
	}


	public void deleteEmployeeRecord(int id) 
	{
		d.deleteEmployeeRecord(id);
	}


	public void updateEmployeerecord(Girmiti_emp_pojo ugep) 
	{
		d.updateEmployeerecord(ugep);
	}


	public Girmiti_emp_pojo viewById(int id) 
	{
	 return	d.viewById(id);
		
	}


	public List<Girmiti_emp_pojo> viewEmployee() 
	{
	 return	d.viewEmployee();
	}
	
	
	//------login----//
	
	public Girmiti_emp_pojo getUserBypassword(String password)
	{
		return d.getUserBypassword(password);
		
	}
	
	public Girmiti_emp_pojo getUserByname(String name)
	{
		return d.getUserByname(name);
	}
	public boolean loginPassMatch(Girmiti_emp_pojo gemployee,Girmiti_emp_pojo u)
	{
		return d.loginPassMatch(gemployee, u);
	}
	public boolean loginnameMatch(Girmiti_emp_pojo gemp,Girmiti_emp_pojo n)
	{
		return d.loginnameMatch(gemp, n);
		
	}
	

}
