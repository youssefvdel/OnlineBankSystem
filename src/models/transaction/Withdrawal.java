package models.transaction;
import models.account.Account;

/**
 * @author Tarek Saeed 252382
 * @since phase 1
 */

public class Withdrawal extends Transaction{

    // withdrawal method "ATM,online,bill payment"
    private String method ;

    /**
     * creates a withdrawal transaction
     * @param transactionId
     * @param accountId
     * @param amount
     * @param method withdrawal method "ATM , online,bill payemnt"
     * */

    public Withdrawal(String transactionId , double amount , String accountId ,String method ) {

        super(transactionId, amount, accountId);

        this.method=method;
    }

    /**
     * returns the withdawal method
     * @return method "string"
     */

    public String getMethod(){return method;}


    /**
     * @returns withdrawl detailes
     */

    @Override
    public boolean execute(Account account){

        if (this.method == null || this.method.isEmpty()){
            this.setStatus("Failed");
            return false;
        }

        if (this.getAmount() <=0) {
            this.setStatus("Failed");
            return false;
        }
            if(account.getBalance() <this.getAmount()){
                this.setStatus("Failed");
                System.out.println("Error: insufficient funds. Balance: " +account.getBalance());
                return false;
            }
            //deduct balance
            account.setBalance(account.getBalance()-this.getAmount());

            this.setStatus("Completed");
            return true;

    }

    @Override
    public String toString(){
        return "withdrawal{"+
                "transactionId='"+getTransactionId()+'\''+
                ", amount="+getAmount()+
                ",method='"+method+'\''+
                ", status='"+getStatus()+'\''+
                '}';
    }


}