package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.Airport;

public interface AirportDAO
{	
	public Airport findByName(String name);
	
	public List<Airport> findByCity(String city);
}