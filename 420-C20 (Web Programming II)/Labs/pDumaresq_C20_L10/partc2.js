var arrayOfPuppies = [];
var currImg;
var currPos = -97;
var width = window.innerWidth
document.documentElement.style.overflowX = "hidden";

window.addEventListener('load', makePuppies, false);
function makePuppies() {
	for (currImg = 0 ; currImg < arrayOfPuppies.length ; currImg++) {
		arrayOfPuppies[currImg] = new Image();
		arrayOfPuppies[currImg].src = "images/puppy/puppy" + currImg + ".gif";
	}
	
	setInterval(movePup, 50);
	setInterval(changePup, 90);
}

function changePup() {
	if (currImg == 5) { currImg = 0; }
		else { currImg++; }
		
	var puppy = document.getElementById('puppy');
   	
    puppy.src = "images/puppy/puppy" + currImg + ".gif"
}

function movePup() {	
	var image = document.getElementById("puppy");
	image.style.left = currPos + "px";
	
	if (currPos > width) { currPos = -97; }
		else { currPos += 10; } 
}
