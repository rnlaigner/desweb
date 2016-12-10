package airlinesystem.business;

import airlinesystem.dao.SeatAppService;
import airlinesystem.entity.Seat;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public class SeatBusiness {

	private static final SeatBusiness seatBusiness = new SeatBusiness();
	
	private SeatAppService seatAppService;
	
	private SeatBusiness()
	{
		
	}
	
	public static SeatBusiness getInstance()
	{
		return seatBusiness;
	}
	
	
	public Seat find(long id) throws ObjetoNaoEncontradoException {
		
	    seatAppService = SeatAppService.getInstance();
	    
	    return seatAppService.find(id);
	}
	
	public Seat findBySeatNumber(String seatNumber) throws ObjetoNaoEncontradoException {
		
	    seatAppService = SeatAppService.getInstance();
	    
	    return seatAppService.findBySeatNumber(seatNumber);
	}
}
