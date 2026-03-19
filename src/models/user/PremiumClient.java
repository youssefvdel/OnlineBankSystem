package models.user;

import models.interfaces.LoanEligible;

/**
 * @author [yousif hafez_ 258612]
 * @see Client
 * @see LoanEligible
 * @since phase1
 */
public class PremiumClient extends Client implements LoanEligible {

    private double minBalance;
    private double interestRate;

    /**
     * returns the minimum balance of the premium client
     * @return minBalance as double
     */
    public double getMinBalance() {
        return minBalance;
    }

    /**
     * sets the minimum balance of the premium client
     * @param minBalance as double
     */
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    /**
     * returns the interest rate of the premium client
     * @return interestRate as double
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * sets the interest rate of the premium client
     * @param interestRate as double
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * creates a premium client with all required client information
     * and assigns minimum balance and interest rate
     * @param userId unique user id
     * @param name client name
     * @param password client password
     * @param email client email
     * @param client_ID client id
     * @param phoneNumber client phone number
     * @param minBalance minimum required balance
     * @param interestRate client interest rate
     */
    public PremiumClient(
            String userId,
            String name,
            String password,
            String email,
            String client_ID,
            String phoneNumber,
            double minBalance,
            double interestRate) {
        super(userId, name, password, email, client_ID, phoneNumber, "Active");
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    /**
     * returns the benefits of the premium client
     * including high interest rate and special loan privileges
     * @return benefits as string
     */
    @Override
    public String getBenefits() {
        return "Premium Benefits: minimum balance = " + minBalance
                + ", interest rate = " + interestRate + "%"
                + ", higher loan eligibility, and priority banking support";
    }

    /**
     * allows the premium client to apply for a loan
     */
    @Override
    public void applyForLoan() {
        System.out.println("Premium client applying for loan...");
    }

    /**
     * returns the loan limit of the premium client
     * @return loan limit as double
     */
    @Override
    public double getLoanLimit() {
        return minBalance * 5;
    }

    /**
     * returns the type of the user
     * @return user type as string
     */
    @Override
    public String getUserType() {
        return "Premium Client";
    }
}