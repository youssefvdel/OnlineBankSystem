package exceptions;

/**

 *Thrown when withdrawal/transfer exceeds account balance.
 * @author tareq
**/
public class InsufficientFundsException extends Exception 
{
    private double balance;
    private double amount;
    
    /**
     * Create exception with balance and attempted amount.
     */
    public InsufficientFundsException(double balance, double amount) 
    {
        super("Insufficient funds Balance: " + balance + ", Attempted: " + amount);
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
