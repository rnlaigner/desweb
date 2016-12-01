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
	
//	$(document).on('click', '#bookBtn1', '#bookBtn2', '#bookBtn3', function(event) {
//		$('html, body').animate({
//	        scrollTop: $("#bookSection").offset().top
//	    }, 2000);
//		$('body').scrollTo('#bookSection');
//	});
    
    $('#searchForm').on('submit', function(e){
        e.preventDefault();
    
        var origin = $("#origin").val();
        var destiny = $("#destiny").val();
        var departureDate = $("#departure").attr('value');
        var returnDate = $("#return").attr('value');
        var adult = $("#adult").val();
        var children = $("#children").val();
        var baby = $("#baby").val();
        var seat = $("#seat").val();
        
        if(origin == "" || origin == null){
            alert("A origem do vôo é necessária");
            return false;
        }
        if(destiny == "" || destiny == null){
            alert("A destino do vôo é necessário");
            return false;
        }
        if(departureDate == "" || departureDate == null){
            alert("A data do vôo é necessária");
            return false;
        }
        if(returnDate == "" || returnDate == null){
            alert("A data de retorno do vôo é necessária");
            return false;
        }
        if(seat == "" || seat == null){
            alert("A classe do vôo é necessária");
            return false;
        }
        this.submit();
    });
});


