package exceptions;

/**
 * Thrown when creating a staff member with duplicate or invalid data.
 * @author Yousef Mohiey - 248679
 */


public class StaffCreationException extends Exception {
    public StaffCreationException(String message) {
        super(message);
    }
}