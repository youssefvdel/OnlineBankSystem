package models.account;

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

public abstract class Account {

    /** Unique identifier for the account */
    private String accountNumber;

    /** Current balance in the account */
    private double balance;

    /** Account owner (User) */
    private User owner;

    /**
     * Creates a new Account with specified details.
     *
     * @param accountNumber the unique account identifier
     * @param balance the initial balance
     * @param owner the User who owns this account
     */
    public Account(String accountNumber, double balance, User owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    /**
     * Deposits money into the account.
     *
     * @param value the amount to deposit (must be non-negative)
     */
    public void deposit(double value) {
        if (value < 0) {
            System.err.println(
                "Error: Cannot deposit negative amount: " + value
            );
            return;
        }
        this.balance += value;
    }

    /**
     * Withdraws money from the account.
     *
     * @param value the amount to withdraw (must be non-negative)
     */
    public void withdraw(double value) {
        if (value < 0) {
            System.err.println(
                "Error: Cannot withdraw negative amount: " + value
            );
            return;
        }
        if (value > this.balance) {
            System.err.println(
                "Error: Insufficient balance. Available: " + this.balance
            );
            return;
        }
        this.balance -= value;
    }

    /**
     * Transfers money to another account.
     *
     * @param destination the destination account to transfer to
     * @param value the amount to transfer (must be non-negative)
     */
    public void transfer(Account destination, double value) {
        if (value < 0) {
            System.err.println(
                "Error: Cannot transfer negative amount: " + value
            );
            return;
        }
        if (value > this.balance) {
            System.err.println(
                "Error: Insufficient balance for transfer. Available: " +
                    this.balance
            );
            return;
        }
        this.balance -= value;
        destination.balance += value;
    }

    /**
     * Applies yearly fee to the account.
     * Must be implemented by all account types.
     *
     * @return the fee amount that was applied
     */
    public abstract double applyYearlyFee();

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
