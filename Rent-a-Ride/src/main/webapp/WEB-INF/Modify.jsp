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

<form action="">

  <strong>Car License Plate  :</strong>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <input type="text" name="licensePlateNumber" value="LBRCOA">
  <br><br>
  <strong>Client First Name:</strong>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <input type="text" name="firstName" value="Divya">
  <br><br>
  <strong>Client Last Name :</strong>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <input type="text" name="lastName" value="Pandit">
  <br><br>
  <strong>Client Mobile Number :</strong>&nbsp
  <input type="text" name="Mobile" value="4383455508">
  <br><br>
 <strong> Client Drivers License:</strong>&nbsp
  <input type="text" name="licenceNo" value="xxxx53465">
  <br><br>
</form>

  <strong><a href="#" class="card" style="background-color:lightgrey;color:black;">Modify</a></strong>
  <br>
  <br>
  <br>
  </div>
</div>
<br>
<br>
<br>

<div align="center">
<a href="#" class="card" style="background-color:black;color:white;">Back</a>
<a href="#" class="delete"> delete </a>
</div>


</body>
</html>