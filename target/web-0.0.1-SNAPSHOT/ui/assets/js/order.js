/*------------------------------------------
 Search Route - Not used
 ------------------------------------------*/

$(document).ready(function () {

	var firstClassFactor = $('#firstClassFactor').text();
	var executiveClassFactor = $('#executiveClassFactor').text();
	var economyClassFactor = $('#economyClassFactor').text();
	
	var adults = $('#adults').text();
	var children = $('#children').text();
	var babies = $('#babies').text();
	
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
    	
    	var outboundRouteId = $(this).attr('route_id');
    	
    	var id = '#'+outboundRouteId;
    	
    	var outboundRoute =  $("#outboundRoutes").find( id );
    	
    	//<a href='#' onclick='openSeatsPopUp()' title='Pop Up'>Pop Up</a>
    	
    	$( "#selectedRoutes .routes" ).append( outboundRoute );
    	
    	//$( "#selectedRoutes .routes" ).find(id).append("<a href='#' id='outboundSeatsPopUp' title='Pop Up'>Pop Up</a>");
    	
    	//this strategy does not work. insert this element at jsp. maintain hidden until resume
    	//$("<a href='#' id='outSeatsPopUp' title='Pop Up'>Pop Up</a>").insertAfter( "#selectedRoutes .routes .outbound" );
    });
    
    $(".return").on('click', function(){
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
    	
    	$('.proceed').css("display","block");
    	
    	$('#originCity').css("display","none");
    	$('#resume').css("display","block");
    	
    	$('.returnSeats').css("display","block");
    	$('.outboundSeats').css("display","block");
    	
    	//$('.food').css("display","none");
    	//$('.scale').css("display","none");
    	
    	//$('.flightNumber').css("display","none");
    	//$('.airplaneModel').css("display","none");
    	
    	$('.seatsPopUp').css("display","block");
    });
    
    $(".proceed").on('click', function(){
    	
    	//se nao ha seats selecionados, retorna
    	if ( $( "#outboundTotal" ).length != 1 ) {
    		 
    	    alert("Escolha os assentos do voo de ida");
    	    return;    	 
    	}
    	if ( $( "#returnTotal" ).length != 1 ) {
   		 
    	    alert("Escolha os assentos do voo de volta");
    	    return;    	 
    	}
    	
    	$('#selectedRoutes').css("display","none");
    	
    	$('#passengerForm').css("display","block");
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
    
    $(document).on('click', '#returnSeatsPopUp', function(event){
    	var price = $("#selectedRoutes .returnPrice").attr('price');
    	
    	var w = window.open("http://localhost:8080/web/seats.jsp", "_blank", "scrollbars=1,resizable=1,height=520,width=600");
    	
    	w.price = price;
    	w.firstClassFactor = firstClassFactor;
    	w.executiveClassFactor = executiveClassFactor;
    	w.economyClassFactor = economyClassFactor;
    	
    	w.adults = adults;
    	w.children = children;
    	w.babies = babies;
    	
    	var name = 'returnTotal';
    	w.elementName = name;
    });
    
    $(document).on('click', '#outboundSeatsPopUp', function(event){
    	var price = $("#selectedRoutes .outboundPrice").attr('price');
    	
    	var w = window.open("http://localhost:8080/web/seats.jsp", "_blank", "scrollbars=1,resizable=1,height=520,width=600");
    	
    	w.price = price;
    	w.firstClassFactor = firstClassFactor;
    	w.executiveClassFactor = executiveClassFactor;
    	w.economyClassFactor = economyClassFactor;
    	
    	w.adults = adults;
    	w.children = children;
    	w.babies = babies;
    	
    	var name = 'outboundTotal';
    	w.elementName = name;
    });
    
    function setClassAndRoutePrice(firstClassFactor,executiveClassFactor,economyClassFactor,price,window)
    {
    	window.price = price;
    	window.firstClassFactor = firstClassFactor;
    	window.executiveClassFactor = executiveClassFactor;
    	window.economyClassFactor = economyClassFactor;
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


