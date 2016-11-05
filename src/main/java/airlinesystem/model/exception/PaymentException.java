package airlinesystem.model.exception;


public abstract class PaymentException extends RuntimeException
{
    private static final long serialVersionUID = 1209874521536603615L;

    /**
     *
     * @param message
     */
    public PaymentException(String message) 
    {
        super(message);
    }
}
