<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="scripts/car-catalog-script.js"></script>  
<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">
<script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>

</head>
<body>
<form method="POST" action="filterCars">
	<h2>Available Cars</h2>
	<div>
		<label>Model</label> 
		<input type="hidden" name="modelInput" id="modelInput"/>
		<select id="model" onChange="setInputValue('model')" >
			<option value="invalid">---</option>
			<option value="D6">D6</option>
			<option value="X6">X6</option>
			<option value="X3">X3</option>
			<option value="Cruze">Cruze</option>
			<option value="Mirage">Mirage</option>
		</select>
		&nbsp;<label>Type</label>
		<input type="hidden" name="typeInput" id="typeInput"/>
		<select id="type" onChange="setInputValue('type')">
			<option value="invalid">---</option>
			<option value="Sedan">Sedan</option>
			<option value="SUV">SUV</option>
		</select> 
		&nbsp;<label>Make</label> 
		<input type="hidden" name="makeInput" id="makeInput"/>
		<select id="make" onChange="setInputValue('make')">
			<option value="invalid">---</option>
			<option value="Volvo">Volvo</option>
			<option value="BMW">BMW</option>
			<option value="Chevrolet">Chevrolet</option>
			<option value="Mitsubishi">Mitsubishi</option>
		</select> 
		
		&nbsp;<label>Year</label>
		<input type="hidden" name="yearInput" id="yearInput"/>
		<select id="year" onChange="setInputValue('year')">
			<option value="invalid">---</option>
			<option value="2011">2011</option>
			<option value="2009">2009</option>
			<option value="2010">2010</option>
			<option value="2017">2017</option>
			<option value="2012">2012</option>
		</select>
		Year Offset <input class="smallNumberInput" type="number" name="yearOffset" width="10" max="5"/>
		
		&nbsp;<label>Color</label>
		<input type="hidden" name="colorInput" id="colorInput"/>
		<select id="color" onChange="setInputValue('color')">
			<option value="invalid">---</option>
			<option value="Red">Red</option>
			<option value="Black">Black</option>
			<option value="White">White</option>
			<option value="Blue">Blue</option>
			<option value="Green">Green</option>
		</select>
		<input type="submit" value="Search"/>
		<input type="checkbox" id="isAvailable"><label>Show Only Available</label>
	</div>
</form>
<br>

<form>
	<table id="myTable" class="sortable">
		<tr class="header">
			<th style="width: 20%;">Model</th>
			<th style="width: 20%;">Type</th>
			<th style="width: 20%;">Make</th>
			<th style="width: 10%;">Year</th>
			<th style="width: 10%;">Color</th>
			<th style="width: 10%;">Availability For Rent</th>
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