package models.transaction;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.TransactionFailedException;
import models.account.Account;
/**
 * Represents a transfer of money between two accounts.
 * Extends Transaction and implements execute to withdraw from
 * source and deposit into destination account.
 *
 * @author Yosef - 255796
 * @see Transaction
 * @since Phase 1
 */
public class Transfer extends Transaction implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** The account number the money is taken FROM */
    private String sourceAccountId;

    /** The account money is sent TO */
    private Account destinationAccount;

    /**
     * Creates a new Transfer with specified details.
     * @param transactionId the unique transaction identifier
     * @param amount the amount to transfer
     * @param sourceAccountId the account id to withdraw from
     * @param destinationAccount the account to deposit into
     */
    public Transfer(String transactionId, double amount, String sourceAccountId, Account destinationAccount)
    throws InvalidAmountException, TransactionFailedException
    {
        // Call the parent Transaction constructor with transactionId, amount, sourceAccountId
        super(transactionId, amount, sourceAccountId);
        // Save the source account id into the attribute
        this.sourceAccountId = sourceAccountId;
        // Save the destination account into the attribute
        this.destinationAccount = destinationAccount;
    }
    /**
     * Executes the transfer by withdrawing from source account
     * and depositing into destination account.
     * Validates the transfer before proceeding.
     * @param account the source account to withdraw from
     * @return true if transfer succeeded, false otherwise
     */
    @Override
    public boolean execute(Account account)
               throws InsufficientFundsException,
               InvalidAmountException,
               TransactionFailedException {
        // Check source account is not null
        if (account == null) {
            System.out.println("Error Source account is null");
            // Mark transaction as failed
            setStatus("failed");
            return false;
        }
        // Check destination account is not null
        if (destinationAccount == null) {
            System.out.println("Error Destination account is null");
            // Mark transaction as failed
            setStatus("failed");
            return false;
        }
        // Check source and destination are not the same account
        if (account.getAccountNumber().equals(destinationAccount.getAccountNumber()))
        {
            System.out.println("Error Cannot transfer to the same account");
            // Mark transaction as failed
            setStatus("failed");
            return false;
        }
        // Check source account has enough balance
        if (getAmount() > account.getBalance())
        {
            System.out.println("Error Insufficient balance for transfer. Available: " + account.getBalance());
            // Mark transaction as failed
            setStatus("failed");
            return false;
        }

        /**
         * Tarek added this comment
         * to use transferable interface
         *         // Check if accounts support transfer (Polymorphism via Interface)
         *         if (sourceAccount instanceof Transferable) {
         *             // Use the interface method
         *             return ((Transferable) sourceAccount).transfer(destAccount, this.getAmount());
         *         }
         *         return false;
         */


        // Save balances before the transfer
        double srcBefore = account.getBalance();
        double dstBefore = destinationAccount.getBalance();

        // Withdraw the amount from the source account
        account.withdraw(getAmount());
        // Deposit the same amount into the destination account
        destinationAccount.deposit(getAmount());
        // Mark transaction as completed
        setStatus("Completed");
        // Print confirmation of the successful transfer
        System.out.println("Transfer successful!" + " From: " + account.getAccountNumber() + " To: " + destinationAccount.getAccountNumber() + " Amount: " + getAmount());
        // Return true to indicate success
        // Print updated balances
        System.out.println("Source: " + srcBefore + " ==> " + account.getBalance());
        System.out.println("Destination: " + dstBefore + " ==> " + destinationAccount.getBalance());
        
        // Add to transaction history
        account.getTransactionHistory().addTransaction(this);
        
        return true;
    }
    /**
     * @return the source account id
     */
    public String getSourceAccountId() {
        return this.sourceAccountId;
    }
    /**
     * @return the destination account
     */
    public Account getDestinationAccount() {
        return this.destinationAccount;
    }
    /**
     * Sets the destination account.
     * @param destinationAccount the new destination account
     */
    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
    /**
     * Returns string representation of the transfer.
     * Useful for debugging and display purposes.
     * @return transfer details as string
     */
    @Override
    public String toString() {
        // Get destination account number
        String destAccountNo;
        if (destinationAccount != null) {
            destAccountNo = destinationAccount.getAccountNumber();
        } else {
            destAccountNo = "Unknown";
        }
        return ("Transfer" + "transactionId= " + getTransactionId() + ", amount=" + getAmount() + ", from= " + sourceAccountId + ", to= " + destAccountNo + ", status= " + getStatus());
    }
}