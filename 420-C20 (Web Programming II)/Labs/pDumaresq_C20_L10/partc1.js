var currPos = -97;
setInterval(movePup, 50);
var width = window.innerWidth
document.documentElement.style.overflowX = "hidden";

function movePup() {
	var image = document.getElementById("puppy");
	image.style.left = currPos + "px";
	
	if (currPos > width) { currPos = -97; }
		else { currPos += 10; } 
}
