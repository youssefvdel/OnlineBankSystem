package models.transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author [Tarek Saeed 252382]
 * @see Account
 * @see Transactions
 * @since phase 1
 */

public class TransactionHistory implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private final ArrayList<Transaction> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
        loadFromFile("data/transactions.txt");
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
        return new ArrayList<>(transactions);
    }

    public int getTransactionCount() {
        return transactions.size();
    }
    
    public void saveToFile(String filename) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
        for (Transaction t : transactions) {
            writer.println(
                t.getTransactionId() + "," +
                t.getClass().getSimpleName() + "," +
                t.getAmount() + "," +
                t.getAccountId() + "," +
                t.getStatus()
            );
        }
    } catch (IOException e) {
        System.out.println("Error saving transactions");
    }
    }
    
public void loadFromFile(String filename) {

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length < 5) {
                continue;
                          }

            String id = parts[0];
            String type = parts[1];
            double amount = Double.parseDouble(parts[2]);
            String accId = parts[3];
            String status = parts[4];

            Transaction t;

            try {
                if (type.equals("Deposit")) {
                    t = new Deposit(id, amount, accId, "loaded");
                } else {
                    t = new Withdrawal(id, amount, accId, "loaded");
                }

                t.setStatus(status);
                transactions.add(t);

            } catch (Exception e) {
                System.out.println("Skipping invalid transaction: " + e.getMessage());
            }
        }

    } catch (IOException e) {
        System.out.println("Error loading transactions");
    }
}
    
    @Override
    public String toString() {
        return "TransactionHistory{" +
                "count=" + transactions.size() +
                ", transactions=" + transactions +
                '}';
    }
}