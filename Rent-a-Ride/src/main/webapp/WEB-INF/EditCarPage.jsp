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
 <h2>Edit Car Details</h2>
 <br>
<div class="container" align="center">

<div class="form-group">
	 <div class="col-md-5">
	 	<label class="control-label pull-right">License Plate Number:</label>
	 </div>
	 <div class="col-md-3">
	 	<input value="${car.licensePlateNumber}" class="form-control pull-left" type="text" name="licensePlateNumber" readonly>
	 </div>
 </div>
 
 <div class="form-group">
	 <div class="col-md-5">
	 	<label class="control-label pull-right">Description:</label>
	 </div>
	 <div class="col-md-3">
  		<textarea class="form-control rounded-0" name="description" id="carDescription" rows="2">${car.description}</textarea>
	 </div>
 </div>
 
 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Model:</label>
 	</div>
 	<div class="col-md-3">
 		<input value="${car.model}" class="form-control pull-left" type="text" name="model">
 	</div>
 </div>

 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Type:</label>
 	</div>
 	<div class="col-md-3">
 		<input value="${car.type}" class="form-control pull-left" type="text" name="type">
 	</div>
 </div>

 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Make:</label>
 	</div>
 	<div class="col-md-3">
 		<input value="${car.make}"  class="form-control pull-left" type="text" name="make"></div>
 	</div>

 <div class="form-group">
 	<div class="col-md-5">
 		<label class="control-label pull-right">Year:</label>
 	</div>
 	<div class="col-md-3">
 		<input value="${car.year}" class="form-control pull-left" type="number" name="year">
 	</div>
 </div>

 <div class="form-group">
	<div class="col-md-5">
 		<label class="control-label pull-right">Color:</label>
	</div>
	<div class="col-md-3">
		<input value="${car.color}" class="form-control pull-left" type="text" name="color">
	</div>
</div>

 <div class="form-group">
	<div class="col-md-5">
 		<label class="control-label pull-right">Price:</label>
	</div>
	<div class="col-md-3">
		<input value="${car.price}" class="form-control pull-left" step="0.01" name="price">
	</div>
</div>

<br>

 <div class="form-group">
	<div>
		<button type="submit" class="btn btn-primary btn-md" formaction="/saveCarChanges">Save Changes</button>
	  	<a href="/adminManageCatalog" class="btn btn-primary btn-md">Cancel</a>
	</div>  
 </div>



</div>
</div>
</div>
</form>
</body>
</html>