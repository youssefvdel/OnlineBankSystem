package manager;

import exceptions.DataLoadException;
import java.util.ArrayList;
import java.util.List;
import models.account.Account;
import models.account.BusinessAccount;
import models.account.CurrentAccount;
import models.account.PremiumAccount;
import models.account.SavingsAccount;
import models.transaction.Deposit;
import models.transaction.Transaction;
import models.transaction.Withdrawal;
import models.user.Admin;
import models.user.Client;
import models.user.StandardClient;
import models.user.User;
import utils.CSVHelper;

/**
 * Central manager for the banking system.
 * Handles user authentication, data persistence, and business logic coordination.
 * 
 * Responsibilities:
 * - Load/save users, accounts, and transactions to CSV files
 * - Authenticate users and track the current session
 * - Provide access to collections of system entities
 * 
 * @author Youssef Adel 258270
 * @version Phase 2
 */
public class BankSystem {

    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private User currentUser;

    /**
     * Creates a new BankSystem with empty collections.
     */
    public BankSystem() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    /**
     * Authenticates a user by ID and password.
     * 
     * @param userId the user's unique identifier
     * @param password the user's password
     * @return true if login succeeds, false otherwise
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

    /**
     * Displays the main menu options for the logged-in user.
     * Requires a user to be authenticated first.
     */
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

    /**
     * Legacy method - replaced by saveAllData().
     * Kept for backward compatibility.
     */
    public void saveToFile() {
        System.out.println("Saving data to file...");
    }

    /**
     * Legacy method - replaced by loadAllData().
     * Kept for backward compatibility.
     */
    public void loadFromFile() {
        System.out.println("Loading data from file...");
    }

    /**
     * Adds a user to the system.
     * 
     * @param user the user to add
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Adds an account to the system and links it to its owner.
     * 
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
        if (account.getOwner() instanceof Client) {
            ((Client) account.getOwner()).addAccount(account);
        }
    }

    /**
     * Finds an account by its account number.
     * 
     * @param accountNumber the account number to search for
     * @return the matching account, or null if not found
     */
    public Account getAccountByNumber(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Returns the currently authenticated user.
     * 
     * @return the current user, or null if no one is logged in
     */
    public User getCurrentUser() {
        return currentUser;
    }

    private static final String DATA_DIR = "data/";
    private static final String USERS_FILE = DATA_DIR + "users.csv";
    private static final String ACCOUNTS_FILE = DATA_DIR + "accounts.csv";
    private static final String TRANSACTIONS_FILE =
        DATA_DIR + "transactions.csv";

    /**
     * Saves all system data (users, accounts, transactions) to CSV files.
     * Catches and logs exceptions to avoid crashing the application.
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
     * Loads all system data from CSV files.
     * 
     * @throws DataLoadException if a critical error occurs during loading
     */
    public void loadAllData() throws DataLoadException {
        loadUsers();
        loadAccounts();
        loadTransactions();
        System.out.println("Data loaded successfully");
    }

    /**
     * Saves the users collection to users.csv.
     * 
     * @throws DataLoadException if writing fails
     */
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

    /**
     * Loads users from users.csv and creates Admin/StandardClient objects.
     * Uses temporary passwords since real passwords should be hashed.
     * 
     * @throws DataLoadException if parsing fails
     */
    private void loadUsers() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(USERS_FILE);
        for (String line : lines) {
            List<String> f = CSVHelper.parseLine(line);
            if (f.size() < 4) continue;
            
            String id = f.get(0);
            String name = f.get(1);
            String email = f.get(2);
            String role = f.get(3);
            
            if ("Admin".equals(role)) {
                users.add(new Admin(id, name, "temp123", email));
            } else if (role.contains("Client")) {
                String clientId = f.size() > 4 ? f.get(4) : id;
                users.add(new StandardClient(id, name, "temp123", email, clientId, "", 1000.0));
            }
        }
    }

    /**
     * Saves the accounts collection to accounts.csv.
     * 
     * @throws DataLoadException if writing fails
     */
    private void saveAccounts() throws DataLoadException {
        ArrayList<String> lines = new ArrayList<>();
        for (Account a : accounts) {
            String base = CSVHelper.join(
                a.getAccountNumber(),
                String.valueOf(a.getBalance()),
                a.getOwner() != null ? a.getOwner().getUserId() : "",
                a.getClass().getSimpleName()
            );
            
            String extra = "";
            if (a instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) a;
                extra = CSVHelper.join(
                    String.valueOf(sa.getInterestRate()),
                    String.valueOf(sa.getMinBalance())
                );
            } else if (a instanceof CurrentAccount) {
                CurrentAccount ca = (CurrentAccount) a;
                extra = CSVHelper.join(
                    String.valueOf(ca.getOverdraftLimit()),
                    String.valueOf(ca.getYearlyFee()),
                    String.valueOf(ca.getTransactionLimit()),
                    String.valueOf(ca.getMinimumBalance()),
                    String.valueOf(ca.isActive())
                );
            } else if (a instanceof PremiumAccount) {
                PremiumAccount pa = (PremiumAccount) a;
                extra = CSVHelper.join(
                    String.valueOf(pa.getHigherLimit()),
                    String.valueOf(pa.getPremiumRate())
                );
            } else if (a instanceof BusinessAccount) {
                BusinessAccount ba = (BusinessAccount) a;
                extra = CSVHelper.join(
                    CSVHelper.escape(ba.getBusinessName()),
                    String.valueOf(ba.getYearlyFee())
                );
            }
            
            if (!extra.isEmpty()) {
                base += "," + extra;
            }
            lines.add(base);
        }
        CSVHelper.writeLines(ACCOUNTS_FILE, lines);
    }

    /**
     * Loads accounts from accounts.csv and creates SavingsAccount/CurrentAccount objects.
     * Links each account to its owner by user ID.
     * 
     * @throws DataLoadException if parsing fails
     */
    private void loadAccounts() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(ACCOUNTS_FILE);
        for (String line : lines) {
            List<String> f = CSVHelper.parseLine(line);
            if (f.size() < 4) continue;
            
            String accNum = f.get(0);
            double balance = Double.parseDouble(f.get(1));
            String ownerId = f.get(2);
            String type = f.get(3);
            
            User owner = null;
            for (User u : users) {
                if (u.getUserId().equals(ownerId)) {
                    owner = u;
                    break;
                }
            }
            if (owner == null) continue;
            
            if ("SavingsAccount".equals(type)) {
                accounts.add(new SavingsAccount(accNum, balance, owner, 0.03, 100.0));
            } else if ("CurrentAccount".equals(type)) {
                accounts.add(new CurrentAccount(accNum, balance, owner, 500.0, 25.0, 50, 0.0));
            }
        }
    }

    /**
     * Saves the transactions collection to transactions.csv.
     * 
     * @throws DataLoadException if writing fails
     */
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

    /**
     * Loads transactions from transactions.csv and creates Deposit/Withdrawal objects.
     * Links each transaction to its account and adds to the account's history.
     * 
     * @throws DataLoadException if parsing fails
     */
    private void loadTransactions() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(TRANSACTIONS_FILE);
        for (String line : lines) {
            List<String> f = CSVHelper.parseLine(line);
            if (f.size() < 5) continue;
            
            String transId = f.get(0);
            double amount = Double.parseDouble(f.get(1));
            String accountId = f.get(2);
            String status = f.get(3);
            String type = f.get(4);
            
            Account acc = getAccountByNumber(accountId);
            if (acc == null) continue;
            
            Transaction txn = null;
            if ("Deposit".equals(type)) {
                txn = new Deposit(transId, amount, accountId, "file_load");
            } else if ("Withdrawal".equals(type)) {
                txn = new Withdrawal(transId, amount, accountId, "file_load");
            }
            
            if (txn != null) {
                txn.setStatus(status);
                transactions.add(txn);
                acc.getTransactionHistory().addTransaction(txn);
            }
        }
    }
}
