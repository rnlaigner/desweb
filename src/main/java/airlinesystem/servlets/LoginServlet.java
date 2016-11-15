package airlinesystem.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import airlinesystem.login.Login;
import airlinesystem.model.entity.User;
import airlinesystem.model.exception.ObjetoNaoEncontradoException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	Session session;
	
	private static final long serialVersionUID = 1L;
	
	/*
	@Override
	public void init()
	{
		HibernateInit hibernateInit;
		
		hibernateInit = HibernateInit.getInstance();
		
		try {
			hibernateInit.voidSetUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    session = hibernateInit.sessionFactory.openSession();
	}
	*/
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		String email = request.getParameter("email");
	    String password = request.getParameter("password");

    	EntityManagerFactory emf;
    	emf = Persistence.createEntityManagerFactory("web");
    	
    	EntityManager em = emf.createEntityManager();
 
        try {
            em.getTransaction().begin();
             
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
             
            em.persist(user);
             
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
         
        System.out.println("It is over");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean logged = false;
		
	    HttpSession session = request.getSession();
        
	    String remember = request.getParameter("remember-me");
        String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    Login login;
	    
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
		    	ServletContext servletContext = request.getServletContext();
		    	servletContext.setAttribute("email", email);
		    }
		    
		    session.setAttribute("email", email);
	    
	    }
	    else
	    {
	    	//colocar erro na tela
	    }
		
		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");      
        rd.forward(request, response);
		
	}

}
