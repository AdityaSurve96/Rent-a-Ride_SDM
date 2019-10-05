<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

#myInput {
	background-image: url('/css/searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}

#myTable {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
	font-size: 18px;
}

#myTable th, #myTable td {
	text-align: left;
	padding: 12px;
}

#myTable tr {
	border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
	background-color: #f1f1f1;
}
</style>
</head>
<body>

	<h2>Available Cars</h2>
	<div>
		<label>Model</label> 
		<select id="model" onchange="filterCars()">
			<option value="invalid">---</option>
			<option value="D6">D6</option>
			<option value="Mustang">Mustang</option>
			<option value="A4">A4</option>
			<option value="X1">X1</option>
			<option value="X3">X3</option>
			<option value="X5">X5</option>
			
		</select>
		&nbsp;<label>Type</label>
		<select id="type" onchange="filterCars()">
			<option value="invalid">---</option>
			<option value="XY720">XY720</option>
			<option value="GT">GT</option>
			<option value="LX">LX</option>
			<option value="Sports">Sports</option>
		</select> 
		&nbsp;<label>Make</label> 
		<select id="make" onchange="filterCars()">
			<option value="invalid">---</option>
			<option value="Volvo">Volvo</option>
			<option value="Ford">Ford</option>
			<option value="Audi">Audi</option>
			<option value="BMW">BMW</option>
			
		</select> 
		
		&nbsp;<label>Year</label>
		<select id="year" onchange="filterCars()">
			<option value="invalid">---</option>
			<option value="2001">2001</option>
			<option value="2011">2011</option>
			<option value="2015">2015</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
		</select>
		
		&nbsp;<label>Color</label>
		<select id="color" onchange="filterCars()">
			<option value="invalid">---</option>
			<option value="Red">Red</option>
			<option value="Black">Black</option>
			<option value="White">White</option>
			<option value="Blue">Blue</option>
			<option value="Navy">Navy</option>
		</select>
		
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
			
		</tr>
		
		<c:forEach var="car" items="${cars}">
		<tr class="CarInfo">
			<td>${car.model}</td>
			<td>${car.type}</td>
			<td>${car.make}</td>
			<td>${car.year}</td>
			<td>${car.color}</td>
		</tr>
		</c:forEach>
		
	</table>

	<script>
		function filterCars() {
			var input, filter, table, tr, td, i, txtValue;
			
			console.log("test...");
			
			var modelDropdown = document.getElementById("model");
			var modelFilter = model.options[model.selectedIndex].value;
			
			console.log(modelFilter);
			
			var typeDropdown = document.getElementById("type");
			var typeFilter = type.options[type.selectedIndex].value;
			console.log(typeFilter);

			
			var makeDropdown = document.getElementById("make");
			var makeFilter = make.options[make.selectedIndex].value;
			console.log(makeFilter);

			var colorDropdown = document.getElementById("color");
			var colorFilter= color.options[color.selectedIndex].value;
			console.log(colorFilter);

			var yearDropdown = document.getElementById("year");
			var yearFilter = year.options[year.selectedIndex].value;
			console.log(yearFilter);

			
				table = document.getElementById("myTable");
				tr = table.getElementsByTagName("tr");
				for (i = 0; i < tr.length; i++) {
					var modelTd = tr[i].getElementsByTagName("td")[0];
					var typeTd = tr[i].getElementsByTagName("td")[1];
					var makeTd = tr[i].getElementsByTagName("td")[2];
					var yearTd = tr[i].getElementsByTagName("td")[3];
					var colorTd = tr[i].getElementsByTagName("td")[4];

					//model filter
					if (modelTd && modelFilter!='invalid') {
						var txtValue = modelTd.textContent || modelTd.innerText;
						console.log(txtValue);
						if (txtValue.toLowerCase().indexOf(modelFilter.toLowerCase()) > -1) {
							console.log("matched");
							tr[i].style.display = "";
						} else {
							tr[i].style.display = "none";
						}
					}
					
					
					//make filter
					if (makeTd && makeFilter!='invalid') {
						var txtValue = makeTd.textContent || makeTd.innerText;
						if (txtValue.toLowerCase().indexOf(makeFilter.toLowerCase()) > -1) {
							tr[i].style.display = "";
						} else {
							tr[i].style.display = "none";
						}
					}
					
					//type filter
					if (typeTd && typeFilter!='invalid') {
						var txtValue = typeTd.textContent || typeTd.innerText;
						if (txtValue.toLowerCase().indexOf(typeFilter.toLowerCase()) > -1) {
							tr[i].style.display = "";
						} else {
							tr[i].style.display = "none";
						}
					}
					
					//make filter
					if (colorTd && colorFilter!='invalid') {
						var txtValue = colorTd.textContent || colorTd.innerText;
						if (txtValue.toLowerCase().indexOf(colorFilter.toLowerCase()) > -1) {
							tr[i].style.display = "";
						} else {
							tr[i].style.display = "none";
						}
					}
					
					//year filter
					if (yearTd && yearFilter!='invalid') {
						var txtValue = yearTd.textContent || yearTd.innerText;
						if (txtValue.toLowerCase().indexOf(yearFilter.toLowerCase()) > -1) {
							tr[i].style.display = "";
						} else {
							tr[i].style.display = "none";
						}
					}
					
				}
					
		};
		
		
		
		
		(function () {
			  var
			    filters = {
			      model: null,
			      make: null,
			      type: null,
			      color: null,
			      year: null
			    };

			  function updateFilters() {
			    $('.CarInfo').hide().filter(function () {
			      var
			        self = $(this),
			        result = true; // not guilty until proven guilty

			      Object.keys(filters).forEach(function (filter) {
			        if (filters[filter] && (filters[filter] != 'None') && (filters[filter] != 'Any')) {
			          result = result && filters[filter] === self.data(filter);
			        }
			      });

			      return result;
			    }).show();
			  }

			  function bindDropdownFilters() {
			    Object.keys(filters).forEach(function (filterName) {
			      $('#' + filterName + '-filter').on('change', function () {
			        filters[filterName] = this.value;
			        updateFilters();
			      });
			    });
			  }

			  bindDropdownFilters();
			})();
		
		
		
	</script>

</body>