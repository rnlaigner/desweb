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
    	
    	$('#breadcrumbPassenger').css("display","inline");
    	$('#breadcrumbPassenger').addClass("active");
    	
    	$(this).css("display","none");
    	
    	$(".finish").css("display","block");
    });
    
    $(".finish").on('click', function(e){
    	debugger;
    	
    	e.preventDefault();
    	
    	//TODO Fazer validacao dos campos
    	
//    	PARA CADA ROTA:
//    	id da rota botao de comprar
    	var routeIds = [];
    	$('#selectedRoutes li [route_id]').each(function(i)
		{
    		routeIds.push($(this).attr('route_id'));
		});
    	
//    	data da viagem
    	var outboundDate = $('#selectedRoutes .outboundDate').html();
    	var returnDate = $('#selectedRoutes .returnDate').html();
    	
//    	assentos escolhidos TODO FIXME
    	var outboundSeats = $('#selectedRoutes #outboundTotal').attr('seats');
    	var returnSeats = $('#selectedRoutes #returnTotal').attr('seats')
    	
//    	valor final da passagem
    	var outboundTotal = $('#selectedRoutes #outboundTotal').attr('total');
    	var returnTotal = $('#selectedRoutes #returnTotal').attr('total')
    	
//    	dados dos passageiros - array de json
    	var arrayName = [];
    	$('.name').each(function(i) { 
    		arrayName.push($(this).val()); 
    	});
    	
    	var arrayNationality = [];
    	$('.nationality').each(function(i) { 
    		arrayNationality.push($(this).val()); 
    	});
    	
    	var arrayIdentity = [];
    	$('.identity').each(function(i) { 
    		arrayIdentity.push($(this).val()); 
    	});
    	
//    	dados do cartao
    	
    	$.ajax({
        	type: "POST",
            url : "OrderServlet",
            data : {
            	routeIds : routeIds,
            	outboundDate : outboundDate,
            	returnDate : returnDate,
            	outboundSeats : outboundSeats,
            	returnSeats : returnSeats,
            	outboundTotal : outboundTotal,
            	returnTotal : returnTotal,
            	arrayName : arrayName,
            	arrayNationality : arrayNationality,
            	arrayIdentity : arrayIdentity
            },
            success : function(results){
                if(results != null && results != ""){
                    
                }else{
                    
                }
            }
        });
    	
    	
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


