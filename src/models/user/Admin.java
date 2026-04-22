package models.user;

import java.util.ArrayList;

/**
 * Admin.java
 *
 * Represents an administrator who can manage users in the system.
 * Extends User to inherit login functionality.
 *
 * @author Yousef Mohiey
 * @since Phase 1
 * @see User
 */
public class Admin extends User {

    /**
     * Constructs a new Admin object.
     *
     * @param userId the unique user ID from parent class
     * @param name the admin's full name
     * @param password the login password
     * @param email the admin's email address
     */
    public Admin(String userId, String name, String password, String email) {
        super(userId, name, password, email);
    }

    /**
     * Adds a new user to the admin's user list.
     * NOTE: This does not check for duplicate user IDs.
     *
     * @param user the User to add
     * @param userList shared list from BankSystem
     */
    public void createUser(User user, ArrayList<User> userList) {
      userList.add(user);
    }

    
 /**
 * Removes a user from the shared user list.
 *
 * @param user The user to remove
 * @param userList The shared list from BankSystem
 * @return true if user was found and removed, false if not found
 */
    
    public boolean deleteUser(User user, ArrayList<User> userList) {
        if (userList.remove(user)) {
            return true;
        } 
        else {
            return false;
             }
    }

/**
 * Returns the list of all users for display.
 *
 * @param userList The shared list to return
 * @return ArrayList of User objects for GUI to display
 */
    
  public ArrayList<User> viewAllUsers (ArrayList<User> userList)
  {
      return userList;
  }

    /**
     * Returns the user type for this Admin object.
     * Implements the abstract method from User class.
     *
     * @return "Admin" indicating this is an administrator
     */
    @Override
    public String getUserType() {
        return "Admin";
    }

} // End of Admin class