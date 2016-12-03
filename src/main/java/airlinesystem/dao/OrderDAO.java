package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.Order;
import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public interface OrderDAO
{	
	public long add(Order umUser); 

	public void edit(Order umUser)
		throws ObjetoNaoEncontradoException; 
	
	public void remove(long id) 
		throws ObjetoNaoEncontradoException; 
	
	public Order retrieveOrder(long numero) 
		throws ObjetoNaoEncontradoException;

	public List<Order> retrieveOrders(User user); 
	
}