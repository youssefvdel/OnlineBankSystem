package models.user;

public class StandardClient extends Client implements Insurable  {
    private double withdrawalLimit;

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public StandardClient(
            String userId,
            String name,
            String password,
            String email,
            String client_ID,
            String phoneNumber,
            double withdrawalLimit) {
        super(userId,name,password,email,client_ID,phoneNumber,"Active");
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public String getBenefits() {
        return "Withdrawal Limit: " + withdrawalLimit;
    }

    @Override
    public String getInsurance() {
        return "Basic account insurance";
    }

    @Override
    public void claimInsurance() {
        System.out.println("Claiming basic insurance...");
    }
}