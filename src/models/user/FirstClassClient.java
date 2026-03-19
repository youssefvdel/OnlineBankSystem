package models.user;

/**
 * @author [yousif hafez_ 258612]
 * @see Client
 * @since phase1
 */
public class FirstClassClient extends Client {

    private double priorityLevel;

    /**
     * @return priorityLevel
     */
    public double getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * @param priorityLevel
     */
    public void setPriorityLevel(double priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * @param userId
     * @param name
     * @param password
     * @param email
     * @param client_ID
     * @param phoneNumber
     * @param Status
     * @param priorityLevel
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

        super(userId, name, password, email, client_ID, phoneNumber,status);
        this.priorityLevel = priorityLevel;
    }

    /**
     * @return client benefits based on priority level
     */
    @Override
    public String getBenefits() {
        return "Priority Level:" + priorityLevel + "-VIP treatment";
    }

    /**
     * prints VIP services available for first class client
     */
    public void getVIPServices() {
        System.out.println("Access to VIP lounge and dedicated manager");
    }
}
