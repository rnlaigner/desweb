/*------------------------------------------
 Reservation
 ------------------------------------------*/

$(document).ready(function () {
	
	//TODO debugar
	$(document).on('click', '.seatsPopUp', function(event){
		
		var flight_id = $(this).attr('flight_id');
		
		var elementPrice = '#' + flight_id + ' ' + '.price';
		
		var price = $(elementPrice).attr('price');
		
		var firstClassFactor = $('#firstClassFactor').text();
		var executiveClassFactor = $('#executiveClassFactor').text();
		var economyClassFactor = $('#economyClassFactor').text();
		
		var elementCategory = flight_id + '.category';
		
		var category = $(elementCategory).text();
		
		var elementSeat = flight_id + '.seat';
		
		var seat = $(elementSeat).text();
		
    	var w = window.open("http://localhost:8080/web/seats.jsp", "_blank", "scrollbars=1,resizable=1,height=520,width=600");
    	
    	w.price = price;
    	w.firstClassFactor = firstClassFactor;
    	w.executiveClassFactor = executiveClassFactor;
    	w.economyClassFactor = economyClassFactor;
    	
    	w.changeSeat = true;
    	w.seat = seat;
    	w.category = category;
    });
	
	$(".checkin").on('click', function(e){
    	e.preventDefault();
    	var flight_id = $(this).attr('flight_id');  
    	$.ajax({
        	type: "POST",
            url : "CheckinServlet",
            data : {
            	flight_id : flight_id
            },
            success : function(results){
                if(results != null && results != ""){
                	window.location.href = "http://localhost:8080/web/boardingPass.jsp";
                }else{
                    alert("Erro no checkin");
                }
            }
        });
	});
	
	$(".boardingPass").on('click', function(e){
    	e.preventDefault();
    	debugger;
    	var flight_id = $(this).attr('flight_id');  
    	$.ajax({
        	type: "POST",
            url : "BoardingPassServlet",
            data : {
            	flight_id : flight_id
            },
            success : function(results){
                if(results != null && results != ""){
                	window.location.href = "http://localhost:8080/web/boardingPass.jsp";
                }else{
                    alert("Erro no checkin");
                }
            }
        });
	});
    
    function deselect(e) {
    	 $('.pop').slideFadeToggle(function() {
    	   e.removeClass('selected');
    	 });    
    }

	$(function() {
	  $('#contact').on('click', function() {
	    if($(this).hasClass('selected')) {
	      deselect($(this));               
	    } else {
	      $(this).addClass('selected');
	      $('.pop').slideFadeToggle();
	    }
	    return false;
	  });

	  $('.close').on('click', function() {
	    deselect($('#contact'));
	    return false;
	  });
	});

    $.fn.slideFadeToggle = function(easing, callback) {
    	return this.animate({ opacity: 'toggle', height: 'toggle' }, 'fast', easing, callback);
    };
});


