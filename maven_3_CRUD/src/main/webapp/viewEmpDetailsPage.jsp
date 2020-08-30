<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


 

<body>
<h1>Employee Details :</h1>  
<table   cellpadding="2">  
<tr>
<th>EmpId</th>
<th>EmpName</th>
<th>EmpPassword</th>
<th>EmpMobNo</th> 
<th>Edit</th>
<th>Delete</th>
</tr>   
   <c:forEach var="Girmiti_emp_pojo" items="${viewKey}">   
   <tr>  
   <td>${Girmiti_emp_pojo.id}</td>   
   <td>${Girmiti_emp_pojo.name}</td>  
   <td>${Girmiti_emp_pojo.password}</td>  
   <td>${Girmiti_emp_pojo.mobno}</td> 
    
    <td><a href="editEmpRequestFromViewPage/${Girmiti_emp_pojo.id}">Edit</a></td> 
       
   <td><a href="deleteEmpRecord/${Girmiti_emp_pojo.id}">Delete</a></td>  
   
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  <br />
   <a href="http://localhost:8080/maven_3_CRUD/index.jsp">Click Here For Home page</a><br/>  <br />
	<a href="requestFromIndex">Click Here For create New Employee </a>
</body>
</html>