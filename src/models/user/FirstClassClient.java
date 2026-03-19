package models.user;

public class FirstClassClient extends Client {
    private double priorityLevel;

    public double getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(double priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
    public FirstClassClient(
            String userId,
            String name,
            String password,
            String email,
            String client_ID,
            String phoneNumber,
            double priorityLevel)
    {
        super(userId,name,password,email,client_ID,phoneNumber,"Active");
        this.priorityLevel=priorityLevel;
    }
    @Override
    public String getBenefits()
    {
        return "Priority Level:" + priorityLevel +"-VIP treatment";
    }
    public void getVIPServices()
    {
        System.out.println("Access to VIP lounge and dedicated manager");
    }


}
