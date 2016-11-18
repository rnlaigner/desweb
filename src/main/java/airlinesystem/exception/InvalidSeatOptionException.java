/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.exception;

import static airlinesystem.constants.Constants.INVALID_SEAT_OPTION;

/**
 *
 * @author Rodrigo
 */
public class InvalidSeatOptionException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 9213187382196136424L;

	public InvalidSeatOptionException()
    {
        super(INVALID_SEAT_OPTION);
    }
}
