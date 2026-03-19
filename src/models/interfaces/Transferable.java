package models.interfaces;

import models.account.Account;

/**
 * @author Tarek Saeed 252382
 * @see Account //implementation
 * @see Transfer //use
 * @since phase 1
 */
//defining the capability to transfer money.

public interface Transferable {

    // transfer money from account to another if it's elibible
    boolean transfer(Account destination , double amount);

    /**
     * @return the current balance
     */
    double getBalance();

    /**
     * needed to update balance after transfer
     * @param newBalance
     */

    void setBalance(double newBalance);
}


/**
 *
 * transferable implementation in account
 *
 * public class Account implements Transferable {
 *     // ... existing code ...
 *
 *     @Override
 *     public boolean transfer(Account destination, double amount) {
 *         // For Week 6: Just call existing withdraw/deposit
 *         if (this.getBalance() >= amount) {
 *             this.setBalance(this.getBalance() - amount);
 *             destination.setBalance(destination.getBalance() + amount);
 *             return true;
 *         }
 *         return false;
 *     }
 * }
 *
 */