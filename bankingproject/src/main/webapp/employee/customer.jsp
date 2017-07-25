<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BankingProject</title>
	<link href = "../styles/simpleStyle.css" type = "text/css" rel = "stylesheet">
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
		
		<h2>You are logged in as <c:out value="${login}"/>.</h2>
		<h3>(If you are leaving your workspace, please, log out)</h3>
		
		<h1>Customer page</h1>
	</div>
	
	<div align = "right">
		<form action="../LogoutServlet">
			<input type = "submit" value = "Log out">
		</form>
		
		<form action="employee/mainPage.jsp">
			<input type = "submit" value = "Go to main page">
		</form>
	</div>
	
	<div align = "center">
		<h2>Personal information: </h2>
	
		<table>
			<tr>
				<td>ID:</td>
				<td><c:out value="${requestScope.id}"/></td>
			</tr>
			
			<tr>
				<td>Name:</td>
				<td><c:out value="${requestScope.name}"/></td>
			</tr>
			
			<tr>
				<td>Age:</td>
				<td><c:out value="${requestScope.age}"/></td>
			</tr>
		</table>
		
		<h2>Add account</h2>
		
		<form action="CreateAccountServlet">
			<input type = "hidden" name = "owner" value = "${requestScope.id}">
			<select name = "currency">
				<option value = "USD">USD</option>
				<option value = "EUR">EUR</option>
				<option value = "RUB">RUB</option>
				<option value = "GBP">GBP</option>
			</select>
			<br><br>
			<input type = "submit" value = "Submit">
		</form>
		
		<h2>Accounts information: </h2>
		<table border = "1">
			<tr>
				<th>ID</th>
				<th>Balance</th>
				<th>Currency</th>
			</tr>
			
			<c:forEach var = "account" items = "${requestScope.accounts}">
				<tr>
					<td><c:out value="${account[0]}"/></td>
					<td><c:out value="${account[1]}"/></td>
					<td><c:out value="${account[2]}"/></td>
					<td><a href = "AccountServlet?id=${account[0]}">View account</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>