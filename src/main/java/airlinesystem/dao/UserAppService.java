package airlinesystem.dao;

import java.util.List;

import airlinesystem.model.entity.User;
import airlinesystem.model.exception.InfraestruturaException;
import airlinesystem.model.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class UserAppService
{	
	private static final UserDAO userDAO = FabricaDeDAOs.getDAO(UserDAO.class);

	private static final UserAppService userAppService = new UserAppService();
	
	private UserAppService()
	{
		
	}
	
	public static UserAppService getInstance()
	{
		return userAppService;
	}
	
	public long inclui(User umUser) 
	{	try
		{	
		
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			long numero = userDAO.inclui(umUser);
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

	public void altera(User umUser) throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			userDAO.altera(umUser);

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
	
	public void exclui(long numero) 
		throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			userDAO.exclui(numero);

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

	public User recuperaUmUser(long numero) 
		throws ObjetoNaoEncontradoException
	{	
		try
		{	User umUser = userDAO.recuperaUmUser(numero);
			
			return umUser;
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ObjetoNaoEncontradoException("User n�o encontrado");
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}

	public User recuperaUmUser(String email, String password) 
			throws ObjetoNaoEncontradoException
		{	
			try
			{	User umUser = userDAO.recuperaUmUser(email,password);
				
				return umUser;
			} 
			catch(ObjetoNaoEncontradoException e)
			{	throw new ObjetoNaoEncontradoException("User n�o encontrado");
			}
			finally
			{   JPAUtil.closeEntityManager();
			}
		}
	
	public List<User> recuperaUsers() 
	{	try
		{	List<User> users = userDAO.recuperaUsers();

			return users;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
}