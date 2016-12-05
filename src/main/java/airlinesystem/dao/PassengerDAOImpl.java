package airlinesystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import airlinesystem.entity.Passenger;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class PassengerDAOImpl implements PassengerDAO
{	
	@Override
	public long add(Passenger passenger) {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			em.persist(passenger);
			
			return passenger.getId();
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	@Override
	public void edit(Passenger passenger) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			Passenger aPassenger = em.find(Passenger.class, passenger.getId(), LockModeType.PESSIMISTIC_WRITE);
			
			if(aPassenger == null)
			{	throw new ObjetoNaoEncontradoException("Flight não existe");
			}
		
			em.merge(aPassenger);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@Override
	public Passenger retrievePassenger(long id) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			Passenger aPassenger = (Passenger)em
				.find(Passenger.class, new Long(id));
			
			if (aPassenger == null)
			{	throw new ObjetoNaoEncontradoException("Passenger não existe");
			}

			return aPassenger;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@Override
	public void remove(long id) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();
		
			Passenger passenger = em.find(Passenger.class, id, LockModeType.PESSIMISTIC_WRITE);
			
			if(passenger == null)
			{	throw new ObjetoNaoEncontradoException("Passenger não existe");
			}
	
			em.remove(passenger);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

}