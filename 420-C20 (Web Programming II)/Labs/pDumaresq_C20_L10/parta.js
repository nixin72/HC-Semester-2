var currPoster = 1;
setInterval(changeImage, 5000);

function changeImage() {
	if (currPoster == 5) { currPoster = 1; }
		else { currPoster++ ;}
		
	var image = document.getElementById('theConcert');
   	image.src = "images/concerts/concert" + currPoster + ".jpg";
}