package models.transaction;

import models.transaction.Transaction;

import java.util.ArrayList;

/**
 * @author [Tarek Saeed 252382]
 * @see Account
 * @see Transactions
 * @since phase 1
 */

public class TransactionHistory {
    private ArrayList<Transaction> transactions ;

    public TransactionHistory(){
        this.transactions=new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        if (transaction !=null){
            transaction.add(transaction);
        }
    }

    public Transaction viewTransaction(String transactionId){
        for (Transaction t : transactions){
            if (t.getTransacionId().equals(transactionId)){
                return t;
            }
        }
        return null;
    }


    public ArrayList<Transaction> getHistory() {
        return transactions;
    }

    public int getTransactionCount(){
        return transactions.size();
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "count=" + transactions.size() +
                ", transactions=" + transactions +
                '}';
    }

}