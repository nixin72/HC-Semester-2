$("#addClass").on('click', function() {
	$("p.newClass").add("p #p5").addClass("myclass");
});

$("#find").on('click', function() {
	$("p:contains(large)").css("color", "DarkSlateBlue");
});

$("#listThings").on('click', function() {
	$("li:gt(6)").css("fontStyle", "italic");
});

$("#listAgain").on('click', function() {
	$("li:lt(9)").css("fontFamily", "Arial");
});