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
public class Admin extends User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    
    private String phoneNumber;
    private String jobTitle;
    
    /**
     * Constructs a new Admin object.
     *
     * @param userId the unique user ID from parent class
     * @param name the admin's full name
     * @param password the login password
     * @param email the admin's email address
     * @param phone the admin's phone number
     * @param job the admin's job title
     */
    public Admin(String userId, String name, String password, String email, String phone, String job) {
        super(userId, name, password, email);
        this.phoneNumber = phone;  
        this.jobTitle = job;        
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Adds a new user to the admin's user list.
     */
    public void createUser(User user, ArrayList<User> userList) {
        userList.add(user);
    }

    /**
     * Removes a user from the shared user list.
     */
    public boolean deleteUser(User user, ArrayList<User> userList) {
        return userList.remove(user);
    }

    /**
     * Returns the list of all users for display.
     */
    public ArrayList<User> viewAllUsers(ArrayList<User> userList) {
        return userList;
    }

    @Override
    public String getUserType() {
        return "Admin";
    }

}