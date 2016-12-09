package airlinesystem.business;

import airlinesystem.dao.PassengerAppService;
import airlinesystem.entity.Passenger;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public class PassengerBusiness {

	private static final PassengerBusiness passengerBusiness = new PassengerBusiness();
	
	private PassengerAppService passengerAppService;
	
	private PassengerBusiness()
	{
		
	}
	
	public static PassengerBusiness getInstance()
	{
		return passengerBusiness;
	}
	
	public long save(Passenger passenger){
		
		passengerAppService = PassengerAppService.getInstance();
	    
	    return passengerAppService.add(passenger);
	}
	
	public void update(Passenger passenger) throws ObjetoNaoEncontradoException{
		
		passengerAppService = PassengerAppService.getInstance();
	    
	    passengerAppService.edit(passenger);
	}
	
	public Passenger find(long id) throws ObjetoNaoEncontradoException{
		
		passengerAppService = PassengerAppService.getInstance();
	    
	    return passengerAppService.find(id);
	}
}
