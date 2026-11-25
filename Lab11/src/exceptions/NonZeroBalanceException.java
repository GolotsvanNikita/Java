package exceptions;

public class NonZeroBalanceException extends AccountException
{
    public NonZeroBalanceException(String message)
    {
        super(message);
    }
}