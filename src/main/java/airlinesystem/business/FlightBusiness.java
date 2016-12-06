package airlinesystem.business;

import java.util.List;

import airlinesystem.dao.FlightAppService;
import airlinesystem.entity.Flight;
import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public class FlightBusiness {

	private static final FlightBusiness flightBusiness = new FlightBusiness();
	
	private FlightAppService flightAppService;
	
	private FlightBusiness()
	{
		
	}
	
	public static FlightBusiness getInstance()
	{
		return flightBusiness;
	}
	
	public long save(Flight flight){
		
		flightAppService = FlightAppService.getInstance();
	    
	    return flightAppService.add(flight);
	}
	
	public void update(Flight flight) throws ObjetoNaoEncontradoException{
		
		flightAppService = FlightAppService.getInstance();
	    
	    flightAppService.edit(flight);
	}

	public List<Flight> retrieveFlights(User user) throws ObjetoNaoEncontradoException {
		
	    flightAppService = FlightAppService.getInstance();
	    
	    return flightAppService.retrieveFlights(user);
	}
	
	public Flight retrieveFlight(long id) throws ObjetoNaoEncontradoException {
		
	    flightAppService = FlightAppService.getInstance();
	    
	    return flightAppService.retrieveFlight(id);
	}
}
