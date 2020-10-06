<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List emplyees - coming soon</h1>


<table border = "1">
  <tr>
    <th>Name</th>
    <th>DateOfBirth</th>
    <th>Department</th>
  </tr>
  
  <c:forEach items="${listOfEmployees}" var="employee">
  <tr>
    <td>${employee.name}</td>
    <td>${employee.getDateOfBirth()}</td>
    <td>${employee.getDepartment()}</td>
    </tr>
</c:forEach>
  
  
  
</table>


</body>
</html>