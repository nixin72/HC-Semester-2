var returningPlayer = new function() {
	var playerName = localStorage.getItem("FirstName");
	if (localStorage.getItem("moneyLeft") != localStorage.getItem("moneyStart")){
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
