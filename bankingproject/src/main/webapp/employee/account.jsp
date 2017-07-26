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
		
		<h2>You are logged in as <c:out value="${login}"/>.</h2>
		<h3>(If you are leaving your workspace, please, log out)</h3>
		
		<h1>Account page</h1>
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
		<table>
			<tr>
				<td>ID:</td>
				<td><c:out value="${requestScope.id}"/></td>
			</tr>
			
			<tr>
				<td>Balance:</td>
				<td><c:out value="${requestScope.balance}"/></td>
			</tr>
			
			<tr>
				<td>Owner:</td>
				<td><a href = "CustomerServlet?query=${requestScope.owner}"><c:out value="${requestScope.owner}"/></a></td>
			</tr>
		</table>
		
		<form action = "AccountManagerServlet">
			<input type = "hidden" name = "id" value = "${requestScope.id}">
			
			<input type = "text" name = "deposit_amount">
			<input type = "submit" name = "action" value = "deposit">
			<br><br><br>
			<input type = "text" name = "withdraw_amount">
			<input type = "submit" name = "action" value = "withdraw">
			<br><br><br>
			<input type = "text" name = "transfer_id">
			<input type = "text" name = "transfer_amount">
			<input type = "submit" name = "action" value = "transfer">
		</form>
	</div>
</body>

</html>