package airlinesystem.model.exception;

public abstract class LoginException extends RuntimeException
{
    private static final long serialVersionUID = 1276727019536603615L;

     /**
     *
     * @param message
     */
    public LoginException(String message) 
    {
        super(message);
    }
}
