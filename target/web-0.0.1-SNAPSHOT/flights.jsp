<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "airlinesystem.utils.Util"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "airlinesystem.entity.Route" %>
<%@ page import = "airlinesystem.enums.SeatCategory" %>
<%@ page language="java" %>
<%@ page session="true" %>
<% 
@SuppressWarnings("unchecked")
List<Route> outboundRoutes = (List<Route>) session.getAttribute("outboundRoutes"); 

@SuppressWarnings("unchecked") 
List<Route> returnRoutes = (List<Route>) session.getAttribute("returnRoutes"); 

String destinyCity = (String) session.getAttribute("destiny");
String originCity = (String) session.getAttribute("origin");
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
		.category {
			color: black;
		}
	
		.list-group li {
    		list-style: none;
		}
		.panel-info, .panel-rating, .panel-more1 {
		    float: left;
		    margin: 0 10px;
		}
		button.custom-btn
		{
			border-color:#337ab7;
			padding: 9px;
		}	
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
						<li class="active"><a href="flights.jsp">Vôos</a></li>
						<li><a href="services.html">services</a></li>
						<li><a href="contact.html">contact</a></li>
					</ul> <!-- /.nav -->
			    </div><!-- /.navbar-collapse -->
		  	</div><!-- /.container -->
		</nav>
	</section> <!-- /#header -->
	<!-- Section Background -->
	<section class="section-background">
		<div class="container">
			<h2 class="page-header" id="destinyCity" style="display:block;">
				<%if (destinyCity != null){ %>
				Escolha seu vôo para <%= destinyCity %>
				<%} else{ %>
				Escolha seu vôo de ida 
				<%} %>
			</h2>
			<h2 class="page-header" id="originCity" style="display:none;">
				<%if (originCity != null){ %>
				Escolha seu vôo para <%= originCity %>
				<%} else{ %>
				Escolha seu vôo de volta 
				<%} %>
			</h2>
			<ol class="breadcrumb">
				<li><a href="home.jsp">Início</a></li>
				<li><a href="flights.jsp">Vôos</a></li>
				<li class="active" id="breadcrumbOutbound">&nbsp;Vôos de Ida</li>
				<li style="display:none;" id="breadcrumbReturn">Vôos de Volta</li>
			</ol>
		</div> <!-- /.container -->
	</section> <!-- /.section-background -->
	
	<br>
	
	<div class="container" id="outboundRoutes" style="display:block;">
    <ul class="list-group">
    <%  for(Route route : outboundRoutes){%>
    	<li>
	        <div class="panel panel-default">
	            <div class="panel-body" style="padding-bottom: 1px;">
	                <div class="panel-info">
	                    <p><strong>Ida</strong></p>
	                    <p><%= Util.dateToStr(route.getDepartureTime())	%></p>
	                </div>		
    		
    				<div class="panel-info">
	                    <p><strong><%= route.getOrigin().getName()	%></strong></p>
	                    <p><%= route.getOrigin().getCity()	%></p>
	                    <p><%   @SuppressWarnings( "deprecation" )
	                    		String departureHour = String.valueOf(route.getDepartureTime().getHours());
	                    		@SuppressWarnings( "deprecation" )
	                    		String departureMinute = String.valueOf(route.getDepartureTime().getMinutes());
	                    		StringBuilder sb = new StringBuilder(departureHour);
	                    		sb.append(":").append(departureMinute);
	                    		out.print(sb.toString());
	                    	%></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong><%= route.getDestiny().getName()	%></strong></p>
	                    <p><%= route.getDestiny().getCity()	%></p>
	                    <p><%   @SuppressWarnings( "deprecation" )
	                    		String landingHour = String.valueOf(route.getLandingTime().getHours());
		                		@SuppressWarnings( "deprecation" )
		                		String landingMinute = String.valueOf(route.getLandingTime().getMinutes());
	                    		sb = new StringBuilder(landingHour);
	                    		sb.append(":").append(landingMinute);
	                    		out.print(sb.toString());
	                    	%></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Duração</strong></p>
	                    <p><% 
	                    	long mili1 = route.getDepartureTime().getTime();
	                    	long mili2 = route.getLandingTime().getTime();
	                    	long mili = mili2 - mili1;
	                    	String miliStr = Util.milisecondsToDate(mili);  
	                    	out.print(miliStr);
	                    %></p>
	                </div>
	                
	                <div class="panel-info">
	                    <ul class="list-group">
						  <li class="list-group-item">
						    <span class="tag tag-default tag-pill float-xs-right"><%= route.getPrice() * SeatCategory.ECONOMY.getFactor() %></span>
						    Tarifa Cheia
						  </li>
						  <li class="list-group-item">
						    <span class="tag tag-default tag-pill float-xs-right"><%= route.getPrice() * SeatCategory.EXECUTIVE.getFactor() %></span>
						    Executiva
						  </li>
						  <li class="list-group-item">
						    <span class="tag tag-default tag-pill float-xs-right"><%= route.getPrice() * SeatCategory.FIRST_CLASS.getFactor() %></span>
						    Primeira Classe
						  </li>
						</ul>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Número do vôo</strong></p>
	                    <p><%= route.getRouteId() %></p>
	                    <p><%= route.getAirplane().getModel() %></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Preço por adulto</strong></p>
	                    <p>R$ <%= route.getPrice() %></p>
	                </div>
	                
	                 <div class="panel-info">
	                    <p><strong>Refeição</strong></p>
	                    <p>Não</p>
	                </div>
	                
	                <div class="btn btn-default border-radius custom-button outbound" 
	                id="<%= route.getRouteId() %>"
	                style="width: 10em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
						Comprar
				   </div>
	            </div>
	         </div>
	     </li>
<%		 }	%>
	</ul>
	</div>
	
	<div class="container" id="returnRoutes" style="display:none;">
    <ul class="list-group">
    
    	<% for(Route route : returnRoutes){%>
    	<li>
	        <div class="panel panel-default">
	            <div class="panel-body" style="padding-bottom: 1px;">
	                <div class="panel-info">
	                    <p><strong>Retorno</strong></p>
	                    <p><%= Util.dateToStr(route.getDepartureTime())	%></p>
	                </div>		
    		
    				<div class="panel-info">
	                    <p><strong><%= route.getOrigin().getName()	%></strong></p>
	                    <p><%= route.getOrigin().getCity()	%></p>
	                    <p><%   @SuppressWarnings( "deprecation" )
		                		String departureHour = String.valueOf(route.getDepartureTime().getHours());
		                		@SuppressWarnings( "deprecation" )
		                		String departureMinute = String.valueOf(route.getDepartureTime().getMinutes());
		                		StringBuilder sb = new StringBuilder(departureHour);
		                		sb.append(":").append(departureMinute);
		                		out.print(sb.toString());
	                    	%></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong><%= route.getDestiny().getName()	%></strong></p>
	                    <p><%= route.getDestiny().getCity()	%></p>
	                    <p><%   @SuppressWarnings( "deprecation" )
		                		String landingHour = String.valueOf(route.getLandingTime().getHours());
		                		@SuppressWarnings( "deprecation" )
		                		String landingMinute = String.valueOf(route.getLandingTime().getMinutes());
		                		sb = new StringBuilder(landingHour);
		                		sb.append(":").append(landingMinute);
		                		out.print(sb.toString());
	                    	%></p>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Duração</strong></p>
	                    <p><% 
	                    	long mili1 = route.getDepartureTime().getTime();
	                    	long mili2 = route.getLandingTime().getTime();
	                    	long mili = mili2 - mili1;
	                    	String miliStr = Util.milisecondsToDate(mili);  
	                    	out.print(miliStr);
	                    %></p>
	                </div>
	                
	                <div class="panel-info">
	                    <ul class="list-group">
						  <li class="list-group-item category">
						    <span class="tag tag-default tag-pill float-xs-right"><%= route.getPrice() * SeatCategory.ECONOMY.getFactor() %></span>
						    Tarifa Cheia
						  </li>
						  <li class="list-group-item">
						    <span class="tag tag-default tag-pill float-xs-right"><%= route.getPrice() * SeatCategory.EXECUTIVE.getFactor() %></span>
						    Executiva
						  </li>
						  <li class="list-group-item">
						    <span class="tag tag-default tag-pill float-xs-right"><%= route.getPrice() * SeatCategory.FIRST_CLASS.getFactor() %></span>
						    Primeira Classe
						  </li>
						</ul>
	                </div>
	                
	                <div class="panel-info">
	                    <p><strong>Preço por adulto</strong></p>
	                    <p><%= route.getPrice() %></p>
	                </div>
	                
	                 <div class="panel-info">
	                    <p><strong>Refeição</strong></p>
	                    <p>Não</p>
	                </div>
	                
	                <div class="btn btn-default border-radius custom-button return" 
	                id="<%= route.getRouteId() %>"
	                style="width: 10em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
						Comprar
				   </div>
	            </div>
	         </div>
	     </li>
<%		}%>
	</ul>
	</div>
	
	<section id="bookSection" class="tour section-wrapper container">
		<h2 class="section-title">
			Não gostou das opções? Refaça sua pesquisa!
		</h2>
		<br>
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" placeholder="Origem"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>

			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" placeholder="Destino"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>

			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" id="datepicker1" placeholder="Data de Saída"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" id="datepicker2" placeholder="Data de Retorno"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
				<form role="form" class="form-dropdown">
					<div class="form-group">
						<label for="sel1">Adultos</label>
						<select class="form-control border-radius" id="sel1">
							<option value="" disabled selected>Adultos</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
				</form>
			</div>
			
			<div class="col-md-3 col-sm-6">
				<form role="form" class="form-dropdown">
					<div class="form-group">
						<label for="sel2">Crianças</label>
						<select class="form-control border-radius" id="sel2">
							<option value="" disabled selected>Crianças</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
				</form>
			</div>
			
			<div class="col-md-3 col-sm-6">
				<form role="form" class="form-dropdown">
					<div class="form-group">
						<label for="sel3">Bebês</label>
						<select class="form-control border-radius" id="sel4">
							<option value="" disabled selected>Bebês</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
				</form>
			</div>
			
			<div class="col-md-3 col-sm-6">
				<form role="form" class="form-dropdown">
					<div class="form-group">
						<label for="sel4">Classe</label>
						<select class="form-control border-radius" id="sel3">
							<option value="" disabled selected>Classe</option>
							<option value="1">Tarifa Cheia</option>
							<option value="2">Executiva</option>
							<option value="3">Primeira Classe</option>
						</select>
					</div>
				</form>
			</div>
		</div>	
		
		<div class="btn btn-default border-radius custom-button center-block" id="search" style="width: 20em; height: 3em;">
			Procurar
		</div>
		
	</section> 

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
	<script src="ui/assets/js/order.js"></script>
	
</body>
</html>