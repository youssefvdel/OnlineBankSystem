package exceptions;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
    
    public InvalidAmountException(double amount) {
        super("Invalid amount: " + amount);
    }
}
