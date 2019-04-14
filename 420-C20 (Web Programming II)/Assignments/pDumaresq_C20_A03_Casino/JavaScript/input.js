/*
---------------------------DEALS WITH THE INTRO PAGE ONLY. NOT LINKED ON GAME.HTML OR INTRO.HTML--------------------------------
*/

/*
PREVIOUSLY IN ONLOAD.JS---------------------------------------------------------------------------------------------------------
----------------------------------LOADING THE PAGE AND WELCOMING A RETURNING PLAYER---------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
*/

var returningPlayer = new function() {
	var playerName = localStorage.getItem("FirstName");
	if (localStorage.getItem("FirstName") != null){
		$("#userInput").css('textAlign', 'center');
		$("userInput").css('paddingTop', '8%').css('paddingBottom', '8%').css('fontSize','large');
		$("playerReturn").text("Welcome back " + playerName +"!");
		
		$("#playerReturn").html("Not " + playerName 
					+ "? <a href='index.html'>Sign in here!</a>").css('display', 'block').
					html("<p>Welcome back " + playerName + "!</p>"
				+ "<p>Your phone number is: " + localStorage.getItem("Phone") + " and your postal code is "
				+ localStorage.getItem("postalCode") + "</p><p>You have " + localStorage.getItem("moneyLeft") 
				+ "$ left in your bankroll</p><p>Your last visit was " + localStorage.getItem("lastVisit") + "</p>");
				
		$("#GoToGame").html("<p><br /><a href='game.html'>" + "Click here to continue to your game!</a></p>");
		$("#returnToIntro").html("Not " + playerName + "? Click here to Sign up!");
		
	}
}

$("#returnToIntro").on('click', function(){
	localStorage.removeItem("FirstName");
	localStorage.removeItem("lastName");
	localStorage.removeItem("phoneNum");
	localStorage.removeItem("moneyLeft");
	localStorage.removeItem("moneyStart");
	localStorage.removeItem("postalCode");
	localStorage.removeItem("lastVisit");
	location.href = "index.html";
});

/*
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------SAVING AND VALIDATING THE USER'S INFO-----------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
*/

var isValid = false;
var inputs = new Array();
var player = new Object();

$("#startPlaying").on("click", function(event){
	event.preventDefault();
	if (validate()) { setLocalStorage(); }
	
});

function validate() {
	var id = ["#fname1", "#lname1", "#phone1", "#postal1", "#money1"];
	
	regexFName  = /^[a-zA-Z]{1,25}$/;
	regexLName  = /^[a-zA-Z]{1,25}$/; 
	regexPhone  = /^((1(\s|-|))?)(\(\d{3}\))(-|\s)(\d{3})(-|\s)(\d{4})$/;
	regexPostal = /^([A-Z][\d][A-Z])\s(\d[A-Z]\d)$/;
	regexMoney  = /^(?:([0-4]?[0-9]{1,3})|([5][0-9]{2})|(5000))$/;
	var regexs = [ regexFName, regexLName, regexPhone, regexPostal, regexMoney ];

	for ( q = 0 ; q < id.length - 1 ; q++ ) {
		inputs[q] = {
			type: "name",
			contains: function() {
				var input_v = $(id[q]).val();
				if ( input_v == undefined ) 
					input_v = ""; 
		
				var valid = regexs[q];
				var tester = valid.test(input_v);
				//console.log(tester);
				
				try {
					if (input_v == "") { isValid = false; throw "Error"; }
						else if (tester != true) { isValid = false; throw "error"; }
							else { isValid = true;
								$(id[q]).css('borderWidth', '2px').css('borderColor', 'Green');
							}
				}
				catch(err) {
					$("#message").text("Input is " );
					$(id[q]).css('borderWidth', '2px').css('borderColor', 'red');
				}
				finally {
					return input_v;
				}
			}
		}
		console.log(inputs[q].contains());
	}
	player.firstName  = inputs[0].contains();
	player.lastName   = inputs[1].contains();
	player.phoneNum   = inputs[2].contains();
	player.postalCode = inputs[3].contains();
	player.money      = inputs[4].contains();
	
	return isValid;
}

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
		
		localStorage.setItem("FirstName" , player.firstName);
		localStorage.setItem("lastName", player.lastName); 
		localStorage.setItem("phoneNum", player.phoneNum); 
		localStorage.setItem("postalCode", player.postalCode); 
		localStorage.setItem("moneyStart", player.money); 
		localStorage.setItem("moneyLeft", player.money);		
		localStorage.setItem("lastVisit", currentDate);		
	}
	else { window.alert("You didn't enter all your information properly"); }
}