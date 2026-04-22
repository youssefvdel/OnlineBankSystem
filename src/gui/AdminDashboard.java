package gui;

import models.user.User;
import javax.swing.JFrame;

public class AdminDashboard extends JFrame {
    public AdminDashboard(User user) {
        setTitle("Admin Dashboard - Welcome, " + user.getName());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        javax.swing.JLabel label = new javax.swing.JLabel(
            "Admin Dashboard\nWelcome, " + user.getName(),
            javax.swing.SwingConstants.CENTER
        );
        label.setFont(new java.awt.Font("sansserif", 1, 24));
        add(label);
        
        setVisible(true);
    }
}