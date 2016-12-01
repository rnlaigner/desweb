<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		
<form method="post" action="SearchRouteServlet" id="searchForm" accept-charset="UTF-8">
<!-- Find a Tour -->
	<section id="bookSection" class="tour section-wrapper container">
		<h2 class="section-title">
			Encontre sua passagem
		</h2>
		<p class="section-subtitle">
			Para onde você deseja ir?
		</p>
		
		<div class="row">
			
			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" id="origin" name="origin" placeholder="Origem"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>

			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" id="destiny" name="destiny" placeholder="Destino"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>

			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" id="departureDate" name="departureDate" placeholder="Data de Saída"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control border-radius border-right" id="returnDate" name="returnDate" placeholder="Data de Retorno"/>
					<span class="input-group-addon border-radius custom-addon">
						<i class="ion-ios-calendar"></i>
					</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
				
					<div class="form-group">
						<select class="form-control border-radius" id="adult" name="adult">
							<option value="" disabled selected>Adultos</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
					<div class="form-group">
						<select class="form-control border-radius" id="children" name="children">
							<option value="" disabled selected>Crianças</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
					<div class="form-group">
						<select class="form-control border-radius" id="baby" name="baby">
							<option value="" disabled selected>Bebês</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
					<div class="form-group">
						<select class="form-control border-radius" id="seat" name="seat">
							<option value="" disabled selected>Escala</option>
							<option value="Turística">Sim</option>
							<option value="Executiva">Não</option>
						</select>
					</div>
			</div>
			
		</div>	
		
		<input class="btn btn-default border-radius custom-button center-block" type="submit" value="Procurar" id="search" style="width: 20em; height: 3em;">
			
	</section> <!-- /.tour -->

</form>
    

</body>
</html>