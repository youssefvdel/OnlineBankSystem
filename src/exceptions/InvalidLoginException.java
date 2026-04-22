package exceptions;

/**
 * InvalidLoginException - Custom exception for login failures
 * @author Yousef Mohiey - 248679
 * @since Phase 2
 */
public class InvalidLoginException extends Exception {
    
    /**
     * Constructor with error message
     * @param message The error message to display
     */
    public InvalidLoginException(String message) {
        super(message);
    }
}