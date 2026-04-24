package exceptions;

/**
 * Custom exception thrown when data persistence operations fail.
 * Provides context about which file and operation caused the error,
 * along with a user-friendly message for display.
 *
 * @author Youssef Adel 258270
 * @version Phase 2
 */
public class DataLoadException extends Exception {

    /** The name of the file involved in the error */
    private final String fileName;

    /** The operation that failed (e.g., "read", "write", "parse") */
    private final String operation;

    /**
     * Creates a new DataLoadException with a descriptive message.
     *
     * @param fileName the name of the file being accessed
     * @param operation the operation that failed
     * @param reason a brief description of why the operation failed
     */
    public DataLoadException(String fileName, String operation, String reason) {
        super("Error in " + fileName + " during " + operation + ": " + reason);
        this.fileName = fileName;
        this.operation = operation;
    }

    /**
     * Creates a new DataLoadException wrapping another exception.
     *
     * @param fileName the name of the file being accessed
     * @param operation the operation that failed
     * @param cause the underlying exception that caused this error
     */
    public DataLoadException(String fileName, String operation, Throwable cause) {
        super("Error in " + fileName + ": " + cause.getMessage(), cause);
        this.fileName = fileName;
        this.operation = operation;
    }

    /**
     * Returns the name of the file involved in the error.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns the operation that failed.
     *
     * @return the operation name (e.g., "read", "write")
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Returns a user-friendly error message suitable for display.
     *
     * @return a message explaining what the user should check
     */
    public String getUserMessage() {
        return "Could not " + operation + " " + fileName + ". Check file permissions.";
    }
}
