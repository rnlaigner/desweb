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
    	debugger;
    	outboundRouteId = $(this).attr('active','active');
    	
    	//$('#'+id+'').attr('active','active');
    	
    	//setar esse id como selecionado
    });
    
    $(".return").on('click', function(){
    	debugger;
        //pegar os voos selecionados
    	var returnRouteId = $(this).attr('id');
    	
    	var returnFlight = $(id);
    	
    	//chamar ajax - tentar tratar com json
    	$.ajax({
        	type: "POST",
            url : "OrderServlet",
            data : {
            	returnRouteId : returnRouteId,
            	outboundRouteId : outboundRouteId
            },
            success : function(results){
                if(results != null && results != ""){
                    processLoginResult(results);
                    //$('#messageDiv').css("display","block");
                }else{
                    $('#messageDiv').css("display","none");
                    $('#messageDiv').html("");
                    alert("Some exception occurred! Please try again.");
                }
            }
        });
    });
    
});


