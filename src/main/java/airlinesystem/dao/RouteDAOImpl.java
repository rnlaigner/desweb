package airlinesystem.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.enums.SeatCategory;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.utils.JPAUtil;

public class RouteDAOImpl implements RouteDAO
{	
	@SuppressWarnings("unchecked")
	@Override
	public List<Route> findRoutes(Airport origin, Airport destiny, Date departureDate, Date returnDate, SeatCategory seatCategory) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<Route> routes = em
					.createQuery("select r from Route r " +
						     "order by p.id asc")
				.getResultList();
			
//		"where email = :email and password = :password")
//			.setParameter("email", email).setParameter("password", password).getSingleResult();

			return routes;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
}