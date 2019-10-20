<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

.modify {
  background-color: #f1f1f1;
  color: black;
}

.delete {
  background-color: #4CAF50;
  color: white;
}

.round {
  border-radius: 50%;
}
</style>
</head>
<body background ="Light grey">
<br>
<br>
<br>
<br>

<br>

<div class="row">

<div class="card">
<br><br>

<form method="post">

  <div class="row">

<div class="card">

  <strong><label >Car Licence No : </label>
</strong>
  <input value = "${carLicenseNumber}" type="text" name="CarLicenseNo" readonly><br><br>
   <input value = "${carLicenseNumber}" type="hidden" name="CarLicenseNoForForm">

   <strong> <label>Client First Name: </label>

</strong>

    <input value = "${clientFirstName}" type="text" name="clientFirstName"> <br><br>
   
    <strong> <label>Client Last Name: </label>

</strong>

    <input value = "${clientLastName}" type="text" name="clientLastName"> <br><br>
    
    
    
    <strong><label>Client Mobile : </label>
</strong>

       <input value = "${phoneNumber}" type="text" name="phoneNumber"> <br><br>
   
    <strong><label>Client Drivers Licence: </label>
</strong>

      <input value = "${driverLicenceNumber}" type="text" name="driverLicenceNumber">  <br><br>
      
      <strong><label>Expiration Date : </label>
      
       <input value = "${licenceExpiryDate}" type="text" name="licenceExpiryDate" placeholder="yyyy/mm/dd"> <br><br>
	
	<strong><label>Rental Due Date: </label>
</strong>
	   <input value = "${dueDate}" type="text" name="dueDate" placeholder="yyyy/mm/dd">  <br><br>

  <strong>
  		
  		<button type="submit" class="card" 
  		style="background-color:lightgrey;color:black;" 
  		formaction="/gotoRentalsPageAfterDelete">Confirm</button>
  </strong>
  </strong>
  <br>
  <br>
  <br>
  </div>
</div>
</form>
</body>
</html>