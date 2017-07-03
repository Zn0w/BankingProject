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
	<div align = "center">
		<h1>Hello World</h1>
		
		<c:forEach var = "i" begin = "1" end = "5">
			<h2><c:out value="Hello ${i}"></c:out></h2>
		</c:forEach>
	</div>
</body>

</html>