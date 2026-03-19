package models.user;

public class PremiumClient extends Client implements LoanEligible {
    private double minBalance;
    private double interestRate;


    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public PremiumClient(
            String userId,
            String name,
            String password,
            String email,
            String client_ID,
            String phoneNumber,
            double minBalance,
            double interestRate)
    {
        super(userId,name,password,email,client_ID,phoneNumber,"Active");
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    @Override
    public String getBenefits() {
        return "Min Balance: " + minBalance + " - Interest Rate: " + interestRate + "%";
    }

    @Override
    public void applyForLoan() {
        System.out.println("Premium client applying for loan...");
    }

    @Override
    public double getLoanLimit() {
        return minBalance * 5;
    }
}
