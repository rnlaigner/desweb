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
	    //String seatCategory = request.getParameter("seat");
	    
	    routeBusiness = RouteBusiness.getInstance();
	    
	    //Se origem é nulo é porque todos os outros parâmetros são nulos
	    if (origin != null){
		    List<Route> outboundRoutes = routeBusiness.find(origin, destiny, Util.strToDateUS(departureDate));
		    
		    List<Route> returnRoutes = routeBusiness.find(destiny, origin, Util.strToDateUS(returnDate));
		    
		    //TODO devo colocar na session ou no request?
		    //session.setAttribute("seatCategory", seatCategory);
		    session.setAttribute("destiny", outboundRoutes.get(0).getDestiny().getCity());
		    session.setAttribute("origin", returnRoutes.get(0).getDestiny().getCity());
		    
		    session.setAttribute("adult", adult);
		    session.setAttribute("children", children);
		    session.setAttribute("baby", baby);
		    
		    Integer totalPassengers = Integer.valueOf(0);

		    totalPassengers = adult == null ? totalPassengers + Integer.parseInt(adult) : totalPassengers;
		    totalPassengers = children == null ? totalPassengers + Integer.parseInt(children) : totalPassengers;
		    totalPassengers = baby == null ? totalPassengers + Integer.parseInt(baby) : totalPassengers;

		    session.setAttribute("totalPassengers",totalPassengers);
		    
		    session.setAttribute("outboundRoutes", outboundRoutes);
		    session.setAttribute("returnRoutes", returnRoutes);
	    }
	    else {
	    	List<Route> routes = routeBusiness.findAll();
	    	
	    	//session.setAttribute("seatCategory", null);
	    	session.setAttribute("destiny", null);
		    session.setAttribute("origin", null);
		    
		    session.setAttribute("adult", "0");
		    session.setAttribute("children", "0");
		    session.setAttribute("baby", "0");
	    	
		    session.setAttribute("totalPassengers",0);
		    
	    	session.setAttribute("outboundRoutes", routes);
		    session.setAttribute("returnRoutes", routes);
	    }
		
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
