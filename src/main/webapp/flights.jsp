<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "airlinesystem.utils.Util"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "airlinesystem.entity.Route" %>
<%@ page import = "airlinesystem.enums.SeatCategory" %>
<%@ page import = "airlinesystem.entity.Seat" %>
<%@ page import = "java.util.Random;" %>
<%@ page language="java" %>
<%@ page session="true" %>
<% 
@SuppressWarnings("unchecked")
List<Route> outboundRoutes = (List<Route>) session.getAttribute("outboundRoutes"); 

@SuppressWarnings("unchecked") 
List<Route> returnRoutes = (List<Route>) session.getAttribute("returnRoutes"); 

String destinyCity = (String) session.getAttribute("destiny");
String originCity = (String) session.getAttribute("origin");

Random randomGenerator = new Random();
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
		.panel-info, .panel-rating, .panel-more1 {
		    float: left;
		    margin: 0 10px;
		}
		button.custom-btn
		{
			border-color:#337ab7;
			padding: 9px;
		}	
		
		a.selected {
		  background-color:#1F75CC;
		  color:white;
		  z-index:100;
		}
		
		.messagepop {
		  background-color:#FFFFFF;
		  border:1px solid #999999;
		  cursor:default;
		  display:none;
		  margin-top: 15px;
		  position:absolute;
		  text-align:left;
		  width:394px;
		  z-index:50;
		  padding: 25px 25px 20px;
		}
		
		label.lblpop {
		  display: block;
		  margin-bottom: 3px;
		  padding-left: 15px;
		  text-indent: -15px;
		}
		
		.messagepop p, .messagepop.div {
		  border-bottom: 1px solid #EFEFEF;
		  margin: 8px 0;
		  padding-bottom: 8px;
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
						<li><a href="home.jsp">In�cio</a></li>
						<li class="active"><a href="flights.jsp">V�os</a></li>
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
				Escolha seu v�o para <%= destinyCity %>
				<%} else{ %>
				Escolha seu v�o de ida 
				<%} %>
			</h2>
			<h2 class="page-header" id="originCity" style="display:none;">
				<%if (originCity != null){ %>
				Escolha seu v�o para <%= originCity %>
				<%} else{ %>
				Escolha seu v�o de volta 
				<%} %>
			</h2>
			<h2 class="page-header" id="resume" style="display:none;">
				Resumo de suas escolhas
			</h2>
			<ol class="breadcrumb">
				<li><a href="home.jsp">In�cio</a></li>
				<li><a href="flights.jsp">V�os</a></li>
				<li class="active" style="display:inline;" id="breadcrumbOutbound">&nbsp;V�os de Ida</li>
				<li style="display:none;" id="breadcrumbReturn">&nbsp;V�os de Volta</li>
				<li style="display:none;" id="breadcrumbResume">&nbsp;Resumo</li>
			</ol>
		</div> <!-- /.container -->
	</section> <!-- /.section-background -->
	
	<br>
	
	<div class="container" id="outboundRoutes" style="display:block;">
    <ul class="list-group">
    <%  for(Route route : outboundRoutes){%>
    	<li id="<%= route.getId() %>">
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
	                    <p><strong>Dura��o</strong></p>
	                    <p><% 
	                    	long mili1 = route.getDepartureTime().getTime();
	                    	long mili2 = route.getLandingTime().getTime();
	                    	long mili = mili2 - mili1;
	                    	String miliStr = Util.milisecondsToDate(mili);  
	                    	out.print(miliStr);
	                    %></p>
	                </div>
	                
	                <div class="panel-info">
	                	<p><strong>Pre�o por adulto</strong></p>
	                    <ul class="list-group">
						  <li class="list-group-item" style="padding: 4px 15px; color:#969595;">
						    Tarifa Cheia
						    <span class="tag tag-default tag-pill float-xs-right">R$ <%= route.getPrice() * SeatCategory.ECONOMY.getFactor() %></span>
						  </li>
						  <li class="list-group-item" style="padding: 5px 15px; color:#969595;">
						    Executiva
						    <span class="tag tag-default tag-pill float-xs-right">R$ <%= route.getPrice() * SeatCategory.EXECUTIVE.getFactor() %></span>
						  </li>
						  <li class="list-group-item" style="padding: 5px 15px; color:#969595;">
						  	Primeira Classe
						    <span class="tag tag-default tag-pill float-xs-right">R$ <%= route.getPrice() * SeatCategory.FIRST_CLASS.getFactor() %></span>
						  </li>
						</ul>
	                </div>
	                
	                 <div class="panel-info flightNumber">
	                    <p><strong>N�mero do v�o</strong></p>
	                    <p><%= route.getId() %></p>
	                </div>
	                
	                <div class="panel-info airplaneModel">
	                    <p><strong>Aeronave</strong></p>
	                	<p><%= route.getAirplane().getModel() %></p>
	                </div>
	                
	                 <div class="panel-info food">
	                    <p><strong>Refei��o</strong></p>
	                    <p>N�o</p>
	                </div>
	                
	                
                	<div class="col-md-3 col-sm-6 outboundSeats" style="display:none;">
                		<p><strong>Selecione seu assento</strong></p>
						<div class="form-group">
							<select class="form-control border-radius" id="seatOutbound" name="seatOutbound">
								<%for (Seat seat : route.getAirplane().getSeats()){%>
								<option value="<%= seat.getAirplaneSeat() %>" seat_category="<%= seat.getCategory().getName() %>" ><%= seat.getAirplaneSeat() + " - " + seat.getCategory().getName()%></option>
								<%} %>
							</select>
						</div>
					</div>
					
					<!-- TODO taxa de embarque -->
	                
	                
	                <div class="panel-info scale">
	                    <p><strong>Escala</strong></p>
	                    <p>N�o</p>
	                </div>
	                
	                <div class="btn btn-default border-radius custom-button outbound" 
	                 id="<%= randomGenerator.nextInt() %>" route_id="<%= route.getId() %>"
	                style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
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
    	<li id="<%= route.getId() %>">
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
	                    <p><strong>Dura��o</strong></p>
	                    <p><% 
	                    	long mili1 = route.getDepartureTime().getTime();
	                    	long mili2 = route.getLandingTime().getTime();
	                    	long mili = mili2 - mili1;
	                    	String miliStr = Util.milisecondsToDate(mili);  
	                    	out.print(miliStr);
	                    %></p>
	                </div>
	                
	                <div class="panel-info">
	                	<p><strong>Pre�o por adulto</strong></p>
	                    <ul class="list-group">
						  <li class="list-group-item" style="padding: 4px 15px; color:#969595;">
						    Tarifa Cheia
						    <span class="tag tag-default tag-pill float-xs-right">R$ <%= route.getPrice() * SeatCategory.ECONOMY.getFactor() %></span>
						  </li>
						  <li class="list-group-item" style="padding: 5px 15px; color:#969595;">
						    Executiva
						    <span class="tag tag-default tag-pill float-xs-right">R$ <%= route.getPrice() * SeatCategory.EXECUTIVE.getFactor() %></span>
						  </li>
						  <li class="list-group-item" style="padding: 5px 15px; color:#969595;">
						  	Primeira Classe
						    <span class="tag tag-default tag-pill float-xs-right">R$ <%= route.getPrice() * SeatCategory.FIRST_CLASS.getFactor() %></span>
						  </li>
						</ul>
	                </div>
	                
	                <div class="panel-info flightNumber">
	                    <p><strong>N�mero do v�o</strong></p>
	                    <p><%= route.getId() %></p>
	                </div>
	                
	                <div class="panel-info airplaneModel">
	                    <p><strong>Aeronave</strong></p>
	                	<p><%= route.getAirplane().getModel() %></p>
	                </div>
	                
	                 <div class="panel-info food">
	                    <p><strong>Refei��o</strong></p>
	                    <p>N�o</p>
	                </div>
	                
	                <div class="col-md-3 col-sm-6 returnSeats" style="display:none;">
	               		<p><strong>Selecione seu assento</strong></p>
						<div class="form-group">
							<select class="form-control border-radius" id="seatOutbound" name="seatOutbound">
								<%for (Seat seat : route.getAirplane().getSeats()){%>
								<option value="<%= seat.getAirplaneSeat() %>" seat_category="<%= seat.getCategory().getName() %>"><%= seat.getAirplaneSeat() + " - " + seat.getCategory().getName()%></option>
								<%} %>
							</select>
						</div>
					</div>
	                
	                <div class="panel-info scale">
	                    <p><strong>Escala</strong></p>
	                    <p>N�o</p>
	                </div>
	                
	                <div class="btn btn-default border-radius custom-button return" 
	                id="<%= randomGenerator.nextInt() %>" route_id="<%= route.getId() %>"
	                style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
						Comprar
				   </div>
	            </div>
	         </div>
	     </li>
<%		}%>
	</ul>
	</div>
	
	<p name='p_name'> Paragrafo de teste  </p>
	
	<a href='#' onclick='javascript:window.open("http://localhost:8080/web/seats.jsp", "_blank", "scrollbars=1,resizable=1,height=500,width=600");' title='Pop Up'>Pop Up</a>
	
	<div class="messagepop pop">
	    <form method="post" id="new_message" action="/messages">
	        <p><label class="lblpop" for="email">Your email or name</label><input type="text" size="30" name="email" id="email" /></p>
	        <p><label class="lblpop" for="body">Message</label><textarea rows="6" name="body" id="body" cols="35"></textarea></p>
	        <p><input type="submit" value="Send Message" name="commit" id="message_submit"/> or <a class="close" href="/">Cancel</a></p>
	    </form>
	</div>

	<a href="/contact" id="contact">Contact Us</a>
	
	<!-- rotas escolhidas sao colocadas aqui TODO tirar botao comprar -->
	<div class="container" id="selectedRoutes" style="display:none;">
		<ul class="list-group routes">
		</ul>
	</div>
	
	<!-- DIV PARA: Ao final das escolhas, 
		o sistema mostra o pre�o de cada perna, os pre�os das taxas de embarque (espec�fica por aeroporto e 
		somada com as escalas caso existam)  e o total a ser pago pelo bilhete.  Nesta etapa, deve ser dada ao 
		usu�rio  a op��o de escolher o assento; alguns assentos podem ter pre�os diferenciados e isto deve ser 
		refletido no total a ser pago. -->
	<div class="container" id="orderResume" style="display:none;">
		<ul class="list-group routes">
		</ul>
	</div>

	<jsp:include page="search.jsp">
		<jsp:param name="cor" value="azul" />
	</jsp:include>

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
	<script src="ui/assets/js/order.js?1600"></script>
	
	<!-- Date Picker -->
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
     <script>
	    
    </script>
	
</body>
</html>