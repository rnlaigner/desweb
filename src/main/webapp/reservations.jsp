<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "airlinesystem.entity.Order" %>
<%@ page import = "airlinesystem.entity.Route" %>
<%@ page import = "airlinesystem.entity.Flight" %>
<%@ page import = "airlinesystem.enums.SeatCategory" %>
<%@ page language="java" %>
<%@ page session="true" %>
<% 
String email = (String) session.getAttribute("email");

// @SuppressWarnings("unchecked")
// List<Order> orders = (List<Order>) session.getAttribute("orders");

@SuppressWarnings("unchecked")
List<Flight> flights = (List<Flight>) session.getAttribute("flights");
%>
<!DOCTYPE html>
<!--[if IE 7 ]><html class="ie ie7 lte9 lte8 lte7" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="ie ie8 lte9 lte8" lang="en-US">	<![endif]-->
<!--[if IE 9]><html class="ie ie9 lte9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="noIE" lang="en-US">
<!--<![endif]-->
	<head>
	
	<style>
	</style>
	
	<!-- meta -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale = 1.0, maximum-scale=1.0, user-scalable=no"/>
	<title>Euro Travel</title>

	<link rel="stylesheet" href="ui/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="ui/assets/css/ionicons.min.css">
	<link rel="stylesheet" href="ui/assets/css/owl.carousel.css">
	<link rel="stylesheet" href="ui/assets/css/owl.theme.css">
    <link rel="stylesheet" href="ui/assets/css/main.css">
    <link rel="stylesheet" href="ui/assets/css/section.css">
    <link rel="stylesheet" href="ui/assets/css/about.css">
    <link rel="stylesheet" href="ui/assets/css/flights.css">
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="ui/assets/js/html5shiv.js"></script>
		<script src="ui/assets/js/respond.js"></script>
	<![endif]-->

	<!--[if IE 8]>
    	<script src="ui/assets/js/selectivizr.js"></script>
    <![endif]-->
</head>
<body>
<!-- Home -->
	<section class="header">
		
		<nav class="navbar navbar-default">
			<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html" title="HOME"><i class="ion-paper-airplane"></i> euro <span>travel</span></a>
				</div> <!-- /.navbar-header -->

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="home.jsp">Início</a></li>
					<!-- mudar o que eh exibido no link -->
					<li class="active"><a href="/web/SearchRouteServlet">Vôos</a></li>
					<li><a href="contact.jsp">Contato</a></li>
					<%if (email == null){ %>
					<li class="signed-out"><a href="contact.jsp">Cadastre-se</a></li>
					<li class="dropdown signed-out">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Login<strong class="caret"></strong></a>
						<ul class="dropdown-menu" style="padding: 15px; padding-bottom: 10px;">
							<li><input style="margin-bottom: 15px; color:black;" type="text" placeholder="Email" id="email" name="email"><li>
							<li><input style="margin-bottom: 15px; color:black;" type="password" placeholder="Senha" id="password" name="password"><li>
							<li><input style="float: left; margin-right: 10px;" type="checkbox" name="remember-me" id="remember-me" value="1"><li>
							<li><label style="color:#60c9eb; text-transform: none;" class="string optional" for="user_remember_me"> Lembre-se de mim</label><li>
							<li><input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Entrar"></li>
							<li id="messageDiv" style="display:none;"></li>
						</ul>
					</li>
					<li class="dropdown signed-in" style="display:none;" logged_in="false">
				        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Conta<strong class="caret"></strong></a>
				        <ul class="dropdown-menu" style="padding: 10px; padding-bottom: 10px;">
				          <li><a href="/web/UserReservationsServlet" style="margin-bottom: 1px; color:#60c9eb;">Reservas</a></li>
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Configurações</a></li>
				          <li><input style="margin-top: 5px;" class="btn btn-primary btn-block" type="submit" id="sign-out" value="Sair"></li>
				        </ul>
					</li>
					<%} else { %>
					<li class="signed-out" style="display:none;"><a href="contact.jsp">Cadastre-se</a></li>
					<li class="dropdown signed-out" style="display:none;">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Login<strong class="caret"></strong></a>
						<ul class="dropdown-menu" style="padding: 15px; padding-bottom: 10px;">
							<li><input style="margin-bottom: 15px; color:black;" type="text" placeholder="Email" id="email" name="email"><li>
							<li><input style="margin-bottom: 15px; color:black;" type="password" placeholder="Senha" id="password" name="password"><li>
							<li><input style="float: left; margin-right: 10px;" type="checkbox" name="remember-me" id="remember-me" value="1"><li>
							<li><label style="color:#60c9eb; text-transform: none;" class="string optional" for="user_remember_me"> Lembre-se de mim</label><li>
							<li><input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Entrar"></li>
							<li id="messageDiv" style="display:none;"></li>
						</ul>
					</li>
					<li class="dropdown signed-in" logged_in="true">
				        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Conta<strong class="caret"></strong></a>
				        <ul class="dropdown-menu" style="padding: 10px; padding-bottom: 10px;">
				          <li><a href="/web/UserReservationsServlet" style="margin-bottom: 1px; color:#60c9eb;">Reservas</a></li>
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Configurações</a></li>
				          <li><input style="margin-top: 5px;" class="btn btn-primary btn-block" type="submit" id="sign-out" value="Sair"></li>
				        </ul>
					</li>
					<%} %>
				</ul> <!-- /.nav -->
		    </div><!-- /.navbar-collapse -->
		  	</div><!-- /.container -->
		</nav>
	</section> <!-- /#header -->
	
	<!-- Section Background -->
	<section class="section-background">
		<div class="container">
			<h2 class="page-header" id="reservationsHeader" style="display:block;">
				Suas reservas
			</h2>
			<h2 class="page-header" id="originCity" style="display:none;">
				Something else
			</h2>
			<ol class="breadcrumb">
				<li><a href="home.jsp">Início</a></li>
				<li class="active" style="display:inline;">&nbsp;Reservas</li>
				
			</ol>
		</div> <!-- /.container -->
	</section> <!-- /.section-background -->
	
	<br>
	
	<!-- TODO exibir compras do usuario 
	     exibir no mesmo estilo da exibicao de rotas, porem com opcao de mudar assento e fazer checkin
	-->
	<div class="container" id="user_flights" style="display:block;">
    <ul class="list-group">
    <%  for(Flight flight : flights){
    	Route route = flight.getRoute();
    %>
    	<li flight_id="<%=flight.getId()%>">
	        <div class="panel panel-default">
	            <div class="panel-body" style="padding-bottom: 1px;">
	            
	            	 <div class="panel-info">
	                    <p><strong>Passageiro</strong></p>
	                	<p><%= flight.getPassenger().getName() %></p>
	                	<p><%= flight.getPassenger().getIdentificationNumber() %></p>
	                </div>
	            
	            
	                <div class="panel-info">
	                    <p><strong>Número do vôo</strong></p>
	                    <p class="flightNumber"><%=flight.getNumber()%></p>
	                </div>		
    		
    				<div class="panel-info">
	                    <p><strong>Origem </strong></p>
	                    <p><%=flight.getRoute().getOrigin().getName()%></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Destino </strong></p>
	                    <p><%=flight.getRoute().getDestiny().getName() %></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Horário de saída</strong></p>
	                    <p><%=flight.getRoute().getDepartureTime()  %></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Horário de chegada</strong></p>
	                    <p><%=flight.getRoute().getLandingTime() %></p>
	                </div>
	                
	                 <div class="panel-info">
	                    <p><strong>Assento</strong></p>
	                    <p class="category" flight_id='<%=flight.getId()%>'><%=flight.getSeat().getCategory().getValue() %></p>
	                    <p class="seat" flight_id='<%=flight.getId()%>'><%=flight.getSeat().getAirplaneSeat() %></p>
	                </div>
	                
	                <div class="panel-info seatsPopUp">
				   	 <a href='#' flight_id='<%=flight.getId()%>' title='Pop Up'>Mudar assento</a>
				   	 <p style="display:none; visibility: hidden;" flight_id='<%=flight.getId()%>' price=<%= route.getPrice()%>> </p>
				    </div>
	                
	                <!-- check para verificar se ja foi feito o checkin -->
	                <%if (flight.getCheckinDate() == null) {%>
	                <div class="btn btn-default border-radius custom-button checkin" 
	                  flight_id="<%=flight.getId()%>"
	                  style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
						Checkin
				    </div>
				    <%} else {	%>
				    <div class="btn btn-default border-radius custom-button boardingPass" 
	                  flight_id="<%=flight.getId()%>"
	                  style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
						Cartão
				    </div>
				    <%} %>
	            </div>
	         </div>
	     </li>
	     
	     <%if (flight.getPassenger().getTelephone() == null){ %>
		 <li>
			<p class="col-form-label"></p>
			<div class="form-group row">
			  <label for="example-text-input" class="col-xs-2 col-form-label">Telefone</label>
			  <div class="col-xs-8">
			    <input class="form-control name" type="text" value="" flight_id="<%=flight.getId()%>" id="telephone">
			  </div>
			</div>
			
			<div class="btn btn-default border-radius custom-button updatePassenger" 
				passenger_id="<%=flight.getPassenger().getId()%>"
				flight_id="<%=flight.getId()%>"
	         	style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
			 	Atualizar
			</div>
		 </li>
		<%}%>
	     
	<%}%>
	</ul>
	</div>
	
	<div class="info" style="display:none; visibility: hidden;">
		<div id="firstClassFactor"><%=SeatCategory.FIRST_CLASS.getFactor()%></div>
		<div id="executiveClassFactor"><%=SeatCategory.EXECUTIVE.getFactor()%></div>
		<div id="economyClassFactor"><%=SeatCategory.ECONOMY.getFactor()%></div>
	</div>

	<div class="section-wrapper sponsor">
		<div class="container">
			<div class="owl-carousel sponsor-carousel">
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-1.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-2.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-3.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-4.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-5.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-6.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-1.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-2.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-3.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-4.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-5.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-6.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-1.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-2.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-3.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-4.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-5.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
				<div class="item">
					<a href="#">
						<img src="ui/assets/images/sp-6.png" alt="sponsor-brand" class="img-responsive sponsor-item">
					</a>
				</div>
			</div> <!-- /.owl-carousel -->
		</div> <!-- /.container -->
	</div> <!-- /.sponsor -->

	<div class="subscribe section-wrapper">
		<a class="brand-logo" href="index.html" title="HOME"><i class="ion-paper-airplane"></i> Euro <span>Travel</span></a>
		<p class="subscribe-now">
			Subscribe to our Newsletter
		</p>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
					<div class="input-group">
						<input type="email" class="form-control border-radius" placeholder="Email address">
						<span class="input-group-btn">
							<button class="btn btn-default border-radius custom-sub-btn" type="button">DONE</button>
						</span>
					</div><!-- /input-group -->
				</div>
			</div>
		</div>
	
		<ul class="social-icon">
			<li><a href="#"><i class="ion-social-twitter"></i></a></li>
			<li><a href="#"><i class="ion-social-facebook"></i></a></li>
			<li><a href="#"><i class="ion-social-linkedin-outline"></i></a></li>
			<li><a href="#"><i class="ion-social-googleplus"></i></a></li>
		</ul>
	</div> <!-- /.subscribe -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-xs-4">
					<div class="text-left">
						&copy; Copyright Euro Travels
					</div>
				</div>
				<div class="col-xs-4">
					Theme by <a href="http://www.themewagon.com">THEMEWAGON</a>
				</div>
				<div class="col-xs-4">
					<!-- <div class="top">
						<a href="#header">
							<i class="ion-arrow-up-b"></i>
						</a>
					</div> -->
				</div>
			</div>
		</div>		
	</footer>

	<script src="ui/assets/js/jquery-1.11.2.min.js"></script>
    <script src="ui/assets/js/bootstrap.min.js"></script>
    <script src="ui/assets/js/owl.carousel.min.js"></script>
	<script src="ui/assets/js/script.js"></script>
	<script src="ui/assets/js/reservation.js?1010"></script>
	
	<!--  -->
	<script src="ui/assets/js/login.js?1002"></script>
	
	<script type="text/javascript">
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
	</script>
	
</body>
</html>