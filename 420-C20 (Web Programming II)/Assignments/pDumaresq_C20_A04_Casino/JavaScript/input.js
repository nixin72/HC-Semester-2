$(document).ready(function() {
	var returningPlayer = new function() {
		var playerName = localStorage.getItem("FirstName");
		if (localStorage.getItem("FirstName") != null) {
			$("#userInput").css('textAlign', 'center');
			$("#userInput").css('padding', '8%').css('fontSize','large');
			$("#playerReturn").text("Welcome back " + playerName +"!");
		
			$("#playerReturn").html("Not " + playerName 
						+ "? <a href='index.html'>Sign in here!</a>").css('display', 'block').
						html("<p>Welcome back " + playerName + "!</p>"
					+ "<p>Your phone number is: " + localStorage.getItem("PhoneNum") + " and your postal code is "
					+ localStorage.getItem("PostalCode") + "</p><p>You have " + localStorage.getItem("MoneyLeft") 
					+ "$ left in your bankroll</p><p>Your last visit was " + localStorage.getItem("LastVisit") + "</p>");
				
			$("#GoToGame").html("<p><br /><a href='game.html'>" + "Click here to continue to your game!</a></p>");
			$("#returnToIntro").html("Not " + playerName + "? Click here to Sign up!");
		}
	}

	$("#returnToIntro").on('click', function(){
		localStorage.clear();
		location.href = "index.html";
	});


/*------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------SAVING AND VALIDATING THE USER'S INFO-----------------------------------------------
------------------------------------------------------------------------------------------------------------------------------*/

	document.getElementById("startPlaying").addEventListener("click", function(event){
		event.preventDefault();
		validate();
	});
	
	function validate() {
		var regexFName  = /^[a-zA-Z]{1,25}$/;
		var regexLName  = /^[a-zA-Z]{1,25}$/; 
		var regexPhone  = /^((1(\s|-|))?)(\(\d{3}\))(-|\s)(\d{3})(-|\s)(\d{4})$/;
		var regexPostal = /^([A-z]\d[A-z])\s?(\d[A-z]\d)$/;
		var regexMoney  = /^(?:(5000)|(5)|([1-4]?(\d{1,2})?(5|0)))$/;
		
		var isValid = true;
		
		var player = {
			firstName: contain("#fname1", regexFName, "Invalid first name."),
			lastName: contain("#lName1", regexLName, "Invalid last Name."),
			phoneNumber: contain("#phone1", regexPhone, "Invalid phone number."),
			postalCode: contain("#postal1", regexPostal, "Invalid postal code."),
			money: contain("#money1", regexMoney, "Invalid amount."),
		}
		
		function contain(id, regex, errorMessage) {
			var input_v = $(id).val();
			if ( input_v == undefined ) 
				input_v = ""; 
			
			var valid = regex;
			var tester = valid.test(input_v);
			
			isValid = isValid && tester;
			try {
				if (input_v == "") { throw ""; }
					else if (tester != true) { throw ""; }
						else { $(id).css('borderWidth', '2px').css('borderColor', 'Green');	}
			}
			catch(err) {
				$("#message").text(errorMessage);
				$(id).css('borderWidth', '2px').css('borderColor', 'red');
			}
			finally {
				return input_v;
			} 
		}
		if ( isValid ) {
			localStorage.clear();
			localStorage.setItem("FirstName" , player.firstName);
			localStorage.setItem("LastName", player.lastName); 
			localStorage.setItem("PhoneNum", player.phoneNumber); 
			localStorage.setItem("PostalCode", player.postalCode); 
			localStorage.setItem("MoneyLeft", player.money);		
			localStorage.setItem("LastVisit", Date());	
			location.href = "game.html";
		}
	}
});