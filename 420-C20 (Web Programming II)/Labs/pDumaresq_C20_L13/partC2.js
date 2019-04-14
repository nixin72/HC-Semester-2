$(document).ready(function() {
	$("img").draggable();
	$("#finish").droppable({drop: function(e, ui) {
		var whichOne = ui.draggable.attr("alt");
		var string = whichOne + " dropped at " + e.pageX + " x " + e.pageY + "<br />";
		$(this).html(string);
			
	}});
});