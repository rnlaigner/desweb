<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String email = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<!--[if IE 7 ]><html class="ie ie7 lte9 lte8 lte7" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="ie ie8 lte9 lte8" lang="en-US">	<![endif]-->
<!--[if IE 9]><html class="ie ie9 lte9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="noIE" lang="en-US">
<!--<![endif]-->
	<head>
		<!-- meta -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale = 1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>Euro Travel</title>
	
		<link rel="stylesheet" href="ui/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="ui/assets/css/ionicons.min.css">
		<link rel="stylesheet" href="ui/assets/css/owl.carousel.css">
		<link rel="stylesheet" href="ui/assets/css/owl.theme.css">
		<link rel="stylesheet" href="ui/assets/css/flexslider.css" type="text/css">
	    <link rel="stylesheet" href="ui/assets/css/main.css">
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
	<nav class="navbar navbar-default navbar-fixed-top">
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
					<li><a href="/web/SearchRouteServlet">Vôos</a></li>
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
					<div class="top">
						<a href="#header">
							<i class="ion-arrow-up-b"></i>
						</a>
					</div>
				</div>
			</div>
		</div>		
	</footer>

	<!-- Animações da tela principal -->
	<script src="ui/assets/js/jquery-1.11.2.min.js"></script>
    <script src="ui/assets/js/bootstrap.min.js"></script>
    <script src="ui/assets/js/owl.carousel.min.js"></script>
    <script src="ui/assets/js/contact.js"></script>
    <script src="ui/assets/js/jquery.flexslider.js"></script>
	<script src="ui/assets/js/script.js"></script>

	<script src="ui/assets/js/login.js?1001"></script>

</body>
</html>