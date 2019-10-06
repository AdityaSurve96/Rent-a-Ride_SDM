<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">
<link href="styles/universal.css" rel="stylesheet" type="text/css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = post>
<div class="container" align="center">
<h2>Rental Records</h2> 
<h2><a href="/backToCarCatalog">Back to Car Catalog</a></h2> 
<hr style="clear:both;"/>
	<table id="myTable">
		<tr class="header">
			<th style="width: 20%;">Car License Plate Number</th>
			<th style="width: 20%;">Client First Name</th>
			<th style="width: 20%;">Client Last Name</th>
			<th style="width: 10%;">Client D.L</th>
			<th style="width: 10%;">Due Date</th>
			<th style="width: 10%;">Modification</th>
			<th style="width: 10%;">Deletion</th>
		</tr>
		
		<c:forEach var="rentedcar" items="${rentals}" varStatus="loopCounter">
		<tr class="CarInfo">
			<td>${rentedcar.rentedCar.licensePlateNumber}</td>
			<td>${rentedcar.carsClient.clientFirstName}</td>
			<td>${rentedcar.carsClient.clientLastName}</td>
			<td>${rentedcar.carsClient.driverLicenceNumber}</td>
			<td>${rentedcar.dueDate}</td>
			
			<td>  
			<input value="${loopCounter.count}" type = "hidden" name = "modifyCarNumber${loopCounter.count}" />
			<input type="submit" formaction="/modifyCarDetailView${loopCounter.count}" value="MODIFY/DELETE" />
			</td>
		<%-- 	<td>  
			<input value="${loopCounter.count}" type = "hidden" name = "deleteCarNumber${loopCounter.count}" />
			<input type="submit" formaction="/deleteCarDetailView${loopCounter.count}" value="DELETE" />
			</td> --%>
		</tr>
		</c:forEach>
		
	</table>
	</div>
	</form>
</body>
</html>