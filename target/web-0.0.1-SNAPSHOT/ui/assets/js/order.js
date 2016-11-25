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
    	
    	outboundRouteId = $(this).attr('id');
    	
    	var id = '#'+outboundRouteId;
    	
    	var outboundRoute =  $("#outboundRoutes").find( id );
    	
    	$( "#selectedRoutes routes" ).append( outboundRoute );
    	
    });
    
    $(".return").on('click', function(){
    	
        //pegar os voos selecionados
    	var returnRouteId = $(this).attr('id');
    	
    	var id = '#'+returnRouteId;
    	
    	var returnRoute =  $("#returnRoutes").find( id );
    	
    	$( "#selectedRoutes .routes" ).append( returnRoute );
    	
    	$('#returnRoutes').css("display","none");
    	
    	$('#breadcrumbReturn').css("display","");
    	$('#breadcrumbReturn').removeClass("active");
    	
    	$('#breadcrumbResume').css("display","inline");
    	$('#breadcrumbResume').addClass("active");
    	
    	$('#selectedRoutes').css("display","block");
    });
    
});


