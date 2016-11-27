/*------------------------------------------
 Search Route - Not used
 ------------------------------------------*/

$(document).ready(function () {
	var outboundRouteId;
    $(".outbound").on('click', function(){
    	$('#outboundRoutes').css("display","none");
    	$('#returnRoutes').css("display","block");
    	
    	$('#destinyCity').css("display","none");
    	$('#originCity').css("display","block");
    	
    	//$('#breadcrumbOutbound').css("display","none");
    	$('#breadcrumbOutbound').css("display","");
    	$('#breadcrumbOutbound').removeClass("active");
    	
    	$('#breadcrumbReturn').css("display","inline");
    	$('#breadcrumbReturn').addClass("active");
    	debugger;
    	outboundRouteId = $(this).attr('route_id');
    	
    	var id = '#'+outboundRouteId;
    	
    	var outboundRoute =  $("#outboundRoutes").find( id );
    	
    	$( "#selectedRoutes .routes" ).append( outboundRoute );
    	
    });
    
    $(".return").on('click', function(){
    	debugger;
        //pegar os voos selecionados
    	var returnRouteId = $(this).attr('route_id');
    	
    	var id = '#'+returnRouteId;
    	
    	var returnRoute =  $("#returnRoutes").find( id );
    	
    	$( "#selectedRoutes .routes" ).append( returnRoute );
    	
    	$('#returnRoutes').css("display","none");
    	
    	$('#breadcrumbReturn').css("display","");
    	$('#breadcrumbReturn').removeClass("active");
    	
    	$('#breadcrumbResume').css("display","inline");
    	$('#breadcrumbResume').addClass("active");
    	
    	$('#selectedRoutes').css("display","block");
    	
    	$('.outbound').css("display","none");
    	$('.return').css("display","none");
    	
    	$('#originCity').css("display","none");
    	$('#resume').css("display","block");
    	
    	$('.returnSeats').css("display","block");
    	$('.outboundSeats').css("display","block");
    	
    	$('.food').css("display","none");
    	$('.scale').css("display","none");
    	
    	$('.flightNumber').css("display","none");
    	$('.airplaneModel').css("display","none");
    	
    });
    
    $( function() {
        $( "#departureDate" ).datepicker({
          minDate: 1, 
          maxDate: "+1Y"
        });
      } );

    $('#departureDate').change(function(){
        $(this).attr('value', $('#departure').val());
    });
    
    $( function() {
        $( "#returnDate" ).datepicker({
        	minDate: 2, 
            maxDate: "+1Y +10D"
        });
      } );

    $('#returnDate').change(function(){
        $(this).attr('value', $('#return').val());
    });
    
    function HandlePopupResult(result) {
        alert("result of popup is: " + result);
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


