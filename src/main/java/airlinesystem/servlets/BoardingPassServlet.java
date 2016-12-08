package airlinesystem.servlets;

import java.io.IOException;

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
public class BoardingPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FlightBusiness flightBusiness;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardingPassServlet() {
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
		String flight_id = request.getParameter("flight_id");
		String message;
		
		flightBusiness = FlightBusiness.getInstance();
		
		long flightId = Long.valueOf(flight_id);
		
		Flight flight = null;
		try {
			flight = flightBusiness.retrieveFlight(flightId);
			
			session.setAttribute("flight",flight);
			
			message = "SUCCESS";
			
		} catch (ObjetoNaoEncontradoException e) {
			message = "FAILURE";
			e.printStackTrace();
		}
	    
	    response.getWriter().write(message);
	     
	}

}
