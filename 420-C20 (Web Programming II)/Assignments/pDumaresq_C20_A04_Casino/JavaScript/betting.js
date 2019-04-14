/*
--------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------MAKING YOUR BETS------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
*/


$("#rollingTheDice").on('click', makeBets);
var bets = new Array();

function makeBets() {
	var sides = ["diamonds", "crown", "spades", "clubs", "anchor", "hearts"];
	var id = ["#betForDiamonds", "#betForCrown", "#betForSpades", "#betForClubs", "#betForAnchor", "#betForHearts"];

	for ( var q = 0 ; q < 6 ; q++ ) {
		bets[q] = {
			side: sides[q],
			bet: function() {
				var amount = $(id[q]).val();
				var regex = /^(?:(([1234]?[\d]{1,3})|(5000))|((5)(\d){0,2}))$/;
				var checker = regex.test(amount);
				
				if (!checker || amount == null) { amount = 0; }
				console.log("amount:" + amount);
				return amount;
			}
		}
	}
}

/*
PREVIOUSLY IN WINNING.JS--------------------------------------------------------------------------------------------------------
-----------------------------------------------MONEY DEDUCTIONS AND PAYOUTS-----------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

$("rollingTheDice").on('click', function(){rollOutcomes()}).on('click', function(){deductMoney()});

var rollOutcomes = function() {
	var roll1 = $("#firstDiceRoll").text();
	var roll2 = $("#secondDiceRoll").text();
	var roll3 = $("#thirdDiceRoll").text();
}

//deducts the amount of money bet from how much money you currenly have.
//Takes values from the cooresponding element in the game.html page
//parses them to an int, and if the result is NaN, sets the number to 0
//The finally updates the money remaining in the player info div
$("#rollingTheDice").on('click', moneyDeduct);
function moneyDeduct() {
	var winsAndLoses = new Array();
	var ids = ["#betDiamonds", "#betCrown", "#betSpades", "#betClubs", "#betAnchor", "#betHearts"];
	var totalMoneyBet = 0;

	for ( var q = 0 ; q < 6 ; q++ ) {
		winsAndLoses[q] = {
			square: "diamonds",
			bet: $(bets[q]).val(),
			won: function() {
				if ( diceArray[q].outcome() == q ) { return true; }
					else { return false; }
			}
		}
		totalMoneyBet += winsAndLoses[q].bet;
		//console.log(winsAndLoses[q].bet);
	}
}


var deductMoney = function() {
	var ids = ["#betDiamonds", "#betCrown", "#betSpades", "#betClubs", "#betAnchor", "#betHearts"];
	var trueCrown, trueAnchor, trueDiamonds, trueHearts, trueSpades, trueClubs;
	var moneyLeft = localStorage.moneyLeft;
	if (moneyLeft <= 0) {
		console.log("You have no money left");
	}
	
	var betDiamonds = $("#betDiamonds").text();
		var dInt;
		if (betDiamonds == "")
			dInt = 0;
		else {
			trueDiamonds = true;
			dInt = parseInt(betDiamonds);
		}	
	var betCrown = $("#betCrown").text();
		var crInt;
		if (betCrown == "")
			crInt = 0;
		else {
			trueCrown = true;
			crInt = parseInt(betCrown);
		}	
	var betSpades = $("#betSpades").text();
		var sInt;
		if (betSpades == "")
			sInt = 0;
		else {
			trueSpades = true;
			sInt = parseInt(betSpades);
		}	
	var betClubs = $("#betClubs").text();
		var clInt;
		if (betClubs == "")
			clInt = 0;
		else {
			trueClubs = true;
			clInt = parseInt(betClubs);
		}	
	var betAnchor = $("#betAnchor").text();
		var aInt;
		if (betAnchor == "")
			aInt = 0;
		else {
			trueAnchor = true;
			aInt = parseInt(betAnchor);
		}	
	var betHearts = $("#betHearts").text();
		var hInt;
		if (betHearts == "")
			hInt = 0;
		else {
			trueHearts = true;
			hInt = parseInt(betHearts);
		}	
	var totalMoneyBet = dInt + crInt + sInt + clInt + aInt + hInt;
	
	var moneyRemaining = $("#remain2").text();
		var mR;
		if (moneyRemaining == "")
			hmRInt = 0;
		else 
			mR = parseInt(moneyRemaining);
	
	var moneyLeft = mR - totalMoneyBet;
	$("#remain2").text(moneyLeft);
	localStorage.setItem("moneyLeft", moneyLeft);
	
	var bets = [crInt, aInt, dInt, sInt, hInt, clInt];
	var outcomes = [trueCrown, trueAnchor, trueDiamonds, trueSpades, trueHearts, trueClubs];
	var money = parseInt(localStorage.getItem("moneyLeft"));
	firstRoll1();
	secondRoll2();
	thirdRoll3();
	function firstRoll1() {
		var rollOutcome1 = $("#firstDiceRoll").text();
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
		var rollOutcome2 = $("#secondDiceRoll").text();
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
		var rollOutcome3 = $("#thirdDiceRoll").text(); 
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
		$("#DidYouWin").text("Congratulations! You Won $" + difference + "!");
	}
	else {
		$("DidYouWin").text("Sorry, you lost.");
	}
	parseInt(localStorage.setItem("moneyLeft", money));
	var remain = localStorage.getItem("moneyLeft");
	$("remain2").text(remain);
}
*/