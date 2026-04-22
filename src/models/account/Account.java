package models.account;

import models.interfaces.Transferable;
import models.transaction.Deposit;
import models.transaction.TransactionHistory;
import models.transaction.Transfer;
import models.transaction.Withdrawal;
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
     * Deposits money into the account using the Deposit transaction class.
     *
     * @param amount the amount to deposit
     * @return true if deposit was successful, false otherwise
     * @see Deposit#execute(Account)
     */
    public boolean deposit(double amount) {
        String transId = "DEP" + System.currentTimeMillis();
        Deposit deposit = new Deposit(
            transId,
            amount,
            this.accountNumber,
            "internal"
        );
        return deposit.execute(this);
    }

    /**
     * Withdraws money from the account using the Withdrawal transaction class.
     *
     * @param amount the amount to withdraw
     * @return true if withdrawal was successful, false otherwise
     * @see Withdrawal#execute(Account)
     */
    public boolean withdraw(double amount) {
        String transId = "WDR" + System.currentTimeMillis();
        Withdrawal withdrawal = new Withdrawal(
            transId,
            amount,
            this.accountNumber,
            "internal"
        );
        return withdrawal.execute(this);
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
     * Transfers money from this account to a destination account using the Transfer transaction class.
     *
     * @param destination the destination account to transfer funds to
     * @param amount the amount to transfer
     * @return true if transfer was successful, false otherwise
     * @see Transfer#execute(Account)
     */
    public boolean transfer(Account destination, double amount) {
        String transId = "TRF" + System.currentTimeMillis();
        Transfer transfer = new Transfer(
            transId,
            amount,
            this.accountNumber,
            destination
        );
        return transfer.execute(this);
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

    /**
     * @return the transaction history for this account
     */
    public TransactionHistory getTransactionHistory() {
        return this.transactionHistory;
    }
}
