package airlinesystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import airlinesystem.entity.Airplane;
import airlinesystem.entity.Seat;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.utils.JPAUtil;

public class SeatDAOImpl implements SeatDAO
{	
	@Override
	public Seat find(long id) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			Seat seat = (Seat)em
					.find(Seat.class, new Long(id));

			return seat;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Seat> findByAirplane(Airplane airplane) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<Seat> seats = em
				.createQuery("select s from Seat s " +
						"where airplane = :airplane")
				.setParameter("airplane", airplane)
				.getResultList();

			return seats;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
}