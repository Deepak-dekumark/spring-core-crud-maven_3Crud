<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INSERT form</title>
</head>
<body>
	<form:form method="POST" action="requestFromFilledForm" modelAttribute="key1" >
	
	<h1>enter the deatils plz</h1>
			<table>
			<tr>
				<td><label >Employee ID :  </label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><label>Employee Name : </label></td>
				<td><form:input path="name" /></td>
			</tr>
			
			<tr>
				<td><label>Your Password : </label></td>
				<td><form:input path="password" /></td>
			</tr>
			
			<tr>
				<td><label>Your MobNum : </label></td>
				<td><form:input path="mobno" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Insert" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>