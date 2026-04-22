package gui;

import gui.admin.ViewReportsDialog;
import gui.auth.RegisterFrame;
import gui.util.Toast;
import manager.BankSystem;

import javax.swing.*;
import java.awt.*;

/**
 * Test class for YoussefAdel's GUI components.
 * Run this to test RegisterFrame, Toast, and ViewReportsDialog.
 * @author Youssef Adel 258270
 */
public class YoussefAdelGUITest {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankSystem bank = new BankSystem();
            
            try {
                bank.loadAllData();
                System.out.println("✓ Data loaded successfully");
            } catch (Exception e) {
                System.out.println("⚠ Starting with empty data");
            }
            
            JFrame mainFrame = new JFrame("YoussefAdel GUI Test");
            mainFrame.setSize(300, 200);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            JButton testRegister = new JButton("Test RegisterFrame");
            testRegister.addActionListener(e -> {
                new RegisterFrame(bank).setVisible(true);
            });
            
            JButton testToastSuccess = new JButton("Test Toast Success");
            testToastSuccess.addActionListener(e -> {
                Toast.showSuccess(mainFrame, "Registration successful!\nUser ID: U123456");
            });
            
            JButton testToastError = new JButton("Test Toast Error");
            testToastError.addActionListener(e -> {
                Toast.showError(mainFrame, "Email already exists!");
            });
            
            JButton testReports = new JButton("Test ViewReportsDialog");
            testReports.addActionListener(e -> {
                new ViewReportsDialog(mainFrame).setVisible(true);
            });
            
            JButton exitBtn = new JButton("Exit");
            exitBtn.addActionListener(e -> {
                bank.saveAllData();
                System.exit(0);
            });
            
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            panel.add(testRegister);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(testToastSuccess);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(testToastError);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(testReports);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(exitBtn);
            
            mainFrame.add(panel);
            mainFrame.setVisible(true);
            
            System.out.println("✓ GUI Test Frame opened");
            System.out.println("Click buttons to test each component");
        });
    }
}
