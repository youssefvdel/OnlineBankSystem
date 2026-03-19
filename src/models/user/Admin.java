package models.user;


import models.user.User;

import java.util.ArrayList;

/**
 * Admin.java
 *
 * Represents an administrator user in the banking system.
 * Extends the User class and inherits all its attributes and methods.
 * Provides additional functionality for user management.
 *
 * @author Yousef Mohiey
 * @since Phase one
 * @see User
 */

public class Admin extends User
{
    /**
     * @param userId  The unique ID for this user
     * @param name  The full name of the user
     * @param password The password for login confirmation
     * @param email    The email address of the user
     */
    public Admin(String userId, String name, String password, String email)
    {
        super(userId, name, password, email);
    }


    /**
     * Adds a new user to the system.
     *
     * @param userId new user's id
     * @param name new user's name
     * @param password new user's password
     * @param email new user's email
     * @param userType "Admin" or "Client"
     * @param userList the list we're adding to
     * @return the new user, or null if failed
     */
    public User createUser(String userId, String name, String password,
                           String email, String userType, ArrayList<User> userList)
    {

        System.out.println("Admin "+getName()+" creating"+userType+": "+name);


    }
