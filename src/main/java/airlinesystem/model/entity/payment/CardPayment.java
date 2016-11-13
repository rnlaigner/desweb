/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.entity.payment;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="card_payment")
public class CardPayment extends Payment
{
	
	public CardPayment() 
	{
    }

    public CardPayment(int paymentNumber) {
        super(paymentNumber);
    }

    @Override
    public void makePayment() 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPaymentInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
