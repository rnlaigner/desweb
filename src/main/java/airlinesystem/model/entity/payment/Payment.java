package airlinesystem.model.entity.payment;
 
import airlinesystem.model.exception.PaymentException;

public abstract class Payment 
{
    private final int paymentNumber;
    
    public Payment(int paymentNumber) 
    {
        this.paymentNumber = paymentNumber;
        
    }
    
    public int getPaymentNumber()
    {
        return this.paymentNumber;
    }
    
    public abstract void makePayment() throws PaymentException;
    
    public abstract String getPaymentInformation();
    
}
