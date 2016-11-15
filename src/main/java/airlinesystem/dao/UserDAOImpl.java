package airlinesystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import airlinesystem.model.entity.User;
import airlinesystem.model.exception.InfraestruturaException;
import airlinesystem.model.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class UserDAOImpl implements UserDAO
{	
	public long inclui(User umUser) 
	{	try
		{	EntityManager em = JPAUtil.getEntityManager();

			em.persist(umUser);
			
			return umUser.getId();
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	public void altera(User umUser) 
		throws ObjetoNaoEncontradoException 
	{	try
		{	EntityManager em = JPAUtil.getEntityManager();

			User user = em.find(User.class, umUser.getId(), LockModeType.PESSIMISTIC_WRITE);
			
			if(user == null)
			{	throw new ObjetoNaoEncontradoException("Usuário não existe");
			}
		
			em.merge(umUser);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	public void exclui(long id) throws ObjetoNaoEncontradoException 
	{	try
		{	EntityManager em = JPAUtil.getEntityManager();
		
			User user = em.find(User.class, id, LockModeType.PESSIMISTIC_WRITE);
			
			if(user == null)
			{	throw new ObjetoNaoEncontradoException("Usuário não existe");
			}
	
			em.remove(user);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	public User recuperaUmUser(long id) 
		throws ObjetoNaoEncontradoException 
	{	try
		{	EntityManager em = JPAUtil.getEntityManager();

			User umUser = (User)em
				.find(User.class, new Long(id));
			
			if (umUser == null)
			{	throw new ObjetoNaoEncontradoException("Usuário não existe");
			}

			return umUser;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	public User recuperaUmUserComLock(long id) 
		throws ObjetoNaoEncontradoException 
	{	try
		{	EntityManager em = JPAUtil.getEntityManager();

			User umUser = em.find(User.class, id, LockModeType.PESSIMISTIC_WRITE);

			if (umUser == null)
			{	throw new ObjetoNaoEncontradoException("Usuário não existe");
			}

			return umUser;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> recuperaUsers()
	{	try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<User> users = em
				.createQuery("select u from User u " +
						     "order by u.id asc")
				.getResultList();

			return users;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	@Override
	public User recuperaUmUser(String email, String password) throws ObjetoNaoEncontradoException {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			User user = (User) em
				.createQuery("select u from User u " +
						     "where email = :email and password = :password")
				.setParameter("email", email).setParameter("password", password).getSingleResult();

			return user;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
}