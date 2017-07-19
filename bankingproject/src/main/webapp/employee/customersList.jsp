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
	<c:choose>
		<c:when test="${cookie.containsKey('employeeLogin')}">
			<c:set var = "login" value = "${cookie['employeeLogin'].value}"/>
		</c:when>
			
		<c:otherwise>
			<c:redirect url = "../index.jsp"/>
		</c:otherwise>
	</c:choose>
	
	<div align = "right">
		<form action="../LogoutServlet">
			<input type = "submit" value = "Log out">
		</form>
	</div>
	
	<div align = "center">
		<c:forEach var = "customer" items = "${requestScope.customers}">
			<h3><c:out value="${customer[0]}"/> | <c:out value="${customer[1]}"/> | <c:out value="${customer[2]}"/></h3>
		</c:forEach>
	</div>
</body>

</html>