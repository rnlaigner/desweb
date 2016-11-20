package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.utils.JPAUtil;

public class RouteAppService
{	
	private static final RouteDAO routeDAO = FabricaDeDAOs.getDAO(RouteDAO.class);

	private static final RouteAppService routeAppService = new RouteAppService();
	
	private RouteAppService()
	{
		
	}
	
	public static RouteAppService getInstance()
	{
		return routeAppService;
	}
	
	public List<Route> findRoutes(Airport origin, Airport destiny, Date departureDate) 
	{	try
		{	List<Route> routes = routeDAO.findRoutes(origin, destiny, departureDate);

			return routes;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
}