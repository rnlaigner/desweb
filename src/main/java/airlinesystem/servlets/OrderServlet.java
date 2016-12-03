package airlinesystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.RouteBusiness;
import airlinesystem.dao.SeatAppService;
import airlinesystem.entity.Flight;
import airlinesystem.entity.Order;
import airlinesystem.entity.Passenger;
import airlinesystem.entity.Route;
import airlinesystem.entity.Seat;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.Util;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RouteBusiness routeBusiness;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response){
		 HttpSession session = request.getSession();
		 
		 String[] routeIds = request.getParameterValues("routeIds[]");
		 String outboundDate = request.getParameter("outboundDate");
	     String returnDate = request.getParameter("returnDate");
	     String outboundSeats = request.getParameter("outboundSeats");
	     String returnSeats = request.getParameter("returnSeats");
	     
	     List<String> outboundSeatsArray = Util.convertCommaListToArray(outboundSeats);
	     List<String> returnSeatsArray = Util.convertCommaListToArray(returnSeats);
	     
	     String outboundTotal = request.getParameter("outboundTotal");
	     String returnTotal = request.getParameter("returnTotal");
	     
	     //TODO pegar data de nascimento para saber a categoria
	     String[] arrayName = request.getParameterValues("arrayName[]");
	     String[] arrayNationality = request.getParameterValues("arrayNationality[]");
	     String[] arrayIdentity = request.getParameterValues("arrayIdentity[]");
	     
	     routeBusiness = RouteBusiness.getInstance();
	     
	     int numberPassengers = outboundSeatsArray.size();
	     
	     //busco o seat do airplane da rota
	     //salvo o flight
	     
	     Long outboundRouteId = new Long(routeIds[0]);
	     Long returnRouteId = new Long(routeIds[1]);
	     
	     Route outboundRoute = routeBusiness.find(outboundRouteId);
	     Route returnRoute = routeBusiness.find(returnRouteId);
	     
	     Order order = new Order();
	     
	     for(int i = 0; i < numberPassengers; i++){
	     
		     SeatAppService seatService = SeatAppService.getInstance();
		     Seat outboundSeat = null;
		     Seat returnSeat = null;
		     try {
				outboundSeat = seatService.find(new Long(outboundSeatsArray.get(i)));
				returnSeat = seatService.find(new Long(returnSeatsArray.get(i)));
			 } catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (ObjetoNaoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		     
		    //TODO setAgeCategory
		     Passenger passenger = new Passenger();
		     passenger.setName(arrayName[i]);
		     passenger.setNationality(arrayNationality[i]);
		     passenger.setIdentificationNumber(arrayIdentity[i]);
		     
		     Flight outboundFlight = new Flight(outboundRoute,outboundRoute.getId(),outboundSeat,passenger);
		     Flight returnFlight = new Flight(returnRoute,returnRoute.getId(),returnSeat,passenger);
		     
		     order.addFlight(outboundFlight);
		     order.addFlight(returnFlight);
		     
	     }
	}

	

}
