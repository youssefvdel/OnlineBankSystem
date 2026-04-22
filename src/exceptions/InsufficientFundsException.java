/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.exceptions;

/**
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
        return balance;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
