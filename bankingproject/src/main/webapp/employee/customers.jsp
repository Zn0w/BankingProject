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
		<br><br><br><br>
		
		<img alt="Add new customer" src="images/addCustomer.png" width = "250" height = "250" hspace = "20" onclick = "getNewCustomerData()">
		
		<img alt="Find customer" src="images/search.png" width = "250" height = "250" hspace = "20" onclick = "getSearchQuery()">
	</div>
</body>

</html>