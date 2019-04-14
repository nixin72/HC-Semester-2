var $ = function(id) { return document.getElementById(id); }
const NAMESTR  = "enter your name";
const EMAILSTR = "Enter your email address";
const PHONESTR = "Enter your phone number";
const AREASTR  = "What are of town are you interested in?";
const NUMSTR   = "###";
const MONEYSTR = "$$$";

document.addEventListener("load", setDefault());
    
function setDefault() {
	$("visitorName").value = NAMESTR;
		$("visitorName").select();
	$("emailAddr").value = EMAILSTR;
	$("phoneNumber").value = EMAILSTR;
	$("area").value = AREASTR;
	$("bedroom").value = NUMSTR;
	$("maxPrice").value = MONEYSTR;
}

$("visitorName").addEventListener("focus",
	function() {blankField(this, NAMESTR)});
$("emailAddr").addEventListener("focus",
	function() {blankField(this, EMAILSTR )});
$("phoneNumber").addEventListener("focus",
	function() {blankField(this, PHONESTR)});
$("area").addEventListener("focus",
	function() {blankField(this, AREASTR)});
		
var blankField = function(theEl, testStr) {
console.log("reaches first function");
	if (theEl=== testStr) 
		console.log("reaches inside first if");
		(theEl).value = "";
}

$("visitorName").addEventListener("blur",
	function() {resetField (this, NAMESTR)});
$("emailAddr").addEventListener("blur",
	function() {resetField (this, EMAILSTR )});
$("phoneNumber").addEventListener("blur",
	function() {resetField (this, PHONESTR)});
$("area").addEventListener("blur",
	function() {resetField (this, AREASTR)});

var resetField = function(theEl, testStr) {
console.log("reaches second function");
	if (theEl === "") 
		console.log("reaches second first if");
		(theEl).value = testStr;
	//	theEl.style.removeProperty('border');
}

/*
--------------------------------------------------------------------------------------
---------------------------------FORM VALIDATION--------------------------------------
--------------------------------------------------------------------------------------
*/

document.addEventListener('submit', validateForm());

function validateForm() {
	if (visitorName === "" || emailAddr === "" || phoneNumber === "" 
		|| area === "" || bedroom === "" || maxPrice === "" 
		|| visitorName === NAMESTR || emailAddr === EMAILSTR 
		|| phoneNumber === EMAILSTR || area === AREASTR 
		|| bedroom === NUMSTR || maxPrice === MONEYSTR) 
	{
		window.alert("please enter a value for your fields");	
		return false;
	}//must enter input into all text fields
	else { 
		if (propertyType == 0) {
			window.alert("please select a property type");	
			return false;
		}//must set a value in the combo box
		else {
			/*if (callMe.checked || emailMe.checked) {
				window.alert("please select a contact method");
				return false;
			}//must select one of the radio buttons
			else {
				return true;
			*/}//all fields entered correctly
		}//combo boxes are entered correctly
	}//text fields are entered correctly
//validate form






























































