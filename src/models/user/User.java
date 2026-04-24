/**
 * User.java
 * This is an abstract class that represents a user in the banking system.
 * It is the parent class for Admin and Client.
 *
 * @author Yousef Mohiey - 248679
 * @since Phase 1
 */

package models.user;

public abstract class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
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
 * Cheking Passowrd
 * @param inputPassword password user entered
 * @return true if matching password, false if wrong
 */
public boolean login(String inputPassword)
{
    return this.password.equals(inputPassword);
}


    /**
     * Logs out the current user.
     * Displays a confirmation message to the console.
     */
public void logout()
{
    System.out.println("User "+this.name+" logged out");
}
//   =============== [GETTERS]===============
    /**
     * Gets the user's unique identifier.
     *
     * @return the userId as a String
     */

    public String getUserId()
    {
    return this.userId;
    }

    /**
     * Gets the user's email address.
     *
     * @return the email as a String
     */
    public String getEmail()
    {
        return this.email;
    }
    /**
     * Gets the user's name
     *
     * @return name as a String
     */

    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the user password.
     * @return the password as a String
     */
    public String getPassword()
    {
        return this.password;
    }

//   =============== [SETTERS]===============
/**
 * Sets the user id
 *
  @param userId the new ID for the user
 */
    public void setUserId(String userId)
    {this.userId = userId;}

    /**
     * Sets the user full name
     *
     * @param name the new name for the user
     */
    public void setName(String name)
    {this.name = name;}

    /**
     * Sets the user email address
     * @param email the new email address for the user
     *
     */
    public void setEmail(String email)
    {this.email= email;}

    /**
     * Sets the user password.
     * @param password the new password for the user
     */
    public void setPassword(String password)
    {this.password = password;}


    /**
     * Returns the type of user (Admin or Client).
     * Polymorphism.
     * @return "Admin" or "Client"
     */
    public abstract String getUserType();


}
// === End of the class ===
