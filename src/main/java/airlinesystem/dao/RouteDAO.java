package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import airlinesystem.entity.Route;

public interface RouteDAO
{	
	public List<Route> findRoutes(String origin, String destiny, Date departureDate);
}