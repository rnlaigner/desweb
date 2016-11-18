package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.enums.SeatCategory;

public interface RouteDAO
{	
	public List<Route> findRoutes(Airport origin, Airport destiny, Date departureDate, Date returnDate, SeatCategory seatCategory);
}