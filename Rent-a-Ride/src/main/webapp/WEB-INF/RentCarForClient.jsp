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

<form method="post" class="form-horizontal">
<div align="center">
 <div >
 <h2>Create A New Rental</h2>
 <br>
<div class="container" align="center">

<div class="form-group">
	 <div class="col-md-5">
	 	<label class="control-label pull-right">Car License Number:</label>
	 </div>
	 <div class="col-md-3">
	 	<input value = "${carLicenseNumber}" class="form-control pull-left" type="text" name="CarLicenseNo" readonly>
	 	<input value = "${carLicenseNumber}" type="hidden" name="CarLicenseNoForForm">
	 </div>
 </div>
 
 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Client First Name:</label>
 	</div>
 	<div class="col-md-3">
 		<input class="form-control pull-left" type="text" name="clientFirstName">
 	</div>
 </div>

 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Client Last Name:</label>
 	</div>
 	<div class="col-md-3">
 		<input class="form-control pull-left" type="text" name="clientLastName">
 	</div>
 </div>

 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Client Mobile:</label>
 	</div>
 	<div class="col-md-3">
 		<input class="form-control pull-left" type="number" name="phoneNumber"></div>
 	</div>

 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Client Drivers License:</label>
 	</div>
 	<div class="col-md-3">
 		<input class="form-control pull-left" type="text" name="driverLicenceNumber">
 	</div>
 </div>

 <div class="form-group">
	 	<div class="col-md-5">
	 		<label class="control-label pull-right">Expiry Date:</label>
	 	</div>
	 	<div class="col-md-3">
	 		<input class="form-control pull-left" type="text" name="licenceExpiryDate" placeholder="yyyy/mm/dd">
	 	</div>
	</div>
 	<div class="form-group">
	 	<div class="col-md-5">
	 		<label class="control-label pull-right">Rental Due Date:</label>
	 	</div>
	 	<div class="col-md-3">
	 		<input class="form-control pull-left" type="text" name="dueDate" placeholder="yyyy/mm/dd">
	 	</div>
 	</div>
<br>
	<div class="form-group">
		<div>
	  		<button type="submit" class="btn btn-primary btn-md" formaction="/RentCarForClient">Confirm</button>
	  		<a href="/back" class="btn btn-primary btn-md">Back</a>
		</div>  
	</div>

   </div>
 </div>
 </div>
</form>
</body>
</html>