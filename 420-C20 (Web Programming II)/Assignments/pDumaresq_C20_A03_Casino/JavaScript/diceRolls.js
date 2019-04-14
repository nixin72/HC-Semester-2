$("#rollingTheDice").on('click', diceRolls);
var diceArray = new Array();

function diceRolls() {
	for ( var q = 0 ; q < 3 ; q++ ) {
		diceArray[q] = {

			outcome: function() {
				var dice = ["crown", "anchor", "diamonds", "hearts", "spades", "clubs"];
				roll = Math.floor(Math.random() * 6);
				return dice[roll];
			} 
		}
	}
	$("#firstDiceRoll").text(diceArray[0].outcome);
	$("#secondDiceRoll").text(diceArray[1].outcome);
	$("#thirdDiceRoll").text(diceArray[2].outcome);
}