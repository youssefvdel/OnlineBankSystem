/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< Updated upstream
package src.exceptions;
=======
package exceptions;
>>>>>>> Stashed changes

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
    
    
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
