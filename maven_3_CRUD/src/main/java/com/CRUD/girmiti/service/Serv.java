package com.CRUD.girmiti.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.CRUD.girmiti.girmiti_emp_model.Girmiti_emp_pojo;

public interface Serv 
{
	public void insertEmployee(Girmiti_emp_pojo p);
	public void deleteEmployeeRecord(int id);
	public void updateEmployeerecord(Girmiti_emp_pojo ugep);
	public Girmiti_emp_pojo viewById(int id);
	public List<Girmiti_emp_pojo> viewEmployee();
	
	public Girmiti_emp_pojo getUserBypassword(String pswrd);
	public Girmiti_emp_pojo getUserByname(String n);
	public boolean loginPassMatch(Girmiti_emp_pojo gemployee,Girmiti_emp_pojo u);
	public boolean loginnameMatch(Girmiti_emp_pojo gemp,Girmiti_emp_pojo n);

}
