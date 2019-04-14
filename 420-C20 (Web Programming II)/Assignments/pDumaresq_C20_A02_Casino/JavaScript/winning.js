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
	var betDiamonds = document.getElementById("betDiamonds").textContent;
		var dInt;
		if (betDiamonds == "")
			dInt = 0;
		else 
			dInt = parseInt(betDiamonds);
			
	var betCrown = document.getElementById("betCrown").textContent;
		var crInt;
		if (betCrown == "")
			crInt = 0;
		else 
			crInt = parseInt(betCrown);
			
	var betSpades = document.getElementById("betSpades").textContent;
		var sInt;
		if (betSpades == "")
			sInt = 0;
		else 
			sInt = parseInt(betSpades);
			
	var betClubs = document.getElementById("betClubs").textContent;
		var clInt;
		if (betClubs == "")
			clInt = 0;
		else 
			clInt = parseInt(betClubs);
			
	var betAnchor = document.getElementById("betAnchor").textContent;
		var aInt;
		if (betAnchor == "")
			aInt = 0;
		else 
			aInt = parseInt(betAnchor);
			
	var betHearts = document.getElementById("betHearts").textContent;
		var hInt;
		if (betHearts == "")
			hInt = 0;
		else 
			hInt = parseInt(betHearts);
			
	var totalMoneyBet = dInt + crInt + sInt + clInt + aInt + hInt;
	
	var moneyRemaining = document.getElementById("remain2").textContent;
		var mR;
		if (moneyRemaining == "")
			hmRInt = 0;
		else 
			mR = parseInt(moneyRemaining);
	
	var moneyLeft = mR - totalMoneyBet;
	document.getElementById("remain2").textContent = moneyLeft;
	console.log(moneyLeft);
	
	/*
	------------------------------------------------------------------------------------------------------
	---------------------------------------DID YOU WIN?---------------------------------------------------
	------------------------------------------------------------------------------------------------------	
	*/
	var roll1 = document.getElementById("firstDiceRoll").textContent;
	var roll2 = document.getElementById("secondDiceRoll").textContent;
	var roll3 = document.getElementById("thirdDiceRoll").textContent;
	
	var madeOffAnchor, madeOffClubs, madeOffCrown, madeOffDiamonds, madeOffHearts, madeOffSpades;
	//------------------------------------------------------------------------------------------------------
	//----------------------------------CHECK DIAMONDS--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	if ((dInt != 0 && roll1 != "diamonds") && (dInt != 0 && roll2 != "diamonds") && (dInt != 0 && roll3 != "diamonds")) {
		madeOffDiamonds = dInt * 0;
		if (madeOffDiamonds == undefined) {
			madeOffDiamonds = 0;
		}
	}
	else if ((dInt != 0 && roll1 == "diamonds") ^ (dInt != 0 && roll2 == "diamonds") ^ (dInt != 0 && roll3 == "diamonds")) {
		madeOffDiamonds = dInt * 2;
		if (madeOffDiamonds == undefined) {
			madeOffDiamonds = 0;
		}
	}
	else if ((dInt != 0 && roll1 == "diamonds") || (dInt != 0 && roll2 == "diamonds") || (dInt != 0 && roll3 == "diamonds")) {
		madeOffDiamonds = dInt * 3;
		if (madeOffDiamonds == undefined) {
			madeOffDiamonds = 0;
		}
	}
	else if ((dInt != 0 && roll1 == "diamonds") && (dInt != 0 && roll2 == "diamonds") && (dInt != 0 && roll3 == "diamonds")) {
		madeOffDiamonds = dInt * 4;
		if (madeOffDiamonds == undefined) {
			madeOffDiamonds = 0;
		}
	}
	//------------------------------------------------------------------------------------------------------
	//----------------------------------CHECK CROWN--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	if ((crInt != 0 && roll1 != "crown") && (crInt != 0 && roll2 != "crown") && (crInt != 0 && roll3 != "crown")) {
		madeOffCrown = crInt * 0;
		if (madeOffCrown == undefined) {
			madeOffCrown = 0;
		}
	}
	else if ((crInt != 0 && roll1 == "crown") ^ (crInt != 0 && roll2 == "crown") ^ (crInt != 0 && roll3 == "crown")) {
		madeOffCrown = crInt * 2;
		if (madeOffCrown == undefined) {
			madeOffCrown = 0;
		}
	}
	else if ((crInt != 0 && roll1 == "crown") || (crInt != 0 && roll2 == "crown") || (crInt != 0 && roll3 == "crown")) {
		madeOffCrown = crInt * 3;
		if (madeOffCrown == undefined) {
			madeOffCrown = 0;
		}
	}
	else if ((crInt != 0 && roll1 == "crown") && (crInt != 0 && roll2 == "crown") && (crInt != 0 && roll3 == "crown")) {
		madeOffCrown = crInt * 4;
		if (madeOffCrown == undefined) {
			madeOffCrown = 0;
		}
	}
	//------------------------------------------------------------------------------------------------------
	//----------------------------------CHECK SPADES--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	if ((sInt != 0 && roll1 != "spades") && (sInt != 0 && roll2 != "spades") && (sInt != 0 && roll3 != "spades")) {
		madeOffSpades = sInt * 0;
		if (madeOffSpades == undefined) {
			madeOffSpades = 0;
		}
	}
	else if ((sInt != 0 && roll1 == "spades") ^ (sInt != 0 && roll2 == "spades") ^ (sInt != 0 && roll3 == "spades")) {
		madeOffSpades = sInt * 2;
		if (madeOffSpades == undefined) {
			madeOffSpades = 0;
		}
	}
	else if ((sInt != 0 && roll1 == "spades") || (sInt != 0 && roll2 == "spades") || (sInt != 0 && roll3 == "spades")) {
		madeOffSpades = sInt * 3;
		if (madeOffSpades == undefined) {
			madeOffSpades = 0;
		}
	}
	else if ((sInt != 0 && roll1 == "spades") && (sInt != 0 && roll2 == "spades") && (sInt != 0 && roll3 == "spades")) {
		madeOffSpades = sInt * 4;
		if (madeOffSpades == undefined) {
			madeOffSpades = 0;
		}
	}
	//------------------------------------------------------------------------------------------------------
	//----------------------------------CHECK CLUBS--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	if ((clInt != 0 && roll1 != "clubs") && (clInt != 0 && roll2 != "clubs") && (clInt != 0 && roll3 != "clubs")) {
		madeOffClubs = clInt * 0;
		if (madeOffClubs == undefined) {
			madeOffClubs = 0;
		}
	}
	else if ((clInt != 0 && roll1 == "clubs") ^ (clInt != 0 && roll2 == "clubs") ^ (clInt != 0 && roll3 == "clubs")) {
		madeOffClubs = clInt * 2;
		if (madeOffClubs == undefined) {
			madeOffClubs = 0;
		}
	}
	else if ((clInt != 0 && roll1 == "clubs") || (clInt != 0 && roll2 == "clubs") || (clInt != 0 && roll3 == "clubs")) {
		madeOffClubs = clInt * 3;
		if (madeOffClubs == undefined) {
			madeOffClubs = 0;
		}
	}
	else if ((clInt != 0 && roll1 == "clubs") && (clInt != 0 && roll2 == "clubs") && (clInt != 0 && roll3 == "clubs")) {
		madeOffClubs = clInt * 4;
		if (madeOffClubs == undefined) {
			madeOffClubs = 0;
		}
	}
	//------------------------------------------------------------------------------------------------------
	//----------------------------------CHECK ANCHOR--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	if ((aInt != 0 && roll1 != "anchor") && (aInt != 0 && roll2 != "anchor") && (aInt != 0 && roll3 != "anchor")) {
		madeOffAnchor = aInt * 0;
		if (madeOffAnchor == undefined) {
			madeOffAnchor = 0;
		}
	}
	else if ((aInt != 0 && roll1 == "anchor") ^ (aInt != 0 && roll2 == "anchor") ^ (aInt != 0 && roll3 == "anchor")) {
		madeOffAnchor = aInt * 2;
		if (madeOffAnchor == undefined) {
			madeOffAnchor = 0;
		}
	}
	else if ((aInt != 0 && roll1 == "anchor") || (aInt != 0 && roll2 == "anchor") || (aInt != 0 && roll3 == "anchor")) {
		madeOffAnchor = aInt * 3;
		if (madeOffAnchor == undefined) {
			madeOffAnchor = 0;
		}
	}
	else if ((aInt != 0 && roll1 == "anchor") && (aInt != 0 && roll2 == "anchor") && (aInt != 0 && roll3 == "anchor")) {
		madeOffAnchor = aInt * 4;
		if (madeOffAnchor == undefined) {
			madeOffAnchor = 0;
		}
	}
	//------------------------------------------------------------------------------------------------------
	//----------------------------------CHECK HEARTS--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	if ((hInt != 0 && roll1 != "hearts") && (hInt != 0 && roll2 != "hearts") && (hInt != 0 && roll3 != "hearts")) {
		if (madeOffHearts == undefined) {
			madeOffHearts = 0;
		}
		else 
			madeOffHearts = hInt * 0;
	}
	else if ((hInt != 0 && roll1 == "hearts") ^ (hInt != 0 && roll2 == "hearts") ^ (hInt != 0 && roll3 == "hearts")) {
		if (madeOffHearts == undefined) {
			madeOffHearts = 0;
		}
		else 
			madeOffHearts = hInt * 2;
	}
	else if ((hInt != 0 && roll1 == "hearts") || (hInt != 0 && roll2 == "hearts") || (hInt != 0 && roll3 == "hearts")) {
	
		if (madeOffHearts == undefined) {
			madeOffHearts = 0;
		}
		else 
			madeOffHearts = hInt * 3;
	}
	else if ((hInt != 0 && roll1 == "hearts") && (hInt != 0 && roll2 == "hearts") && (hInt != 0 && roll3 == "hearts")) {
		if (madeOffHearts == undefined) {
			madeOffHearts = 0;
		}
			else madeOffHearts = hInt * 4;
	}
	
	var moneyMade = madeOffDiamonds + madeOffAnchor + madeOffClubs + madeOffCrown + madeOffHearts + madeOffSpades;
	var totalMoneyMade = moneyMade + moneyLeft;
	document.getElementById("remain2").textContent = totalMoneyMade;
}


/*
I recognize for the time being that this code is very poorly done. I never finished it all in assignment 1
so now I dont have working code for assignment 2. For assignment 3 I'm going to do this properly and 
create arrays of all of this repetitive code and made it so that it simply loops through the array checking 
in turn each of the possible symbols you can be on. Each function is also supposed to only do one thing, where
as the function in this file does half a million, so I will break it up into multiple functions and pass the 
outputs of the other functions through as parameters to where I want to use them. My winning conditions right 
also don't work 100% of the time. They only work if a number is inputted into the field and will otherwise 
return undefined. I need to make it so that if the value is undefined, then the value inputted is set to a
default of zero. I need to make it so that it will pass test cases if there are two of the same symbol because
right now it only allows no matches, 1 match or 3 matches. 

There's a lot I need to do to make this ready for assignment 3 and I plan on getting an early start to 
programming so I can go and get all of this freshned up for the next assignment as soon as I'm done.

Again, thank you so much for the 24 hour extension on this, I really needed it.  