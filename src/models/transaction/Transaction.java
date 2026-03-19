package models.transaction;
import models.account.Account;

import java.util.Date;

/**
 * @author [Tarek Saeed 252382]
 * @since phase1
 */

public abstract class Transaction {

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

    public Transaction(String transactionId,double amount ,String accountId){

        this.transactionId=transactionId;
        this.timestamp=new Date();
        this.status="Completed";

        if (accountId==null || accountId.isEmpty()){
            this.status="failed";
            System.out.println("Error: account id cannot be empty");
        }else {
            this.accountId=accountId;
        }

        if (amount < 0){
            this.status="failed";
            this.amount=0;
            System.out.println("Error: Amount cannot be negative");
        }else {
            this.amount= amount;
            this.status= "Completed";
        }

    }

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

     public abstract boolean execute(Account account);

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

