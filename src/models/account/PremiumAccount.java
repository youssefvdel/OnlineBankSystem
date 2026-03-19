package models.account;

import models.user.User;

/**
 * Represents a premium account with higher limits and special benefits.
 * Extends Account and adds higher withdrawal limit and premium rate logic.
 * @author Yosef - 255796
 * @see Account
 * @since Phase 1
 */
public class PremiumAccount extends Account {

    /**
     * The higher withdrawal limit allowed for premium accounts
     */
    private double higherLimit;
    /**
     * The premium rate used to calculate special benefits
     */
    private double premiumRate;

    /**
     * Creates a new PremiumAccount with specified details.
     * @param accountNumber the unique account identifier
     * @param balance       the initial balance
     * @param owner         the User who owns this account
     * @param higherLimit   the higher withdrawal limit for premium accounts
     * @param premiumRate   the premium rate applied for benefits
     */
    public PremiumAccount(
        String accountNumber,
        double balance,
        User owner,
        double higherLimit,
        double premiumRate
    ) {
        // Call the parent Account constructor to set up base attributes
        super(accountNumber, balance, owner);
        this.higherLimit = higherLimit;
        this.premiumRate = premiumRate;
    }

    /**
     * Withdraws money from the account.
     * Overrides parent withdraw to allow higher withdrawal limit.
     * Premium accounts can withdraw up to higherLimit in one transaction.
     * @param value the amount to withdraw
     */
    @Override
    public void withdraw(double value) {
        if (value < 0) {
            System.out.println(
                "Error Cannot withdraw negative amount: " + value
            );
            return;
        }
        // Check if withdrawal exceeds the higher limit allowed
        if (value > higherLimit) {
            System.out.println(
                "Error Amount exceeds premium withdrawal limit of: " +
                    higherLimit
            );
            return;
        }
        // Check if balance is sufficient
        if (value > getBalance()) {
            System.out.println(
                "Error Insufficient balance Available: " + getBalance()
            );
            return;
        }
        // If all checks pass call the parent withdraw method
        super.withdraw(value);
        System.out.println(
            "Premium withdrawal successful Remaining balance: " + getBalance()
        );
    }

    /**
     * Displays and returns the premium benefits available to this account.
     * Benefits are calculated based on the current balance and premiumRate.
     * Called when the client wants to view their premium perks.
     */
    public void getPremiumBenefits() {
        // Calculate the bonus amount the client is entitled to
        double bonusAmount = getBalance() * premiumRate;
        // Get owner name
        String ownerName;
        if (getOwner() != null) {
            ownerName = getOwner().getName();
        } else {
            ownerName = "Unknown";
        }
        // Print a full benefits summary to the screen
        System.out.println("Premium Account Benefits");
        System.out.println("Account No: " + getAccountNumber());
        System.out.println("Current Balance: " + getBalance());
        System.out.println("Premium Rate: " + (premiumRate * 100) + "%");
        System.out.println("Bonus Amount: " + bonusAmount);
        System.out.println("Higher Limit: " + higherLimit);
    }

    /**
     * Applies a fixed yearly fee to the premium account.
     * Deducts 75.0 from the balance using the withdraw method.
     * Called once per year by the system.
     * @return the fee amount that was deducted
     */
    public double applyYearlyFee() {
        // yearly fee amount for premium accounts
        double fee = 75.0;
        // Deduct the fee using the overridden withdraw method
        withdraw(fee);
        // Return the fee so the caller knows how much was deducted
        return fee;
    }

    /**
     * @return the higher withdrawal limit
     */
    public double getHigherLimit() {
        return this.higherLimit;
    }

    /**
     * Sets the higher withdrawal limit.
     * @param higherLimit the new higher withdrawal limit
     */
    public void setHigherLimit(double higherLimit) {
        this.higherLimit = higherLimit;
    }

    /**
     * @return the premium rate
     */
    public double getPremiumRate() {
        return this.premiumRate;
    }

    /**
     * Sets the premium rate.
     * @param premiumRate the new premium rate to apply
     */
    public void setPremiumRate(double premiumRate) {
        this.premiumRate = premiumRate;
    }

    /**
     * Returns string representation of the premium account.
     * Useful for debugging and display purposes.
     * @return premium account details as string
     */
    @Override
    public String toString() {
        // Get owner name
        String ownerName;
        if (getOwner() != null) {
            ownerName = getOwner().getName();
        } else {

            ownerName = "Unknown";
        }
        return (
            "PremiumAccount " +
            "accountNumber='" +
            getAccountNumber() +
            ", balance=" +
            getBalance() +
            ", higherLimit=" +
            higherLimit +
            ", premiumRate=" +
            premiumRate +
            ", owner=" +
            ownerName
        );
    }
}
