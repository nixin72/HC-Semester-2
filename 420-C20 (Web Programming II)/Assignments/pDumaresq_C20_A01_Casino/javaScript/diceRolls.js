//Array for first dice
function firstRoll(outcome1) {
	var dice1 = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
	var roll1 = Math.floor((Math.random() * 6));
	var outcome1 = dice1[roll1];
	return outcome1;
}
document.write("<br />First dice: " + firstRoll());

//array for second dice
function secondRoll() {
	var dice2 = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
	var roll2 = Math.floor((Math.random() * 6));
	var outcome2 = dice2[roll2];
	return outcome2;
}
document.write("<br />Second dice: " + secondRoll());

//array for third dice
function thirdRoll() {
	var dice3 = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
	var roll3 = Math.floor((Math.random() * 6));
	var outcome3 = dice3[roll3];
	return outcome3;
}
document.write("<br />Third dice: " + thirdRoll());

//console.log("*******************************************************************");
/*
function diceRollsTest1() {
	firstRoll("crown");
	secondRoll("anchor");
	thordRoll("diamonds");
}
function diceRollsTest2() {
	firstRoll("crown");
	secondRoll("anchor");
	thordRoll("diamonds");
}
function diceRollsTest3() {
	firstRoll("crown");
	secondRoll("anchor");
	thordRoll("diamonds");
}
function diceRollsTest4() {
	firstRoll("crown");
	secondRoll("anchor");
	thordRoll("diamonds");
}
function diceRollsTest5() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("diamonds");
}
function diceRollsTest6() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("diamonds");
}
function diceRollsTest7() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("diamonds");
}
function diceRollsTest8() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("diamonds");
}
function diceRollsTest9() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("diamonds");
}
function diceRollsTest10() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("crown");
}
function diceRollsTest11() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("crown");
}
function diceRollsTest12() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("crown");
}
function diceRollsTest13() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("crown");
}
function diceRollsTest14() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("crown");
}
function diceRollsTest15() {
	firstRoll("crown");
	secondRoll("crown");
	thordRoll("crown");
}
*/


