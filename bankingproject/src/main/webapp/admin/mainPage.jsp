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
			<c:when test="${cookie.containsKey('adminLogin')}">
				<c:set var = "login" value = "${cookie['adminLogin'].value}"/>
			</c:when>
			
			<c:otherwise>
				<c:redirect url = "../index.jsp"/>
			</c:otherwise>
		</c:choose>
		
		<h1>Welcome, <c:out value="${login}"/>!</h1>
		
		<br><br><br><br>
		
		<form action="../LogoutServlet">
			<input type = "submit" value = "Log out">
		</form>
	</div>
</body>

</html>