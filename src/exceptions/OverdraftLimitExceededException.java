package exceptions;

/**
 * Custom exception thrown when a transaction exceeds the current account overdraft limit.
 * @author Yosef Osama - 255796
 */
public class OverdraftLimitExceededException extends Exception 
{
    
    private final double overdraftLimit;
    private final double amount;
    
    /**
     * Create exception with overdraft limit and attempted amount.
     */
    public OverdraftLimitExceededException(double overdraftLimit, double amount) 
    {
        super("Overdraft limit exceeded Limit:$ " + overdraftLimit + ", Attempted:$ "+ amount);
        this.overdraftLimit = overdraftLimit;
        this.amount = amount;
    }
    
    /**
     * Create exception wrapping another error.
     */
    public OverdraftLimitExceededException(double overdraftLimit, double amount, Throwable cause) 
    {
        super("Overdraft limit exceeded Limit:$ "+ overdraftLimit + ", Attempted:$ " + amount, cause);
        this.overdraftLimit = overdraftLimit;
        this.amount = amount;
    }
    
    public double getOverdraftLimit() 
    {
        return overdraftLimit;
    }
    
    public double getAmount() 
    {
        return amount;
    }
    
    /**
     * Return error message for GUI.
     */
    public String getUserMessage() 
    {
        return "Transaction declined: Requested amount :$ " + amount + ", exceeds your overdraft limit:$ "+ overdraftLimit;
    }
}
