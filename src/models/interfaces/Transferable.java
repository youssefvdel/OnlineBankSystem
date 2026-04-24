package models.interfaces;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.TransactionFailedException;
import models.account.Account;

/**
 * @author Tarek Saeed 252382
 * @see Account
 * @see Transfer
 * @since phase 1
 */
public interface Transferable {
    /**
     * transfer money from account to another if it's elibible
     */
    public boolean transfer(Account destination, double amount)
        throws InsufficientFundsException,
               InvalidAmountException,
               TransactionFailedException;

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
