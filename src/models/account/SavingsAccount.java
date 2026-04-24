package models.account;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.TransactionFailedException;
import models.user.User;

/**
 * Represents a savings account that earns interest over time.
 * Extends Account and adds interest rate and minimum balance logic.
 *
 * @author Yosef - 255796
 * @see Account
 * @since Phase 1
 */
public class SavingsAccount extends Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** The interest rate applied to the balance (e.g. 0.05 = 5%) */
    private double interestRate;

    /** The minimum balance that must remain in the account at all times */
    private double minBalance;

    /**
     * Creates a new SavingsAccount with specified details.
     * @param accountNumber the unique account identifier
     * @param balance the initial balance
     * @param owner the User who owns this account
     * @param interestRate the interest rate applied to the balance
     * @param minBalance the minimum balance required at all times
     */
    public SavingsAccount(
        String accountNumber,
        double balance,
        User owner,
        double interestRate,
        double minBalance
    ) {
        super(accountNumber, balance, owner);
        this.interestRate = interestRate;
        this.minBalance = minBalance;
    }

    /**
     * Calculates and adds interest to the balance.
     * Interest = balance x interestRate.
     * Add the interest
     */
    public void addInterest()   
               throws InsufficientFundsException,
               InvalidAmountException,
               TransactionFailedException {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println(
            "Interest added: " + interest + " / New Balance: " + getBalance()
        );
    }

    /**
     * Withdraws money from the account.
     * Overrides parent withdraw to enforce minimum balance rule.
     * A savings account cannot go below the minimum balance.
     *
     * @param value the amount to withdraw
     * @return true if withdrawal was successful, false otherwise
     */
    @Override
    public boolean withdraw(double value) 
              throws InsufficientFundsException,
               InvalidAmountException,
               TransactionFailedException {
        if (value < 0) {
            System.out.println(
                "Error Cannot withdraw negative amount: " + value
            );
            return false;
        }
        if (getBalance() - value < minBalance) {
            System.out.println(
                "Error Withdrawal would breach minimum balance of: " +
                    minBalance +
                    " Available to withdraw: " +
                    (getBalance() - minBalance)
            );
            return false;
        }
        boolean success = super.withdraw(value);
        if (success) {
            System.out.println(
                "Withdrawal successful Remaining balance: " + getBalance()
            );
        }
        return success;
    }

    /**
     * Applies a  yearly fee to the savings account.
     * Deducts 5.0 from the balance using the withdraw method.
     * Called once per year by the system.
     *
     * @return the fee amount that was deducted
     */
    public double applyYearlyFee()   
               throws InsufficientFundsException,
               InvalidAmountException,
               TransactionFailedException {
        double fee = 5.0;
        withdraw(fee);
        return fee;
    }

    /**
     * @return the current interest rate
     */
    public double getInterestRate() {
        return this.interestRate;
    }

    /**
     * Sets the interest rate.
     * @param interestRate the new interest rate to apply
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the minimum balance required
     */
    public double getMinBalance() {
        return this.minBalance;
    }

    /**
     * Sets the minimum balance.
     * @param minBalance the new minimum balance
     */
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    /**
     * Returns string representation of the savings account.
     * Useful for debugging and display purposes.
     * @return savings account details as string
     */
    @Override
    public String toString() {
        return (
            "SavingsAccount: " +
            "accountNumber='" +
            getAccountNumber() +
            ", balance=" +
            getBalance() +
            ", interestRate=" +
            interestRate +
            ", minBalance=" +
            minBalance +
            ", owner=" +
            (getOwner() != null ? getOwner().getName() : "Unknown")
        );
    }
}
