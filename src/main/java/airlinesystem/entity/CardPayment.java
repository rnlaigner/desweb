/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import airlinesystem.abstracts.Payment;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="card_payment")
public class CardPayment extends Payment
{
	
	private String cardNumber;

	private Date expiringDate;
	
	private String securityCode;
	
	private String cardHolder;
	
	private String cardHolderCPF;
	
	public CardPayment() 
	{
    }

    public CardPayment(int paymentNumber) {
        super(paymentNumber);
    }
    
    public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiringDate() {
		return expiringDate;
	}

	public void setExpiringDate(Date expiringDate) {
		this.expiringDate = expiringDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardHolderCPF() {
		return cardHolderCPF;
	}

	public void setCardHolderCPF(String cardHolderCPF) {
		this.cardHolderCPF = cardHolderCPF;
	}

    @Override
    public boolean makePayment() 
    {
        return true;
    }
    
}
