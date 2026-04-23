package models.user;


import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import java.util.ArrayList;
import models.account.Account;

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
public abstract class Client extends User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    // ========== ATTRIBUTES ==========

    /** Client unique ID */
    private String client_ID;

    /** List of accounts owned by this client */
    private ArrayList<Account> accounts;

    /** Client's phone number */
    private String phoneNumber;

    /** Account status (e.g., "Active", "Suspended") */
    private String status;
    
    /** Client's password */
    private String password;
   
    /**
    * Current status of the client's card
    */
    private CardStatus cardStatus = CardStatus.INACTIVE;


    // ========== CONSTRUCTOR ==========

    /**
     * Constructs a new Client object.
     *
     * @param userId      the unique user ID from parent class
     * @param name        the client's full name
     * @param password    the login password
     * @param email       the client's email address
     * @param client_ID   the unique client identifier
     * @param phoneNumber the client's phone number
     * @param status
     */

    public Client(
        String userId,
        String name,
        String password,
        String email,
        String client_ID,
        String phoneNumber,
        String status) {
        // Call parent (User) constructor
        super(userId, name, password, email);
        this.client_ID = client_ID;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>(); // Initialize empty list
        this.status = status;
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

    /**
    * Gets current card status
     * @return 
    */
    public CardStatus getCardStatus() {
    return cardStatus;
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
    
    /**
 * Sets a new password for the client
 *
 * @param password the new password
 */
public void setPassword(String password) {

    // Basic validation (not empty)
    if (password == null || password.isEmpty()) {
        throw new IllegalArgumentException("Password cannot be empty");
    }

    // Set new password
    this.password = password;
}

    
// ========== CARD METHODS ==========
/**
 * Issues a new card if no card exists
 * @author Yousif Hafez - 258612
 */
public void issueCard() {
    if (cardStatus != CardStatus.INACTIVE) {
        throw new RuntimeException("Card already issued");
    }
    cardStatus = CardStatus.ACTIVE;
}


/**
 * Updates card status.
 * Persistence is handled by BankSystem.saveAllData() to cards.csv
 * @param newStatus the new card status
 */
public void updateCardStatus(CardStatus newStatus) {
    this.cardStatus = newStatus;
}

/**
 * Loads card status - now handled by BankSystem via cards.csv
 * This method is kept for backward compatibility.
 */
public void loadCardStatus() {
    // Card status is loaded by BankSystem.loadAllData() from cards.csv
}

/**
 * Blocks the client's card by updating its status to LOST.
 * Uses the general update method for better code organization.
 */
public void blockCard() {
    updateCardStatus(CardStatus.LOST);
}


// ========== ACCOUNT MANAGEMENT METHODS ==========

    /**
     * Adds a new account to this client's account list.
     *
     * @param account the Account object to add
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     * Removes an account from this client's list.
     * @param account the Account object to remove
     * @return true if account was found and removed
     *         false if account was not in the list
     */
    public boolean removeAccount(Account account) {
        if (accounts.remove(account)) 
        {
        
            return true;
        } 
        else 
        {
     
            return false;
        }
    }

    public double getTotalBalance() {
        double total = 0;
        for (Account account : this.accounts) {
            total += account.getBalance();
        }
        return total;
    }
    
// ========== BILL PAYMENT METHOD ==========

/**
 * Processes bill payment for the client
 *
 * @param billType the type of bill (e.g., Utilities, Subscription)
 * @param amount the amount to be paid
 * @return true if payment is successful
 * @author Yousif Hafez - 258612
 */
public boolean payBill(String billType, double amount) throws InsufficientFundsException {

    // Validate amount
    if (amount <= 0) {
        throw new InvalidAmountException(amount);
    }

    // Check balance
    if (getTotalBalance() < amount) {
        throw new InsufficientFundsException(getTotalBalance(), amount);
    }

    // Deduct
    if (!accounts.isEmpty()) {
        Account acc = accounts.get(0);
        acc.withdraw(amount);
    }

    return true;
}

    //    ========== ABSTRACT METHOD ==========
    /**
     * Returns the benefits for this client type.
     * @return String describing the client's benefits
     */
    public abstract String getBenefits();
}

// End of Client class
