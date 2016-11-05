/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.exception;

import static airlinesystem.model.constants.Constants.INVALID_FLIGHT_OPTION;

/**
 *
 * @author Rodrigo
 */
public class InvalidFlightOptionException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3314567505519078417L;

	public InvalidFlightOptionException()
    {
        super(INVALID_FLIGHT_OPTION);
    }
}
