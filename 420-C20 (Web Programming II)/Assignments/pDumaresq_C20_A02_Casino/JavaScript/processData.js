	var queryStr = location.search;
	console.log("Query String: " , queryStr);
	
	queryStr = queryStr.substring(1,queryStr.length);
	console.log("Remove ?: ", queryStr);
	
	while (queryStr.indexOf("+") != -1) {
		queryStr = queryStr.replace("+", " ");
	}
	console.log("Change + to space: ",queryStr);
	
	var queryArray = queryStr.split("&");
	console.log(queryArray);

	var values = [];
	for (var i = 0; i<queryArray.length; i++) {
		var equalPos = queryArray[i].search("=") ;
		var keyVal = queryArray[i].substring(0,equalPos);
		var dataVal = queryArray[i].substring(equalPos+1);
		var dataVal = unescape(dataVal);
		console.log("Key:",keyVal,"Data:", dataVal);
		values[keyVal] = dataVal;
	}
	
	console.log(values);
	for (i in values) { 
		console.log("Key: ",i," has value: ", values[i]);
	}
	
	var name      = values.name;
	var email     = values.email;
	var postal    = values.postal;
	var moneyLeft = values.starting;
	document.getElementById("name2").textContent   = name;
	document.getElementById("email2").textContent  = email;
	document.getElementById("postal2").textContent = postal;	
	document.getElementById("remain2").textContent = moneyLeft;
