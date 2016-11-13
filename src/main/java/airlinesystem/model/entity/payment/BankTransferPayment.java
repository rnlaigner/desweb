/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.entity.payment;

import javax.persistence.Entity;

/**
 *
 * @author Rodrigo
 */
@Entity
public class BankTransferPayment extends Payment
{
	
	public BankTransferPayment() {
        
    }

    public BankTransferPayment(int paymentNumber) {
        super(paymentNumber);
    }

    @Override
    public void makePayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPaymentInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
