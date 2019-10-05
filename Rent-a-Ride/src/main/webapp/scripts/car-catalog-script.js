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
	var colorFilter = color.options[color.selectedIndex].value;
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

		// model filter
		if (modelTd && modelFilter != 'invalid') {
			var txtValue = modelTd.textContent || modelTd.innerText;
			console.log(txtValue);
			if (txtValue.toLowerCase().indexOf(modelFilter.toLowerCase()) > -1) {
				console.log("matched");
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}

		// make filter
		if (makeTd && makeFilter != 'invalid') {
			var txtValue = makeTd.textContent || makeTd.innerText;
			if (txtValue.toLowerCase().indexOf(makeFilter.toLowerCase()) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}

		// type filter
		if (typeTd && typeFilter != 'invalid') {
			var txtValue = typeTd.textContent || typeTd.innerText;
			if (txtValue.toLowerCase().indexOf(typeFilter.toLowerCase()) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}

		// make filter
		if (colorTd && colorFilter != 'invalid') {
			var txtValue = colorTd.textContent || colorTd.innerText;
			if (txtValue.toLowerCase().indexOf(colorFilter.toLowerCase()) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}

		// year filter
		if (yearTd && yearFilter != 'invalid') {
			var txtValue = yearTd.textContent || yearTd.innerText;
			if (txtValue.toLowerCase().indexOf(yearFilter.toLowerCase()) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}

	}

}