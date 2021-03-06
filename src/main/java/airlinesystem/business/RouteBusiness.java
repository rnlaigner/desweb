package airlinesystem.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import airlinesystem.dao.AirportAppService;
import airlinesystem.dao.RouteAppService;
import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public class RouteBusiness {
	
	private static final RouteBusiness routeBusiness = new RouteBusiness();
	
	private RouteAppService routeAppService;
	
	private AirportAppService airportAppService;
	
	private RouteBusiness()
	{
		
	}
	
	public static RouteBusiness getInstance()
	{
		return routeBusiness;
	}
	
	public Route find(Long id)
	{
		routeAppService = RouteAppService.getInstance();
		
		Route route = null;
		try {
			route = routeAppService.find(id);
		} catch (ObjetoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return route;
	}
	
	public List<Route> find(String origin, String destiny, Date departureDate)
	{
		routeAppService = RouteAppService.getInstance();
		
		airportAppService = AirportAppService.getInstance();
		
		//TODO obter id do aeroporto pedido
		//ideal eh que ajax preencha automaticamente os aeroportos possiveis na tela
		
		Airport originAirport = airportAppService.findByName(origin);
		
		Airport destinyAirport = airportAppService.findByName(destiny);
		 
		Date maxDepartureDate = getMaxDepartureDate(departureDate);
		
		Date minDepartureDate = getMinDepartureDate(departureDate);
		
		List<Route> routes = routeAppService.find(originAirport, destinyAirport, minDepartureDate, maxDepartureDate);
		
		return routes;
		
	}
	
	private Date getMaxDepartureDate(Date date)
	{
		Calendar cal = Calendar.getInstance(); 
		
		cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return cal.getTime();
	}
	
	private Date getMinDepartureDate(Date date)
	{
		Calendar cal = Calendar.getInstance(); 
		
		cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		
		return cal.getTime();
	}
	
	public List<Route> findAll() {
		
		routeAppService = RouteAppService.getInstance();
		
		List<Route> routes = routeAppService.findAll(new Date());
		
		return routes;
	}
	
}
