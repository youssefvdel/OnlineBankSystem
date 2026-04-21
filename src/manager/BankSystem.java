package manager;

import exceptions.DataLoadException;
import java.util.ArrayList;
import java.util.List;
import models.account.Account;
import models.transaction.Transaction;
import models.user.Client;
import models.user.User;
import utils.CSVHelper;

/**
 * Main manager for the banking system.
 * Handles users, accounts, transactions and file persistence.
 * @author Youssef Adel - 258270
 */
public class BankSystem {

    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private User currentUser;

    public BankSystem() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    /**
     * Validate user login credentials.
     */
    public boolean login(String userId, String password) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.login(password)) {
                currentUser = user;
                System.out.println(
                    "Login successful! Welcome, " + user.getName()
                );
                return true;
            }
        }
        System.out.println("Login failed: Invalid user ID or password");
        return false;
    }

    public void mainMenu() {
        if (currentUser == null) {
            System.out.println("Please login first");
            return;
        }
        System.out.println("=== Main Menu ===");
        System.out.println("1. View Accounts");
        System.out.println("2. Transfer Money");
        System.out.println("3. View Transaction History");
        System.out.println("4. Logout");
    }

    public void saveToFile() {
        System.out.println("Saving data to file...");
    }

    public void loadFromFile() {
        System.out.println("Loading data from file...");
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addAccount(Account account) {
        accounts.add(account);
        if (account.getOwner() instanceof Client) {
            ((Client) account.getOwner()).addAccount(account);
        }
    }

    public Account getAccountByNumber(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // File paths for persistence
    private static final String DATA_DIR = "data/";
    private static final String USERS_FILE = DATA_DIR + "users.csv";
    private static final String ACCOUNTS_FILE = DATA_DIR + "accounts.csv";
    private static final String TRANSACTIONS_FILE =
        DATA_DIR + "transactions.csv";

    /**
     * Save all data to CSV files. Call this when app exits.
     */
    public void saveAllData() {
        try {
            saveUsers();
            saveAccounts();
            saveTransactions();
            System.out.println("Data saved successfully");
        } catch (DataLoadException e) {
            System.err.println(e.getUserMessage());
        }
    }

    /**
     * Load all data from CSV files. Call this on startup.
     */
    public void loadAllData() {
        try {
            loadUsers();
            loadAccounts();
            loadTransactions();
            System.out.println("Data loaded successfully");
        } catch (DataLoadException e) {
            System.err.println(e.getUserMessage());
        }
    }

    private void saveUsers() throws DataLoadException {
        ArrayList<String> lines = new ArrayList<>();
        for (User u : users) {
            String base = CSVHelper.join(
                u.getUserId(),
                u.getName(),
                u.getEmail(),
                u.getClass().getSimpleName()
            );
            if (u instanceof Client) {
                base += ",CLIENT";
            }
            lines.add(base);
        }
        CSVHelper.writeLines(USERS_FILE, lines);
    }

    private void loadUsers() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(USERS_FILE);
        for (String line : lines) {
            List<String> f = CSVHelper.parseLine(line);
            if (f.size() < 4) continue;
            String id = f.get(0),
                name = f.get(1),
                email = f.get(2),
                role = f.get(3);
            System.out.println("Loaded: " + name + " (" + role + ")");
        }
    }

    private void saveAccounts() throws DataLoadException {
        ArrayList<String> lines = new ArrayList<>();
        for (Account a : accounts) {
            String base = CSVHelper.join(
                a.getAccountNumber(),
                String.valueOf(a.getBalance()),
                a.getOwner() != null ? a.getOwner().getUserId() : "",
                a.getClass().getSimpleName()
            );
            lines.add(base);
        }
        CSVHelper.writeLines(ACCOUNTS_FILE, lines);
    }

    private void loadAccounts() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(ACCOUNTS_FILE);
        for (String line : lines) {
            List<String> f = CSVHelper.parseLine(line);
            if (f.size() < 4) continue;
            String accNum = f.get(0),
                type = f.get(3);
            System.out.println("Loaded: " + accNum + " (" + type + ")");
        }
    }

    private void saveTransactions() throws DataLoadException {
        ArrayList<String> lines = new ArrayList<>();
        for (Transaction t : transactions) {
            lines.add(
                CSVHelper.join(
                    t.getTransactionId(),
                    String.valueOf(t.getAmount()),
                    t.getAccountId(),
                    t.getStatus(),
                    t.getClass().getSimpleName(),
                    t.getTimestamp() != null
                        ? String.valueOf(t.getTimestamp().getTime())
                        : ""
                )
            );
        }
        CSVHelper.writeLines(TRANSACTIONS_FILE, lines);
    }

    private void loadTransactions() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(TRANSACTIONS_FILE);
        for (String line : lines) {
            List<String> f = CSVHelper.parseLine(line);
            if (f.size() < 5) continue;
            System.out.println("Loaded: " + f.get(0) + " - $" + f.get(1));
        }
    }
}
