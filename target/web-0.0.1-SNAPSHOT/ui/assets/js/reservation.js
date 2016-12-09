/*------------------------------------------
 Reservation
 ------------------------------------------*/

$(document).ready(function () {
	
	//TODO debugar
	$(document).on('click', '.seatsPopUp', function(event){
		debugger;
		var flight_id = $('.seatsPopUp a').attr('flight_id');
		
		var price = $('.seatsPopUp p').attr('price');
		
		var firstClassFactor = $('#firstClassFactor').text();
		var executiveClassFactor = $('#executiveClassFactor').text();
		var economyClassFactor = $('#economyClassFactor').text();
		
		var category = $('.category').attr("flight_id",flight_id).text();
		
		var seat = $('.seat').attr("flight_id",flight_id).text();
		
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
	
	$(".updatePassenger").on('click', function(e){
    	e.preventDefault();
    	var passenger_id = $(this).attr('passenger_id'); 
    	var flight_id = $(this).attr('flight_id'); 
    	var telephone = $('#telephone').attr('flight_id',flight_id).val();
    	$.ajax({
        	type: "POST",
            url : "UpdatePassengerServlet",
            data : {
            	passenger_id : passenger_id,
            	telephone : telephone
            },
            success : function(results){
                if(results != null && results != ""){
                	window.location.href = "http://localhost:8080/web/reservations.jsp";
                }else{
                    alert("Erro no checkin");
                }
            }
        });
	});
    
	function updateSeat(selectedSeat,value){
		debugger;
		if(selectedSeat != null && value != null){
			$.ajax({
	        	type: "POST",
	            url : "UpdateSeatServlet",
	            data : {
	            	selectedSeat : selectedSeat,
	            	value : value
	            },
	            success : function(results){
	                if(results != null && results != ""){
	                	window.location.href = "http://localhost:8080/web/reservations.jsp";
	                }else{
	                    alert("Erro no checkin");
	                }
	            }
	        });
		}
	}
	
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


