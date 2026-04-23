package models.transaction;
import models.account.Account;
<<<<<<< Updated upstream
import src.exceptions.InsufficientFundsException;
import src.exceptions.InvalidAmountException;
import src.exceptions.TransactionFailedException;
=======
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.TransactionFailedException;
>>>>>>> Stashed changes

/**
 * @author Tarek Saeed 252382
 * @see Transaction
 * @since phase 1
 */

public class Withdrawal extends Transaction implements java.io.Serializable{
        private static final long serialVersionUID = 1L;

    // withdrawal method "ATM,online,bill payment"
    private String method ;

    /**
     * creates a withdrawal transaction
     * @param transactionId
     * @param accountId
     * @param amount
     * @param method withdrawal method "ATM , online,bill payemnt"
     * */

    public Withdrawal(String transactionId , double amount , String accountId ,String method ) 
            throws InvalidAmountException, TransactionFailedException{

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
    public boolean execute(Account account)throws InsufficientFundsException , InvalidAmountException ,TransactionFailedException {

        if (this.method == null || this.method.isEmpty()){
            this.setStatus("Failed");
            throw new TransactionFailedException ("withdrawl method is invalid");}

        if (this.getAmount() <=0) {
            this.setStatus(STATUS_FAILED);
            throw new InvalidAmountException(this.getAmount());
        }
            if(account.getBalance() <this.getAmount()){
                this.setStatus(STATUS_FAILED);
                throw new InsufficientFundsException(account.getBalance(), this.getAmount());
            }
            //deduct balance
            account.setBalance(account.getBalance()-this.getAmount());

            this.setStatus(STATUS_COMPLETED);
            
            // Add to transaction history
            account.getTransactionHistory().addTransaction(this);
            
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