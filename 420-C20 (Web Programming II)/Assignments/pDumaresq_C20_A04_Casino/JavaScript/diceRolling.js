$(document).ready(function() {
	var name      = localStorage.getItem("LastName");
	var fname     = localStorage.getItem("FirstName");
	$("#name2").text(fname + " " + name);
	$("#phone2").text(localStorage.getItem("PhoneNum"));
	$("#postal2").text(localStorage.getItem("PostalCode"));	
	$("#remain2").text(localStorage.getItem("MoneyLeft"));
	
	$("#openDialogue").on('click', function() {
		$("#dialog").dialog({ 
			width: 500, 
			modal: true,
			resizable: false,
			draggable: false,
			buttons: {
				"close": function() {
					$(this).dialog("close");
				}
			}
		});
	});
	var sides = [ "diamond", "crown", "spade", "club", "anchor", "heart" ];
	
/* PLAYER LEAVING MESSAGE
 * When the paragraph tag with the id "backToMain" is clicked, a function is called that displays
 * A message for the user thanking them for visiting the casino. Underneath a little message is displayed 
 * Telling the user how much time they have left before being redirected to the main page. 
**/
	$(".backToMain").on('click', function() { 
		var time = 6;
		setInterval(function() {
			var rT = time-1;
			$( "#all" ).css("backgroundColor", "#333").css("margin", "5%").css("color", "white").css("textAlign", "center")
			.css("borderStyle", "solid").css("borderColor", "white").css("borderWidth", "2px").css("borderRadius", "2px")
			.css("padding", "11%").css("opacity", .95)
			.html("<h4>Thank you for visiting Casino Black Lotus. <br /> Please visit us again soon. <br />"
			+ "<br /> You will be redirected to the home page in " + rT + " seconds.</h4>");
			time--;
		},1000);
		
		setTimeout(function() {
			localStorage.clear();
			location.href = "index.html"; 
		},6000);
	});

/*
 * Creates drag and drop interface. Makes all of the chips draggable and all of the squares on the table droppable. 
 * Whenever a chip gets dragged, the chip is cloned. Whenever the chip is dropped somewhere on the page, it's 
 * brought back to it's original position. If the chip is dropped on the table, then it will be destroyed and the bet 
 * amount will be increased.  
**/
	var amountBet = 0;
	var betAmounts = new Array();
	var bets = new Array();
	
	(function() {
		for (q = 0 ; q < 6 ; q++) {
			betAmounts[q] = {
				side: sides[q],
				amount: 0,
			}
			bets[q] = 0;
		}
		
		$(".chip").draggable({
			revert: true,
			appendTo: 'body',
			containment: 'window',
			scroll: false,
			overflow: 'scroll',
			helper: 'clone',
		});//draggable
		
		$(".mat").droppable({
			drop: function(e, ui) {
				var chipAmount = parseInt(ui.draggable.attr("id"));
				var index = $(this).attr("alt");
				var square = $(this).attr("id");
				
				if (chipAmount > (localStorage.MoneyLeft - amountBet)) {
					$("#tooMuch").dialog({ 
						width: 300, 
						modal: true,
						resizable: false,
						draggable: false,
					});
					setTimeout(function() {
						$("#tooMuch").dialog("close");
					},4000);
				}
				else {
					amountBet += chipAmount;
					$("#amountBet").css("display", "inline").text(amountBet);
					$("#amount").css("display", "inline");
					makeBets(chipAmount, square, index);
				}
			},
		});//droppable

		function makeBets(money, square, index) {
			bets[index] += money;
			betAmounts[index] = {
				side: square,
				amount: bets[index],
			}
			console.log(betAmounts[index].side + ": " + betAmounts[index].amount);
		}
	})();

	$("#resetBets").on('click', function() {
		amountBet = 0;
		$("#amountBet").css("display", "none");
		$("#amount").css("display", "none");
		for (q = 0 ; q < 6 ; q++) {
			bets[q] = 0;
			betAmounts[q].amount = 0;
			console.log(betAmounts[q].amount)
		}
		$("#reset").dialog({ 
			width: 300, 
			modal: true,
			resizable: false,
			draggable: false,
		});
		setTimeout(function() {
			$("#reset").dialog("close");
		},1000);
	});	
	
/* ROLLING THE DICE
 * When the rollTheDice button is clicked, several things happen. First of all, 3 random numbers
 * between 0 and 5 are chosen. those numbers are the sides that the 3 different dice are going to land on.
 * So there's 3 different images of dice on the game page. Each of those images is going to change until one at a time,
 * they each stop rolling. There's an array of image objects and whatever each random number is, one of the dice 
 * is going to land on the image that is contained at that index in the array of images. 
 * Then underneath that, there's a message displayed telling the user if they won or lost. To determine that, another function
 * is called that checks all of the winning conditions.   
**/
	var outcome1, outcome2, outcome3;
	var q;
	var time1 = 0;
	var time2 = 0;
	var time3 = 0;

	$("#rollingTheDice").on('click', proceed);
	
	function proceed() {
		var totalAmountBet = 0;
		for (var q = 0 ; q < 6 ; q++) {
			totalAmountBet += betAmounts[q].amount;
		}
		if (totalAmountBet == 0) {
			$("#enterBet").dialog({ 
				width: 400, 
				modal: true,
				resizable: false,
				draggable: false,
				buttons: {
					"close": function() {
						$(this).dialog("close");
					}
				}
			});
		}
		else {
			for (var q = 0 ; q < 6 ; q++) {
				//console.log(images[q]);
			}
			setUp();
		}
		setTimeout(function() {
			$("#enterBet").dialog("close");
		},20000);
	}
	
	function setUp() {
		$("#rollingTheDice").attr('disabled', true);
		$("#resetBets").attr('disabled', true);
		$(".chip").draggable('disable');
		
		var images = [];
		for (q = 0 ; q < images.length ; q++) {
			images[q] = new Image();
			images[q].src = "./Images/dice/ " + sides[q] + ".png";
		}
		
		outcome1 = Math.floor(Math.random() * 6);
		outcome2 = Math.floor(Math.random() * 6);
		outcome3 = Math.floor(Math.random() * 6);
		
		interval = setInterval(function() {
			if (q == 5) { q = 0; } 
				else { q++ }
	
			if (time1 != 1500) {
				var image1 = document.getElementById("dice1");
				image1.src = "./Images/dice/" + sides[q] + ".png";
				time1+=50;
			
				if (time1 == 1500) {
					image1.src = "./Images/dice/" + sides[outcome1] + ".png";
				}
			}
			if (time2 != 3000) {
				var image2 = document.getElementById("dice2");
				image2.src = "./Images/dice/" + sides[q] + ".png";
				time2+=50;
			
				if (time2 == 3000) {
					image2.src = "./Images/dice/" + sides[outcome2] + ".png";
				}
			}
			if (time3 != 4500) {
				var image3 = document.getElementById("dice3");
				image3.src = "./Images/dice/" + sides[q] + ".png";
				time3+=50;
			
				if (time3 == 4500) {
					image3.src = "./Images/dice/" + sides[outcome3] + ".png";
					clearInterval(interval);
					
					setTimeout(function() {
						winningConditions();
					},500);
					
					setTimeout(function() {
						location.href = "game.html";
					},3000);
				}
			}
		},50);
	}	
	
/* WINNING
 * These are the conditions that are checked to determind if the player won the game or not. 
**/

	function winningConditions() {
		var totalAmountBet = 0;
		var moneyLeft = parseInt(localStorage.MoneyLeft);
		var placesBet = new Array();
		var firstWin = true;
		
		for (q = 0 ; q < 6 ; q++) {
			if (betAmounts[q].amount > 0) 
				placesBet[q] = true;
			else 
				placesBet[q] = false;
			
			totalAmountBet += betAmounts[q].amount;
		}
	
		var moneyWonBack = 0;
		for (q = 0 ; q < 6 ; q++) {
			firstWin = true;
			if (placesBet[q] == true) {
				if (outcome1 == q) {
					moneyWonBack += betAmounts[q].amount;
					if (firstWin == true) {
						moneyWonBack += betAmounts[q].amount;
					}
					firstWin = false
				}
				if (outcome2 == q) {
					moneyWonBack += betAmounts[q].amount;
					if (firstWin == true) {
						moneyWonBack += betAmounts[q].amount;
					}
					firstWin = false;
				}
				if (outcome3 == q) {
					moneyWonBack += betAmounts[q].amount;
					if (firstWin == true) {
						moneyWonBack += betAmounts[q].amount;
					}
					firstWin = false;
				}
			}
		}
		
		moneyLeft -= totalAmountBet;
		moneyLeft += moneyWonBack;
	
		if (moneyLeft > localStorage.MoneyLeft) {
			$("#winning").html("<h1>YOU WIN!!!</h1>");
		}
		else if (moneyLeft == localStorage.MoneyLeft) {
			$("#winning").html("Close call! <br />You didn't lose or win any money");
		}
		else {
			$("#winning").html("<h4>Sorry, you lose</h4>");
		}
		$("#remain2").text(moneyLeft);
		localStorage.MoneyLeft = moneyLeft;
	}
});