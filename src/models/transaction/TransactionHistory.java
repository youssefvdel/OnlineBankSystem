package models.transaction;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author [Tarek Saeed 252382]
 * @see Account
 * @see Transactions
 * @since phase 1
 */

public class TransactionHistory implements Iterable<Transaction> {

    private ArrayList<Transaction> transactions;

    /**
     * Creates a new TransactionHistory with empty list.
     * Called internally by Account constructor (composition).
     */
    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    /**
     * Adds a transaction to the account history.
     * @param transaction the transaction to add
     */
    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactions.add(transaction);
        }
    }

    /**
     * Returns a transaction by ID.
     * @param transactionId the transaction ID to search for
     * @return Transaction object if found, null otherwise
     */
    public Transaction viewTransaction(String transactionId) {
        for (Transaction t : transactions) {
            if (t.getTransactionId().equals(transactionId)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Returns the full list of transactions for an account.
     * @return ArrayList of all transactions
     */
    public ArrayList<Transaction> getHistory() {
        return transactions;
    }

    /**
     * Returns the number of transactions.
     * @return count as int
     */
    public int getTransactionCount() {
        return transactions.size();
    }

    /**
     * Returns an iterator over the transactions.
     * @return Iterator of Transaction
     */
    @Override
    public Iterator<Transaction> iterator() {
        return transactions.iterator();
    }

    /**
     * Returns details of TransactionHistory.
     * @return history as string
     */
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
