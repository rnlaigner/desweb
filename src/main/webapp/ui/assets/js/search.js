/*------------------------------------------
 Homepage
 ------------------------------------------*/

$(document).ready(function () {
    
    $("#search").on('click', function(){
        var origin = $("#origin").val();
        var destiny = $("#destiny").val();
        var departureDate = $("#departure").attr('value');
        var returnDate = $("#return").attr('value');
        var adult = $("#adult").val();
        var children = $("#children").val();
        var baby = $("#baby").val();
        var seat = $("#seat").val();
        if(seat == "" || seat == null){
            alert("A classe do vôo é necessária");
            return;
        }
        $.ajax({
        	type: "GET",
            url : "SearchRouteServlet",
            data : {
            	origin : origin,
            	destiny : destiny,
            	departureDate : departureDate,
            	returnDate : returnDate,
            	adult : adult,
            	children : children,
            	baby : baby,
            	seat : seat
            },
            success : function(data){
            	window.location = data.redirectURL;
            }
        });
    });
    
});


