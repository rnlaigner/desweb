package airlinesystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.RouteBusiness;
import airlinesystem.entity.Route;
import airlinesystem.utils.Util;

/**
 * Servlet implementation class LoginServlet
 */
public class SearchRouteServlet extends HttpServlet {
	
	private RouteBusiness routeBusiness;
	
	private static final long serialVersionUID = 1L;
	
	/*
	@Override
	public void init()
	{
	}
	*/
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRouteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{		
	    HttpSession session = request.getSession();
	    String origin = request.getParameter("origin");
        String destiny = request.getParameter("destiny");
	    String departureDate = request.getParameter("departureDate");
	    String returnDate = request.getParameter("returnDate");
	    String adult = request.getParameter("adult");
	    String children = request.getParameter("children");
	    String baby = request.getParameter("baby");
	    //change Formatting in home.jsp UTF para ISO
	    String seatCategory = request.getParameter("seat");
	    
	    routeBusiness = RouteBusiness.getInstance();
	    
	    List<Route> outboundRoutes = routeBusiness.findRoutes(origin, destiny, Util.strToDateUS(departureDate), seatCategory);
	    
	    List<Route> returnRoutes = routeBusiness.findRoutes(destiny, origin, Util.strToDateUS(returnDate), seatCategory);
	    
	    session.setAttribute("outboundRoutes", outboundRoutes);
	    session.setAttribute("returnRoutes", returnRoutes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/flights.jsp");      
		
        try 
        {
			rd.forward(request, response);
		} 
        catch (ServletException e) 
        {
			//Pagina de erro
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request,response);
	}

}
