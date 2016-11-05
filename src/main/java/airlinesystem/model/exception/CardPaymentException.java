/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.exception;

/**
 *
 * @author Rodrigo
 */
public class CardPaymentException extends PaymentException 
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -8213843142597167078L;

	public CardPaymentException(String message) 
    {
        super(message);
    }
    
}
