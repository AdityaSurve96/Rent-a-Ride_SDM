<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Cars:</h4>
	<table border="1" >
		<tr>
			<th>Color</th>
			<th>Year</th>
		</tr>
		<c:forEach var="carr" items="${cars}">
		<tr>
			<td>${carr.name}</td>
			<td>${carr.color}</td>
			<td>${carr.year}</td>
		</tr>		
		</c:forEach>
		
	</table>
</body>
</html>