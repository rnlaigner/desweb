<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "airlinesystem.utils.Pair"%>
<%
@SuppressWarnings("unchecked")
List<Pair<Integer,String>> passengers = (List<Pair<Integer,String>>) session.getAttribute("passengers");

if(passengers.isEmpty()){
    Pair<Integer,String> pair = new Pair<Integer,String>(1, "Adulto");
	passengers.add(pair);
}
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

<div class="container" id="passengerForm" style="display:none;">
    <ul class="list-group">		
<% 
for (Pair<Integer,String> pair  : passengers) { %>
		<li>
			<p class="col-form-label"><%=pair.getRight().toString()%> <%=pair.getLeft().toString()%></p>
			<div class="form-group row">
			  <label for="example-text-input" class="col-xs-2 col-form-label">Nome completo</label>
			  <div class="col-xs-8">
			    <input class="form-control name" type="text" value="" id="example-text-input">
			  </div>
			</div>
			<div class="form-group row">
			  <label for="example-search-input" class="col-xs-2 col-form-label">Nacionalidade</label>
			  <div class="col-xs-6">
			    <input class="form-control nationality" type="text" value="Brasileiro" id="example-text-input">
			  </div>
			</div>
			
			<div class="form-group row">
			  <label for="example-email-input" class="col-xs-2 col-form-label">Tipo e número de documento</label>
			  <div class="col-xs-2">
			   <select class="form-control form-control-sm">
				  <option value="CPF">CPF</option>
				  <option value="Passaporte">Passaporte</option>
				</select>
			  </div>
			  <div class="col-xs-4">
			    <input class="form-control identity" type="text" value="" id="example-text-input">
			  </div>
			</div>
			
			<div class="form-group row">
			  <label for="example-time-input" class="col-xs-2 col-form-label">Possui necessidade especiais?</label>
			  <div class="col-xs-10">
			    <div class="checkbox">
				  <label><input id="specialNeed" type="checkbox" value="">Option 3</label>
				</div>
			  </div>
			</div>
			
		</li>
<% } %>
    </ul>
</div> 

</body>
</html>