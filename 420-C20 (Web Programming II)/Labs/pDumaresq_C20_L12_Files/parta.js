var countRight = 0;
	var countWrong = 0;
	myNumber = Math.floor(Math.random()*100);
	console.log(myNumber);

	$(document).ready(timeIsRunningOut());
	function timeIsRunningOut() {
		theTimer = setTimeout(Continue, 10000);
	}
	
	function Continue() {
		var cont = window.confirm("You haven't entered a number in 10 seconds. Do you want to continue?");
		if (cont == true) 
			{ timeIsRunningOut(); }
	}
	
	$("#confirm").on("click", function(event){
		event.preventDefault();
		isItRight();
	});
	function isItRight() {
		var input = $("#guess").val();
		var valid = isNaN(input);
		clearTimeout(theTimer);
		
		if (!valid && input <= 100 && input > 0) {
			$("#errors").text("");
			if (input == myNumber) {
				$("#msg").text("That's right!!!");
				$("#msg").css("font-size", "50px");
				$("#msg").css("color", "green");
				$("#label").css("display", "none");
				$("#guess").css("display", "none");
				$("#confirm").css("display", "none");
			}
			else if (input < myNumber) {
				$("#msg").text("Too low");
				$("#msg").css("color", "red");
				timeIsRunningOut();
			}
			else if (input > myNumber) {
				$("#msg").text("Too high");
				$("#msg").css("color", "red");
				timeIsRunningOut();
			}
			countRight++;
			$('#theCount').text("number of valid guesses: " + countRight);
			if ($('#guesses').text() == "") {
				$('#guesses').append(input);
			}
			else if ($('#guesses').text() != "") {
				$('#guesses').append(", " + input);
			}
			
		}
		else {
			countWrong++;
			if (countWrong > 10) {
				$("body").html("<h1>STOP ENTERING THINGS THAT AREN'T NUMBERS!!!<h1>");
				setTimeout(function() {
					location.reload();
				}, 2000)
			}
			$("#msg").text("");
			$("#errors").text("Invalid input. Please enter something else");
			$('#countWrong').text("number of invalid guesses: " + countWrong);
		}
		
	}