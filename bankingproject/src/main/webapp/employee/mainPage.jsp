<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BankingProject</title>
	
	<script type="text/javascript" src = "../scripts/customersScripts.js"></script>
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
		
		<h1>Main page</h1>
	</div>
	
	<div align = "right">
		<form action="../LogoutServlet">
			<input type = "submit" value = "Log out">
		</form>
	</div>
	
	<div align = "center">
		<br><br><br><br>
		
		<img alt="Add new customer" src="images/addCustomer.png" width = "250" height = "250" hspace = "20" onclick = "setNewCustomerData()">
		
		<img alt="Find customer" src="images/search.png" width = "250" height = "250" hspace = "20" onclick = "setSearchQuery()">
	</div>
	
	<br><br>
	
	<div id = "display" align = "center">
		
	</div>
</body>

</html>