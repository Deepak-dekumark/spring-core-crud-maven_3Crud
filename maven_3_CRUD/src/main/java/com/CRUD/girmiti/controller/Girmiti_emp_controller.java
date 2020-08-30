package com.CRUD.girmiti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.CRUD.girmiti.girmiti_emp_model.Girmiti_emp_pojo;
import com.CRUD.girmiti.service.Serv;

@Controller
public class Girmiti_emp_controller {
	
	@Autowired
	//Girmiti_emp_daoInterface d;
	Serv d;
	
	@RequestMapping(value="/requestFromIndex")
	public ModelAndView requestFromIndexPage()
	{
		return new ModelAndView("InsertForm","key1", new Girmiti_emp_pojo());
		
	}
	
	
	
	//---------- For Inserting Employee details into table -----//
	
	@RequestMapping(value="/requestFromFilledForm",method=RequestMethod.POST)
    public ModelAndView save( Girmiti_emp_pojo e)
	{  
		       d.insertEmployee(e);  
          //return new ModelAndView("Insrt_successMSG");
		       return new ModelAndView("redirect:/requestIndexToControllerForView");
	} 
	
	
//-----------Deleting Employee record present in the table-------//
	
	@RequestMapping(value="/deleteEmpRecord/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id)
	{
		d.deleteEmployeeRecord(id);
      //List<Girmiti_emp_pojo> empDetailsAsObject =d.viewEmployee();
     //	return new ModelAndView("viewEmpDetailsPage","viewKey",empDetailsAsObject);
		
		return new ModelAndView("redirect:/requestIndexToControllerForView");
	}
	
	
	
	
	//--------For updation Employee Records Present in the table ------//

	@RequestMapping(value="/editEmpRequestFromViewPage/{id}")
	public ModelAndView edit(@PathVariable int id)
	{
		Girmiti_emp_pojo empObj=d.viewById(id);
		return new ModelAndView("editPage","keyforEdit",empObj);
	}
	
	@RequestMapping(value="/editEmpRequestFromViewPage/editedRequest",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("empObj") Girmiti_emp_pojo empObj)
       {
		d.updateEmployeerecord(empObj);
		return new ModelAndView("redirect:/requestIndexToControllerForView");
	   }
	
	
	
	
	//----- For Displaying All Record of Employee Present in Table --------//
	
	@RequestMapping(value="/requestIndexToControllerForView")
	public ModelAndView view()
	{
	List<Girmiti_emp_pojo> empDetailsAsObject =d.viewEmployee();
		return new ModelAndView("viewEmpDetailsPage","viewKey",empDetailsAsObject);
	}

	
	//----------------for LOG IN ----------------------//
	
	
	
	@RequestMapping(value="/loginForm",method=RequestMethod.GET)
	public ModelAndView loginpage()
	{   
		return new ModelAndView("login","command",new Girmiti_emp_pojo());
		
	}
	
/*	@RequestMapping(value = "/LoginRequest", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("employee") Girmiti_emp_pojo employee) 
	{
		System.out.println(employee.getName());
		
		if( d.getUserByname(employee.getName())!=null)
		{
			Girmiti_emp_pojo u = d.getUserByname(employee.getName());
			
			if (d.loginPassMatch(employee, u)) 
			{

				return new ModelAndView("Welcome", "Welcomkey", u.getName()+","+u.getId());

			} 
			else 
			{
			ModelAndView modelAndView1 = new ModelAndView();
			modelAndView1.addObject("error", "Invalid Username/Password");
			modelAndView1.setViewName("login");
			modelAndView1.addObject("command", new Girmiti_emp_pojo());
			return modelAndView1;

		}
		}
		else
		{
			ModelAndView modelAndView2 = new ModelAndView();
			modelAndView2.addObject("error", "Invalid Username/Password");
			modelAndView2.setViewName("login");
			modelAndView2.addObject("command", new Girmiti_emp_pojo());
			return modelAndView2;
		}
		
		}*/

	
	
	
		
	@RequestMapping(value = "/LoginRequest", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("girmiti_emp_pojo") Girmiti_emp_pojo girimiti_emp_pojo) 
	{   
		Girmiti_emp_pojo u = d.getUserBypassword(girimiti_emp_pojo.getPassword());

		Girmiti_emp_pojo n = d.getUserByname(girimiti_emp_pojo.getName());
		ModelAndView modelAndView2 = new ModelAndView();
//		System.out.println(u);
		
		if(d.loginPassMatch(girimiti_emp_pojo,u))
		{
			if(d.loginnameMatch(girimiti_emp_pojo,n))
			{
				u.getId();
				modelAndView2.addObject("Welcomkey", u);
				modelAndView2.setViewName("Welcome");
				return modelAndView2;/*("Welcome","Welcomkey",u"name="+u.getName()+" , "+"id="+u.getId()+" , "+"Mobile No.="+u.getMobno()*/
			}
	    }
		
		
		//ModelAndView modelAndView2 = new ModelAndView();
		modelAndView2.addObject("error", "Invalid Username/Password");
		modelAndView2.setViewName("login");
		return modelAndView2;
		
		
	}
	

}
	
	


