package exceptions;

public class InvalidPasswordException extends AccountException
{
    public InvalidPasswordException(String message)
    {
        super(message);
    }
}