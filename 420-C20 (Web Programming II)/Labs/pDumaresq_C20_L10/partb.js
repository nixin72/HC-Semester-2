var images = [];
var currImage;

window.addEventListener('load', setUp, false);
function setUp() {
	for (currImage = 0 ; currImage < images.length ; currImage++) {
		images[currImage] = new Image();
		images[currImage].src = "images/jackhammer/jackhammer" + currImage + ".gif";
	}
	
	setInterval(startBouncing, 90);
}

function startBouncing() {
	if (currImage == 10) { currImage = 0; } 
		else { currImage++ }
		
	var image = document.getElementById('theImage');
   	
    image.src = "images/jackhammer/jackhammer" + currImage + ".gif";
}
