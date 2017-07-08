<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BankingProject</title>
</head>

<body>
	<div align = "center">
		<c:choose>
			<c:when test="${cookie.containsKey('employeeLogin')}">
				<c:set var = "login" value = "${cookie['employeeLogin'].value}"/>
			</c:when>
			
			<c:otherwise>
				<c:redirect url = "../index.jsp"/>
			</c:otherwise>
		</c:choose>
		
		<h1>You are logged in as <c:out value="${login}"/>.</h1>
		<h2>(If you are leaving your workspace, please, log out)</h2>
	</div>
	
	<div align = "right">
		<form action="../LogoutServlet">
			<input type = "submit" value = "Log out">
		</form>
	</div>
	
	<div align = "center">
		<a href = "../CustomerListServlet">
			<img alt="Customers" src="images/customers.jpg">
		</a>
	</div>
</body>

</html>