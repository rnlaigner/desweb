package airlinesystem.business;

import airlinesystem.dao.CheckInAppService;
import airlinesystem.entity.CheckIn;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public class CheckInBusiness {

	private static final CheckInBusiness checkInBusiness = new CheckInBusiness();
	
	private CheckInAppService checkInAppService;
	
	private CheckInBusiness()
	{
		
	}
	
	public static CheckInBusiness getInstance()
	{
		return checkInBusiness;
	}
	
	public long save(CheckIn flight){
		
		checkInAppService = CheckInAppService.getInstance();
	    
	    return checkInAppService.add(flight);
	}
	
	public CheckIn find(long id) throws ObjetoNaoEncontradoException {
		
	    checkInAppService = CheckInAppService.getInstance();
	    
	    return checkInAppService.find(id);
	}
}
