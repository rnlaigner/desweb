/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.exception;

import static airlinesystem.model.constants.Constants.WRONG_PASSWORD;

/**
 *
 * @author Rodrigo
 */
public class WrongPasswordException extends LoginException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8954144000914721229L;

	public WrongPasswordException() 
    {
        super(WRONG_PASSWORD);
    }
    
}
