/*------------------------------------------
 Login
 ------------------------------------------*/

$(document).ready(function () {
    
    $("#sign-in").on('click', function(){
        var email = $("#email").val();
        var password = $("#password").val();
        if(email == ""){
            $('#messageDiv').css("display","none");
            alert("Email is required");
            return;
        }
        if(password == ""){
            $('#messageDiv').css("display","none");
            alert("Password is required");
            return;
        }
        $.ajax({
        	type: "POST",
            url : "LoginServlet",
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
    
    //avoid dropdown-menu to deactivate when clicking on elements inside it
    $(document).on('click', '.dropdown-menu', function (e) {
    	  e.stopPropagation();
    });
     
    //function to display message to the user
    function processLoginResult(results){
    	
        if(results == 'SUCCESS'){
            //$('#messageDiv').html("<font color='green'>You are successfully logged in. </font>");
        	$('.signed-out').css("display","none");
        	$('.signed-in').css("display","block");
        	$(".signed-in").attr("logged_in","true");
        	
        	$('#messageDiv').css("display","none");
            $('#messageDiv').html("");
        }else 
    	if(results == 'FAILURE'){
            $('#messageDiv').html("<font color='red'>Username or password incorrect </font>");
            $('#messageDiv').css("display","block");
            $(".signed-in").attr("logged_in","false");
        }
    };

	$("#sign-out").on('click', function(){
		$.ajax({
        	type: "GET",
            url : "LogoutServlet",
            success : function(results){
                if(results != null && results != ""){
                    processLogoutResult(results);
                }else{
                    $('#messageDiv').css("display","none");
                    $('#messageDiv').html("");
                    alert("Some exception occurred! Please try again.");
                }
            }
        });
	});
	
	function processLogoutResult(results){
        if(results == 'SUCCESS'){
        	$('.signed-out').css("display","block");
        	$('.signed-in').css("display","none");
        	$("#email").val('');
            $("#password").val('');
        	$('#messageDiv').html("");
        	$('#messageDiv').html("<font color='green'>You successfully logged out. </font>");
        	$('#messageDiv').css("display","block");
        } 
        else if(results == 'FAILURE'){
            $('#messageDiv').html("<font color='red'>Logout incorrect. Please try again. </font>");
            $('#messageDiv').css("display","block");
        }
    };
    
});


