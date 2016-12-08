package airlinesystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import airlinesystem.entity.Flight;
import airlinesystem.entity.User;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class FlightDAOImpl implements FlightDAO
{	
	@Override
	public long add(Flight flight) {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			em.persist(flight);
			
			return flight.getId();
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	@Override
	public void edit(Flight flight) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			Flight aFlight = em.find(Flight.class, flight.getId(), LockModeType.PESSIMISTIC_WRITE);
			
			if(aFlight == null)
			{	throw new ObjetoNaoEncontradoException("Flight não existe");
			}
		
			em.merge(flight);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@Override
	public Flight retrieveFlight(long id) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			Flight aFlight = (Flight)em
				.find(Flight.class, new Long(id));
			
			if (aFlight == null)
			{	throw new ObjetoNaoEncontradoException("Flight não existe");
			}

			return aFlight;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@Override
	public void remove(long id) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();
		
			Flight flight = em.find(Flight.class, id, LockModeType.PESSIMISTIC_WRITE);
			
			if(flight == null)
			{	throw new ObjetoNaoEncontradoException("Usuário não existe");
			}
	
			em.remove(flight);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> retrieveFlights(User user) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<Flight> flights = em
				.createQuery("select f from Flight f " +
						"where order.user = :user")
				.setParameter("user", user)
				.getResultList();

			return flights;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
	
}