package airlinesystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

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

	@Override
	public void edit(CheckIn checkin) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			CheckIn aCheckIn = em.find(CheckIn.class, checkin.getId(), LockModeType.PESSIMISTIC_WRITE);
			
			if(aCheckIn == null)
			{	throw new ObjetoNaoEncontradoException("Flight não existe");
			}
		
			em.merge(checkin);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}
}