/*
---------------------------------------------------------------------------------------------------------
---------------------------------------VALIDATE USER DATA------------------------------------------------
---------------------------------------------------------------------------------------------------------
*/
var isValid = false;
var fname, lname, phone, postal, money;
document.getElementById("fname1").addEventListener('blur', function(){validatefName()}, false);
document.getElementById("lname1").addEventListener('blur', function(){validatelName()}, false);
document.getElementById("phone1").addEventListener('blur', function(){validatePhone()}, false);
document.getElementById("postal1").addEventListener('blur', function(){validatePostal()}, false);
document.getElementById("money1").addEventListener('blur', function(){validateMoney()}, false);
document.getElementById("startPlaying").addEventListener('onclick', function(){setLocalStorage()},false);

//-------------------------------------CHECK FIRST NAME FUNCTION------------------------------------------------

var validatefName = function() {
	fname = document.getElementById("fname1").value;
	var valid = /^[a-zA-Z ]*$/;
	var tester = valid.test(fname);
	
	try { 
        if (fname == "") { isValid = false; throw "invalid: You must enter a first name"; }
			else if (tester != true) { isValid = false; throw "Not a valid first name"; }
				else { isValid = true; 
					document.getElementById("fname1").style.borderWidth = "2px";
					document.getElementById("fname1").style.borderColor = "Green";
				}
    }
    catch(err) {
        document.getElementById("message").textContent = "Input is " + err;
		document.getElementById("fname1").style.borderWidth = "2px";
		document.getElementById("fname1").style.borderColor = "red";
    }
}

//-------------------------------------CHECK LAST NAME FUNCTION------------------------------------------------

var validatelName = function() {
	lname = document.getElementById("lname1").value;
	var valid = /^[a-zA-Z ]+$/;
	var tester = valid.test(lname);
	try { 
        if(lname == "") {isValid = false; throw "empty: You must enter a last name";}
			else if(tester != true) {isValid = false; throw "Not a valid last name";}
				else { isValid = true; 
						document.getElementById("lname1").style.borderWidth = "2px";
						document.getElementById("lname1").style.borderColor = "Green";
				}
    }
    catch(err) {
        document.getElementById("message").textContent = "Input is " + err;
		document.getElementById("lname1").style.borderWidth = "2px";
		document.getElementById("lname1").style.borderColor = "red";
    }
}


//---------------------------------------CHECK PHONE FUNCTION----------------------------------------------

var validatePhone = function() {
	phone = document.getElementById("phone1").value;
	var valid = /^((1(\s|-|))?)(\(\d{3}\))(-|\s)(\d{3})(-|\s)(\d{4})$/;
	var tester = valid.test(phone);	
		
	try {
	if (phone == "") { isValid = false; throw "empty: You must enter an phone number."; }
		else if (tester != true) { isValid = false; throw "not a valid phone number"; }
			else { isValid = true;
					document.getElementById("phone1").style.borderWidth = "2px";
					document.getElementById("phone1").style.borderColor = "Green";
			}
	}
	catch (err) {
		document.getElementById("message").textContent = "Input is " + err;
		document.getElementById("phone1").style.borderWidth = "2px";
		document.getElementById("phone1").style.borderColor = "red";
	}
}

//--------------------------------------CHECK POSTAL CODE FUNCTION-----------------------------------------

var validatePostal = function() {
	postal = document.getElementById("postal1").value;
	var valid = /^([A-Z][\d][A-Z])\s(\d[A-Z]\d)$/;
	var tester = valid.test(postal);
	
	try {
		if (postal == "") { isValid = false; throw "empty: You must enter an email adress."; }
			else if (tester != true) { isValid = false; throw "not a valid postal code"; }
				else { isValid = true; 
						document.getElementById("postal1").style.borderWidth = "2px";
						document.getElementById("postal1").style.borderColor = "Green";
				}
	}
	catch(err) {
		document.getElementById("message").textContent = "Input is " + err;
		document.getElementById("postal1").style.borderWidth = "2px";
		document.getElementById("postal1").style.borderColor = "red";
	}
}

//---------------------------------------CHECK MONEY BEING BET---------------------------------------------

var validateMoney = function() {
	money = document.getElementById("money1").value;
	var valid = /^(?:([0-4]?[0-9]{1,3})|([5][0-9]{2})|(5000))$/;
	var tester = valid.test(money);	
	
	try {
		if (money == "") { isValid = false; throw "empty: You must enter a starting amount"; }
			else if(tester != true) { isValid = false; throw "You must enter a valid amount."; }
				else { isValid = true;
						document.getElementById("money1").style.borderWidth = "2px";
						document.getElementById("money1").style.borderColor = "Green";
				}
	}
	catch(err) {
		document.getElementById("message").textContent = "Input is " + err;
		document.getElementById("money1").style.borderWidth = "2px";
		document.getElementById("money1").style.borderColor = "red";
	}
}

document.getElementById("startPlaying").addEventListener("click", function(event){
	if (isValid == false) {
		event.preventDefault()
	}
	setLocalStorage();
});

function setLocalStorage() {
	var currentDate = Date();
	if (isValid == true) {
		localStorage.removeItem("FirstName");
		localStorage.removeItem("lastName");
		localStorage.removeItem("phoneNum");
		localStorage.removeItem("postalCode");
		localStorage.removeItem("moneyStart");
		localStorage.removeItem("moneyLeft");
		localStorage.removeItem("lastVisit");
		
		localStorage.setItem("FirstName" , fname);
		localStorage.setItem("lastName", lname); 
		localStorage.setItem("phoneNum", phone); 
		localStorage.setItem("postalCode", postal); 
		localStorage.setItem("moneyStart", money); 
		localStorage.setItem("moneyLeft", money);		
		localStorage.setItem("lastVisit", currentDate);		
	}
	else {
		window.alert("You didn't enter all your information properly");
	}
}