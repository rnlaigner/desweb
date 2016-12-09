package airlinesystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.PassengerBusiness;
import airlinesystem.entity.Flight;
import airlinesystem.entity.Passenger;
import airlinesystem.exception.ObjetoNaoEncontradoException;

/**
 * Servlet implementation class UserReservationsServlet
 */
public class UpdatePassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PassengerBusiness passengerBusiness;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassengerServlet() {
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
		String passenger_id = request.getParameter("passenger_id");
		String telephone = request.getParameter("telephone");
		@SuppressWarnings("unchecked")
		List<Flight> flights = (List<Flight>) session.getAttribute("flights");
		String message;
		
		passengerBusiness = PassengerBusiness.getInstance();
		
		long passengerId = Long.valueOf(passenger_id);
		
		Passenger passenger = null;
		try {
			passenger = passengerBusiness.find(passengerId);
			
			if( telephone != null && !telephone.equals("")){
				passenger.setTelephone(telephone);
				passengerBusiness.update(passenger);
				
				for(Flight flight : flights){
					if(flight.getPassenger().getId().equals(passenger.getId()))
					{
						flight.setPassenger(passenger);
					}
				}
				
				session.setAttribute("flights", flights);
			}
			
			message = "SUCCESS";
			
		} catch (ObjetoNaoEncontradoException e) {
			message = "FAILURE";
			e.printStackTrace();
		}
	    
	    response.getWriter().write(message);
	     
	}

}
