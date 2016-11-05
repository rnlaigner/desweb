/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.login;

import airlinesystem.model.entity.user.User;
import airlinesystem.model.exception.WrongPasswordException;
import airlinesystem.model.exception.WrongUsernameException;
import airlinesystem.persistence.SimulateDB;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Login 
{
    private String username;
    private String password;
    private Date date;
    
    public Login(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.setDate(new Date());
    }
    
    public User authenticate(SimulateDB database)
    {
        List<User> userList = database.retrieveUsers();
        
        for(User user : userList)
        {
            if(user.getUsername().equals(this.username))
            {
                if(user.getPassword().equals(this.password))
                {
                    return user;
                }
                else
                {
                    throw new WrongPasswordException();
                }
            }
        }
        throw new WrongUsernameException();
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
