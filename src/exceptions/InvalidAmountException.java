package exceptions;

/**
 * Exception thrown when amount is invalid
 * 
 * @author Yousif Hafez - 258612
 */
public class InvalidAmountException extends RuntimeException {

    private double amount;

    /**
     * Default constructor
     */
    public InvalidAmountException() {
        super("Invalid amount: must be greater than 0");
    }

    /**
     * Constructor with amount detail
     */
    public InvalidAmountException(double amount) {
        super("Invalid amount: " + amount);
        this.amount = amount;
    }

    /**
     * Gets the invalid amount
     */
    public double getAmount() {
        return amount;
    }
}