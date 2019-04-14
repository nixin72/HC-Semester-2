document.getElementById("rollingTheDice").addEventListener('click', function(){firstRoll()}, false);
document.getElementById("rollingTheDice").addEventListener('click', function(){secondRoll()}, false);
document.getElementById("rollingTheDice").addEventListener('click', function(){thirdRoll()}, false);

var firstRoll = function() {
	var dice1 = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
	var roll1 = Math.floor((Math.random() * 6));
	var outcome1 = dice1[roll1];
	
	document.getElementById("firstDiceRoll").textContent = outcome1;
	
	return roll1;
}


var secondRoll = function() {
	var dice2 = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
	var roll2 = Math.floor((Math.random() * 6));
	var outcome2 = dice2[roll2];
	
	document.getElementById("secondDiceRoll").textContent = outcome2;
	
	return roll2;
}


var thirdRoll = function() {
	var dice3 = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
	var roll3 = Math.floor((Math.random() * 6));
	var outcome3 = dice3[roll3];
		
	document.getElementById("thirdDiceRoll").textContent = outcome3;
	
	return roll3;
}

