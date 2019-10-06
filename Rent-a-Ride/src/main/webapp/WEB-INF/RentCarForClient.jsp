<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>

* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 25%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}


.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 400px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 0.7;
}
a {
  text-decoration: none;
  display: inline-block;
  padding: 8px 16px;
}

a:hover {
  background-color: #ddd;
  color: black;
}

.previous {
  background-color: #f1f1f1;
  color: black;
}

.next {
  background-color: #4CAF50;
  color: white;
}

.round {
  border-radius: 50%;
}
</style>
</head>
<body background="grey">
<form method="post">
<div class="row">

<div class="card">

  <strong><label >Car Licence No : </label>
</strong>
  <input value = "${carLicenseNumber}" type="text" name="CarLicenseNo" readonly><br><br>
   <input value = "${carLicenseNumber}" type="hidden" name="CarLicenseNoForForm">

   <strong> <label>Client First Name: </label>

</strong>

    <input type="text" name="clientFirstName"> <br><br>
    <strong> <label>Client Last Name: </label>

</strong>

    <input type="text" name="clientLastName"> <br><br>
    
    
    
    <strong><label>Client Mobile : </label>
</strong>

       <input type="text" name="phoneNumber"> <br><br>
    <strong><label>Client Drivers Licence: </label>
</strong>

      <input type="text" name="driverLicenceNumber">  <br><br>
      <strong><label>Expiration Date : </label>
      
       <input type="text" name="licenceExpiryDate" placeholder="yyyy/mm/dd"> <br><br>
	<strong><label>Rental Due Date: </label>
</strong>
	   <input type="text" name="dueDate" placeholder="yyyy/mm/dd">  <br><br>

  <strong>
  		<button type="submit" class="card" 
  		style="background-color:lightgrey;color:black;" 
  		formaction="/RentCarForClient">Confirm Rental</button>
  </strong>
  </strong>
  
  <br>
  <br>
  <br>
  </div>
</div>
<br>
<br>
<br>
</form>
<!-- <div align="center">
<a href="A:\FALL 19\SDM\Car1.html" class="modify">&laquo; Previous</a>
<a href="A:\FALL 19\SDM\car.html" class="card" style="background-color:black;color:white;">Back</a>
<a href="A:\FALL 19\SDM\Car3.html" class="delete">Next &raquo;</a>
</div>

 --></body>
</html>