package exceptions;

/**
 * Custom exception thrown when withdrawal amount exceeds available balance.
 * @author Yosef Osama - 255796
 */
public class InsufficientFundsException extends Exception 
{
    private final double balance;
    private final double amount;
    
    /**
     * Create exception with balance and attempted amount.
     */
    public InsufficientFundsException(double balance, double amount) 
    {
        super("Insufficient funds Balance: $" + balance + ", Attempted: $" + amount);
        this.balance = balance;
        this.amount = amount;
    }
    
    /**
     * Create exception wrapping another error.
     */
    public InsufficientFundsException(double balance, double amount, Throwable cause) 
    {
        super("Insufficient funds Balance: $" + balance + ", Attempted: $" + amount);
        this.balance = balance;
        this.amount = amount;
    }
    
    public double getBalance() 
    {
        return balance;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    /**
     * Return user-friendly error message for GUI.
     */
    public String getUserMessage() 
    {
        return ("Withdrawal failed: Your balance :$"+ balance +" ,is less than the requested amount:$"+ amount);
    }
}