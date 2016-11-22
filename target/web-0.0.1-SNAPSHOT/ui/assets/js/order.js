/*------------------------------------------
 Search Route - Not used
 ------------------------------------------*/

$(document).ready(function () {
    
    $(".outbound").on('click', function(){
        
    	$('#outboundRoutes').css("display","none");
    	$('#returnRoutes').css("display","block");
    	
    	$('#destinyCity').css("display","none");
    	$('#originCity').css("display","block");
    	
    	var id = $(this).attr('id');
    	
    	//setar esse id como selecionado
    });
    
    $(".return").on('click', function(){
        //pegar os voos seleconados
    	var id = $(this).attr('id');
    	
    	//chamar ajax - tentar tratar com json
    	$.ajax({
        	type: "POST",
            url : "OrderServlet",
            data : {
            	email : email,
                password : password
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


