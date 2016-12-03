package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public interface UserDAO
{	
	public long add(User umUser); 

	public void edit(User umUser)
		throws ObjetoNaoEncontradoException; 
	
	public void remove(long id) 
		throws ObjetoNaoEncontradoException; 
	
	public User retrieveUser(long numero) 
		throws ObjetoNaoEncontradoException; 
	
	public User retrieveUser(String email, String password) 
			throws ObjetoNaoEncontradoException;
	
	public List<User> retrieveUsers();
}