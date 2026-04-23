package models.transaction;

import models.account.Account;
import exceptions.InvalidAmountException;
import exceptions.InsufficientFundsException;
import exceptions.TransactionFailedException;

/**
 * @author Tarek Saeed 252382
 * @since Phase 2
 */
public class Deposit extends Transaction {

    private String source;

    public Deposit(String transactionId, double amount, String accountId, String source)
            throws InvalidAmountException, TransactionFailedException {

        super(transactionId, amount, accountId);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    @Override
    public boolean execute(Account account)
            throws InvalidAmountException,
                   TransactionFailedException,
                   InsufficientFundsException {

        if (source == null || source.isEmpty()) {
            setStatus(STATUS_FAILED);
            throw new TransactionFailedException("Deposit source is invalid");
        }

        if (getAmount() <= 0) {
            setStatus(STATUS_FAILED);
            throw new InvalidAmountException(getAmount());
        }

        // add balance
        account.setBalance(account.getBalance() + getAmount());

        setStatus(STATUS_COMPLETED);
        

        return true;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "transactionId='" + getTransactionId() + '\'' +
                ", amount=" + getAmount() +
                ", source='" + source + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}