<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<h1 style="text-align:left;float:left;">Rented Cars List</h1> 
<h2 style="text-align:right;float:right;"><a href="/carCatalog">Go to Car Catalog</a></h2> 
<hr style="clear:both;"/>
	<table id="myTable">
		<tr class="header">
			<th style="width: 20%;">Car License Plate Number</th>
			<th style="width: 20%;">Client First Name</th>
			<th style="width: 20%;">Client Last Name</th>
			<th style="width: 10%;">Client D.L</th>
			<th style="width: 10%;">Modification</th>
			<th style="width: 10%;">Deletion</th>
			
		</tr>
		
		<c:forEach var="rentedcar" items="${rentals}" varStatus="loopCounter">
		<tr class="CarInfo">
			<td>${rentedcar.rentedCar.licensePlateNumber}</td>
			<td>${rentedcar.carsClient.clientFirstName}</td>
			<td>${rentedcar.carsClient.clientLastName}</td>
			<td>${rentedcar.carsClient.driverLicenceNumber}</td>
			<td>  
			<input value="${loopCounter.count}" type = "hidden" name = "rentedCarNumber${loopCounter.count}" />
			<input type="submit" formaction="/rentedCarDetailView${loopCounter.count}" value="MODIFY" />
			</td>
			<td>  
			<input value="${loopCounter.count}" type = "hidden" name = "rentedCarNumber${loopCounter.count}" />
			<input type="submit" formaction="/rentedCarDetailView${loopCounter.count}" value="DELETE" />
			</td>
		</tr>
		</c:forEach>
		
	</table>
	</form>
</body>
</html>