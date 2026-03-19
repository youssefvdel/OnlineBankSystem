package models.transaction;

import java.util.ArrayList;

/**
 * @author [Tarek Saeed 252382]
 * @see Account
 * @see Transactions
 * @since phase 1
 */

public class TransactionHistory {
    private ArrayList<Transaction> transactions ;

    // creates a new transactionhistory with empty list
    // called internally by Account constructor (composition)

    public TransactionHistory(){
        this.transactions=new ArrayList<>();
    }

    /**
     * adds a transaction to the account history
     * @param transaction
     */
    public void addTransaction(Transaction transaction){
        if (transaction !=null){
            transaction.add(transaction);
        }
    }

    /**
     * return a transaction by id
     * @param transactionId
     * @return object if found , null otherwise
     */
    public Transaction viewTransaction(String transactionId){
        for (Transaction t : transactions){
            if (t.getTransactionId().equals(transactionId)){
                return t;
            }
        }
        return null;
    }


    /**
     * return a full list of transaction for an account
     * @return arraylist of all transactions
     */
    public ArrayList<Transaction> getHistory() {
        return transactions;
    }

    /**
     * returns number of transactions
     * @return count "int"
     */
    public int getTransactionCount(){
        return transactions.size();
    }

    /**
     * details of transactionhistory
     * @return history
     */

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "count=" + transactions.size() +
                ", transactions=" + transactions +
                '}';
    }

}