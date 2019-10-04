<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

.price {
  color: grey;
  font-size: 22px;
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

<h2 style="text-align:center"><strong>Car Details</strong></h2>


<div class="row">

<div class="card">
<img src="/Users/kalpeshthakare/Documents/Workspace/IntelliJ/Rent-a-Ride_SDM/Rent-a-Ride/src/main/resources/static/images/car1.jpg" style="width:350px;height:350px;">
  <p class="price">$199.99</p>
  <strong><label>Name : </label> </strong> <label>Aston Martin E</label>  <br>
  <strong> <label>Licence-Id : </label> </strong> <label>LBYRNTH</label>  <br>
  <strong><label>Color : </label> </strong> <label>Red</label>  <br>
  <strong> <label>Car Availability : </label></strong> <label>Available</label>  <br><br>
  <strong><a href="" class="card" style="background-color:lightgrey;color:black;">Rent</a></strong> <br><br>
  </div>

</div>

<br>
<br>

<div align="center">
<a href="" class="card" style="background-color:black;color:white;">Back</a>
<a href="" class="next">Next &raquo;</a>
</div>


</body>
</html>