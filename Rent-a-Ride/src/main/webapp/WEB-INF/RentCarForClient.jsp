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
</head>

<body>

<form method="post">


<div class="container" align="center">
 <div class="form">
 <h2>Create A New Rental</h2>
 <br><br>
<div align="center">

<div class="form">
 <div class="col-md-6"><label class="pull-right">Car License Number:</label></div>
 <div class="col-md-6"><input value = "${carLicenseNumber}" class="pull-left" type="text" name="CarLicenseNo" readonly>
 	 <input value = "${carLicenseNumber}" type="hidden" name="CarLicenseNoForForm">
 </div>
 </div>
 <br>
 <div class="form">
 
 	<div class="col-md-6"><label class="pull-right">Client First Name:</label></div>
 	<div class="col-md-6"><input class="pull-left" type="text" name="clientFirstName"></div>
 	</div>
 <br>
 <div class="form">
 
 	<div class="col-md-6"><label class="pull-right">Client Last Name:</label></div>
 	<div class="col-md-6"><input class="pull-left" type="text" name="clientLastName"></div>
 	</div>
 <br>
 <div class="form">
 
 	<div class="col-md-6"><label class="pull-right">Client Mobile:</label></div>
 	<div class="col-md-6"><input class="pull-left" type="number" name="phoneNumber"></div>
 	</div>
 <br>
 <div class="form">
 
 	<div class="col-md-6"><label class="pull-right">Client Drivers License:</label></div>
 	<div class="col-md-6"><input class="pull-left" type="text" name="driverLicenceNumber"></div>
 	</div>
 <br>
 <div class="form">
 
 	<div class="col-md-6"><label class="pull-right">Expiry Date:</label></div>
 	<div class="col-md-6"><input class="pull-left" type="text" name="licenceExpiryDate" placeholder="yyyy/mm/dd"></div>
</div>
 <br>
 <div class="form">
 
 	<div class="col-md-6"><label class="pull-right">Rental Due Date:</label></div>
 	<div class="col-md-6"><input class="pull-left" type="text" name="dueDate" placeholder="yyyy/mm/dd"></div>
 	</div>
</div>  
   </div>
 <div>
 <br>
 <div align="center">
  	<button type="submit" class="btn btn-primary btn-sm" formaction="/RentCarForClient">Confirm</button>
  	<a href="/back" class="btn btn-primary btn-sm">Back</a>
 </div>
 </div>
 </div>
 
</form>
</body>
</html>