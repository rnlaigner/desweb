package airlinesystem.dao;

import java.util.Calendar;
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
	public List<Route> findRoutes(Airport origin, Airport destiny, Date departureDate) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();
			
			//TODO levar isso para o business 
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(departureDate);
			
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			
			Date maxDepartureDate = cal.getTime();
			
			cal.set(Calendar.HOUR_OF_DAY, 00);
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);
			
			departureDate = cal.getTime();

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
}