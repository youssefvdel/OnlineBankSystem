package exceptions;

/**
 * Exception thrown when trying to delete an account
 * that still has a positive balance.
 *
 * @author Yousif Hafez - 258612
 */
public class AccountDeletionException extends RuntimeException {

    /**
     * Default constructor with message
     */
    public AccountDeletionException() {
        super("Cannot delete account: balance must be zero");
    }

    /**
     * Custom message constructor
     */
    public AccountDeletionException(String message) {
        super(message);
    }
}