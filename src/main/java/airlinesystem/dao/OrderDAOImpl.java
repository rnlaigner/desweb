package airlinesystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import airlinesystem.entity.Order;
import airlinesystem.entity.User;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class OrderDAOImpl implements OrderDAO
{	
	@Override
	public long add(Order anOrder) {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			em.persist(anOrder);
			
			return anOrder.getId();
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}

	@Override
	public void edit(Order anOrder) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			Order order = em.find(Order.class, anOrder.getId(), LockModeType.PESSIMISTIC_WRITE);
			
			if(order == null)
			{	throw new ObjetoNaoEncontradoException("Compra não existe");
			}
		
			em.merge(anOrder);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@Override
	public Order retrieveOrder(long id) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();

			Order anOrder = (Order)em
				.find(Order.class, new Long(id));
			
			if (anOrder == null)
			{	throw new ObjetoNaoEncontradoException("Compra não existe");
			}

			return anOrder;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@Override
	public void remove(long id) throws ObjetoNaoEncontradoException {
		try
		{	EntityManager em = JPAUtil.getEntityManager();
		
			Order order = em.find(Order.class, id, LockModeType.PESSIMISTIC_WRITE);
			
			if(order == null)
			{	throw new ObjetoNaoEncontradoException("Usuário não existe");
			}
	
			em.remove(order);
		}
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> retrieveOrders(User user) {
		try
		{	
			EntityManager em = JPAUtil.getEntityManager();

			List<Order> orders = em
				.createQuery("select o from Order o " +
						"where user = :user")
				.setParameter("user", user)
				.getResultList();

			return orders;
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	
	}
}