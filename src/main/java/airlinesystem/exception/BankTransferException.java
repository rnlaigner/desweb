/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.exception;

/**
 *
 * @author Rodrigo
 */
public class BankTransferException extends PaymentException 
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3856164925103899500L;

	public BankTransferException(String message) 
    {
        super(message);
    }
    
}
