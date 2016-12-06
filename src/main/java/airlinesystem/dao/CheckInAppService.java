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
		
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			long numero = checkInDAO.add(checkIn);
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

	public CheckIn find(long numero) 
		throws ObjetoNaoEncontradoException
	{	
		try
		{	CheckIn checkIn = checkInDAO.find(numero);
			
			return checkIn;
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ObjetoNaoEncontradoException("User n�o encontrado");
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
}