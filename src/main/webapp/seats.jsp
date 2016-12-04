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
			    
			    
	<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="ui/assets/css/jquery.seat-charts.css">
	<style>
	body {
		font-family: 'Roboto', sans-serif;
	  background-color:#fafafa;
	}
	a {
		color: #b71a4c;
	}
	.front-indicator {
		width: 145px;
		margin: 5px 32px 15px 32px;
		background-color: #f6f6f6;	
		color: #adadad;
		text-align: center;
		padding: 3px;
		border-radius: 5px;
	}
	.wrapper {
		width: 100%;
		text-align: center;
	  margin-top:20px;
	}
	.container {
		margin: 0 auto;
		width: 500px;
		text-align: left;
	}
	.booking-details {
		float: left;
		text-align: left;
		margin-left: 35px;
		font-size: 12px;
		position: relative;
		height: 401px;
	}
	.booking-details h2 {
		margin: 25px 0 20px 0;
		font-size: 17px;
	}
	.booking-details h3 {
		margin: 5px 5px 0 0;
		font-size: 14px;
	}
	div.seatCharts-cell {
		color: #182C4E;
		height: 25px;
		width: 25px;
		line-height: 25px;
		
	}
	div.seatCharts-seat {
		color: #FFFFFF;
		cursor: pointer;	
	}
	div.seatCharts-row {
		height: 35px;
	}
	div.seatCharts-seat.available {
		background-color: #B9DEA0;
	
	}
	div.seatCharts-seat.available.first-class {
	/* 	background: url(vip.png); */
		background-color: #3a78c3;
	}
	div.seatCharts-seat.available.executive-class {
	/* 	background: url(vip.png); */
		background-color: #3a12c3;
	}
	div.seatCharts-seat.focused {
		background-color: #76B474;
	}
	div.seatCharts-seat.selected {
		background-color: #E6CAC4;
	}
	div.seatCharts-seat.unavailable {
		background-color: #472B34;
	}
	div.seatCharts-container {
		border-right: 1px dotted #adadad;
		width: 200px;
		padding: 20px;
		float: left;
	}
	div.seatCharts-legend {
		padding-left: 0px;
		position: absolute;
	}
	ul.seatCharts-legendList {
		padding-left: 0px;
	}
	span.seatCharts-legendDescription {
		margin-left: 5px;
		line-height: 30px;
	}
	.checkout-button {
		display: block;
		margin: 10px 0;
		font-size: 14px;
	}
	#selected-seats {
		max-height: 90px;
		overflow-y: scroll;
		overflow-x: none;
		width: 170px;
	}
	</style>	    
	</head>
<body>
	<div class="wrapper">
	  <div class="container">
	  <h1>Selecione seu(s) assento(s)</h1>
	    <div id="seat-map">
	      <div class="front-indicator">Frente do Avião</div>
	    </div>
	    <div class="booking-details">
	      <h2>Booking Details</h2>
	      <h3> Selected Seats (<span id="counter">0</span>):</h3>
	      <ul id="selected-seats">
	      </ul>
	      Total: <b>$<span id="total" name="total">0</span></b>
	      <button class="checkout-button">Checkout &raquo;</button>
	      <div id="legend"></div>
	    </div>
	  </div>
	</div>
	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script> 
	<script src="ui/assets/js/jquery.seat-charts.js"></script> 
	<script>
			var firstSeatLabel = 1;

			var firstClassPrice = this.firstClassFactor * this.price;
			var executiveClassPrice = this.price * this.executiveClassFactor;
			var economyClassPrice = this.price * this.economyClassFactor;
			
			var maxSeats = +this.adults + +this.children + +this.babies;
			
			var numberSelectedSeats = 0;
		
			$(document).ready(function() {
				var $cart = $('#selected-seats'),
					$counter = $('#counter'),
					$total = $('#total'),
					sc = $('#seat-map').seatCharts({
					map: [
						'pp_pp',
						'pp_pp',
						'xx_xx',
						'xx_xx',
						'ee___',
						'ee_ee',
						'ee_ee',
						'ee_ee',
						'ee_ee',
						'eeeee'
					],
					seats: {
						p: {
							price   : firstClassPrice,
							classes : 'first-class', //your custom CSS class
							category: 'First Class'
						},
						x: {
							price   : executiveClassPrice,
							classes : 'executive-class', //your custom CSS class
							category: 'Executive Class'
						},
						e: {
							price   : economyClassPrice,
							classes : 'economy-class', //your custom CSS class
							category: 'Economy Class'
						}					
					
					},
					naming : {
						top : false,
						getLabel : function (character, row, column) {
							return firstSeatLabel++;
						},
					},
					legend : {
						node : $('#legend'),
					    items : [
							[ 'p', 'available',   'Primeira Classe' ],
							[ 'x', 'available',   'Executiva' ],
							[ 'e', 'available',   'Classe Econômica'],
							[ 'f', 'unavailable', 'Indisponível']
					    ]					
					},
					click: function () {
						
						if (this.status() == 'available') {

							if(maxSeats != 0 && numberSelectedSeats == maxSeats)
							{
								alert("Número máximo de assentos ultrapassado");
								return;
							}
							
							//let's create a new <li> which we'll add to the cart items
							$('<li class="selectedSeat">'+this.data().category+' Seat # '+this.settings.label+': <b>$'+this.data().price+'</b> <a href="#" class="cancel-cart-item">[cancel]</a></li>')
								.attr('seatNumber',this.settings.label)
								.attr('id', 'cart-item-'+this.settings.id)
								.data('seatId', this.settings.id)
								.appendTo($cart);
							
							/*
							 * Lets update the counter and total
							 *
							 * .find function will not find the current seat, because it will change its stauts only after return
							 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
							 */
							$counter.text(sc.find('selected').length+1);
							$total.text(recalculateTotal(sc)+this.data().price);

							numberSelectedSeats = $counter.text();
							
							return 'selected';
						} else if (this.status() == 'selected') {
							//update the counter
							$counter.text(sc.find('selected').length-1);

							numberSelectedSeats = $counter.text();
							
							//and total
							$total.text(recalculateTotal(sc)-this.data().price);
						
							//remove the item from our cart
							$('#cart-item-'+this.settings.id).remove();
						
							//seat has been vacated
							return 'available';
						} else if (this.status() == 'unavailable') {
							//seat has been already booked
							return 'unavailable';
						} else {
							return this.style();
						}
					}
				});

				//this will handle "[cancel]" link clicks
				$('#selected-seats').on('click', '.cancel-cart-item', function () {
					//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
					sc.get($(this).parents('li:first').data('seatId')).click();
				});

				$('.checkout-button').on('click', function () {

					if(maxSeats != 0 && numberSelectedSeats < maxSeats){
						alert("Ainda há assentos a serem escolhidos");
						return;
					}
					var value = $('#total').html();
					
					opener.document.getElementsByName(elementName).value = value;

					var size = $('.selectedSeat').length;

					var array = new Array();

					$('.selectedSeat').each(function() {
					    array.push($(this).attr('seatNumber'));
					});

					opener.updateTotal(elementName,array,numberSelectedSeats);
					
					self.close();
				});

				//let's pretend some seats have already been booked
				//sc.get(['1_2', '4_1', '7_1', '7_2']).status('unavailable');
		
		});

		function recalculateTotal(sc) {
			var total = 0;
		
			//basically find every selected seat and sum its price
			sc.find('selected').each(function () {
				total += this.data().price;
			});
			
			return total;
		}
		
		
	</script>
    

</body>
</html>