//declaration of variables
	var betOnCrown, betOAnchor, betOnDiamonds, betOnSpades, betOnClubs, betOnHearts; 
	var betCrown, betAnchor, betDiamonds, betSpades, betClubs, betHearts;
	var moneyRemaining;


//Default value for bet on each symbol
	var crownBet = 0;
	var anchorBet = 0;
	var diamondBet = 0;
	var spadesBet = 0;
	var clubsBet = 0;
	var heartsBet = 0;
 
//user inputting initial money
function startingMoney(moneyRemaining) {
	//moneyRemaining = 50;                     //parseInt(prompt("How much money are you putting into game?"));
	//document.getElementById("moneyInput").textContent = "You are starting with "+ moneyRemaining;
	//console.log("initial money = " + moneyRemaining);*/
	return moneyRemaining;
}
document.write("<br />startingMoney = " + startingMoney(50));

//console.log("*******************************************************************");


//How much you're betting on each symbol
//Betting money on the crown
function betOnCrown(crownBet, betCrown) {
/*betCrown = true;
//crownBet = 5;            //parseInt(prompt("Please enter a bet amount"));
//console.log("bet on Crown = " + crownBet);
	//document.getElementById("betForCrown").textContent = "You bet on crown: "+ crownBet;*/
	return betCrown, crownBet;
}
document.write("<br />bet on crown = " + betOnCrown(true) + "<br />   Amount bet = " + betOnCrown(15));

//betting money on the anchor
function betOnAnchor(anchorBet, betAnchor) {
/*betAnchor = true;
//anchorBet = 5;           //parseInt(prompt("Please enter a bet amount"));
//console.log("bet on Anchor = " + anchorBet);
	//document.getElementById("betForAnchor").textContent = "You bet on anchor: "+ anchorBet;*/
	return betAnchor, anchorBet;
}
document.write("<br />bet on anchor = " + betOnAnchor(false) + "<br />   Amount bet = " + betOnAnchor(0));

//betting on the diamonds
function betOnDiamonds(diamondBet, betDiamonds) { 
/*betDiamonds = true;
//diamondBet = 0;                    //parseInt(prompt("Please enter a bet amount"));
//console.log("bet on Diamond = " + diamondBet);
	//document.getElementById("betForDiamonds").textContent = "You bet on diamonds: "+ diamondBet;*/
	return betDiamonds, diamondBet;
}
document.write("<br />bet on diamonds = " + betOnDiamonds(true) + "<br />   Amount bet = " + betOnDiamonds(15));

//betting on the spades
function betOnSpades(spadesBet, betSpades) {
/*betSpades = true;
//spadesBet = 0;                     //parseInt(prompt("Please enter a bet amount"));
//console.log("bet on Spades = " + spadesBet);
//document.getElementById("betForSpades").textContent = "You bet on spades: "+ spadesBet;*/
	return betSpades, spadesBet;
}
document.write("<br />bet on spades = " + betOnSpades(true) + "<br />   Amount bet = " + betOnSpades(10));

//betting on the clubs
function betOnClubs(clubsBet, betClubs) {
/*betClubs = true;
//clubsBet = 5;                       //parseInt(prompt("Please enter a bet amount"));
//console.log("bet on Clubs = " + clubsBet);
//document.getElementById("betForClubs").textContent = "You bet on clubs: "+ clubsBet;*/
	return betClubs, clubsBet;
}
document.write("<br />bet on clubs = " + betOnClubs(false) + "<br />   Amount bet = " + betOnClubs(0));

//betting on the hearts
function betOnHearts(heartsBet, betHearts) {
/*betHearts = true;
//heartsBet = 0;                       //parseInt(prompt("Please enter a bet amount"));
//console.log("bet on Hearts = " + heartsBet);
//document.getElementById("betForHearts").textContent = "You bet on hearts: "+ heartsBet;*/
	return betHearts, heartsBet;
}
document.write("<br />bet on hearts = " + betOnHearts(false) + "<br />   Amount bet = " + betOnHearts(0));




////////////////THIS IS FOR TEST CASE
//TEST CASE AMOUNT BEING BET
function betTestCase1(totalBet1) {
	totalBet = betOnCrown(0) + betOnAnchor(0) + betOnDiamonds(15) + betOnSpades(0) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase2(totalBet2) {
	totalBet = betOnCrown(0) + betOnAnchor(0) + betOnDiamonds(15) + betOnSpades(15) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase3(totalBet3) {
	totalBet = betOnCrown(0) + betOnAnchor(0) + betOnDiamonds(15) + betOnSpades(15) + betOnClubs(15) + betOnHearts(0);
	return	totalBet;
}
function betTestCase4(totalBet4) {
	totalBet = betOnCrown(0) + betOnAnchor(0) + betOnDiamonds(10) + betOnSpades(10) + betOnClubs(10) + betOnHearts(10);
	return	totalBet;
}
function betTestCase5(totalBet5) {
	totalBet = betOnCrown(15) + betOnAnchor(0) + betOnDiamonds(0) + betOnSpades(0) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase6(totalBet6) {
	totalBet = betOnCrown(15) + betOnAnchor(15) + betOnDiamonds(0) + betOnSpades(0) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase7(totalBet7) {
	totalBet = betOnCrown(15) + betOnAnchor(15) + betOnDiamonds(0) + betOnSpades(15) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase8(totalBet8) {
	totalBet = betOnCrown(10) + betOnAnchor(10) + betOnDiamonds(0) + betOnSpades(10) + betOnClubs(10) + betOnHearts(0);
	return	totalBet;
}
function betTestCase9(totalBet9) {
	totalBet = betOnCrown(5) + betOnAnchor(5) + betOnDiamonds(10) + betOnSpades(5) + betOnClubs(5) + betOnHearts(5);
	return	totalBet;
}
function betTestCase10(totalBet10) {
	totalBet = betOnCrown(15) + betOnAnchor(0) + betOnDiamonds(0) + betOnSpades(0) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase11(totalBet11) {
	totalBet = betOnCrown(15) + betOnAnchor(0) + betOnDiamonds(15) + betOnSpades(0) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase12(totalBet12) {
	totalBet = betOnCrown(15) + betOnAnchor(15) + betOnDiamonds(15) + betOnSpades(0) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase13(totalBet13) {
	totalBet = betOnCrown(10) + betOnAnchor(10) + betOnDiamonds(10) + betOnSpades(10) + betOnClubs(0) + betOnHearts(0);
	return	totalBet;
}
function betTestCase14(totalBet14) {
	totalBet = betOnCrown(5) + betOnAnchor(5) + betOnDiamonds(5) + betOnSpades(5) + betOnClubs(5) + betOnHearts(5);
	return	totalBet;
}
function betTestCase15(totalBet15) {
	totalBet = betOnCrown(5) + betOnAnchor(5) + betOnDiamonds(5) + betOnSpades(5) + betOnClubs(5) + betOnHearts(5);
	return	totalBet;
}


//console.log("*******************************************************************");