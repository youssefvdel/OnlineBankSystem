package models.transaction;

import models.account.Account;

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

    public Deposit(String transactionId,double amount,String accountId,String source){
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
    public boolean execute(Account account) {

        if(this.source==null||this.source.isEmpty()){
            this.setStatus("failed");
            return false ;
        }

        if(this.getAmount()<=0){
            this.setStatus("failed");
            return false;
        }

        //adding balance
        account.setBalance(account.getBalance()+this.getAmount());

        this.setStatus("completed");
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