package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.Order;
import airlinesystem.entity.User;
import airlinesystem.exception.InfraestruturaException;
import airlinesystem.exception.ObjetoNaoEncontradoException;
import airlinesystem.utils.JPAUtil;

public class OrderAppService
{	
	private static final OrderDAO orderDAO = FabricaDeDAOs.getDAO(OrderDAO.class);

	private static final OrderAppService orderAppService = new OrderAppService();
	
	private OrderAppService()
	{
		
	}
	
	public static OrderAppService getInstance()
	{
		return orderAppService;
	}
	
	public long add(Order anOrder) 
	{	try
		{	
		
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			long numero = orderDAO.add(anOrder);
			// commita a transa��o
			JPAUtil.commitTransaction();
				
			return numero;
		} 
		catch(InfraestruturaException e)
		{	try
			{	
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do primeiro
			catch(InfraestruturaException ie)
			{				
			}
			// propago erro do primero
		    throw e;
		}
		finally
	    {   
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}

	public void edit(Order anOrder) throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			orderDAO.edit(anOrder);

			JPAUtil.commitTransaction();
		} 
		catch(ObjetoNaoEncontradoException e)
		{	
			JPAUtil.rollbackTransaction();

			throw new ObjetoNaoEncontradoException("Compra n�o encontrada");
		}
		catch(InfraestruturaException e)
		{	try
			{	JPAUtil.rollbackTransaction();
			}
			catch(InfraestruturaException ie)
			{				
			}

		    throw e;
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
	public void remove(long numero) 
		throws ObjetoNaoEncontradoException
	{	try
		{	JPAUtil.beginTransaction();

			orderDAO.remove(numero);

			JPAUtil.commitTransaction();
		} 
		catch(ObjetoNaoEncontradoException e)
		{	
			JPAUtil.rollbackTransaction();

		    throw new ObjetoNaoEncontradoException("Compra n�o encontrada");
		}
		catch(InfraestruturaException e)
		{	try
			{	JPAUtil.rollbackTransaction();
			}
			catch(InfraestruturaException ie)
			{				
			}

		    throw e;
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}

	public Order retrieveOrder(long numero) 
		throws ObjetoNaoEncontradoException
	{	
		try
		{	Order anOrder = orderDAO.retrieveOrder(numero);
			
			return anOrder;
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ObjetoNaoEncontradoException("Compra n�o encontrada");
		}
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
	
	public List<Order> retrieveOrders(User user) 
	{	try
		{	List<Order> orders = orderDAO.retrieveOrders(user);

			return orders;
		} 
		finally
		{   JPAUtil.closeEntityManager();
		}
	}
}