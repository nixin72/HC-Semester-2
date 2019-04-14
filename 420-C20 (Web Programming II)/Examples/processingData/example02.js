var $ = function(id) { return document.getElementById(id); }

var validateUsername = function() {
	var isValid=true;
	var el = $("username");
	if (el.value == "")   {
		el.style.border = "thin solid red";
		$("errors").textContent = "Error in Username";
		isValid = false;
	}
	return isValid;
}

var validateEmail = function() {
	var isValid=true;
	var el = $("emailAddr");
	if (el.value == "") {
		el.style.border = "thin solid red";
		$("errors").textContent = "Error in Email Address";
		isValid = false;
	}
	return isValid;
}
 
var validatePhone = function() {
	var isValid=true;
	var el = $("phone");
	if (el.value == "") {
		el.style.border = "thin solid red";
		$("errors").textContent = "Error in Phone Number";
		isValid = false;
	}
	return isValid;
}
 
var validateForm = function() {
	validForm = false;
	$("errors").textContent = "";
	if (validateUsername())
		if (validateEmail())
			if (validatePhone())
				validForm = true;
	return validForm;
}
 

var el=document.getElementById("myForm");
el.onsubmit = validateForm;
//el.addEventListener('submit', validateForm, false);
	
