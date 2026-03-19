package models.interfaces;

/**
 * @author [yousif hafez_ 258612]
 * @since phase1
 */
public interface Insurable {

    /**
     * returns the insurance type provided to the client
     * @return insurance type as string
     */
    String getInsurance();

    /**
     * allows the client to submit an insurance claim
     */
    void claimInsurable();
}