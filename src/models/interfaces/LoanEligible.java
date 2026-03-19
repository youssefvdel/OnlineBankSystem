package models.interfaces;

/**
 * @author [yousif hafez_ 258612]
 * @since phase1
 */
public interface LoanEligible {

    /**
     * allows the client to apply for a loan
     */
    void applyForLoan();

    /**
     * returns the maximum loan limit available for the client
     * @return loan limit as double
     */
    double getLoanLimit();
}