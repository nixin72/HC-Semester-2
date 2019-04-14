/*
---------------------------------------------------------------------------------------------------------
---------------------------------------VALIDATE USER DATA------------------------------------------------
---------------------------------------------------------------------------------------------------------
*/

document.getElementById("name1").addEventListener('blur', function(){validateName()}, false);
document.getElementById("email1").addEventListener('blur', function(){validateEmail()}, false);
document.getElementById("postal1").addEventListener('blur', function(){validatePostal()}, false);
document.getElementById("money1").addEventListener('blur', function(){validateMoney()}, false);

//------------------------------------CHECK NAME FUNCTION--------------------------------------------------

var validateName = function() {
	var name = document.getElementById("name1").value;
	var regex = /^[a-zA-Z ]+$/;
	var checker = regex.test(name);
			
	if (name.value == "" || checker == false) {
		alert("Please enter a valid first name");
	}
	else if (checker == true) {
		
	}
	return name;
}


//---------------------------------------CHECK EMAIL FUNCTION----------------------------------------------

var validateEmail = function() {
	var email = document.getElementById("email1").value;
	var checkEmail = /^[a-zA-Z0-9._\-!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	var validEmail = checkEmail.test(email);
	
	if (email.value == "" || validEmail == false) {
		alert("Please enter a valid Email");
	}
	else if (validEmail == true) {
	}
	return email;
}

//--------------------------------------CHECK POSTAL CODE FUNCTION-----------------------------------------

var validatePostal = function() {
	var postal = document.getElementById("postal1").value;
	var checkPostal = /^([A-Z][\d][A-Z])\s(\d[A-Z]\d)$/;
	var validPostal = checkPostal.test(postal);
	
	if (postal.value == "" || validPostal == false) {
		alert("Please enter a valid Canadian postal code");
	}
	else if (validPostal == true) {

	}
	return postal;
}

//---------------------------------------CHECK MONEY BEING BET---------------------------------------------

var validateMoney = function() {
	var money = document.getElementById("money1").value;
	var checkMoney = /^(?:([0-4]?[0-9]{1,3})|([5][0-9]{2})|(5000))$/;
	var validMoney = checkMoney.test(money);
	
	if (money.value == "" || validMoney == false) {
		alert("Please enter a valid amount");
	}
	else if (validMoney == true) {
	
	}
	return money;
}







