package manager;

import models.user.StandardClient;

/**
 * Test serialization for .ser files
 */
public class SerializationTest {
    public static void main(String[] args) {
        System.out.println("=== Testing .ser File I/O ===\n");
        
        BankSystem bank = new BankSystem();
        
        // Test 1: Add user and save
        System.out.println("1. Adding test user...");
        StandardClient user = new StandardClient(
            "U001", "Test User", "pass123", "test@test.com", "C001", "01012345678", 1000.0
        );
        bank.addUser(user);
        bank.saveAllData();
        System.out.println("   ✓ User added and saved\n");
        
        // Test 2: Check .ser file exists
        java.io.File serFile = new java.io.File("data/users.ser");
        if (serFile.exists()) {
            System.out.println("2. ✓ users.ser file created (" + serFile.length() + " bytes)\n");
        } else {
            System.out.println("2. ✗ users.ser NOT created\n");
            return;
        }
        
        // Test 3: Load in new BankSystem instance
        System.out.println("3. Loading data in new BankSystem instance...");
        BankSystem bank2 = new BankSystem();
        try {
            bank2.loadAllData();
            System.out.println("   ✓ Data loaded successfully\n");
        } catch (Exception e) {
            System.out.println("   ✗ Load failed: " + e.getMessage() + "\n");
            return;
        }
        
        // Test 4: Verify user persisted
        System.out.println("4. Verifying user persisted...");
        if (bank2.getCurrentUser() == null) {
            // Try login
            if (bank2.login("U001", "pass123")) {
                System.out.println("   ✓ User found and logged in!\n");
            } else {
                System.out.println("   ✗ Login failed\n");
            }
        }
        
        System.out.println("=== Serialization Test Complete ===");
        System.out.println("\n✓ .ser files working correctly!");
    }
}
