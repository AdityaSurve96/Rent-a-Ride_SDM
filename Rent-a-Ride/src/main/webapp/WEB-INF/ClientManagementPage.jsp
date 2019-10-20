<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/custom.css" rel="stylesheet" />
	<script type="text/javascript" src="scripts/car-catalog-script.js"></script>  
	<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">
	<script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>

<meta charset="ISO-8859-1">
<title>Client List</title>
</head>
<body>


<form method = post>

<div class="col-md-6">
	<h2>Client List</h2> 
	</div>
<div class="col-md-6"align="right" >
		<h3>
			<a href="/createNewClient" class="btn btn-primary btn-lg"><u>Create New Client</u></a>
		</h3>
</div> 

<hr style="clear:both;"/>
<div class="container">
	<table id="myTable" class="sortable">
		<tr class="header">
			<th style="width: 25%;">Driver License Number</th>
			<th style="width: 10%;">First Name</th>
			<th style="width: 10%;">Last Name</th>
			<th style="width: 10%;">Phone Number</th>
			<th style="width: 25%;">Expiry Date</th>
			<th style="width: 10%;">Modification</th>
			<th style="width: 10%;">Deletion</th>
		</tr>
		
		<c:forEach var="client" items="${clients}" varStatus="loopCounter">
		<tr class="CarInfo">
			<td>${client.driverlicenseNumber}</td>
			<td>${client.clientFirstName}</td>
			<td>${client.clientFirstName}</td>
			<td>${client.phoneNumber}</td>
			<td>${client.licenseExpiryDate}</td>
			
			<td>  
			<input value= "${loopCounter.count}" type = "hidden" name = "modifyCLientNumber${loopCounter.count}" />
			<input type= "submit" formaction= "/modifyCLientView${loopCounter.count}" value="MODIFY" />
			</td>
			
			<td>  
			<input value= "${loopCounter.count}" type = "hidden" name = "deleteClientNumber${loopCounter.count}" />
			<input type= "submit" formaction= "/deleteClientView${loopCounter.count}" value= "DELETE" />
			</td>
			
		</tr>
		</c:forEach>
		
	</table>
	</div>
	</form>
</body>
</html>