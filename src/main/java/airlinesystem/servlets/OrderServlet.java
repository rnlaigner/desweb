package airlinesystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.FlightBusiness;
import airlinesystem.business.OrderBusiness;
import airlinesystem.business.PassengerBusiness;
import airlinesystem.business.RouteBusiness;
import airlinesystem.dao.SeatAppService;
import airlinesystem.dao.UserAppService;
//import airlinesystem.entity.CheckIn;
import airlinesystem.entity.Flight;
import airlinesystem.entity.Order;
import airlinesystem.entity.Passenger;
import airlinesystem.entity.Route;
import airlinesystem.entity.Seat;
import airlinesystem.enums.AgeCategory;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.Pair;
import airlinesystem.utils.Util;
import airlinesystem.entity.User;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RouteBusiness routeBusiness;
	private FlightBusiness flightBusiness;
	private PassengerBusiness passengerBusiness;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 HttpSession session = request.getSession();
		 
		 String userEmail = (String) session.getAttribute("email");
		 
		 String[] routeIds = request.getParameterValues("routeIds[]");
//		 String outboundDate = request.getParameter("outboundDate");
//	     String returnDate = request.getParameter("returnDate");
	     String outboundSeats = request.getParameter("outboundSeats");
	     String returnSeats = request.getParameter("returnSeats");
	     
	     List<String> outboundSeatsArray = Util.convertCommaListToArray(outboundSeats);
	     List<String> returnSeatsArray = Util.convertCommaListToArray(returnSeats);
	     
	     String outboundTotalStr = request.getParameter("outboundTotal");
	     String returnTotalStr = request.getParameter("returnTotal");
	     
	     String[] arrayName = request.getParameterValues("arrayName[]");
	     String[] arrayNationality = request.getParameterValues("arrayNationality[]");
	     String[] arrayIdentity = request.getParameterValues("arrayIdentity[]");
	     
	     @SuppressWarnings("unchecked")
		 List<Pair<Integer,String>> passengers = (List<Pair<Integer,String>>) session.getAttribute("passengers");
	     
	     routeBusiness = RouteBusiness.getInstance();
	     flightBusiness = FlightBusiness.getInstance();
	     passengerBusiness = PassengerBusiness.getInstance();
	     
	     int numberPassengers = outboundSeatsArray.size();
	     
	     Long outboundRouteId = new Long(routeIds[0]);
	     Long returnRouteId = new Long(routeIds[1]);
	     
	     Route outboundRoute = routeBusiness.find(outboundRouteId);
	     Route returnRoute = routeBusiness.find(returnRouteId);
	     
	     Order order = new Order();
	     
	     UserAppService userService = UserAppService.getInstance();
	     User user = null;	 
	     try {
			user = userService.retrieveUser(userEmail);
		 } catch (ObjetoNaoEncontradoException e) {
			e.printStackTrace();
		 }
	    		 
	     order.setUser(user);
	     
	     OrderBusiness orderBusiness = OrderBusiness.getInstance();
		    
	     orderBusiness.save(order);
	     
	     //Para cada passageiro
	     for(int i = 0; i < numberPassengers; i++){

		     //Obtem seu respectivo assento
		     SeatAppService seatService = SeatAppService.getInstance();
		     Seat outboundSeat = null;
		     Seat returnSeat = null;
		     try {
				outboundSeat = seatService.find(new Long(outboundSeatsArray.get(i)));
				returnSeat = seatService.find(new Long(returnSeatsArray.get(i)));
			 } catch (NumberFormatException e) {
				e.printStackTrace();
			 } catch (ObjetoNaoEncontradoException e) {
				e.printStackTrace();
			 }
		     
		     //Seta seus dados
		     Passenger passenger = new Passenger();
		     passenger.setName(arrayName[i]);
		     passenger.setNationality(arrayNationality[i]);
		     passenger.setIdentificationNumber(arrayIdentity[i]);
		     
		     //TODO gambiarra no caso da compra nao ser feita por uma busca
		     if(passengers.isEmpty()){
		    	 Pair<Integer,String> pair = new Pair<Integer,String>(i+1, "Adulto");
		    	 passengers.add(pair);
		     }
		     
		    //setAgeCategory
		     String category = passengers.get(i).getRight().toString();
		     if(category.equals("Criança")){
		    	 passenger.setAgeCategory(AgeCategory.CHILD);
		     }else if(category.equals("Adulto")){
		    	 passenger.setAgeCategory(AgeCategory.ADULT);
		     }else if (category.equals("Bebê")){
		    	 passenger.setAgeCategory(AgeCategory.BABY);
		     }
		     
		     //persiste passageiro
		     passengerBusiness.save(passenger);
		     
		     //Cria seus vôos
		     Flight outboundFlight = new Flight(outboundRoute,outboundRoute.getId(),outboundSeat,passenger,order);
		     Flight returnFlight = new Flight(returnRoute,returnRoute.getId(),returnSeat,passenger,order);
		     
//		     CheckIn checkinOutbound = new CheckIn(outboundFlight);
//		     outboundFlight.setCheckin(checkinOutbound);
//		     CheckIn checkinReturn = new CheckIn(returnFlight);
//		     returnFlight.setCheckin(checkinReturn);
		     
		     //persiste flight
		     flightBusiness.save(outboundFlight);
		     flightBusiness.save(returnFlight);
		     
		     //Adiciona os vôos à compra
		     order.addFlight(outboundFlight);
		     order.addFlight(returnFlight);
		     
	     }
	     
	     //TODO setPayment
	    
	     Integer outboundTotal = Integer.valueOf(outboundTotalStr); 
	     Integer returnTotal = Integer.valueOf(returnTotalStr);
	     
	     Float fee = outboundRoute.getOrigin().getFee() * numberPassengers;
	    
	     order.setTotalPrice(outboundTotal + returnTotal + fee);
	    
	     //update em order
	     try {
			orderBusiness.update(order);
		 } catch (ObjetoNaoEncontradoException e1) {
			e1.printStackTrace();
		 }
	     
	     //Pega as orders do usuario e coloca na sessao para acesso na proxima tela
	     List<Order> orders = orderBusiness.retrieveOrders(user);
	     orders.add(order);
	     
	     session.setAttribute("orders",orders);
	     
	     
	     List<Flight> flights = null;
		 try {
			flights = flightBusiness.retrieveFlights(user);
		 } catch (ObjetoNaoEncontradoException e) {
			e.printStackTrace();
		 }
	     
	     session.setAttribute("flights",flights);
	    
	     String message;
	     message = "SUCCESS";
	     response.getWriter().write(message);
        
	}

	

}
