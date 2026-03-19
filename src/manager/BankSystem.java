package manager;

import java.util.ArrayList;
import models.account.Account;
import models.transaction.Transaction;
import models.user.User;
import models.user.Client;

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

    // Methods to implement
    public boolean login(String userId, String password) {
        // Loop through all users to find matching credentials
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
        // TODO: Implement file saving logic
        System.out.println("Saving data to file...");
    }

    public void loadFromFile() {
        // TODO: Implement file loading logic
        System.out.println("Loading data from file...");
    }
    
    // Helper methods
    public void addUser(User user) {
        users.add(user);
    }
    
    public void addAccount(Account account) {
        accounts.add(account);
        // Also add to the owner's account list if owner is a Client
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
}
