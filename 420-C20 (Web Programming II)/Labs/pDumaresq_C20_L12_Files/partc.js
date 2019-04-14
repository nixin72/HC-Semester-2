	$(document).ready(function() {
		$("#myDiv").on('click', doMeasure);
	});
	
	function doMeasure() {
		var myTxt = "";
		myTxt += "width of div: " + $("#myDiv").width() + "<br />";
		myTxt += "height of div: " + $("#myDiv").height() + "<br />";
		myTxt += "innerWidth of div: " + $("#myDiv").innerWidth() + "<br />";
		myTxt += "innerHeight of div: " + $("#myDiv").innerHeight() + "<br />";
		myTxt += "outerWidth of div: " + $("#myDiv").outerWidth() + "<br />";
		myTxt += "outerHeight of div: " + $("#myDiv").outerHeight() + "<br />";
		myTxt += "<hr />";
		myTxt += "Document width x height: "+$(document).width()+" x "+$(document).height()+"<br/>"; 
		myTxt += "Window (viewport) width x height: " + $(window).width() + " x " + $(window).height(); 
		$("#myDiv").html(myTxt);
	}
	
	$("#big").on('click', larger);
	
	function larger() {
		$("#myDiv").width(($("#myDiv").width()+20)).height(($("#myDiv").height()+10));
	}
	$("#sml").on('click', smaller);
	
	function smaller() {
		$("#myDiv").width(($("#myDiv").width()-20)).height(($("#myDiv").height()-10));
	}