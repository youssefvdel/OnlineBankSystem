import manager.BankSystem;
import gui.auth.LoginFrame;
import exceptions.DataLoadException;

/**
 * Entry point for the GUI banking system.
 * Launches LoginFrame after loading data.
 * @author Team
 */
public class Main {
    public static void main(String[] args) {
        // Create the banking system
        BankSystem bank = new BankSystem();
        
        // Load user data from CSV files
        try {
            bank.loadAllData();
        } catch (DataLoadException e) {
            System.err.println("Warning: " + e.getMessage());
            System.err.println("Starting with empty data.");
        }
        
        // Launch the login GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginFrame(bank).setVisible(true);
        });
    }
}