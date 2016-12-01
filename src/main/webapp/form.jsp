<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%    
Integer totalPassengers = (Integer) session.getAttribute("totalPassengers");
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
<!-- 
<div class="container" id="passengerForm" style="display:none;">
    <ul class="list-group">		
		<li>
			<form>
			  <div class="form-group">
			    <label for="exampleInputEmail1">Email address</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			  </div>
			  <div class="form-group">
			    <label for="exampleSelect1">Example select</label>
			    <select class="form-control" id="exampleSelect1">
			      <option>1</option>
			      <option>2</option>
			      <option>3</option>
			      <option>4</option>
			      <option>5</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="exampleSelect2">Example multiple select</label>
			    <select multiple class="form-control" id="exampleSelect2">
			      <option>1</option>
			      <option>2</option>
			      <option>3</option>
			      <option>4</option>
			      <option>5</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="exampleTextarea">Example textarea</label>
			    <textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputFile">File input</label>
			    <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
			    <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
			  </div>
			  <fieldset class="form-group">
			    <legend>Radio buttons</legend>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1" value="option1" checked>
			        Option one is this and that&mdash;be sure to include why it's great
			      </label>
			    </div>
			    <div class="form-check">
			    <label class="form-check-label">
			        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2" value="option2">
			        Option two can be something else and selecting it will deselect option one
			      </label>
			    </div>
			    <div class="form-check disabled">
			    <label class="form-check-label">
			        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
			        Option three is disabled
			      </label>
			    </div>
			  </fieldset>
			  <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" class="form-check-input">
			      Check me out
			    </label>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</li>
    </ul>
</div> -->

<div class="container" id="passengerForm" style="display:none;">
    <ul class="list-group">		
<% 
totalPassengers = totalPassengers == 0 ? 1 : totalPassengers;

for (int i = 1; i <= totalPassengers; i++) { %>
		<li>
			<p class="col-form-label">Entre com as informações para o passageiro <%=i%></p>
			<div class="form-group row">
			  <label for="example-text-input" class="col-xs-2 col-form-label">Nome completo</label>
			  <div class="col-xs-10">
			    <input class="form-control" type="text" value="" id="example-text-input">
			  </div>
			</div>
			<div class="form-group row">
			  <label for="example-search-input" class="col-xs-2 col-form-label">Nacionalidade</label>
			  <div class="col-xs-10">
			    <input class="form-control" type="search" value="Brasileiro" id="example-search-input">
			  </div>
			</div>
			<div class="form-group row">
			  <label for="example-email-input" class="col-xs-2 col-form-label">Identidade</label>
			  <div class="col-xs-10">
			    <input class="form-control" type="email" value="" id="example-email-input">
			  </div>
			</div>
			<div class="form-group row">
			  <label for="example-time-input" class="col-xs-2 col-form-label">Possui necessidade especiais?</label>
			  <div class="col-xs-10">
			    <div class="checkbox">
				  <label><input type="checkbox" value="">Option 3</label>
				</div>
			  </div>
			</div>
		</li>
<% } %>
    </ul>
</div> 

</body>
</html>