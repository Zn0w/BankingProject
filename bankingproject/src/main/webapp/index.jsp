<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BankingProject(User authorization)</title>
</head>

<body>
	<c:if test="${cookie.containsKey('login')}">
		<c:redirect url = "employee/mainPage.jsp"/>
	</c:if>
	
	<div align = "center">
		<h1>Log in to start working</h1>
		
		<br><br><br><br>
		
		<form action="LoginServlet">
			Login: <input type = "text" name = "login">
			<br><br>
			Password: <input type = "password" name = "password">
			<br><br><br>
			<input type = "submit" value = "Log in">
		</form>
		
		<c:if test="${requestScope.message != null}">
			<h2><c:out value = "${requestScope.message}"></c:out></h2>
		</c:if>
	</div>
</body>

</html>