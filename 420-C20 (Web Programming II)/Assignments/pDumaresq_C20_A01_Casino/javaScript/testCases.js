console.log("************************************************************************************************************");
console.log("************************************************************************************************************");
console.log("----------------------------------------------TEST CASES----------------------------------------------------");
console.log("************************************************************************************************************");
console.log("************************************************************************************************************");

//TEST CASES FOR HAVING ONE DICE LAND ON YOUR BET(S)
console.log("Test case 1: one dice lands on your bet. You had one bet.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("anchor"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 0 " + betOnCrown(false));
console.log("Bet on anchor: 0 " + betOnAnchor(false));
console.log("Bet on diamonds: 15 " + betOnDiamonds(true));
console.log("Bet on spades: 0 " + betOnSpades(false));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction1());
console.log("What you should have after the payout: 65$ ");
console.log("Money after payout: " + moneyMadeTest1());
console.log("*******************************************************************");


console.log("Test case 2: one dice lands on your bet. You had two bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("anchor"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 0 " + betOnCrown(false));
console.log("Bet on anchor: 0 " + betOnAnchor(false));
console.log("Bet on diamonds: 15 " + betOnDiamonds(true));
console.log("Bet on spades: 15 " + betOnSpades(true));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction2());
console.log("What you should have after the payout: 50$ ");
console.log("Money after payout: " + moneyMadeTest2());
console.log("*******************************************************************");


console.log("Test case 3: one dice lands on your bet. You had three bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("anchor"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 0 " + betOnCrown(false));
console.log("Bet on anchor: 0 " + betOnAnchor(false));
console.log("Bet on diamonds: 15 " + betOnDiamonds(true));
console.log("Bet on spades: 15 " + betOnSpades(true));
console.log("Bet on clubs: 15 " + betOnClubs(true));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction3());
console.log("What you should have after the payout: 35$ ");
console.log("Money after payout: " + moneyMadeTest3());
console.log("*******************************************************************");


console.log("Test case 4: one dice lands on your bet. You had four bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("anchor"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 0 " + betOnCrown(false));
console.log("Bet on anchor: 0 " + betOnAnchor(false));
console.log("Bet on diamonds: 10 " + betOnDiamonds(true));
console.log("Bet on spades: 10 " + betOnSpades(true));
console.log("Bet on clubs: 10 " + betOnClubs(true));
console.log("Bet on hearts: 10 " + betOnHearts(true));
console.log("Money after deduction, before payout: $" + moneyDeduction4());
console.log("What you should have after the payout: 30$ ");
console.log("Money after payout: " + moneyMadeTest4());
console.log("*******************************************************************");

//TEST CASES FOR HAVING TWO DICE LAND ON YOUR BET(S)
console.log("Test case 5: two dice land on your bet. You had one bet.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 15 " + betOnCrown(true));
console.log("Bet on anchor: 0 " + betOnAnchor(false));
console.log("Bet on diamonds: 0 " + betOnDiamonds(false));
console.log("Bet on spades: 0 " + betOnSpades(false));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction5());
console.log("What you should have after the payout: 80$ ");
console.log("Money after payout: " + moneyMadeTest5());
console.log("*******************************************************************");


console.log("Test case 6: two dice land on your bet. You had two bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 15 " + betOnCrown(true));
console.log("Bet on anchor: 15 " + betOnAnchor(true));
console.log("Bet on diamonds: 0 " + betOnDiamonds(false));
console.log("Bet on spades: 0 " + betOnSpades(false));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction6());
console.log("What you should have after the payout: 65$ ");
console.log("Money after payout: " + moneyMadeTest6());
console.log("*******************************************************************");


console.log("Test case 7: two dice land on your bet. You had three bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 15 " + betOnCrown(true));
console.log("Bet on anchor: 15 " + betOnAnchor(true));
console.log("Bet on diamonds: 0 " + betOnDiamonds(false));
console.log("Bet on spades: 15 " + betOnSpades(true));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction7());
console.log("What you should have after the payout: 50$ ");
console.log("Money after payout: " + moneyMadeTest7());
console.log("*******************************************************************");


console.log("Test case 8: two dice land on your bet. You had four bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 10 " + betOnCrown(true));
console.log("Bet on anchor: 10 " + betOnAnchor(true));
console.log("Bet on diamonds: 0 " + betOnDiamonds(false));
console.log("Bet on spades: 10 " + betOnSpades(true));
console.log("Bet on clubs: 10 " + betOnClubs(true));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction8());
console.log("What you should have after the payout: 40$ ");
console.log("Money after payout: " + moneyMadeTest8());
console.log("*******************************************************************");


console.log("Test case 9: two dice land on your bet. You had five bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 5 " + betOnCrown(true));
console.log("Bet on anchor: 5 " + betOnAnchor(true));
console.log("Bet on diamonds: 0 " + betOnDiamonds(false));
console.log("Bet on spades: 5 " + betOnSpades(true));
console.log("Bet on clubs: 5 " + betOnClubs(true));
console.log("Bet on hearts: 5 " + betOnHearts(true));
console.log("Money after deduction, before payout: $" + moneyDeduction9());
console.log("What you should have after the payout: 40$ ");
console.log("Money after payout: " + moneyMadeTest9());
console.log("*******************************************************************");

//TEST CASES FOR HAVING 3 DICE LAND ON YOUR BET(S)
console.log("Test case 10: Three dice land on your bet. You had one bet.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("Bet on crown: 15 " + betOnCrown(true));
console.log("Bet on anchor: 0 " + betOnAnchor(false));
console.log("Bet on diamonds: 0 " + betOnDiamonds(false));
console.log("Bet on spades: 0 " + betOnSpades(false));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction10());
console.log("What you should have after the payout: 95$ ");
console.log("Money after payout: " + moneyMadeTest10());
console.log("*******************************************************************");


console.log("Test case 11: Three dice land on your bet. You had two bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 15 " + betOnCrown(true));
console.log("Bet on anchor: 0 " + betOnAnchor(false));
console.log("Bet on diamonds: 15 " + betOnDiamonds(true));
console.log("Bet on spades: 0 " + betOnSpades(false));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction11());
console.log("What you should have after the payout: 80$ ");
console.log("Money after payout: " + moneyMadeTest11());
console.log("*******************************************************************");


console.log("Test case 12: Three dice land on your bet. You had three bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 15 " + betOnCrown(true) );
console.log("Bet on anchor: 15 " + betOnAnchor(true));
console.log("Bet on diamonds: 15 " + betOnDiamonds(true));
console.log("Bet on spades: 0 " + betOnSpades(false));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction12());
console.log("What you should have after the payout: 65$ ");
console.log("Money after payout: " + moneyMadeTest12());
console.log("*******************************************************************");


console.log("Test case 13: Three dice land on your bet. You had four bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 10 " + betOnCrown(true));
console.log("Bet on anchor: 10 " + betOnAnchor(true));
console.log("Bet on diamonds: 10 " + betOnDiamonds(true));
console.log("Bet on spades: 10 " + betOnSpades(true));
console.log("Bet on clubs: 0 " + betOnClubs(false));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction13());
console.log("What you should have after the payout: 50$ ");
console.log("Money after payout: " + moneyMadeTest13());
console.log("*******************************************************************");


console.log("Test case 14: Three dice land on your bet. You had five bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 5 " + betOnCrown(true));
console.log("Bet on anchor: 5 " + betOnAnchor(true) );
console.log("Bet on diamonds: 5 " + betOnDiamonds(true));
console.log("Bet on spades: 5 " + betOnSpades(true));
console.log("Bet on clubs: 5 " + betOnClubs(true));
console.log("Bet on hearts: 0 " + betOnHearts(false));
console.log("Money after deduction, before payout: $" + moneyDeduction14());
console.log("What you should have after the payout: 45$ ");
console.log("Money after payout: " + moneyMadeTest14());
console.log("*******************************************************************");


console.log("Test case 15: Three dice land on your bet. You had six bets.");
console.log("Starting money: " + startingMoney(50));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("crown"));
console.log("First dice: " + firstRoll("diamonds"));
console.log("Bet on crown: 5 " + betOnCrown(true));
console.log("Bet on anchor: 5 " + betOnAnchor(true));
console.log("Bet on diamonds: 5 " + betOnDiamonds(true));
console.log("Bet on spades: 5 " + betOnSpades(true));
console.log("Bet on clubs: 5 " + betOnClubs(true));
console.log("Bet on hearts: 5 " + betOnHearts(true));
console.log("Money after deduction, before payout: $" + moneyDeduction15());
console.log("What you should have after the payout: 40$ ");
console.log("Money after payout: " + moneyMadeTest15());
console.log("*******************************************************************");