package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.utils.JPAUtil;

public class RouteDAOImpl implements RouteDAO
{	
	@SuppressWarnings("unchecked")
	@Override
	public List<Route> find(Airport origin, Airport destiny, Date departureDate, Date maxDepartureDate) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<Route> routes = em
					.createQuery("select r from Route r " +
							"where origin = :origin and destiny = :destiny " +
							"and departure >= :departure and departure <= :maxDepartureDate")
					.setParameter("origin", origin)
					.setParameter("destiny", destiny)
					.setParameter("departure", departureDate)
					.setParameter("maxDepartureDate", maxDepartureDate)
					.getResultList();

			return routes;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Route> findAll(Date departureDate) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<Route> routes = em
					.createQuery("select r from Route r " +
							"where departure >= :departure")
					.setParameter("departure", departureDate)
					.getResultList();

			return routes;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
	
	
}