package models.transaction;

import models.account.Account;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.TransactionFailedException;

import java.util.Date;

/**
 * @author Tarek Saeed 252382
 * @since Phase 2
 */
public abstract class Transaction implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    protected static final String STATUS_PENDING = "Pending";
    protected static final String STATUS_COMPLETED = "Completed";
    protected static final String STATUS_FAILED = "Failed";

    private String transactionId;
    private double amount;
    private Date timestamp;
    private String accountId;
    private String status;

    public Transaction(String transactionId, double amount, String accountId)
            throws InvalidAmountException, TransactionFailedException {

        if (accountId == null || accountId.isEmpty()) {
            throw new TransactionFailedException("Account ID cannot be empty");
        }

        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }

        this.transactionId = transactionId;
        this.amount = amount;
        this.accountId = accountId;
        this.timestamp = new Date();
        this.status = STATUS_PENDING;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract boolean execute(Account account)
            throws InsufficientFundsException,
                   InvalidAmountException,
                   TransactionFailedException;

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + transactionId + '\'' +
                ", amount=" + amount +
                ", accountId='" + accountId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}