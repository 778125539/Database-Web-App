<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add An Employee</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<h1>Edit an employee</h1>

<body>


	<div class="container">
	<div class = "float-right">
	<a href = "${pageContext.request.contextPath}/logout.jsp"> Logout </a>
	</div>
	
	
		<form action="${pageContext.request.contextPath}/EmployeeController"
			method="POST">
			Enter name: <input type="text" name="firstname"
				value="${employee.name}" /> <br /> Enter date of birth: <input
				type="date" name="dob" value="${employee.dateOfBirth}" /><br />
			Enter department: <input type="text" name="department"
				value="${employee.department}" /><br />
			
			<button class="btn btn-outline-warning" type="submit">Save</button>
			<input type = "hidden"  name ="id" value = "${employee.id}"/>
		</form>

	</div>

	<button type="button" class="btn btn-outline-success"
		onclick="window.location.href='../EmployeeController'">Back
		to Homepage</button>



</body>
</html>