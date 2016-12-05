package airlinesystem.dao;

import airlinesystem.entity.Passenger;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public interface PassengerDAO
{	
	public long add(Passenger flight); 

	public void edit(Passenger flight)
		throws ObjetoNaoEncontradoException; 
	
	public void remove(long id) 
		throws ObjetoNaoEncontradoException; 
	
	public Passenger retrievePassenger(long numero) 
		throws ObjetoNaoEncontradoException;
}