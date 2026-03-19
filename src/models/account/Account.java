package models.account;

import java.awt.datatransfer.Transferable;
import models.transaction.TransactionHistory;
import models.user.User;

/**
 * Abstract base class for all account types.
 * Cannot be instantiated directly - must use specific account types.
 *
 * @author Youssef Adel 258270
 * @see SavingsAccount
 * @see CurrentAccount
 * @see PremiumAccount
 * @see BusinessAccount
 * @see models/user/User.java
 * @since Phase 1
 */
public abstract class Account implements Transferable {

    /** Unique identifier for the account */
    private String accountNumber;

    /** Current balance in the account */
    private double balance;

    /** Account owner (User) */
    private User owner;
    /** TranscationHistory of account */
    private TransactionHistory transactionHistory;

    /**
     * Creates a new Account with spnew Account with specified details.
     *
     * @param accountNumber the unique account identifier
     * @param balance the initial balance
     * @param owner the User who owns this account
     */
    public Account(String accountNumber, double balance, User owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
        transactionHistory = new TransactionHistory();
    }

    /**
     * Applies yearly fee to the account.
     * Must be implemented by all account types.
     *
     * @return the fee amount that was applied
     */
    public abstract double applyYearlyFee();

    /**
     * Deposits money into the account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount < 0) {
            System.err.println(
                "Error: Cannot deposit negative amount: " + amount
            );
            return;
        }
        this.balance += amount;
        System.out.println(
            "Deposited: $" + amount + " | New Balance: $" + this.balance
        );
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount < 0) {
            System.err.println(
                "Error: Cannot withdraw negative amount: " + amount
            );
            return;
        }
        if (amount > this.balance) {
            System.err.println(
                "Error: Insufficient funds. Available: $" + this.balance
            );
            return;
        }
        this.balance -= amount;
        System.out.println(
            "Withdrew: $" + amount + " | New Balance: $" + this.balance
        );
    }

    /**
     * @return the current account balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * @return the unique account number
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * @return the account owner
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * Sets the account owner.
     *
     * @param owner the new owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Sets the account balance.
     *
     * @param balance the new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber the new account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *Check if the transferable amount is avalable in the account
     *
     * @param destination
     * @param amount
     * @return
     */

    public boolean transfer(Account destination, double amount) {
        if (this.getBalance() >= amount) {
            this.setBalance(this.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Returns string representation of the account.
     * Useful for debugging and display purposes.
     *
     * @return account details as string
     */
    @Override
    public String toString() {
        return (
            "Account{" +
            "accountNumber='" +
            accountNumber +
            '\'' +
            ", balance=" +
            balance +
            ", owner=" +
            (owner != null ? owner.getName() : "Unknown") +
            '}'
        );
    }
}
