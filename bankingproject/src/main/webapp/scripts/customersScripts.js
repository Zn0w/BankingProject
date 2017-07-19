function getNewCustomerData() {
	alert("Adding new customer");
}

function getSearchQuery() {
	var query = prompt("Enter customer id");
	
	if (query != null) {
		alert("Finding customer " + query);
	}
}