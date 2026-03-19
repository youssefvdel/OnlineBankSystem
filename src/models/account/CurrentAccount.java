package models.account;

public class CurrentAccount extends Account {

    private double overdraftLimit;
    private double fee;

    public CurrentAccount(
        String accountNumber,
        double balance,
        User owner,
        double overdraftLimit,
        double fee
    ) {
        super(accountNumber, balance, owner);
        this.overdraftLimit = overdraftLimit;
        this.fee = fee;
    }

    public double applyYearlyFee() {
        double fee = 20.0;
        withdraw(fee);
        return fee;
    }
}
