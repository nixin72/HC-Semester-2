document.getElementById("rollingTheDice").addEventListener('click', function(){rollOutcomes()},false);
document.getElementById("rollingTheDice").addEventListener('click', function(){deductMoney()},false);


var rollOutcomes = function() {
	var roll1 = document.getElementById("firstDiceRoll").textContent;
		console.log("roll1: " + roll1);
	var roll2 = document.getElementById("secondDiceRoll").textContent;
		console.log("roll2: " + roll2);
	var roll3 = document.getElementById("thirdDiceRoll").textContent;
		console.log("roll3: " + roll3);
}
//deducts the amount of money bet from how much money you currenly have.
//Takes values from the cooresponding element in the game.html page
//parses them to an int, and if the result is NaN, sets the number to 0
//The finally updates the money remaining in the player info div
var deductMoney = function() {
	var trueCrown, trueAnchor, trueDiamonds, trueHearts, trueSpades, trueClubs;
	var moneyLeft = localStorage.moneyLeft;
	if (moneyLeft <= 0) {
		console.log("You have no money left");
	}
	var betDiamonds = document.getElementById("betDiamonds").textContent;
		var dInt;
		if (betDiamonds == "")
			dInt = 0;
		else {
			trueDiamonds = true;
			dInt = parseInt(betDiamonds);
		}	
	var betCrown = document.getElementById("betCrown").textContent;
		var crInt;
		if (betCrown == "")
			crInt = 0;
		else {
			trueCrown = true;
			crInt = parseInt(betCrown);
		}	
	var betSpades = document.getElementById("betSpades").textContent;
		var sInt;
		if (betSpades == "")
			sInt = 0;
		else {
			trueSpades = true;
			sInt = parseInt(betSpades);
		}	
	var betClubs = document.getElementById("betClubs").textContent;
		var clInt;
		if (betClubs == "")
			clInt = 0;
		else {
			trueClubs = true;
			clInt = parseInt(betClubs);
		}	
	var betAnchor = document.getElementById("betAnchor").textContent;
		var aInt;
		if (betAnchor == "")
			aInt = 0;
		else {
			trueAnchor = true;
			aInt = parseInt(betAnchor);
		}	
	var betHearts = document.getElementById("betHearts").textContent;
		var hInt;
		if (betHearts == "")
			hInt = 0;
		else {
			trueHearts = true;
			hInt = parseInt(betHearts);
		}	
	var totalMoneyBet = dInt + crInt + sInt + clInt + aInt + hInt;
	
	var moneyRemaining = document.getElementById("remain2").textContent;
		var mR;
		if (moneyRemaining == "")
			hmRInt = 0;
		else 
			mR = parseInt(moneyRemaining);
	
	var moneyLeft = mR - totalMoneyBet;
	document.getElementById("remain2").textContent = moneyLeft;
	localStorage.setItem("moneyLeft", moneyLeft);
	
	var bets = [crInt, aInt, dInt, sInt, hInt, clInt];
	var outcomes = [trueCrown, trueAnchor, trueDiamonds, trueSpades, trueHearts, trueClubs];
	var money = parseInt(localStorage.getItem("moneyLeft"));
	firstRoll1();
	secondRoll2();
	thirdRoll3();
	function firstRoll1() {
		var rollOutcome1 = document.getElementById("firstDiceRoll").textContent;
		var temp = parseInt(rollOutcome1);
		var temp2;
		for (var i = 0 ; i < 6 ; i++) {
			if (outcomes[i] == true) {
				if (temp == i) {
					temp2 = parseInt(bets[i]);
					money = money + temp2;
				}
			}
		}
	}
	function secondRoll2() {
		var rollOutcome2 = document.getElementById("secondDiceRoll").textContent;
		var temp = parseInt(rollOutcome2);
		var temp2;
		for (var i = 0 ; i < 6 ; i++) {
			if (outcomes[i] == true) {
				if (temp == i) {
					temp2 = parseInt(bets[i]);
					money = money + temp2;
				}
			}
		}
	}
	function thirdRoll3() {
		var rollOutcome3 = document.getElementById("thirdDiceRoll").textContent; 
		var temp = parseInt(rollOutcome3);
		var temp2;
		for (var i = 0 ; i < 6 ; i++) {
			if (outcomes[i] == true) {
				if (temp == i) {
					temp2 = parseInt(bets[i]);
					money = money + temp2;
				}
			}
		}
	}
	var difference = money - localStorage.getItem("moneyLeft");
	if (difference != 0) {
		document.getElementById("DidYouWin").textContent = "Congratulations! You Won $" + difference + "!";
	}
	else {
		document.getElementById("DidYouWin").textContent = "Sorry, you lost.";
	}
	parseInt(localStorage.setItem("moneyLeft", money));
	var remain = localStorage.getItem("moneyLeft");
	document.getElementById("remain2").textContent = remain;
}