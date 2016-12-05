package airlinesystem.business;

import airlinesystem.dao.FlightAppService;
import airlinesystem.entity.Flight;
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
	
}
