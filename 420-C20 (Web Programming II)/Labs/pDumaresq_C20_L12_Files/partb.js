	$("#addClass").on('click', function() {
		$("p:first").addClass('myclass');
	});
	
	$("#rmvClass").on('click', function() {
		$("p:first").removeClass('myclass');
	});
	
	$("#title").on('click', function() {
		$('img:not([title])').attr('title', 'No Title Provided');
	});
	
	$("#indicator").on('click', function() {
		$(":header").prepend("Heading: ");
	});
	
	$("#line").on('click', function() {
		$("p:even").after("<hr />");
	});
	
	$("#toggleP").on('click', function() {
		$("p").slideToggle("slow", "swing");
	});
	
	$("#fade").on('click', function() {
		$("p:last").fadeTo("slow", .1);
	});
