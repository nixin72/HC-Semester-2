document.getElementById("betForDiamonds").addEventListener('blur', function(){setDiamond()}, false);
document.getElementById("betForCrown").addEventListener('blur', function(){setCrown()}, false);
document.getElementById("betForSpades").addEventListener('blur', function(){setSpades()}, false);
document.getElementById("betForClubs").addEventListener('blur', function(){setClubs()}, false);
document.getElementById("betForAnchor").addEventListener('blur', function(){setAnchor()}, false);
document.getElementById("betForHearts").addEventListener('blur', function(){setHearts()}, false);

var setDiamond = function() {
	var diamonds = 0;
	console.log("diamonds1: " + diamonds);
	diamonds = document.getElementById("betForDiamonds").value;
	var regex = /^(\d*)$/;
	var checker = regex.test(diamonds);
	
	if(checker == true && diamonds != "") {
		document.getElementById("betDiamonds").textContent = diamonds;
		return parseInt(diamonds);
	}
	console.log("diamonds2: " + diamonds);
	return parseInt(diamonds);
} 

var setCrown = function() {
	var crown = 0;
	crown = document.getElementById("betForCrown").value;
	var regex = /^(\d*)$/;
	var checker = regex.test(crown);
	
	if(checker == true && crown != "") {
		document.getElementById("betCrown").textContent = crown;
		return parseInt(crown);
	}
	console.log("crown: " + crown);
	return parseInt(crown);
}

var setSpades = function() {
	var spades = 0
	spades = document.getElementById("betForSpades").value;
	var regex = /^(\d*)$/;
	var checker = regex.test(spades);
	
	if(checker == true && spades != "") {
		document.getElementById("betSpades").textContent = spades;
		return parseInt(spades);
	}
	console.log("spades: " + spades);
	return parseInt(spades);
} 

var setClubs = function() {
	var clubs = 0;
	clubs = document.getElementById("betForClubs").value;
	var regex = /^(\d*)$/;
	var checker = regex.test(clubs);
	
	if(checker == true && clubs != "") {
		document.getElementById("betClubs").textContent = clubs;
		return parseInt(clubs);
	}
	console.log("clubs: " + clubs);
	return parseInt(clubs);
} 

var setAnchor = function() {
	var anchor = 0;
	anchor = document.getElementById("betForAnchor").value;
	var regex = /^(\d*)$/;
	var checker = regex.test(anchor);
	
	if(checker == true && anchor != "") {
		document.getElementById("betAnchor").textContent = anchor;
		return parseInt(anchor);
	}
	console.log("anchor: " + anchor);
	return parseInt(anchor);
} 

var setHearts = function() {
	var hearts = 0;
	hearts = document.getElementById("betForHearts").value;
	var regex = /^(\d*)$/;
	var checker = regex.test(hearts);
	
	if(checker == true && hearts != "") {
		document.getElementById("betHearts").textContent = hearts;
		return parseInt(hearts);
	}
	console.log("hearts: " + hearts);
	
	return parseInt(hearts);
} 