package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public interface UserDAO
{	
	public long inclui(User umUser); 

	public void altera(User umUser)
		throws ObjetoNaoEncontradoException; 
	
	public void exclui(long id) 
		throws ObjetoNaoEncontradoException; 
	
	public User recuperaUmUser(long numero) 
		throws ObjetoNaoEncontradoException; 
	
	public User recuperaUmUser(String email, String password) 
			throws ObjetoNaoEncontradoException;
	
	public List<User> recuperaUsers();
}