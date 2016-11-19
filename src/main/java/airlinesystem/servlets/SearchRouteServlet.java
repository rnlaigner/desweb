package airlinesystem.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airlinesystem.business.RouteBusiness;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.login.Login;

/**
 * Servlet implementation class LoginServlet
 */
public class SearchRouteServlet extends HttpServlet {
	
	@SuppressWarnings("unused")
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
		boolean logged = false;
	    HttpSession session = request.getSession();
	    String remember = request.getParameter("remember-me");
        String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String message;
	    Login login;
	    
	    routeBusiness = RouteBusiness.getInstance();
	    
	    try
	    {
	    	login = new Login(email,password);
	    	login.authenticate();
	    	logged = true;
	    }
	    catch(ObjetoNaoEncontradoException e)
		{	
	    	//log4j
		}
	    
	    if(logged)
	    {
	    
		    if(remember != null)
		    {
		    	//NOT THE RIGHT WAY TO DO IT 
		    	ServletContext servletContext = request.getServletContext();
		    	servletContext.setAttribute("email", email);
		    }
		    session.setAttribute("email", email);
		    
		    message = "SUCCESS";
	    }
	    else
	    {
	    	//colocar erro na tela
	    	message = "FAILURE";
	    }
		
//		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");      
//        rd.forward(request, response);
	    
	    response.getWriter().write(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request,response);
	}

}
