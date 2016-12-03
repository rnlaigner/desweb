package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.User;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
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
		
			// inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			long numero = userDAO.add(umUser);
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

	public void altera(User umUser) throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			userDAO.edit(umUser);

			JPAUtil.commitTransaction();
		} 
		catch(ObjetoNaoEncontradoException e)
		{	
			JPAUtil.rollbackTransaction();

			throw new ObjetoNaoEncontradoException("User não encontrado");
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

			userDAO.remove(numero);

			JPAUtil.commitTransaction();
		} 
		catch(ObjetoNaoEncontradoException e)
		{	
			JPAUtil.rollbackTransaction();

		    throw new ObjetoNaoEncontradoException("User não encontrado");
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
		{	User umUser = userDAO.retrieveUser(numero);
			
			return umUser;
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ObjetoNaoEncontradoException("User não encontrado");
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}

	public User recuperaUmUser(String email, String password) 
			throws ObjetoNaoEncontradoException
		{	
			try
			{	User umUser = userDAO.retrieveUser(email,password);
				
				return umUser;
			} 
			catch(ObjetoNaoEncontradoException e)
			{	throw new ObjetoNaoEncontradoException("User não encontrado");
			}
			finally
			{   JPAUtil.closeEntityManager();
			}
		}
	
	public List<User> recuperaUsers() 
	{	try
		{	List<User> users = userDAO.retrieveUsers();

			return users;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
}