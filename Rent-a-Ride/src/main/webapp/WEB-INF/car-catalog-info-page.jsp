<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="scripts/car-catalog-script.js"></script>  
<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">


</head>
<body>
<form method="get" action="carList">
	<h2>Available Cars</h2>
	<div>
		<label>Model</label> 
		<select id="model">
			<option value="invalid">---</option>
			<option value="D6">D6</option>
			<option value="Mustang">Mustang</option>
			<option value="A4">A4</option>
			<option value="X1">X1</option>
			<option value="X3">X3</option>
			<option value="X5">X5</option>
			
		</select>
		&nbsp;<label>Type</label>
		<select id="type"">
			<option value="invalid">---</option>
			<option value="XY720">XY720</option>
			<option value="GT">GT</option>
			<option value="LX">LX</option>
			<option value="Sports">Sports</option>
		</select> 
		&nbsp;<label>Make</label> 
		<select id="make"">
			<option value="invalid">---</option>
			<option value="Volvo">Volvo</option>
			<option value="Ford">Ford</option>
			<option value="Audi">Audi</option>
			<option value="BMW">BMW</option>
			
		</select> 
		
		&nbsp;<label>Year</label>
		<select id="year">
			<option value="invalid">---</option>
			<option value="2001">2001</option>
			<option value="2011">2011</option>
			<option value="2015">2015</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
		</select>
		
		&nbsp;<label>Color</label>
		<select id="color">
			<option value="invalid">---</option>
			<option value="Red">Red</option>
			<option value="Black">Black</option>
			<option value="White">White</option>
			<option value="Blue">Blue</option>
			<option value="Navy">Navy</option>
		</select>
		
		<input type="submit">Search</button>
		
		<input type="checkbox" id="isAvailable"><label>Show Only Available</label>
		
	</div>

<br>
	<table id="myTable">
		<tr class="header">
			<th style="width: 20%;">Model</th>
			<th style="width: 20%;">Type</th>
			<th style="width: 20%;">Make</th>
			<th style="width: 10%;">Year</th>
			<th style="width: 10%;">Color</th>
			<th style="width: 10%;">Availablity For Rent</th>
			
			
		</tr>
		
		<c:forEach var="car" items="${cars}">
		<tr class="CarInfo">
			<td>${car.model}</td>
			<td>${car.type}</td>
			<td>${car.make}</td>
			<td>${car.year}</td>
			<td>${car.color}</td>
			<td>${car.availableToRentOrNot}</td>
		</tr>
		</c:forEach>
		
	</table>
</form>
</body>