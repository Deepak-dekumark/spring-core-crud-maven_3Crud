package com.CRUD.girmiti.girmiti_emp_model;

import org.springframework.stereotype.Component;

@Component
public class Girmiti_emp_pojo {
	int id;
	String name;
	String password;
	String mobno;
	
	
	@Override
	public String toString() {
		return "Girmiti_emp_pojo [id=" + id + ", name=" + name + ", password=" + password + ", mobno=" + mobno + "]";
	}


	public Girmiti_emp_pojo()
	{
		
	}
	
	
	public Girmiti_emp_pojo(int id, String name, String password, String mobno) 
	{
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobno = mobno;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	
	
}



