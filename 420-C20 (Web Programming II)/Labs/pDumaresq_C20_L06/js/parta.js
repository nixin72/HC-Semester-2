var heroes = [];
heroes[0] = ["Barry", "Allen", 1996, "The Flash", 50];
heroes[1] = ["Oliver", "Queen", 1976, "Green Arrow", 100];
heroes[2] = ["Natasha", "Romanov", 1981, "Black Widow", 400];
heroes[3] = ["Clint", "Barton", 1956, "Hawkeye", 20];
heroes[4] = ["James", "Howlett", 1816, "Wolverine", 1000];
heroes[5] = ["Tony", "Stark", 1966, "Ironman", 10];

var left = "";
var right = "";

for (var k = 0 ; k < heroes.length ; k++) 
{
	
	var currentYear = new Date().getFullYear();
	var age = (currentYear-heroes[k][2]);
	var rate;
	
	if (age > 50) 
	{ 
		rate = (heroes[k][4]*(2016-heroes[k][2])) * 1.5;
	} 
	else 
	{
		rate = (heroes[k][4]*(2016-heroes[k][2]));
	}
	
	if (rate > 2000) 
	{
		left += 
		"<br />" + heroes[k][0] + " " + heroes[k][1] + " aka the " 
		+ heroes[k][3] + " was born " + age 
		+ " years ago. He/she is worth: $" + rate + "<br />";
	} 
	else if (rate < 2000)
	{
		right += 
		"<br />" + heroes[k][0] + " " + heroes[k][1] + " aka the " 
		+ heroes[k][3] + " was born " + age 
		+ " years ago. He/she is worth: $" + rate + "<br />";
	}
}

document.getElementById("theLeft").innerHTML = left + "<br />";
document.getElementById("theRight").innerHTML = right + "<br />";	