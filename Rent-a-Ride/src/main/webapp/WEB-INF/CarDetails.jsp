<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/custom.css" rel="stylesheet" />
<script type="text/javascript" src="scripts/car-catalog-script.js"></script>  
<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">
<script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>

</head>
<body background="grey">


<div class="container" align="center">
<h2 style="text-align:center"><strong>${CarMake} ${CarModel} Details</strong></h2>

<img src="images/car1.jpg" style="width:350px;height:200px;">
 <p class="price">$ ${price}</p>
 
 <div class="form">
 <div class="col-md-6"><label class="pull-right">Model:</label></div>
 <div class="col-md-6"><label class="pull-left">${CarModel}</label></div>
 </div>
 
  <div class="form">
 <div class="col-md-6"><label class="pull-right">Make:</label></div>
 <div class="col-md-6"><label class="pull-left">${CarMake}</label></div>
 </div>
 
  <div class="form">
 <div class="col-md-6"><label class="pull-right">Year:</label></div>
 <div class="col-md-6"><label class="pull-left">${CarYear}</label></div>
 </div>
 
  <div class="form">
 <div class="col-md-6"><label class="pull-right">Car:</label></div>
 <div class="col-md-6"><label class="pull-left">${CarType}</label></div>
 </div>
 
  <div class="form">
 <div class="col-md-6"><label class="pull-right">License Number:</label></div>
 <div class="col-md-6"><label class="pull-left">${CarLicensePlate}</label></div>
 </div>
 
 <div class="form">
 <div class="col-md-6"><label class="pull-right">Color:</label></div>
 <div class="col-md-6"><label class="pull-left">${CarColor}</label></div>
 </div>
</div>
 
 <br>
 
 <div align="center">
  <form method="post">
	  <input value="${CarLicensePlate}" type = "hidden" name = "licensePlate" />
	  <input type="submit" class="btn btn-primary btn-sm" formaction="/rentTheSelectedCar${CarAvailablity}" value="${showRentOrNot}" />
		<a href="/back" class="btn btn-primary btn-sm">Back</a>
		<a href="/next" class="btn btn-primary btn-sm">Next</a>
</form>
</div>


</body>
</html>