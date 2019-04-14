window.addEventListener('load', draw, false);
function draw() {
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	
	ctx.beginPath();
	ctx.fillStyle  = "#ff9";
	ctx.strokeStyle = "#999";
	ctx.lineWidth = 4;
	ctx.arc(120,40,25,0,2*Math.PI,false);
	ctx.stroke();
	ctx.fill();
	ctx.closePath();
	
	ctx.beginPath();
	ctx.moveTo(120,65);
	ctx.lineTo(120,165);
	ctx.lineTo(160,205);
	ctx.moveTo(120, 165);
	ctx.lineTo(80,205);
	ctx.moveTo(120, 105);
	ctx.lineTo(80,65);
	ctx.moveTo(120, 105);
	ctx.lineTo(160,65);
	ctx.stroke();
	ctx.closePath();
}
