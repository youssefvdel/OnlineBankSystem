package manager;

import exceptions.DataLoadException;
import models.account.Account;
import models.transaction.Transaction;
import models.user.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Central manager for the banking system.
 * Handles user authentication, data persistence with .ser files.
 * 
 * @author Youssef Adel 258270
 * @version Phase 2
 */
public class BankSystem {

    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private User currentUser;

    private static final String DATA_DIR = "data/";
    private static final String USERS_FILE = DATA_DIR + "users.ser";
    private static final String ACCOUNTS_FILE = DATA_DIR + "accounts.ser";
    private static final String TRANSACTIONS_FILE = DATA_DIR + "transactions.ser";

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
     */
    public boolean login(String userId, String password) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.login(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome, " + user.getName());
                return true;
            }
        }
        System.out.println("Login failed: Invalid user ID or password");
        return false;
    }

    /**
     * Displays the main menu options for the logged-in user.
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
     * Adds a user to the system.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Adds an account to the system and links it to its owner.
     */
    public void addAccount(Account account) {
        accounts.add(account);
        if (account.getOwner() instanceof models.user.Client) {
            ((models.user.Client) account.getOwner()).addAccount(account);
        }
    }

    /**
     * Finds an account by its account number.
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
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Saves all system data (users, accounts, transactions) to .ser files.
     */
    public void saveAllData() {
        try {
            saveToFile(USERS_FILE, users);
            saveToFile(ACCOUNTS_FILE, accounts);
            saveToFile(TRANSACTIONS_FILE, transactions);
            System.out.println("✓ Data saved successfully");
        } catch (Exception e) {
            System.err.println("✗ Error saving data: " + e.getMessage());
        }
    }

    /**
     * Loads all system data from .ser files.
     */
    public void loadAllData() throws DataLoadException {
        try {
            users = loadFromFile(USERS_FILE);
            accounts = loadFromFile(ACCOUNTS_FILE);
            transactions = loadFromFile(TRANSACTIONS_FILE);
            
            if (users == null) users = new ArrayList<>();
            if (accounts == null) accounts = new ArrayList<>();
            if (transactions == null) transactions = new ArrayList<>();
            
            System.out.println("✓ Data loaded successfully");
        } catch (DataLoadException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("⚠ Starting with empty data (files not found)");
            users = new ArrayList<>();
            accounts = new ArrayList<>();
            transactions = new ArrayList<>();
        }
    }

    /**
     * Generic save to .ser file using serialization.
     */
    @SuppressWarnings("unchecked")
    private <T> void saveToFile(String filePath, T data) throws DataLoadException {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(data);
            oos.close();
        } catch (IOException e) {
            throw new DataLoadException(filePath, "write", e);
        }
    }

    /**
     * Generic load from .ser file using deserialization.
     */
    @SuppressWarnings("unchecked")
    private <T> T loadFromFile(String filePath) throws DataLoadException {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return null;
            }
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            T data = (T) ois.readObject();
            ois.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            throw new DataLoadException(filePath, "read", e);
        }
    }
}
