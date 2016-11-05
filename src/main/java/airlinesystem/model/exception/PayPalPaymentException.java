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
public class PayPalPaymentException extends PaymentException 
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6219688707235638783L;

	public PayPalPaymentException(String message) 
    {
        super(message);
    }
    
}
