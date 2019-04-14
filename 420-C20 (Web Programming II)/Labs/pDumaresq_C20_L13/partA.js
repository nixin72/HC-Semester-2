$(document).ready(function(e) {
	$("#animDiv1").on('click', function() {
		$("#animDiv1").animate({
			width: "70%",
			opacity: .4, 
			marginLeft: "3em", 
			fontSize: "2em",
			borderWidth: "10px",
		}, 5000, function() {
		$("#animDiv2").animate({
			width: "100%", 
			fontSize: ".6em",
			borderWidth: "3px",
		}, 4000)});
	});
});