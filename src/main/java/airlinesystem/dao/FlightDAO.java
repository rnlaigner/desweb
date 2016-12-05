package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.Flight;
import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public interface FlightDAO
{	
	public long add(Flight flight); 

	public void edit(Flight flight)
		throws ObjetoNaoEncontradoException; 
	
	public void remove(long id) 
		throws ObjetoNaoEncontradoException; 
	
	public Flight retrieveFlight(long numero) 
		throws ObjetoNaoEncontradoException;

	public List<Flight> retrieveFlights(User user);
}