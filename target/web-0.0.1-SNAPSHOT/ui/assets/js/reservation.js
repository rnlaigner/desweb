/*------------------------------------------
 Reservation
 ------------------------------------------*/

$(document).ready(function () {
	
	$(document).on('click', '.seatsPopUp', function(event){
		var flight_id = $(this).find('p').attr('flight_id');
		
		//ou $(this).find('p').attr('price')
		//ou $('.seatsPopUp p').attr("flight_id",flight_id).attr("price");
		var price = $(this).find('p').attr('price');
		
		var firstClassFactor = $('#firstClassFactor').text();
		var executiveClassFactor = $('#executiveClassFactor').text();
		var economyClassFactor = $('#economyClassFactor').text();
		
		//BUG do jsp ou jquery - apesar de estar certo
		/*
		var category = $('.category').attr("flight_id",flight_id).text();
		var seat = $('.seat').attr("flight_id",flight_id).text();
		*/
		
		var category = $(this).prev().find('p.category').text().trim();
		var seat = $(this).prev().find('p.seat').text();
		
    	var w = window.open("http://localhost:8080/web/seats.jsp", "_blank", "scrollbars=1,resizable=1,height=520,width=600");
    	
    	w.price = price;
    	w.firstClassFactor = firstClassFactor;
    	w.executiveClassFactor = executiveClassFactor;
    	w.economyClassFactor = economyClassFactor;
    	
    	w.changeSeat = true;
    	w.seat = seat;
    	w.category = category;
    	w.flight_id = flight_id;
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
    	debugger;
    	var passenger_id = $(this).attr('passenger_id'); 
    	//var flight_id = $(this).attr('flight_id'); 
    	//var telephone = $('#telephone').attr('flight_id',flight_id).val();
    	var name = $(this).prev().prev().find('#name').val();
    	var telephone = $(this).prev().find('#telephone').val();
    	
    	if(name == "" || name == null || telephone == "" || telephone == null){
    		alert('Favor preencher todos os campos para atualização!');
    	}
    	
    	$.ajax({
        	type: "POST",
            url : "UpdatePassengerServlet",
            data : {
            	passenger_id : passenger_id,
            	telephone : telephone,
            	name : name
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


