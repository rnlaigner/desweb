package airlinesystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import airlinesystem.entity.Airport;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.utils.JPAUtil;

public class AirportDAOImpl implements AirportDAO
{

	@Override
	public Airport findByName(String name) {

		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			Airport airport = (Airport) em
				.createQuery("select a from Airport a " +
						     "where name = :name")
				.setParameter("name", name).getSingleResult();

			return airport;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	@Override
	public List<Airport> findByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}