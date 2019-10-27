<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">
<link href="styles/universal.css" rel="stylesheet" type="text/css"/>
<script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<div class="col-md-6">
	<h2>Reservation Transactions</h2> 
	</div>
	<div class="col-md-6">
		<h3>
			<a href="/backToAdminCarCatalog"><u>Back to Admin Car Catalog</u></a>
			<a href="/backToAdminRentedCarList"><u>View Rented Transactions</u></a>
		</h3>
	</div> 

<hr style="clear:both;"/>
<div class="container">
	<table id="myTable" class="sortable">
		<tr class="header">
			<th style="width: 20%;">Car License Plate Number</th>
			<th style="width: 20%;">Client First Name</th>
			<th style="width: 20%;">Client Last Name</th>
			<th style="width: 10%;">Client D.L</th>
			<th style="width: 10%;">Pick-Up Date</th>
			<th style="width: 10%;">Drop-Off Date</th>
			<th style="width: 10%;">TimeStamp</th>
			
		
		</tr>
		
		<c:forEach var="reservedCar" items="${reservations}" varStatus="loopCounter">
		<tr class="CarInfo">
			<td>${reservedCar.car.licensePlateNumber}</td>
			<td>${reservedCar.associatedClient.clientFirstName}</td>
			<td>${reservedCar.associatedClient.clientLastName}</td>
			<td>${reservedCar.associatedClient.driverLicenceNumber}</td>
			<td>${reservedCar.startDate}</td>
			<td>${reservedCar.dueDate}</td>
			<td>${reservedCar.bookingTimestamp}</td>
			
			
			
		</tr>
		</c:forEach>
		
	</table>
	</div>

</body>
</html>