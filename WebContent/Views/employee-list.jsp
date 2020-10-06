<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Employees</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<body>
	<h1>List of Employees</h1>

	<div class="container">
		<p>${message}</p>
		<button type="button" class="btn btn-outline-primary"
			onclick="window.location.href='Views/AddEmployee.jsp'">Add
			Employee</button>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-dark">
				<th>No.</th>
				<th>Name</th>
				<th>DateOfBirth</th>
				<th>Department</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${listOfEmployees}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.getDateOfBirth()}</td>
					<td>${employee.getDepartment()}</td>
					<td><a
						href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">
							 Edit
					</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>