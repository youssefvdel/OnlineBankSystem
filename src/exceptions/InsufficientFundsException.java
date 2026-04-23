/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.exceptions;

/**
<<<<<<< Updated upstream
 *Thrown when withdrawal/transfer exceeds account balance.
 * @author tareq
 */
public class InsufficientFundsException extends Exception{
    private final double balance;
    private final double amount;

 
    public InsufficientFundsException(double balance, double amount) {
        super("insufficient funds. Balance: "+ balance +", requsted"+amount);
        this.balance = balance;
        this.amount = amount;
    }

    public double getBalance() {
=======
 * Custom exception thrown when withdrawal amount exceeds available balance.
 * @author Tareq
 */
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
>>>>>>> Stashed changes
        return balance;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
