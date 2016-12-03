package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.exception.ObjetoNaoEncontradoException;
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
	
	public List<Route> find(Airport origin, Airport destiny, Date departureDate, Date maxDepartureDate) 
	{	try
		{	List<Route> routes = routeDAO.find(origin, destiny, departureDate, maxDepartureDate);

			return routes;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}

	public List<Route> findAll(Date departureDate) {
		try
		{	
			List<Route> routes = routeDAO.findAll(departureDate);

			return routes;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
	public Route find(long numero) 
			throws ObjetoNaoEncontradoException
		{	
			try
			{	Route route = routeDAO.find(numero);
				
				return route;
			} 
			catch(ObjetoNaoEncontradoException e)
			{	throw new ObjetoNaoEncontradoException("Rota não encontrada");
			}
			finally
			{   JPAUtil.closeEntityManager();
			}
		}
}