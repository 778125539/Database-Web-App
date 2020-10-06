<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add An Employee</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<body>
	<h1>Edit an employee</h1>

	<div class="container">
		Enter name:		 <input type="text" name="name" /> <br /> Enter date of
		birth: <input type="date" name="dob" /><br /> Enter department: <input
			type="text" name="department" /><br />

	
		<button type="button" class="btn btn-outline-warning"
		onclick="window.location.href='../EmployeeController'">Save</button>


	<button type="button" class="btn btn-outline-success"
		onclick="window.location.href='../EmployeeController'">Back
		to Homepage</button>

	</div>



</body>
</html>