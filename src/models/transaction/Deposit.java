package models.transaction;

import models.account.Account;
import src.exceptions.InvalidAmountException;
import src.exceptions.TransactionFailedException;

/**
 * @author [Tarek Saeed 252382]
 * @see Transaction
 * @since phase1
 */

public class Deposit extends Transaction {

    //source for deposit "cash,check,transfer"
    private String source;

    /**
     * Creates a new deposit
     * @param transactionId
     * @param accountId
     * @param amount
     * @param source
     * */

    public Deposit(String transactionId,double amount,String accountId,String source)
            throws InvalidAmountException, TransactionFailedException {
        super(transactionId,amount,accountId);

        this.source=source;
    }

    /**
     * returns the source of the deposit
     * @return source "string"
     */

    public String getSource(){
        return source;
    }

    /**
     *excutes the deposit validation logic
     * @return true if valid , false otherwise
     */
    @Override
    public boolean execute(Account account) throws InvalidAmountException,TransactionFailedException {

        if(this.source==null||this.source.isEmpty()){
            this.setStatus(STATUS_FAILED);
            throw new TransactionFailedException("withdrawl method is invalid");
        }

        if(this.getAmount()<=0){
            this.setStatus(STATUS_FAILED);
            throw new InvalidAmountException(this.getAmount());
        }

        //adding balance
        account.setBalance(account.getBalance()+this.getAmount());

        this.setStatus(STATUS_COMPLETED);
        
        // Add to transaction history
        account.getTransactionHistory().addTransaction(this);
        
        return true;
    }

    /**
     * @return deposit detailes
     */

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