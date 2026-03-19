package manager;

import java.util.ArrayList;
import models.account.Account;
import models.transaction.Transaction;
import models.user.Client;
import models.user.User;

/**
 * BankSystem is the central management class for the online banking system.
 * It handles user authentication, account management, and transaction processing.
 * This class maintains collections of all users, accounts, and transactions
 * within the banking system.
 *
 * @author Yousef Mohiey - 248679
 * @since Phase 1
 * @see User
 * @see Client
 * @see Account
 * @see Transaction
 */
public class BankSystem {

    /** List of all registered users in the banking system */
    private ArrayList<User> users;

    /** List of all accounts managed by the banking system */
    private ArrayList<Account> accounts;

    /** List of all transactions processed in the banking system */
    private ArrayList<Transaction> transactions;

    /** The currently logged-in user */
    private User currentUser;

    /**
     * Constructs a new BankSystem with empty collections for users,
     * accounts, and transactions.
     */
    public BankSystem() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    /**
     * Authenticates a user by verifying their user ID and password.
     * If authentication is successful, sets the authenticated user as
     * the current user.
     *
     * @param userId the unique identifier of the user attempting to log in
     * @param password the password provided by the user for authentication
     * @return true if login is successful, false if user ID or password is invalid
     * @see User#login(String)
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
     * Displays the main menu options for the currently logged-in user.
     * The menu includes options for viewing accounts, transferring money,
     * viewing transaction history, and logging out.
     * If no user is logged in, displays a message prompting the user to login first.
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
     * Saves all banking system data (users, accounts, transactions) to a file.
     * This method is currently a placeholder for future implementation.
     *
     * TODO: Implement file saving logic using serialization or file I/O
     */
    public void saveToFile() {
        // TODO: Implement file saving logic
        System.out.println("Saving data to file...");
    }

    /**
     * Loads banking system data (users, accounts, transactions) from a file.
     * This method is currently a placeholder for future implementation.
     *
     * TODO: Implement file loading logic using serialization or file I/O
     */
    public void loadFromFile() {
        // TODO: Implement file loading logic
        System.out.println("Loading data from file...");
    }

    /**
     * Adds a new user to the banking system.
     *
     * @param user the User object to be added to the system
     * @see User
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Adds a new account to the banking system and associates it with
     * the account owner if the owner is a Client.
     *
     * @param account the Account object to be added to the system
     * @see Account
     * @see Client#addAccount(Account)
     */
    public void addAccount(Account account) {
        accounts.add(account);

        if (account.getOwner() instanceof Client) {
            ((Client) account.getOwner()).addAccount(account);
        }
    }

    /**
     * Retrieves an account by its account number.
     *
     * @param accountNumber the unique account number to search for
     * @return the Account object if found, null if no account matches the given number
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
     * Returns the currently logged-in user.
     *
     * @return the current User object, or null if no user is logged in
     * @see #login(String, String)
     */
    public User getCurrentUser() {
        return currentUser;
    }
}
