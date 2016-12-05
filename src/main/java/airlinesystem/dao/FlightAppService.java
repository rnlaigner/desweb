package airlinesystem.dao;

import airlinesystem.entity.Flight;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class FlightAppService
{	
	private static final FlightDAO flightDAO = FabricaDeDAOs.getDAO(FlightDAO.class);

	private static final FlightAppService flightAppService = new FlightAppService();
	
	private FlightAppService()
	{
		
	}
	
	public static FlightAppService getInstance()
	{
		return flightAppService;
	}
	
	public long add(Flight aFlight) 
	{	try
		{	
		
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			long numero = flightDAO.add(aFlight);
			// commita a transa��o
			JPAUtil.commitTransaction();
				
			return numero;
		} 
		catch(InfraestruturaException e)
		{	try
			{	
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do primeiro
			catch(InfraestruturaException ie)
			{				
			}
			// propago erro do primero
		    throw e;
		}
		finally
	    {   
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}

	public void edit(Flight aFlight) throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			flightDAO.edit(aFlight);

			JPAUtil.commitTransaction();
		} 
		catch(ObjetoNaoEncontradoException e)
		{	
			JPAUtil.rollbackTransaction();

			throw new ObjetoNaoEncontradoException("User n�o encontrado");
		}
		catch(InfraestruturaException e)
		{	try
			{	JPAUtil.rollbackTransaction();
			}
			catch(InfraestruturaException ie)
			{				
			}

		    throw e;
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
	public void remove(long numero) 
		throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			flightDAO.remove(numero);

			JPAUtil.commitTransaction();
		} 
		catch(ObjetoNaoEncontradoException e)
		{	
			JPAUtil.rollbackTransaction();

		    throw new ObjetoNaoEncontradoException("User n�o encontrado");
		}
		catch(InfraestruturaException e)
		{	try
			{	JPAUtil.rollbackTransaction();
			}
			catch(InfraestruturaException ie)
			{				
			}

		    throw e;
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}

	public Flight retrieveFlight(long numero) 
		throws ObjetoNaoEncontradoException
	{	
		try
		{	Flight aFlight = flightDAO.retrieveFlight(numero);
			
			return aFlight;
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ObjetoNaoEncontradoException("Flight n�o encontrado");
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
}