package models.transaction;
import models.account.Account;

import java.util.Date;
import src.exceptions.InsufficientFundsException;
import src.exceptions.InvalidAmountException;
import src.exceptions.TransactionFailedException;


/**
 * @author [Tarek Saeed 252382]
 * @see Deposit
 * @see Withdrawal
 * @see Transfer
 * @see TransactionHistory
 * @since phase1
 */

public abstract class Transaction {
    
    protected static final String STATUS_PENDING = "Pending";
    protected static final String STATUS_COMPLETED = "Completed";
    protected static final String STATUS_FAILED = "Failed";

    private String transactionId;
    private double amount;
    private Date timestamp;
    private String accountId;
    private String status;

    /**
     * @param transactionId
     * @param amount
     * @param accountId
     * */

  public Transaction(String transactionId, double amount, String accountId)
            throws InvalidAmountException, TransactionFailedException {

        if (accountId == null || accountId.isEmpty()) {
            throw new TransactionFailedException("Account ID is invalid");
        }

        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }

        this.transactionId = transactionId;
        this.amount = amount;
        this.accountId = accountId;
        this.timestamp = new Date();
        this.status = STATUS_PENDING;

    /**
     * returns the unique transaction ID
     * @return transactionId "string"
     * */

    public String getTransactionId(){
        return transactionId;
    }

    /**
     * returns the transaction amount
     * @return amount as double
     * */

     public double getAmount(){
         return amount;
     }

     /**
      * returns the timestamp of the transaction
      * @return timestamp as date
      * */

     public Date getTimestamp(){
         return timestamp;
     }

     /**
      * returns account id
      * @return accountId "string"
      * */

     public String getAccountId(){
         return accountId;
     }

     /**
      * returns current satues
      * @return status "string"
      * */

     public String getStatus(){
         return status;
     }

     /**
      * updates the status of transaction
      * @param status new status value "completed,failed,etc."
      * */

     public void setStatus(String status){
         this.status=status;
     }

     /**
      * @return true if transaction succed , false otherwise
      * */

     public abstract boolean execute(Account account)throws InsufficientFundsException, InvalidAmountException, TransactionFailedException;

     /**
      * @return transaction detailes for output
      * */

     @Override
    public String toString(){
         return "Transaction{"+
                 "id='"+transactionId+'\''+
                 ", amount="+amount+
                 ", accountId='" +accountId+ '\''+
                 ", status='"+status+'\''+
                 '}';
     }


}

