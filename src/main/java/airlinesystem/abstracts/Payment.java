package airlinesystem.abstracts;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;

import airlinesystem.exception.PaymentException;

import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
    private int paymentNumber;
    
    private Date date;
    
    public Payment() 
    {
        
    }
    
    public Payment(int paymentNumber) 
    {
        this.paymentNumber = paymentNumber;
        
    }
    
    public int getPaymentNumber()
    {
        return this.paymentNumber;
    }
    
    public abstract boolean makePayment() throws PaymentException;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
