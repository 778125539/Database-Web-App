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
		<form action="${pageContext.request.contextPath}/EmployeeController?action=UPDATE"
			method="POST">
			Enter name: <input type="text" name="firstname"
				value="${nameOfEmployee}" /> <br /> Enter date of birth: <input
				type="date" name="dob" value="${dateOfBirthOfEmployee}" /><br />
			Enter department: <input type="text" name="department"
				value=" ${departmentOfEmployee}" /><br />
			<button class="btn btn-outline-warning" type="submit">Save</button>

		</form>

	</div>

	<button type="button" class="btn btn-outline-success"
		onclick="window.location.href='../EmployeeController'">Back
		to Homepage</button>



</body>
</html>