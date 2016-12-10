package airlinesystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.FlightBusiness;
import airlinesystem.business.SeatBusiness;
import airlinesystem.dao.UserAppService;
import airlinesystem.entity.Flight;
import airlinesystem.entity.Seat;
import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

/**
 * Servlet implementation class UserReservationsServlet
 */
public class UpdateSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SeatBusiness seatBusiness;
	private FlightBusiness flightBusiness;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSeatServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		String flightId = request.getParameter("flightId");
		String selectedSeat = request.getParameter("selectedSeat");
		String value = request.getParameter("value");
		
		@SuppressWarnings("unchecked")
		List<Flight> flights = (List<Flight>) session.getAttribute("flights");
		
		//String userEmail = (String) session.getAttribute("email");
		String message;
		
		seatBusiness = SeatBusiness.getInstance();
		
		flightBusiness = FlightBusiness.getInstance();
		
		//UserAppService userService = UserAppService.getInstance();
	    //User user = null;	
		Seat seat = null;
		Flight flight = null;
		
		long flight_id = Long.valueOf(flightId);
		
		try {
			//user = userService.retrieveUser(userEmail);
			
			seat = seatBusiness.findBySeatNumber(selectedSeat);
			
			flight = flightBusiness.retrieveFlight(flight_id);
			
			flight.setSeat(seat);
			
			//TODO ALTERAR VALOR DO ASSENTO TAMBEM
				
			flightBusiness.update(flight);
			
			for(Flight flighty : flights){
				if(flighty.getId().equals(flight.getId()))
				{
					flighty.setSeat(seat);
				}
			}
				
			session.setAttribute("flights", flights);
			
			message = "SUCCESS";
			
		} catch (ObjetoNaoEncontradoException e) {
			message = "FAILURE";
			e.printStackTrace();
		}
	    
	    response.getWriter().write(message);
	     
	}

}
