package models.account;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.TransactionFailedException;
import models.transaction.Withdrawal;
import models.user.User;

/**
 * CurrentAccount represents a checking/current bank account with overdraft facility.
 * Extends Account with overdraft support and transaction limits.
 *
 * @author Youssef Adel 258270
 * @since Phase 1
 */
public class CurrentAccount extends Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** Maximum overdraft amount allowed (negative balance limit) */
    private double overdraftLimit;

    /** Yearly fee for this account */
    private double yearlyFee;

    /** Maximum number of transactions per month */
    private int transactionLimit;

    /** Minimum balance required to avoid additional charges */
    private double minimumBalance;

    /** Account status (active/inactive) */
    private boolean isActive;

    /**
     * Creates a new CurrentAccount with specified details.
     *
     * @param accountNumber the unique account identifier
     * @param balance the initial balance
     * @param owner the User who owns this account
     * @param overdraftLimit the maximum overdraft amount allowed
     * @param yearlyFee the yearly fee for this account
     * @param transactionLimit the maximum transactions per month
     * @param minimumBalance the minimum balance required
     */
    public CurrentAccount(
        String accountNumber,
        double balance,
        User owner,
        double overdraftLimit,
        double yearlyFee,
        int transactionLimit,
        double minimumBalance
    ) {
        super(accountNumber, balance, owner);
        this.overdraftLimit = overdraftLimit;
        this.yearlyFee = yearlyFee;
        this.transactionLimit = transactionLimit;
        this.minimumBalance = minimumBalance;
        this.isActive = true;
    }

    /**
     * Withdraws money from the account using overdraft if needed.
     *
     * @param amount the amount to withdraw
     * @return true if withdrawal was successful, false otherwise
     */
    @Override
    public boolean withdraw(double amount)
               throws InsufficientFundsException,
               InvalidAmountException,
               TransactionFailedException {
        if (amount < 0) {
            System.err.println(
                "Error: Cannot withdraw negative amount: " + amount
            );
            return false;
        }
        if (!isActive) {
            System.err.println("Error: Account is inactive. Cannot withdraw.");
            return false;
        }
        if (!canWithdraw(amount)) {
            System.err.println(
                "Error: Withdrawal exceeds overdraft limit. Available: $" +
                    getAvailableFunds()
            );
            return false;
        }
        setBalance(getBalance() - amount);
        System.out.println(
            "Withdrew: $" + amount + " | New Balance: $" + getBalance()
        );

        String transId = "WDR" + System.currentTimeMillis();
        Withdrawal withdrawal = new Withdrawal(
            transId,
            amount,
            getAccountNumber(),
            "internal"
        );
        withdrawal.execute(this);
        return true;
    }

    /**
     * Applies the yearly fee for this current account.
     *
     * @return the fee amount that was applied
     */
    @Override
    public double applyYearlyFee()    
               throws InsufficientFundsException,
               InvalidAmountException,
               TransactionFailedException {
        withdraw(yearlyFee);
        return yearlyFee;
    }

    /**
     * Checks if withdrawal is within overdraft limit.
     *
     * @param amount the amount to withdraw
     * @return true if withdrawal is allowed, false otherwise
     */
    public boolean canWithdraw(double amount) {
        return (getBalance() - amount) >= -overdraftLimit;
    }

    /**
     * Gets the overdraft limit.
     *
     * @return the overdraft limit
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Gets the yearly fee.
     *
     * @return the yearly fee
     */
    public double getYearlyFee() {
        return yearlyFee;
    }

    /**
     * Gets the transaction limit.
     *
     * @return the transaction limit
     */
    public int getTransactionLimit() {
        return transactionLimit;
    }

    /**
     * Gets the minimum balance.
     *
     * @return the minimum balance
     */
    public double getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Checks if account is active.
     *
     * @return true if active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the account status.
     *
     * @param active the new status
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Gets available balance including overdraft.
     *
     * @return total available funds (balance + overdraft)
     */
    public double getAvailableFunds() {
        return getBalance() + overdraftLimit;
    }
}
