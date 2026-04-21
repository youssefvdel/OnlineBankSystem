package exceptions;

/**
 * Custom exception for file load/save errors.
 * @author Youssef Adel - 258270
 */
public class DataLoadException extends Exception {
    
    private final String fileName;
    private final String operation;
    
    /**
     * Create new exception with message.
     */
    public DataLoadException(String fileName, String operation, String reason) {
        super("Error in " + fileName + " during " + operation + ": " + reason);
        this.fileName = fileName;
        this.operation = operation;
    }
    
    /**
     * Create exception wrapping another error.
     */
    public DataLoadException(String fileName, String operation, Throwable cause) {
        super("Error in " + fileName + ": " + cause.getMessage(), cause);
        this.fileName = fileName;
        this.operation = operation;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public String getOperation() {
        return operation;
    }
    
    /**
     * Return user-friendly error message.
     */
    public String getUserMessage() {
        return "Could not " + operation + " " + fileName + ". Check file permissions.";
    }
}
