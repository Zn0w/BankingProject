function setNewCustomerData() {
	document.getElementById("display").innerHTML = "<h3>Register new customer<h3>" +
			"<form action = '../CreateCustomerServlet'>" +
			"First name: <input type = 'text' name = 'first name'>" +
			"Last name:  <input type = 'text' name = 'last name'>" +
			"Age:        <input type = 'text' name = 'age'>" +
			"<input type = 'submit' value = 'Submit'>";
}

function setSearchQuery() {
	var query = prompt("Enter customer id");
	
	if (query != null && !isNaN(query)) {
		window.location.href = "/bankingproject/CustomerServlet?query=" + query;
	}
	else {
		alert("Search query must be a number: without letters nor symbols");
	}
}