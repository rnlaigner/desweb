package airlinesystem.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import airlinesystem.dao.AirportAppService;
import airlinesystem.dao.RouteAppService;
import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.entity.Seat;

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
	
	public List<Route> find(String origin, String destiny, Date departureDate)
	{
		routeAppService = RouteAppService.getInstance();
		
		airportAppService = AirportAppService.getInstance();
		
		//TODO obter id do aeroporto pedido (fazer isso por ora)
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
	
	private List<Route> filterSeatCategory(List<Route> routes, String seatCategory)
	{
		List<Route> filteredRoutes = new ArrayList<Route>();
		
		for(Route route : routes)
		{
			if(existsSeatCategory(route.getAirplane().getSeats(),seatCategory))
			{
				filteredRoutes.add(route);
			}
		}
		
		return filteredRoutes;
	}

	private boolean existsSeatCategory(List<Seat> seats, String seatCategory)
	{
		for(Seat seat : seats)
		{
			if(seat.getCategory().getName().equals(seatCategory))
			{
				return true;
			}
		}
		return false;
	}
	
}
