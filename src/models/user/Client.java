import models.account.Account;
import models.user.User;
import java.util.ArrayList;

/**
 * Client.java
 *
 * Abstract class representing a bank client.
 * Extends User to inherit login functionality.
 * Clients can have multiple bank accounts.
 * This is abstract because we have different client types
 * (Premium, Standard, FirstClass) with different benefits.
 *
 * @author Yousef Mohiey - 248679
 * @since Phase 1
 * @see User
 */
public abstract class Client extends User {

    // ========== ATTRIBUTES ==========

    /** Client unique ID */
    private String client_ID;

    /** List of accounts owned by this client */
    private ArrayList<Account> accounts;

    /** Client's phone number */
    private String phoneNumber;

    /** Account status (e.g., "Active", "Suspended") */
    private String status;

    // ========== CONSTRUCTOR ==========

    /**
     * Constructs a new Client object.
     * @param userId the unique user ID from parent class
     * @param name the client's full name
     * @param password the login password
     * @param email the client's email address
     * @param client_ID the unique client identifier
     * @param phoneNumber the client's phone number
     */

    public Client(String userId, String name, String password, String email,
                  String client_ID, String phoneNumber) {
        // Call parent (User) constructor
        super(userId, name, password, email);

        this.client_ID = client_ID;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();  // Initialize empty list
        this.status = "Active";  // Default status
    }

    // ========== GETTERS ==========

    /**
     * Gets the client's ID.*
     * @return the client_ID
     */

    public String getClientId() {
        return this.client_ID;
    }

    /**
     * Gets the list of all accounts owned by this client.*
     * @return ArrayList of Account objects
     */

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    /**
     * Gets the client's phone number.
     *
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Gets the client's account status.
     *
     * @return the status (e.g., "Active", "Suspended")
     */
    public String getStatus() {
        return this.status;
    }

    // ========== SETTERS ==========

    /**
     * Sets the client's phone number.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the client's account status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    // ========== ACCOUNT MANAGEMENT METHODS ==========

    /**
     * Adds a new account to this client's account list.
     *
     * @param account the Account object to add
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
        System.out.println("Account added to client " + getName());
    }

    /**
     * Removes an account from this client's list.
     * @param account the Account object to remove
     * @return true if account was found and removed
     *         false if account was not in the list
     */
    public boolean removeAccount(Account account) {
        if (accounts.remove(account)) {
            System.out.println("Account " + account.getAccountNumber() + " removed.");
            return true;
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }

    public double getTotatlBalance()
    {
    double total = 0;
    for (Account account : this.accounts)
    {
        total += account.getBalance();
    }
        return total;


    }

   //    ========== ABSTRACT METHOD ==========
    /**
     * Returns the benefits for this client type.
     * @return String describing the client's benefits
     */
    public abstract String getBenefits();


}

// End of Client class