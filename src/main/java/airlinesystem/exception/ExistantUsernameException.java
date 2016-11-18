/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.exception;

import static airlinesystem.constants.Constants.EXISTANT_USERNAME;

/**
 *
 * @author Rodrigo
 */
public class ExistantUsernameException extends LoginException
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2985511514581902883L;

	public ExistantUsernameException() 
    {
        super(EXISTANT_USERNAME);
    }
    
}
