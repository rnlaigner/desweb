package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.Airplane;
import airlinesystem.entity.Seat;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class SeatAppService
{	
	private static final SeatDAO seatDAO = FabricaDeDAOs.getDAO(SeatDAO.class);

	private static final SeatAppService seatAppService = new SeatAppService();
	
	private SeatAppService()
	{
		
	}
	
	public static SeatAppService getInstance()
	{
		return seatAppService;
	}
	

	public Seat find(long id) 
		throws ObjetoNaoEncontradoException
	{	
		try
		{	Seat seat = seatDAO.find(id);
			
			return seat;
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
	public List<Seat> findByAirplane(Airplane airplane) 
	{	try
		{	List<Seat> seats = seatDAO.findByAirplane(airplane);

			return seats;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
	public Seat findBySeatNumber(String seatNumber) 
	{	try
		{	Seat seat = seatDAO.findBySeatNumber(seatNumber);

			return seat;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
}