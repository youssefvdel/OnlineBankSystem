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
    boolean transfer(Account destination, double amount);

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
