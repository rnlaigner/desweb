package airlinesystem.dao;

import airlinesystem.entity.Airport;
import airlinesystem.utils.JPAUtil;

public class AirportAppService
{	
	private static final AirportDAO airportDAO = FabricaDeDAOs.getDAO(AirportDAO.class);

	private static final AirportAppService airportAppService = new AirportAppService();
	
	private AirportAppService()
	{
		
	}
	
	public static AirportAppService getInstance()
	{
		return airportAppService;
	}
	
	public Airport findByName(String name) 
	{	
		try
		{	
			Airport airport = airportDAO.findByName(name);

			return airport;
		} 
		finally
		{   
			JPAUtil.closeEntityManager();
		}
	}
}