package models.transaction;

import models.account.Account;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.TransactionFailedException;

/**
 * @author Tarek Saeed 252382
 * @since Phase 2
 */
public class Withdrawal extends Transaction {

    private String method;

    public Withdrawal(String transactionId, double amount, String accountId, String method)
            throws InvalidAmountException, TransactionFailedException {

        super(transactionId, amount, accountId);
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public boolean execute(Account account)
            throws InsufficientFundsException,
                   InvalidAmountException,
                   TransactionFailedException {

        if (method == null || method.isEmpty()) {
            setStatus(STATUS_FAILED);
            throw new TransactionFailedException("Withdrawal method is invalid");
        }

        if (getAmount() <= 0) {
            setStatus(STATUS_FAILED);
            throw new InvalidAmountException(getAmount());
        }

        if (account.getBalance() < getAmount()) {
            setStatus(STATUS_FAILED);
            throw new InsufficientFundsException(account.getBalance(), getAmount());
        }

        // deduct balance
        account.setBalance(account.getBalance() - getAmount());

        setStatus(STATUS_COMPLETED);
        account.getTransactionHistory().addTransaction(this);

        return true;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "transactionId='" + getTransactionId() + '\'' +
                ", amount=" + getAmount() +
                ", method='" + method + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}