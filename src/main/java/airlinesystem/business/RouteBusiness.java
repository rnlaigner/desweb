package airlinesystem.business;

import java.util.ArrayList;
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
	
	public List<Route> findRoutes(String origin, String destiny, Date departureDate, String seatCategory)
	{
		routeAppService = RouteAppService.getInstance();
		
		airportAppService = AirportAppService.getInstance();
		
		//TODO obter id do aeroporto pedido (fazer isso por ora)
		//ideal eh que ajax preencha automaticamente os aeroportos possiveis na tela
		
		Airport originAirport = airportAppService.findByName(origin);
		
		Airport destinyAirport = airportAppService.findByName(destiny);
		
		List<Route> routes = routeAppService.findRoutes(originAirport, destinyAirport, departureDate);
		
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
