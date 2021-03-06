package airlinesystem.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.FlightBusiness;
import airlinesystem.entity.Flight;
import airlinesystem.exception.ObjetoNaoEncontradoException;

/**
 * Servlet implementation class UserReservationsServlet
 */
public class CheckinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FlightBusiness flightBusiness;
	//private CheckInBusiness checkInBusiness;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckinServlet() {
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
		//String userEmail = (String) session.getAttribute("email");
		String flight_id = request.getParameter("flight_id");
		String message;
		
		flightBusiness = FlightBusiness.getInstance();
		//checkInBusiness = CheckInBusiness.getInstance();
		
		long flightId = Long.valueOf(flight_id);
		
		Flight flight = null;
		//CheckIn checkin = null;
		try {
			flight = flightBusiness.retrieveFlight(flightId);
		
			//checkin = checkInBusiness.find(flightId);
			
			//checkin.setDate(new Date());
			
			//flight.getCheckin().setDate(new Date());
			
			flight.setCheckinDate(new Date());
			
			flightBusiness.update(flight);
			
			//checkInBusiness.edit(checkin);
			
			//session.setAttribute("checkin",checkin);
			session.setAttribute("flight",flight);
			
			message = "SUCCESS";
			
		} catch (ObjetoNaoEncontradoException e) {
			message = "FAILURE";
			e.printStackTrace();
		}
	    
	    response.getWriter().write(message);
	     
	}

}
