package exceptions;

/**
 * Custom exception thrown when an account number is not found in the system.
 * @author Yosef Osama - 255796
 */
public class InvalidAccountException extends Exception
{

    private final String accountNumber;

    /**
     * Create exception with invalid account number.
     */
    public InvalidAccountException(String accountNumber)
    {
        super("Account not found: " + accountNumber);
        this.accountNumber = accountNumber;
    }

    /**
     * Create exception wrapping another error.
     */
    public InvalidAccountException(String accountNumber, Throwable cause)
    {
        super("Account not found: " + accountNumber, cause);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Return error message for GUI.
     */
    public String getUserMessage()
    {
        return "Account '" + accountNumber + "' does not exist. Please verify the number and try again.";
    }
}