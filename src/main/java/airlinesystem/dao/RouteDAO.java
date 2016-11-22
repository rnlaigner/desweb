package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;

public interface RouteDAO
{	
	public List<Route> find(Airport origin, Airport destiny, Date departureDate, Date maxDepartureDate);

	public List<Route> findAll(Date departureDate);
}