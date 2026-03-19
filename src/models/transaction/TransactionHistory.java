package models.transaction;

import java.util.ArrayList;

/**
 * @author [Tarek Saeed 252382]
 * @see Account
 * @see Transactions
 * @since phase 1
 */

public class TransactionHistory implements Iterable<Transaction> {

    private ArrayList<Transaction> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactions.add(transaction);
        }
    }

    public Transaction viewTransaction(String transactionId) {
        for (Transaction t : transactions) {
            if (t.getTransactionId().equals(transactionId)) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<Transaction> getHistory() {
        return transactions;
    }

    @Override
    public java.util.Iterator<Transaction> iterator() {
        return transactions.iterator();
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    @Override
    public String toString() {
        return (
            "TransactionHistory{" +
            "count=" +
            transactions.size() +
            ", transactions=" +
            transactions +
            '}'
        );
    }
}
