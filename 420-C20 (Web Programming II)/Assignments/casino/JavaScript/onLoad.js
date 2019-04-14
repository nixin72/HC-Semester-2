var returningPlayer = new function() {
	var playerName = localStorage.getItem("FirstName");
	if (localStorage.getItem("moneyLeft") != localStorage.getItem("moneyStart")){
		document.getElementById("userInput").style.textAlign = "center";
		document.getElementById("userInput").style.paddingTop = "8%";
		document.getElementById("userInput").style.paddingBottom = "8%";
		document.getElementById("userInput").style.fontSize = "large";
		document.getElementById("playerReturn").textContent = "Welcome back " + playerName +"!";
		
		document.getElementById("playerReturn").innerHTML = "Not " + playerName 
					+ "? <a href='index.html'>Sign in here!</a>";
					
		document.getElementById("playerReturn").style.display = "block";
				
		document.getElementById("playerReturn").innerHTML = "<p>Welcome back " + playerName + "!</p>"
				+ "<p>Your phone number is: " + localStorage.getItem("Phone") + " and your postal code is "
				+ localStorage.getItem("postalCode") + "</p><p>You have " + localStorage.getItem("moneyLeft") 
				+ "$ left in your bankroll</p><p>Your last visit was " + localStorage.getItem("lastVisit") + "</p>";
		document.getElementById("GoToGame").innerHTML = "<p><br /><a href='game.html'>" 
		+ "Click here to continue to your game!</a></p>";
		document.getElementById("returnToIntro").innerHTML = "Not " + playerName + "? Click here to Sign up!";
		
	}
}

document.getElementById("returnToIntro").addEventListener('click', function(){
	localStorage.removeItem("FirstName");
	localStorage.removeItem("lastName");
	localStorage.removeItem("phoneNum");
	localStorage.removeItem("moneyLeft");
	localStorage.removeItem("moneyStart");
	localStorage.removeItem("postalCode");
	localStorage.removeItem("lastVisit");
	location.href = "index.html";
});
