package manager;

import exceptions.DataLoadException;
import models.account.*;
import models.transaction.*;
import models.user.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.CSVHelper;

/**
 * Central manager for the banking system.
 * Handles user authentication, data persistence with CSV files.
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
    private static final String USERS_FILE = DATA_DIR + "users.csv";
    private static final String ACCOUNTS_FILE = DATA_DIR + "accounts.csv";
    private static final String TRANSACTIONS_FILE = DATA_DIR + "transactions.csv";
    private static final String CARDS_FILE = DATA_DIR + "cards.csv";

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

    // ========== CSV SAVE METHODS ==========

    /**
     * Saves all system data to CSV files.
     */
    public void saveAllData() {
        try {
            new File(DATA_DIR).mkdirs();
            saveUsers();
            saveAccounts();
            saveTransactions();
            saveCards();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    private void saveUsers() throws DataLoadException {
        List<String> lines = new ArrayList<>();
        lines.add("type,userId,name,password,email,clientId,phone,status,cardStatus");
        for (User user : users) {
            lines.add(userToCSV(user));
        }
        CSVHelper.writeLines(USERS_FILE, lines);
    }

    private void saveAccounts() throws DataLoadException {
        List<String> lines = new ArrayList<>();
        lines.add("type,accountNumber,balance,ownerUserId,interestRate,overdraftLimit,businessName,creditLimit");
        for (Account acc : accounts) {
            lines.add(accountToCSV(acc));
        }
        CSVHelper.writeLines(ACCOUNTS_FILE, lines);
    }

    private void saveTransactions() throws DataLoadException {
        List<String> lines = new ArrayList<>();
        lines.add("type,transactionId,amount,timestamp,accountId,status,destinationAccountId");
        for (Transaction trans : transactions) {
            lines.add(transactionToCSV(trans));
        }
        CSVHelper.writeLines(TRANSACTIONS_FILE, lines);
    }

    private void saveCards() throws DataLoadException {
        List<String> lines = new ArrayList<>();
        lines.add("clientUserId,cardStatus");
        for (User user : users) {
            if (user instanceof Client) {
                Client client = (Client) user;
                lines.add(CSVHelper.join(client.getUserId(), client.getCardStatus().name()));
            }
        }
        CSVHelper.writeLines(CARDS_FILE, lines);
    }

    // ========== CSV LOAD METHODS ==========

    /**
     * Loads all system data from CSV files.
     */
    public void loadAllData() throws DataLoadException {
        try {
            loadUsers();
            loadAccounts();
            loadTransactions();
            loadCards();
            System.out.println("Data loaded successfully");
        } catch (DataLoadException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Starting with empty data (files not found)");
            users = new ArrayList<>();
            accounts = new ArrayList<>();
            transactions = new ArrayList<>();
        }
    }

    private void loadUsers() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(USERS_FILE);
        if (lines.isEmpty()) return;
        users = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            User user = csvToUser(lines.get(i));
            if (user != null) users.add(user);
        }
    }

    private void loadAccounts() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(ACCOUNTS_FILE);
        if (lines.isEmpty()) return;
        accounts = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            Account acc = csvToAccount(lines.get(i));
            if (acc != null) accounts.add(acc);
        }
    }

    private void loadTransactions() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(TRANSACTIONS_FILE);
        if (lines.isEmpty()) return;
        transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            Transaction trans = csvToTransaction(lines.get(i));
            if (trans != null) transactions.add(trans);
        }
    }

    private void loadCards() throws DataLoadException {
        List<String> lines = CSVHelper.readLines(CARDS_FILE);
        if (lines.isEmpty()) return;
        for (int i = 1; i < lines.size(); i++) {
            List<String> fields = CSVHelper.parseLine(lines.get(i));
            if (fields.size() >= 2) {
                String userId = fields.get(0);
                String statusStr = fields.get(1);
                User user = findUserById(userId);
                if (user instanceof Client) {
                    try {
                        ((Client) user).updateCardStatus(CardStatus.valueOf(statusStr));
                    } catch (Exception e) {
                        // ignore invalid status
                    }
                }
            }
        }
    }

    // ========== CONVERSION HELPERS ==========

    private User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) return user;
        }
        return null;
    }

    private String userToCSV(User user) {
        String type = user instanceof Admin ? "Admin" : "Client";
        String clientId = "";
        String phone = "";
        String status = "";
        String cardStatus = "";
        if (user instanceof Client) {
            Client c = (Client) user;
            clientId = c.getClientId();
            phone = c.getPhoneNumber();
            status = c.getStatus();
            cardStatus = c.getCardStatus().name();
            if (c instanceof StandardClient) type = "StandardClient";
            else if (c instanceof PremiumClient) type = "PremiumClient";
            else if (c instanceof FirstClassClient) type = "FirstClassClient";
        }
        return CSVHelper.join(type, user.getUserId(), user.getName(), user.getPassword(), user.getEmail(),
                clientId, phone, status, cardStatus);
    }

    private User csvToUser(String line) {
        List<String> f = CSVHelper.parseLine(line);
        if (f.size() < 5) return null;
        String type = f.get(0);
        String userId = f.get(1);
        String name = f.get(2);
        String password = f.get(3);
        String email = f.get(4);
        String clientId = f.size() > 5 ? f.get(5) : "";
        String phone = f.size() > 6 ? f.get(6) : "";
        String status = f.size() > 7 ? f.get(7) : "";
        String cardStatusStr = f.size() > 8 ? f.get(8) : "";

        User user;
        if ("Admin".equals(type)) {
            user = new Admin(userId, name, password, email);
        } else if ("StandardClient".equals(type)) {
            user = new StandardClient(userId, name, password, email, userId, phone, 1000.0);
        } else if ("PremiumClient".equals(type)) {
            user = new PremiumClient(userId, name, password, email, userId, phone, 5000.0, 0.05);
        } else if ("FirstClassClient".equals(type)) {
            user = new FirstClassClient(userId, name, password, email, userId, phone, "Active", 1.0);
        } else {
            user = new StandardClient(userId, name, password, email, userId, phone, 1000.0);
        }

        if (user instanceof Client && !cardStatusStr.isEmpty()) {
            try {
                ((Client) user).updateCardStatus(CardStatus.valueOf(cardStatusStr));
            } catch (Exception e) {
                // ignore
            }
        }
        return user;
    }

    private String accountToCSV(Account acc) {
        String type = "Account";
        String extra1 = "";
        String extra2 = "";
        if (acc instanceof SavingsAccount) {
            type = "SavingsAccount";
            extra1 = String.valueOf(((SavingsAccount) acc).getInterestRate());
        } else if (acc instanceof CurrentAccount) {
            type = "CurrentAccount";
            extra1 = String.valueOf(((CurrentAccount) acc).getOverdraftLimit());
        } else if (acc instanceof PremiumAccount) {
            type = "PremiumAccount";
            extra1 = String.valueOf(((PremiumAccount) acc).getPremiumRate());
            extra2 = String.valueOf(((PremiumAccount) acc).getHigherLimit());
        } else if (acc instanceof BusinessAccount) {
            type = "BusinessAccount";
            extra1 = ((BusinessAccount) acc).getBusinessName();
        }
        String ownerId = acc.getOwner() != null ? acc.getOwner().getUserId() : "";
        return CSVHelper.join(type, acc.getAccountNumber(), String.valueOf(acc.getBalance()), ownerId, extra1, extra2);
    }

    private Account csvToAccount(String line) {
        List<String> f = CSVHelper.parseLine(line);
        if (f.size() < 4) return null;
        String type = f.get(0);
        String accNum = f.get(1);
        double balance = CSVHelper.parseDouble(f.get(2), 0.0);
        String ownerId = f.get(3);
        User owner = findUserById(ownerId);
        if (owner == null) owner = new Admin("unknown", "Unknown", "", "");

        Account acc;
        if ("SavingsAccount".equals(type)) {
            double rate = f.size() > 4 ? CSVHelper.parseDouble(f.get(4), 0.05) : 0.05;
            acc = new SavingsAccount(accNum, balance, owner, rate, 100.0);
        } else if ("CurrentAccount".equals(type)) {
            double limit = f.size() > 4 ? CSVHelper.parseDouble(f.get(4), 500.0) : 500.0;
            acc = new CurrentAccount(accNum, balance, owner, limit, 50.0, 100, 0.0);
        } else if ("PremiumAccount".equals(type)) {
            double rate = f.size() > 4 ? CSVHelper.parseDouble(f.get(4), 0.08) : 0.08;
            double credit = f.size() > 5 ? CSVHelper.parseDouble(f.get(5), 10000.0) : 10000.0;
            acc = new PremiumAccount(accNum, balance, owner, rate, credit);
        } else if ("BusinessAccount".equals(type)) {
            String bizName = f.size() > 4 ? f.get(4) : "Business";
            acc = new BusinessAccount(accNum, balance, owner, bizName, 100.0);
        } else {
            acc = new SavingsAccount(accNum, balance, owner, 0.05, 100.0);
        }
        return acc;
    }

    private String transactionToCSV(Transaction trans) {
        String type = "Transaction";
        String destAcc = "";
        if (trans instanceof Deposit) type = "Deposit";
        else if (trans instanceof Withdrawal) type = "Withdrawal";
        else if (trans instanceof Transfer) {
            type = "Transfer";
            Account dest = ((Transfer) trans).getDestinationAccount();
            if (dest != null) destAcc = dest.getAccountNumber();
        }
        return CSVHelper.join(type, trans.getTransactionId(), String.valueOf(trans.getAmount()),
                String.valueOf(trans.getTimestamp().getTime()), trans.getAccountId(), trans.getStatus(), destAcc);
    }

    private Transaction csvToTransaction(String line) {
        List<String> f = CSVHelper.parseLine(line);
        if (f.size() < 6) return null;
        String type = f.get(0);
        String transId = f.get(1);
        double amount = CSVHelper.parseDouble(f.get(2), 0.0);
        String accountId = f.get(4);
        String status = f.get(5);
        String destAcc = f.size() > 6 ? f.get(6) : "";

        Transaction trans;
      try {
    if ("Deposit".equals(type)) {
        trans = new Deposit(transId, amount, accountId, "internal");
    } else if ("Withdrawal".equals(type)) {
        trans = new Withdrawal(transId, amount, accountId, "internal");
    } else if ("Transfer".equals(type)) {
        Account dest = getAccountByNumber(destAcc);
        trans = new Transfer(transId, amount, accountId, dest);
    } else {
        trans = new Deposit(transId, amount, accountId, "internal");
    }
    } catch (Exception e) {
    return null; // skip invalid transaction
    }
        trans.setStatus(status);
        return trans;
    }
}
