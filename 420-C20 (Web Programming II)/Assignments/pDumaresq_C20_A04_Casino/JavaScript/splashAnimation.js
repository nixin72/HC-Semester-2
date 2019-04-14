$(document).ready(function() {
	if ($(window).width() < 1100) {
		location.href = "index.html";
	}
	
	var XposRight = 1300;
	var XposLeft = 200;
	var XposRect = 1300;
	var clear2   = 2000;

	ctx = document.getElementById("animation").getContext("2d");

	drawBackground();
	function drawBackground() {
		var background = document.getElementById("background");
		ctx.drawImage(background, 5, 0, 2000, 750);

		//DRAW CAR PULLING UP
		margin = 0;
		var interval = setInterval(function() {
			ctx.fillStyle = "black";
			ctx.rect(0,0,XposRect,650);
			ctx.fill();
			ctx.clearRect(XposLeft,75,800,300);

			XposLeft++;
			XposRect+=10000;//width of rect

			console.log(XposRect);
			
			$("#splash").css("marginLeft", margin);
			margin--;
			if (margin < -300) {
				clearInterval(interval);
			}
		}, .1);
		
		var showAngleInner = 0;
		var showAngleOutter = 0;
		setTimeout(function() {
			//OPEN DOOR
			var interval2 = setInterval(function() {
				if (XposLeft > 10) { 
					ctx.fillStyle = "black";
					ctx.rect(0,0,XposRect,800);
					ctx.fill();
					ctx.clearRect(XposLeft,75,XposRight,300);
					
					XposLeft -= 5; //left hand side of window
					XposRight -= 5; //right hand side of window
					
					XposRect -= 5 + showAngleInner;
					clear2 += 10;
					ctx.clearRect(XposRect, 0, clear2-showAngleOutter, 750);
					
					showAngleOutter += 1;
					showAngleInner += 1.4;
					//ctx.stroke();
				}
				else { 
					//clears interval once the car door has opened
					clearInterval(interval2);
	
					/*
					 * Decreases the margin on the left to replicate turning to the right to make 
					 * the center of the image be the middle of the red carpet. Lights flashing 
					 * all over the sides behind the ropes. 
					**/
					//var margin = 0;
					var interval3 = setInterval(function() {
						$("#splash").css("marginLeft", margin);
						margin--;
						
						if (margin < -300) {
							clearInterval(interval3);
							
							
							/*
							 * Zooms in on the background while trying to keep the image centered on the screen. 
							 * Increases the height to compensate for the decreasing margin, etc.
							**/
							var zoom = 100;
							var margin_top = 0;
							var height = 480;
							
							margin = 0
							$("#animation").remove();
							var interval4 = setInterval(function() {
								$("#splash").css("backgroundSize", zoom+"%").css("marginLeft", margin)
											.css("marginTop", margin_top).height(height);
								height+=4;
								margin-=25;
								margin_top-=4;
								zoom++;
								if (margin < -1500) {
									clearInterval(interval4);
									
									
									/*
									 * Transitions to the welcome message. Opacity on current image decreases until it's 
									 * transparent and the new background comes up with the casino logo and the name
									 * with the redirection message. 
									**/
									var opacity = 1;
									var interval5 = setInterval(function() {
										$("#logo").css("display", "inline");
										$("#inside").css({
											backgroundColor: "#333",
										});
										$("#splash").css("opacity", opacity);
										opacity -= .05;
										
										if (opacity < 0) {
											clearInterval(interval5);
											
											$("#splash").css("backgroundImage", "none")
													.css("opacity", 1)
													.css("marginLeft", -1)
													.css("marginTop", -1)
													.css("height", "100%");
												
											$("#splash").html("<div id='logoDisplay'></div><div id='welcomeMessage'></div>");
												
											$("#logoDisplay").html("<img src='./Images/casinoLogo.jpg' " 
												+ "height='60%' width='60%' alt='casino logo' /><br />")
											
											$("#logoDisplay").css("marginLeft", "auto").css("marginRight", "auto");
											
											$("#splash").append("<h1>Welcome to the Casino Black Lotus!</h1> " 
													+ "<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /> "
													+ "<br />")
													.append("<h4 id='redirect'>Redirecting you in 5"
														+ "</h4><br /><br />");		
											var seconds = 5;
											interval6 = setInterval(function() {
												var display = seconds-1;
												$("#redirect").text("Redirecting you in " + display);												
													
												seconds--;
												if ( seconds <= 0 ) {
													clearInterval(interval6);
													location.href = "index.html";
												}
											},1000);
										}
									},150);	
								}
							},100);//100
						}
					},5);//5
				}
			}, 60);//60
		}, 4000);
	}
	$("#skip").on('click', function() {
		location.href = "index.html";
	});
});