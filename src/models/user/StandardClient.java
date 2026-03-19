package models.user;

/**
 * @author [yousif hafez_ 258612]
 * @see Client
 * @see Insurable
 * @since phase1
 */
public class StandardClient extends Client implements Insurable {

    private double withdrawalLimit;

    /**
     * returns the withdrawal limit of the standard client
     * @return withdrawalLimit as double
     */
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    /**
     * sets the withdrawal limit of the standard client
     * @param withdrawalLimit as double
     */
    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    /**
     * creates a standard client with all required client information
     * and assigns the withdrawal limit
     * @param userId unique user id
     * @param name client name
     * @param password client password
     * @param email client email
     * @param client_ID client id
     * @param phoneNumber client phone number
     * @param withdrawalLimit maximum withdrawal limit
     */
    public StandardClient(
            String userId,
            String name,
            String password,
            String email,
            String client_ID,
            String phoneNumber,
            double withdrawalLimit) {
        super(userId, name, password, email, client_ID, phoneNumber, "Active");
        this.withdrawalLimit = withdrawalLimit;
    }

    /**
     * returns the benefits of the standard client
     * @return benefits as string
     */
    @Override
    public String getBenefits() {
        return "Withdrawal Limit: " + withdrawalLimit;
    }

    /**
     * returns the insurance type for the standard client
     * @return insurance as string
     */
    @Override
    public String getInsurance() {
        return "Basic account insurance";
    }

    /**
     * allows the standard client to claim insurance
     */
    @Override
    public void claimInsurance() {
        System.out.println("Claiming basic insurance...");
    }

    /**
     * returns the type of the user
     * @return user type as string
     */
    @Override
    public String getUserType() {
        return "Standard Client";
    }
}