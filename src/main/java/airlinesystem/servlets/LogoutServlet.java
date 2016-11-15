package airlinesystem.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LogoutServlet extends HttpServlet {
	
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
    public LogoutServlet() {
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
		String message;
		HttpSession session = request.getSession();
		
		//Provavelmente no futuro retirardados do usuario da sessao. Entretanto isso ja eh cumprido pelo invalidate.
		
		try
		{
		    ServletContext servletContext = request.getServletContext();
		    servletContext.setAttribute("email", null);
		    
		    session.invalidate();
		    
		    message = "SUCCESS";
		}
		catch(Exception e)
		{
			message = "FAILURE";
		}
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
