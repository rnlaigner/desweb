package airlinesystem.business;

public class RouteBusiness {
	
	private static final RouteBusiness routeBusiness = new RouteBusiness();
	
	private RouteBusiness()
	{
		
	}
	
	public static RouteBusiness getInstance()
	{
		return routeBusiness;
	}
	
	

}
