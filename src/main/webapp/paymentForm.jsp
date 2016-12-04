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
	
<div class="container" id="paymentForm" style="display:none;">
			<p class="col-form-label">Entre com as informações de pagamento</p>
			<div class="form-group row">
			  <label for="example-text-input" class="col-xs-2 col-form-label">Número do cartão</label>
			  <div class="col-xs-6">
			    <input class="form-control" type="text" value="" id="example-text-input">
			  </div>
			</div>
			
			<div class="form-group row">
			  <label for="example-email-input" class="col-xs-2 col-form-label">Cartão válido até</label>
			  <div class="col-xs-2">
			    <select class="form-control form-control-sm">
				  <option value="" disabled selected>Mês</option>
				  <option value="Janeiro">Janeiro</option>
				  <option value="">Não</option>
				</select>
				<select class="form-control form-control-sm">
				  <option value="" disabled selected>Ano</option>
				  <option value="2026">2026</option>
				  <option value="">Não</option>
				</select>
			  </div>
			</div>
			
			<div class="form-group row">
			  <label for="example-search-input" class="col-xs-2 col-form-label">Código de segurança</label>
			  <div class="col-xs-2">
			    <input class="form-control" type="search" value="" id="example-text-input">
			  </div>
			</div>
			
			<div class="form-group row">
			  <label for="example-search-input" class="col-xs-2 col-form-label">Titular do cartão</label>
			  <div class="col-xs-10">
			    <input class="form-control" type="search" value="" id="example-text-input">
			  </div>
			</div>
			
			<div class="form-group row">
			  <label for="example-search-input" class="col-xs-2 col-form-label">CPF do titular do cartão</label>
			  <div class="col-xs-6">
			    <input class="form-control" type="search" value="" id="example-text-input">
			  </div>
			</div>
			<!-- 
			<div class="form-actions">
	            <button type="submit" class="btn btn-primary">Comprar</button>
          	</div>
          	 -->
</div> 

</body>
</html>