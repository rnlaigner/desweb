<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "airlinesystem.utils.Util"%>
<%@ page import = "airlinesystem.entity.Route" %>
<%@ page import = "airlinesystem.enums.SeatCategory" %>
<%@ page import = "airlinesystem.entity.Seat" %>
<%@ page import = "java.util.Random" %>
<%@ page language="java" %>
<%@ page session="true" %>
<% 
String email = (String) session.getAttribute("email");

@SuppressWarnings("unchecked")
List<Route> outboundRoutes = (List<Route>) session.getAttribute("outboundRoutes"); 

@SuppressWarnings("unchecked") 
List<Route> returnRoutes = (List<Route>) session.getAttribute("returnRoutes"); 

String destinyCity = (String) session.getAttribute("destiny");
String originCity = (String) session.getAttribute("origin");

String adults = (String) session.getAttribute("adult");
String children = (String) session.getAttribute("children");
String babies = (String) session.getAttribute("baby");

Random randomGenerator = new Random();
int minimum  = 1;
int maximum = 100;
int range = maximum - minimum + 1;
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
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Realizar Check-In</a></li>
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Compras</a></li>
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Alterar Dados</a></li>
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
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Realizar Check-In</a></li>
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Compras</a></li>
				          <li><a href="#" style="margin-bottom: 1px; color:#60c9eb;">Alterar Dados</a></li>
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
			<h2 class="page-header" id="seat" style="display:none;">
				Selecione seu(s) assento(s)
			</h2>
			<h2 class="page-header" id="passagerData" style="display:none;">
				Informe os dados do(s) passageiro(s)
			</h2>
			<h2 class="page-header" id="paymentData" style="display:none;">
				Informe os dados do(s) passageiro(s)
			</h2>
			<ol class="breadcrumb">
				<li><a href="home.jsp">Início</a></li>
				<li><a href="flights.jsp">Vôos</a></li>
				<li class="active" style="display:inline;" id="breadcrumbOutbound">&nbsp;Ida</li>
				<li style="display:none;" id="breadcrumbReturn">&nbsp;Volta</li>
				<li style="display:none;" id="breadcrumbResume">&nbsp;Selecão de Assento</li>
				<li style="display:none;" id="breadcrumbPassenger">&nbsp;Dados do Passageiro</li>
				<li style="display:none;" id="breadcrumbPayment">&nbsp;Pagamento</li>
			</ol>
		</div> <!-- /.container -->
	</section> <!-- /.section-background -->
	
	<br>
	
	<div class="container" id="outboundRoutes" style="display:block;">
    <ul class="list-group">
    <%  for(Route route : outboundRoutes){%>
    	<li route_id="<%= route.getId() %>" id="<%= route.getId() %>">
	        <div class="panel panel-default">
	            <div class="panel-body" style="padding-bottom: 1px;">
	                <div class="panel-info">
	                    <p><strong>Ida</strong></p>
	                    <p class="outboundDate"><%=Util.dateToStr(route.getDepartureTime())%></p>
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
	                
	                <div class="panel-info outboundPrice" price=<%= route.getPrice()%>>
	                	<p><strong>Preço por adulto</strong></p>
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
	                    <p><strong>Número do vôo</strong></p>
	                    <p><%= route.getId() %></p>
	                </div>
	                
	                <div class="panel-info airplaneModel">
	                    <p><strong>Aeronave</strong></p>
	                	<p><%= route.getAirplane().getModel() %></p>
	                </div>
	                
	                <!--
	                 <div class="panel-info food">
	                    <p><strong>Refeição</strong></p>
	                    <p>Não</p>
	                </div>
					-->
					<div class="panel-info tax">
	                    <p><strong>Taxa de Embarque</strong></p>
	                    <p><%= route.getOrigin().getFee() %></p>
	                </div>  
	                
	                
	                <div class="panel-info scale">
	                    <p><strong>Escala</strong></p>
	                    <p>Não</p>
	                </div>
	                
	                <div class="btn btn-default border-radius custom-button outbound" 
	                 id="<%= randomGenerator.nextInt(range) + minimum %>" route_id="<%= route.getId() %>"
	                 style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
						Comprar
				    </div>
				   
				    <div class="panel-info seatsPopUp" style="display:none;">
				   	 <a href='#' id='outboundSeatsPopUp' title='Pop Up'>Assentos</a>
				    </div>
				   
				    <div class="panel-info outboundTotal"></div>
				   
	            </div>
	         </div>
	     </li>
<%		 }	%>
	</ul>
	</div>
	
	<div class="container" id="returnRoutes" style="display:none;">
    <ul class="list-group">
    
    	<% for(Route route : returnRoutes){%>
    	<li route_id="<%= route.getId() %>" id="<%= route.getId() %>">
	        <div class="panel panel-default">
	            <div class="panel-body" style="padding-bottom: 1px;">
	                <div class="panel-info">
	                    <p><strong>Retorno</strong></p>
	                    <p class="returnDate"><%= Util.dateToStr(route.getDepartureTime())	%></p>
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
	                
	                <div class="panel-info returnPrice" price=<%= route.getPrice()%>>
	                	<p><strong>Preço por adulto</strong></p>
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
	                    <p><strong>Número do vôo</strong></p>
	                    <p><%= route.getId() %></p>
	                </div>
	                
	                <div class="panel-info airplaneModel">
	                    <p><strong>Aeronave</strong></p>
	                	<p><%= route.getAirplane().getModel() %></p>
	                </div>
	                
	                 <!--
	                 <div class="panel-info food">
	                    <p><strong>Refeição</strong></p>
	                    <p>Não</p>
	                </div>
					-->
					<div class="panel-info tax">
	                    <p><strong>Taxa de Embarque</strong></p>
	                    <p><%= route.getOrigin().getFee() %></p>
	                </div>
	                
	                <div class="panel-info scale">
	                    <p><strong>Escala</strong></p>
	                    <p>Não</p>
	                </div>
	                
	                <div class="btn btn-default border-radius custom-button return" 
	                id="<%= randomGenerator.nextInt(range) + minimum %>" route_id="<%= route.getId() %>"
	                style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px;">
						Comprar
				    </div>
				  
				    <div class="panel-info seatsPopUp" style="display:none;">
				   	 <a href='#' id='returnSeatsPopUp' title='Pop Up'>Assentos</a>
				    </div>
	               
	                <div class="panel-info returnTotal"></div>
				   
	            </div>
	         </div>
	     </li>
<%		}%>
	</ul>
	</div>
	
	<!-- rotas escolhidas sao colocadas aqui -->
	<div class="container" id="selectedRoutes" style="display:none;">
		<ul class="list-group routes">
		</ul>
	</div>
	
	<div class="info" style="display:none; visibility: hidden;">
		<div id="firstClassFactor"><%=SeatCategory.FIRST_CLASS.getFactor()%></div>
		<div id="executiveClassFactor"><%=SeatCategory.EXECUTIVE.getFactor()%></div>
		<div id="economyClassFactor"><%=SeatCategory.ECONOMY.getFactor()%></div>
		
		<div id="adults">
				<%if(adults!=null){%>
					<%=adults%><%} else{ %>
					0
				<%} %></div>
		<div id="children">
				<%if(children!=null){%>
					<%=children%><%} else{ %>
					0
				<%} %></div>
		<div id="babies">
				<%if(babies!=null){%>
					<%=babies%><%} else{ %>
					0
				<%} %></div>
	</div>
	
	<jsp:include page="passengerForm.jsp">
		<jsp:param name="cor" value="azul" />
	</jsp:include>
	
	<jsp:include page="paymentForm.jsp">
		<jsp:param name="cor" value="azul" />
	</jsp:include>
	
	<div class="btn btn-default border-radius custom-button" id="loadPassengerForm"
	style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px; display:none;">
		Prosseguir >>
	</div>
	
	<div class="btn btn-default border-radius custom-button" id="loadPaymentForm"
	style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px; display:none;">
		Prosseguir >>
	</div>
	
	<div class="btn btn-default border-radius custom-button" id="finishOrder"
	style="width: 7em; height: 2.7em; float: right; margin-right: 10px; margin-top: 27px; display:none;">
		Concluir
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
	
	<!--  -->
	<script src="ui/assets/js/login.js?1002"></script>
	<script src="ui/assets/js/order.js?1024"></script>
	
	<!-- Date Picker -->
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <script>
	 	function updateTotal(elementName,array,numberSelectedSeats){
	 		var value = document.getElementsByName(elementName).value;

			var elementId = '#' + elementName;

	 		//if exists, update total value
	 		if ( $( elementId ).length ) {
	 			$( elementId ).remove();
	 			$("<p id='"+elementName+"' name='"+elementName+"' total="+value+" seats="+array+">R$ "+value+"</p>").appendTo( "."+elementName );
			}
	 		else{
	 			$("<p><strong>Total</strong></p>").appendTo( "."+elementName );
	            $("<p id='"+elementName+"' name='"+elementName+"' total="+value+" seats="+array+">R$ "+value+"</p>").appendTo( "."+elementName );
		 	}

			//TODO caso totalPassengers != numberSelectedSeats, adicionar mais forms
			//Clonar div de form 
            
		}
    </script>
	
</body>
</html>