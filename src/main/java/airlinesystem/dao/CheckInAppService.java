package airlinesystem.dao;

import airlinesystem.entity.CheckIn;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class CheckInAppService
{	
	private static final CheckInDAO checkInDAO = FabricaDeDAOs.getDAO(CheckInDAO.class);

	private static final CheckInAppService checkInAppService = new CheckInAppService();
	
	private CheckInAppService()
	{
		
	}
	
	public static CheckInAppService getInstance()
	{
		return checkInAppService;
	}
	
	public long add(CheckIn checkIn) 
	{	try
		{	
		
			// inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			long numero = checkInDAO.add(checkIn);
			// commita a transação
			JPAUtil.commitTransaction();
				
			return numero;
		} 
		catch(InfraestruturaException e)
		{	try
			{	
				// se der erro na transação volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui não propaga pois é em decorrencia do primeiro
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

	public CheckIn find(long numero) 
		throws ObjetoNaoEncontradoException
	{	
		try
		{	CheckIn checkIn = checkInDAO.find(numero);
			
			return checkIn;
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ObjetoNaoEncontradoException("User não encontrado");
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
	public void edit(CheckIn checkin) throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			checkInDAO.edit(checkin);

			JPAUtil.commitTransaction();
		} 
		catch(ObjetoNaoEncontradoException e)
		{	
			JPAUtil.rollbackTransaction();

			throw new ObjetoNaoEncontradoException("Checkin não encontrado");
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
}