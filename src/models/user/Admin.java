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

    /** List of users managed by this admin */
    private ArrayList<User> users;

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
        this.users = new ArrayList<>();
    }

    /**
     * Adds a new user to the admin's user list.
     * NOTE: This does not check for duplicate user IDs.
     *
     * @param user the User object to add
     */
    public void createUser(User user) {
        users.add(user);
        System.out.println("User " + user.getName() + " added successfully.");
    }

    /**
     * Removes a user from the admin's user list.
     *
     * @param user the User object to remove
     * @return true if user was found and removed
     *         false if user was not in the list
     */
    public boolean deleteUser(User user) {
        if (users.remove(user)) {
            System.out.println("User " + user.getName() + " deleted.");
            return true;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    /**
     * Displays all users in the admin's list.
     * Shows name, email, and user type for each user.
     */
    public void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in system.");
            return;
        }

        for (User user : users) {
            System.out.println("Name: " + user.getName() +
                    " | Email: " + user.getEmail() +
                    " | Type: " + user.getUserType());
        }
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