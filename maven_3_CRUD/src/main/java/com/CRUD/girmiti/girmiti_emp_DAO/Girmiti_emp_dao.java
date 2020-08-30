package com.CRUD.girmiti.girmiti_emp_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.CRUD.girmiti.DaoInterface.Girmiti_emp_daoInterface;
import com.CRUD.girmiti.girmiti_emp_model.Girmiti_emp_pojo;

@Repository
public class Girmiti_emp_dao implements Girmiti_emp_daoInterface
{
	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	
	//-----------------insert method---------------------//
	public void insertEmployee(Girmiti_emp_pojo gep)
	{
		String query="insert into girmitiEmp values ('"+gep.getId()+"','"+gep.getName()+"','"+gep.getPassword()+"','"+gep.getMobno()+"')";
		
		template.update(query);
	}
	//------------------------ delete method--------------------------//
	public void deleteEmployeeRecord(int id)
	{
		String query="delete from girmitiEmp where id="+id+"";
		template.update(query);
	}
	
	//------------------- Update method--------------- --//
	public void updateEmployeerecord(Girmiti_emp_pojo ugep)
	{
		String query="update girmitiEmp set name='"+ugep.getName()+"',password='"+ugep.getPassword()+"',mobno='"+ugep.getMobno()+"'  where id='"+ugep.getId()+"'";
		template.update(query);
	}
	
	//--- -------------View method---------------------------//

	public Girmiti_emp_pojo viewById(int id)
	{
		String query="select * from girmitiEmp where id=?";
		return template.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<Girmiti_emp_pojo>(Girmiti_emp_pojo.class));
	}
	
	
	public List<Girmiti_emp_pojo> viewEmployee(){
		return template.query("select * from girmitiEmp ", new RowMapper<Girmiti_emp_pojo>()
				{

					public Girmiti_emp_pojo mapRow(ResultSet rs, int rownumber) throws SQLException
					{
						Girmiti_emp_pojo ge=new Girmiti_emp_pojo();
						ge.setId(rs.getInt(1));
						ge.setName(rs.getString(2));
						ge.setPassword(rs.getString(3));
						ge.setMobno(rs.getString(4));
						return ge;
					}
				});	
	}
	
	//---------------------logIn method-------------------------//
	
	
	
//	public Girmiti_emp_pojo getUserByname(String name)
//	{ 
//		String sql="select * from girmitiEmp where name=?";
//		return template.queryForObject(sql, new Object[]{name},new BeanPropertyRowMapper<Girmiti_emp_pojo>(Girmiti_emp_pojo.class));
//	}
//	public Girmiti_emp_pojo getUserBypassword(String password)
//	{ 
//		String sql="select * from girmitiEmp where password=?";
//	    return template.queryForObject(sql, new Object[]{password},new BeanPropertyRowMapper<Girmiti_emp_pojo>(Girmiti_emp_pojo.class));
//	}
//	
//	
//	public boolean loginPassMatch(Girmiti_emp_pojo girmiti_emp_pojo,Girmiti_emp_pojo u)
//	{	
//		String s=girmiti_emp_pojo.getPassword();
//		System.out.println(s);
//		String s1=u.getPassword();
//		System.out.println(s1);
//		
//		if(s.equals(s1))
//			return true;
//		else
//		return false;
//	}
//	
//	public boolean loginnameMatch(Girmiti_emp_pojo girmiti_emp_pojo,Girmiti_emp_pojo n)
//	{	String s=girmiti_emp_pojo.getName();
//		String s1=n.getName();
//		
//		if(s.equals(s1))
//			return true;
//		else
//	return false;
//	}
//	
	
		
	public Girmiti_emp_pojo getUserBypassword(String password)
	{ System.out.println("ppppp"+password);
		String sql="select * from girmitiEmp where password=?";
	 return template.queryForObject(sql, new Object[]{password},new BeanPropertyRowMapper<Girmiti_emp_pojo>(Girmiti_emp_pojo.class));
	}
	
	
	
	public Girmiti_emp_pojo getUserByname(String name)
	{ String query="select * from girmitiEmp where name=?";
	 return template.queryForObject(query, new Object[]{name},new BeanPropertyRowMapper<Girmiti_emp_pojo>(Girmiti_emp_pojo.class));
	}
	
	public boolean loginPassMatch(Girmiti_emp_pojo gemployee,Girmiti_emp_pojo u)
	{	
		String s=gemployee.getPassword();
		System.out.println(s);
		
		String s1=u.getPassword();
		System.out.println(s1);
		
		if(s.equals(s1))
			return true;
		else
		return false;
	}
	
	public boolean loginnameMatch(Girmiti_emp_pojo gemp,Girmiti_emp_pojo n)
	{	String s=gemp.getName();
		String s1=n.getName();
		
		if(s.equals(s1))
			return true;
		else
	return false;
	}
	}
