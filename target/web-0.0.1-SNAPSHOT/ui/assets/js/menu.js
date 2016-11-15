/*------------------------------------------
 Homepage
 ------------------------------------------*/

$(document).ready(function () {

	$('#bookBtn1').click(function() {
		window.location='home.jsp#bookSection';
	});
	$('#bookBtn2').click(function() {
		window.location='home.jsp#bookSection';
	});
	$('#bookBtn3').click(function() {
		window.location='home.jsp#bookSection';
	});
	
	//avoid dropdown-menu to deactivate when clicking on elements inside it
    $(document).on('click', '.dropdown-menu', function (e) {
    	  e.stopPropagation();
    });
});


