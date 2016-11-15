/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import airlinesystem.model.abstracts.Payment;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="paypal_payment")
public class PayPalPayment extends Payment
{
	
	public PayPalPayment()
	{
    
	}

    public PayPalPayment(int paymentNumber) {
        super(paymentNumber);
    }

    /**
     *
     */
    @Override
    public void makePayment() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPaymentInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
