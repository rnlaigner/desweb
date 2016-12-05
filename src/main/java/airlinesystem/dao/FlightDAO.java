package airlinesystem.dao;

import airlinesystem.entity.Flight;
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
}