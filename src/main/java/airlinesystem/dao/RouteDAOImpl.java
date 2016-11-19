package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import airlinesystem.entity.Route;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.utils.JPAUtil;

public class RouteDAOImpl implements RouteDAO
{	
	@SuppressWarnings("unchecked")
	@Override
	public List<Route> findRoutes(String origin, String destiny, Date departureDate) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<Route> routes = em
					.createQuery("select r from Route r " +
							"where origin = :origin and destiny = :destiny" +
							"and departure = :departure")
					.setParameter("origin", origin)
					.setParameter("destiny", destiny)
					.setParameter("departure", departureDate)
					.getResultList();

			return routes;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
}