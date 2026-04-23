package models.transaction;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Tareq
 */
public class TransactionHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ArrayList<Transaction> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactions.add(transaction);
        }
    }

    public Transaction viewTransaction(String transactionId) {
        if (transactionId == null) return null;

        for (Transaction t : transactions) {
            if (transactionId.equals(t.getTransactionId())) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<Transaction> getHistory() {
        return new ArrayList<>(transactions); // defensive copy
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    public void clear() {
        transactions.clear();
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "count=" + transactions.size() +
                '}';
    }
}