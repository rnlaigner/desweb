package airlinesystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.FlightBusiness;
import airlinesystem.dao.UserAppService;
import airlinesystem.entity.Flight;
import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

/**
 * Servlet implementation class UserReservationsServlet
 */
public class UserReservationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FlightBusiness flightBusiness;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReservationsServlet() {
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
		String userEmail = (String) session.getAttribute("email");
		
		flightBusiness = FlightBusiness.getInstance();
		
		UserAppService userService = UserAppService.getInstance();
	    User user = null;	 
	    try {
			user = userService.retrieveUser(userEmail);
		} catch (ObjetoNaoEncontradoException e) {
			e.printStackTrace();
		}
		
		List<Flight> flights = null;
		try {
			flights = flightBusiness.retrieveFlights(user);
		} catch (ObjetoNaoEncontradoException e) {
			e.printStackTrace();
		}
	     
	    session.setAttribute("flights",flights);
	     
	    response.sendRedirect("http://localhost:8080/web/reservations.jsp");
	     
	}

}
