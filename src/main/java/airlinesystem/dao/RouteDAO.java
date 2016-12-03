package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public interface RouteDAO
{	
	public List<Route> find(Airport origin, Airport destiny, Date departureDate, Date maxDepartureDate);

	public List<Route> findAll(Date departureDate);
	
	public Route find(long id) throws ObjetoNaoEncontradoException;
}