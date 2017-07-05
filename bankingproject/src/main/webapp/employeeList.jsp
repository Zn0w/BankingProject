<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BankingProject(Employees)</title>
</head>

<body>
	<div align = "center">
		<h1>Employees: </h1>
		
		<table>
			<tr>
				<th>Name</th>
				<th>Login</th>
			</tr>
			
			<c:set var = "employees" value = "${requestScope.employees}"/>
			
			<c:forEach var = "employee" items = "${employees}">
				<tr>
					<td><c:out value="${employee[0]}"></c:out></td>
					<td><c:out value="${employee[1]}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>