function getNewCustomerData() {
	alert("Adding new customer");
}

function getSearchQuery() {
	var query = prompt("Enter customer id");
	
	if (query != null && !isNaN(query)) {
		/*$.ajax({
		     type: 'GET',
		     url: 'localhost:8080/bankingproject/CustomerServlet',
		     data: {"query": query}
		});*/
		
		window.location.href = "/bankingproject/CustomerServlet?query=" + query;
	}
	else {
		alert("Search query must be a number: without letters nor symbols");
	}
}