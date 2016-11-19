package airlinesystem.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import airlinesystem.dao.RouteAppService;
import airlinesystem.entity.Route;
import airlinesystem.entity.Seat;

public class RouteBusiness {
	
	private static final RouteBusiness routeBusiness = new RouteBusiness();
	
	private RouteAppService routeAppService;
	
	private RouteBusiness()
	{
		
	}
	
	public static RouteBusiness getInstance()
	{
		return routeBusiness;
	}
	
	public List<Route> findRoutes(String origin, String destiny, Date departureDate, String seatCategory)
	{
		routeAppService = RouteAppService.getInstance();
		
		List<Route> routes = routeAppService.findRoutes(origin, destiny, departureDate);
		
		return filterSeatCategory(routes, seatCategory);
		
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
