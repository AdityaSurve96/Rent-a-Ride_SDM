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
 <h2>Modify A Client Record</h2>
 <br><br>
<div align="center">

<div class="form">
 <div class="col-md-6"><label class="pull-right">Driver Licence Number:</label></div>
 <div class="col-md-6"><input value = "${client.driverLicenceNumber}" class="pull-left" type="text" name="driverLicenseNumber" readonly>
 	
 </div>
 </div>
 <br>
 <div class="form">
 <div class="col-md-6"><label class="pull-right">Client First Name:</label></div>
 <div class="col-md-6"><input value = "${client.clientFirstName}" class="pull-left" type="text" name="clientFirstName" >
 	
 </div>
 </div>
 <br>
 <div class="form">
 <div class="col-md-6"><label class="pull-right">Client Last Name:</label></div>
 <div class="col-md-6"><input value = "${client.clientLastName}" class="pull-left" type="text" name="clientLastName" >
 	 
 </div>
 </div>
 <br>
 <div class="form">
 <div class="col-md-6"><label class="pull-right">Client Phone Number:</label></div>
 <div class="col-md-6"><input value = "${client.phoneNumber}" class="pull-left" type="number" name="phoneNumber">
 	 
 </div>
 </div>
 <br>
 <div class="form">
 
 	<div class="col-md-6"><label class="pull-right">Expiry Date:</label></div>
 	<div class="col-md-6"><input value = "${client.licenceExpiryDate}" class="pull-left" type="date" name="licenceExpiryDate" placeholder="yyyy-mm-dd"></div>

</div>
 <br>
</div>  
   </div>
 <div>
 <br>
 <div align="center">
 	<input value = "${client.driverLicenceNumber}" class="pull-left" type="hidden" name="driverLicenseNumberForForm">
  	<button type="submit" class="btn btn-primary btn-sm" formaction="/gotoClientManagementPageAfterModification" name ="ConfirmModify">Confirm Modification</button>
  	<a href="/ClientManagementPage" class="btn btn-primary btn-sm">Back</a>
 </div>
 </div>
 </div>
 
</form>
</body>
</html>