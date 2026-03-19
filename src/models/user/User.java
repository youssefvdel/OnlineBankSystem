/**
 * User.java
 * This is an abstract class that represents a user in the banking system.
 * It is the parent class for Admin and Client.
 *
 * @author Yousef Mohiey - 248679
 * @since Phase 1
 */

package models.user;

public abstract class User {
    // "private" means only User can access those variables
    private String userId;
    private String name;
    private String password;
    private String email;

    /**
     * @param userId   The unique ID for this user
     * @param name     The full name of the user
     * @param password The password for login confirmation
     * @param email    The email address of the user
     */
    public User(String userId, String name, String password, String email) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
    }
/**
 * Checks if password is correct
 * @param inputPassword password user typed
 * @return true if match, false if wrong
 */
public boolean login(String inputPassword)
{
    return this.password.equals(inputPassword);
}

}