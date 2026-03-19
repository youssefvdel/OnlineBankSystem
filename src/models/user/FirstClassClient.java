package models.user;

/**
 * @author [yousif hafez_ 258612]
 * @see Client
 * @since phase1
 */
public class FirstClassClient extends Client {

    private double priorityLevel;

    /**
     * returns the priority level of the first class client
     * @return priorityLevel as double
     */
    public double getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * sets the priority level of the first class client
     * @param priorityLevel as double
     */
    public void setPriorityLevel(double priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * creates a first class client with all required client information
     * and assigns a priority level
     * @param userId unique user id
     * @param name client name
     * @param password client password
     * @param email client email
     * @param client_ID client id
     * @param phoneNumber client phone number
     * @param status account status
     * @param priorityLevel client priority level
     */
    public FirstClassClient(
            String userId,
            String name,
            String password,
            String email,
            String client_ID,
            String phoneNumber,
            String status,
            double priorityLevel) {

        super(userId, name, password, email, client_ID, phoneNumber, status);
        this.priorityLevel = priorityLevel;
    }

    /**
     * returns the benefits of the first class client
     * based on the priority level
     * @return benefits as string
     */
    @Override
    public String getBenefits() {
        return "Priority Level:" + priorityLevel + "-VIP treatment";
    }

    /**
     * prints the VIP services available for the first class client
     */
    public void getVIPServices() {
        System.out.println("Access to VIP lounge and dedicated manager");
    }

    /**
     * returns the type of the user
     * @return user type as string
     */
    @Override
    public String getUserType() {
        return "First Class Client";
    }
}