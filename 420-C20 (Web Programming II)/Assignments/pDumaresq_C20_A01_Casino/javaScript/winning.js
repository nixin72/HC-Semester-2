var moneyBeforePayout, moneyAfterBet, winnings;
var madeOffCrown, madeOffAnchor, madeOffDiamonds, madeOffSpades, madeOffClubs, madeOffHearts;
var rollOne =   ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
var rollTwo =   ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
var rollThree = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];

//MONEY DEDUCTION FOR DIFFERENT TEST CASES
function moneyDeduction1() {
	moneyBeforePayout = startingMoney(50) - betTestCase1();
	return moneyBeforePayout;
}
function moneyDeduction2() {
	moneyBeforePayout = startingMoney(50) - betTestCase2();
	return moneyBeforePayout;
}
function moneyDeduction3() {
	moneyBeforePayout = startingMoney(50) - betTestCase3();
	return moneyBeforePayout;
}
function moneyDeduction4() {
	moneyBeforePayout = startingMoney(50) - betTestCase4();
	return moneyBeforePayout;
}
function moneyDeduction5() {
	moneyBeforePayout = startingMoney(50) - betTestCase5();
	return moneyBeforePayout;
}
function moneyDeduction6() {
	moneyBeforePayout = startingMoney(50) - betTestCase6();
	return moneyBeforePayout;
}
function moneyDeduction7() {
	moneyBeforePayout = startingMoney(50) - betTestCase7();
	return moneyBeforePayout;
}
function moneyDeduction8() {
	moneyBeforePayout = startingMoney(50) - betTestCase8();
	return moneyBeforePayout;
}
function moneyDeduction9() {
	moneyBeforePayout = startingMoney(50) - betTestCase9();
	return moneyBeforePayout;
}
function moneyDeduction10() {
	moneyBeforePayout = startingMoney(50) - betTestCase10();
	return moneyBeforePayout;
}
function moneyDeduction11() {
	moneyBeforePayout = startingMoney(50) - betTestCase11();
	return moneyBeforePayout;
}
function moneyDeduction12() {
	moneyBeforePayout = startingMoney(50) - betTestCase12();
	return moneyBeforePayout;
}
function moneyDeduction13() {
	moneyBeforePayout = startingMoney(50) - betTestCase13();
	return moneyBeforePayout;
}
function moneyDeduction14() {
	moneyBeforePayout = startingMoney(50) - betTestCase14();
	return moneyBeforePayout;
}
function moneyDeduction15() {
	moneyBeforePayout = startingMoney(50) - betTestCase15();
	return moneyBeforePayout;
}
//console.log("Money after your bets have been deducted: " + moneyDeduction());

/*
function didYouWin() {
var whereYouBet   = [betOnCrown, betOnAnchor, betOnDiamonds, betOnSpades, betOnClubs, betOnHearts];
var madeOffSymbol = [madeOffCrown, madeOffAnchor, madeOffDiamonds, madeOffSpades, madeOffClubs, madeOffHearts];
var betPerSymbol  = [crownBet, anchorBet, diamondBet, spadesBet, clubsBet, heartsBet];

for (i = 0 ; i < whereYouBet.length ; i++)
	if (whereYouBet[i] && firstRoll()) {
		madeOffSymbol = betPerSymbol * 2;
	}
	else if (whereYouBet[i] && secondRoll()) {
		madeOffSymbol = betPerSymbol * 3;
	}	
	else if (whereYouBet[i] && thirdRoll()) {
		madeOffSymbol = betPerSymbol * 4;
	}
	else {
		madeOffSymbol = 0;
	}
	return madeOffSymbol;
}
//console.log(didYouWin());

//money made after the bet

//console.log(moneyMade());


//Displays wether you win or lose
/*function winOrLose() {
	if (moneyMade > moneyBeforePayout) {
		winning = moneyAfterBet - moneyBeforePayout;
		document.getElementById("winning").textContent = "Congradulations! You won $" + winning + "!";
	}
	else if (moneyBeforePayout == moneyAfterBet) {
		document.getElementById("winning").textContent = "You made your money back!";
	}
	else if (moneyBeforePayout > moneyAfterBet) {
		winning = moneyBeforePayout - moneyAfterBet;
		document.getElementById("winning").textContent = "You lost $" + winning;
	}
	return winning;
}
*/


function winOnCrown() {
	if (betOnCrown(betOnCrown) == true && firstRoll() == "crown") {
		madeOffCrown = crownBet * 2;
	}
	else if (betOnCrown() == true && secondRoll() == "crown") {
		madeOffCrown = crownBet * 3;
	}	
	else if (betOnCrown() == true && thirdRoll() == "crown") {
		madeOffCrown = crownBet * 4;
	}
	else {
		madeOffCrown = 0;
	}
	return madeOffCrown;
}
console.log(winOnCrown());

function winOnAnchor() {
	if (betAnchor == true && outcome1 == dice1[1]) {
		madeOffAnchor = anchorBet * 2;
	}
	if (betAnchor == true && outcome2 == dice2[1]) {
		madeOffAnchor = anchorBet * 3;
	}
	if (betAnchor == true && outcome3 == dice3[1]) {
		madeOffAnchor = anchorBet * 4;
	}
	else 
		madeOffAnchor = 0;
	return madeOffAnchor;
}
//console.log(winOnAnchor());

function winOnDiamond() {
	if (betDiamonds == true && routcome1 == dice1[2]) {
		madeOffDiamonds = diamondBet * 2;
	}
	if (betDiamonds == true && outcome2 == dice2[2]) {
		madeOffDiamonds = diamondBet * 3;
	}
	if (betDiamonds == true && outcome3 == dice3[2]) {
		madeOffDiamonds = diamondBet * 4;
	}
	else 
		madeOffDiamonds = 0;
	return madeOffDiamonds;
}
//console.log(winOnDiamond());

function winOnHearts() {
	if (betHearts == true && outcome1 == dice1[3]) {
		madeOffHearts = heartsBet * 2;
	}
	if (betHearts == true && outcome2 == dice2[3]) {
		madeOffHearts = heartsBet * 3;	
	}
	if (betHearts == true && outcome3 == dice3[3]) {
		madeOffHearts = heartsBet * 4;	
	}
	else
		madeOffHearts = 0;
	return madeOffHearts;
}
//console.log(winOnHearts());

function winOnSpades() {
	if (betSpades == true && outcome1 == dice1[4]) {
		madeOffSpades = spadesBet * 2;
	}
	if (betSpades == true && outcome2 == dice2[4]) {
		madeOffSpades = spadesBet * 3;
	}
	if (betSpades == true && outcome3 == dice3[4]) {
		madeOffSpades = spadesBet * 4;
	}
	else 
		madeOffSpades = 0;
	return madeOffSpades;
}
//console.log(winOnSpades());

function winOnClubs() {
	if (betClubs == true && outcome1 == dice1[5]) {
		madeOffClubs = clubsBet * 2;
	}
	if (betClubs == true && outcome2 == dice2[5]) {
		madeOffClubs = clubsBet * 3;
	}
	if (betClubs == true && outcome2 == dice2[5]) {
		madeOffClubs = clubsBet * 4;
	}
	else 
		madeOffClubs = 0;
	return madeOffClubs;
}
//console.log(winOnClubs());

function moneyMadeTest1() {
	moneyAfterBet = moneyDeduction1() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest2() {
	moneyAfterBet = moneyDeduction2() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest3() {
	moneyAfterBet = moneyDeduction3() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest4() {
	moneyAfterBet = moneyDeduction4() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest5() {
	moneyAfterBet = moneyDeduction5() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest6() {
	moneyAfterBet = moneyDeduction6() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest7() {
	moneyAfterBet = moneyDeduction7() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest8() {
	moneyAfterBet = moneyDeduction8() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest9() {
	moneyAfterBet = moneyDeduction9() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest10() {
	moneyAfterBet = moneyDeduction10() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest11() {
	moneyAfterBet = moneyDeduction11() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest12() {
	moneyAfterBet = moneyDeduction12() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest13() {
	moneyAfterBet = moneyDeduction13() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest14() {
	moneyAfterBet = moneyDeduction14() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
function moneyMadeTest15() {
	moneyAfterBet = moneyDeduction15() + (winOnCrown() + winOnAnchor() + winOnDiamond() + winOnSpades() + winOnClubs() + winOnHearts());
		return moneyAfterBet;
}
