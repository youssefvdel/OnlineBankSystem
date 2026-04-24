
/*
 * Click nbfs:
 * Click nbfs:
 */
package exceptions;
/**
 * Generic exception for transaction execution failures.
 * @author tareq
 */
public class TransactionFailedException extends Exception{
    private final String method;

    public TransactionFailedException(String method) {
        super("Transaction failed during "+method);
        this.method = method;
    }

    public String getMethod() {
        return method;
    }


}