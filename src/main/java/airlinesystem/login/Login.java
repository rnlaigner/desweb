/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.login;

import airlinesystem.dao.UserAppService;
import airlinesystem.entity.User;
import airlinesystem.exception.ObjetoNaoEncontradoException;

/**
 *
 * @author Rodrigo
 */
public class Login 
{
    private String email;
    private String password;
    
    private static final UserAppService userAppService = UserAppService.getInstance();
    
    public Login(String email, String password)
    {
        this.email = email;
        this.password = password;
    }
    
    public User authenticate() throws ObjetoNaoEncontradoException
    {
    	User user;
        try {
			user = userAppService.recuperaUmUser(email,password);
		} catch (ObjetoNaoEncontradoException e) {
			throw new ObjetoNaoEncontradoException(e.getMessage());
		}
		return user;
    }

}
