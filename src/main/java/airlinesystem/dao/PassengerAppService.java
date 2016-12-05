package airlinesystem.dao;

import airlinesystem.entity.Passenger;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class PassengerAppService
{	
	private static final PassengerDAO passengerDAO = FabricaDeDAOs.getDAO(PassengerDAO.class);

	private static final PassengerAppService passengerAppService = new PassengerAppService();
	
	private PassengerAppService()
	{
		
	}
	
	public static PassengerAppService getInstance()
	{
		return passengerAppService;
	}
	
	public long add(Passenger passenger) 
	{	try
		{	
		
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			long numero = passengerDAO.add(passenger);
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

	public void edit(Passenger passenger) throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			passengerDAO.edit(passenger);

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

			passengerDAO.remove(numero);

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

	public Passenger retrieveFlight(long numero) 
		throws ObjetoNaoEncontradoException
	{	
		try
		{	Passenger passenger = passengerDAO.retrievePassenger(numero);
			
			return passenger;
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ObjetoNaoEncontradoException("Flight n�o encontrado");
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
}