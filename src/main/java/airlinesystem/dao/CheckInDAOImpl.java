package airlinesystem.dao;

import javax.persistence.EntityManager;

import airlinesystem.entity.CheckIn;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class CheckInDAOImpl implements CheckInDAO
{	
	public long add(CheckIn checkIn) 
	{	try
		{	EntityManager em = JPAUtil.getEntityManager();

			em.persist(checkIn);
			
			return checkIn.getId();
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	

	public CheckIn find(long id) throws ObjetoNaoEncontradoException 
	{	try
		{	EntityManager em = JPAUtil.getEntityManager();

			CheckIn checkIn = (CheckIn)em
				.find(CheckIn.class, new Long(id));
			
			if (checkIn == null)
			{	throw new ObjetoNaoEncontradoException("CheckIn não existe");
			}

			return checkIn;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
}