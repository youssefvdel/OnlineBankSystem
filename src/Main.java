import exceptions.DataLoadException;
import java.util.Scanner;
import manager.BankSystem;

/**
 * Entry point for the banking system console app.
 * @author Youssef Adel - 258270
 */
public class Main {

    private static BankSystem bank;
    private static Scanner scanner;

    /**
     * App starts here.
     */
    public static void main(String[] args) {
        System.out.println("Online Bank System - Phase 2");
        System.out.println("================================\n");

        bank = new BankSystem();
        scanner = new Scanner(System.in);

        // load data from files
        try {
            bank.loadAllData();
        } catch (DataLoadException e) {
            System.err.println("Warning: " + e.getUserMessage());
            System.err.println("Starting with empty data. New data will be saved on exit.");
        }

        // main loop
        boolean running = true;
        while (running) {
            if (bank.getCurrentUser() == null) {
                running = showLoginMenu();
            } else {
                running = showMainMenu();
            }
        }

        // save before exit
        bank.saveAllData();
        scanner.close();
        System.out.println("Goodbye!");
    }

    /**
     * Login/register menu.
     */
    private static boolean showLoginMenu() {
        System.out.println("\n=== LOGIN ===");
        System.out.println("1. Login");
        System.out.println("2. Register (Client)");
        System.out.println("3. Exit");
        System.out.print("Choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                return handleLogin();
            case "2":
                return handleRegister();
            case "3":
                return false;
            default:
                System.out.println("Invalid choice");
                return true;
        }
    }

    /**
     * Handle login with 3 tries max.
     */
    private static boolean handleLogin() {
        System.out.print("User ID: ");
        String userId = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        for (int attempts = 1; attempts <= 3; attempts++) {
            if (bank.login(userId, password)) {
                return true;
            }
            if (attempts < 3) {
                System.out.print(
                    "Retry (" + (3 - attempts) + " left) - Password: "
                );
                password = scanner.nextLine().trim();
            } else {
                System.out.println("Too many attempts. Exiting.");
                return false;
            }
        }
        return false;
    }

    /**
     * Handle new client signup.
     */
    private static boolean handleRegister() {
        System.out.println("\n=== REGISTER ===");
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Password: ");
        String pass = scanner.nextLine().trim();
        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();

        // TODO: actually create the client
        System.out.println("Registration received. Admin approval required.");
        return true;
    }

    /**
     * Show menu based on user role.
     */
    private static boolean showMainMenu() {
        var user = bank.getCurrentUser();
        String role = user.getClass().getSimpleName();

        System.out.println(
            "\n=== Welcome, " + user.getName() + " (" + role + ") ==="
        );

        if (role.equals("Admin")) {
            return showAdminMenu();
        } else {
            return showClientMenu();
        }
    }

    /**
     * Admin options menu.
     */
    private static boolean showAdminMenu() {
        System.out.println("\n[Admin Menu]");
        System.out.println("1. Add Staff");
        System.out.println("2. Remove Staff");
        System.out.println("3. Update Staff");
        System.out.println("4. Generate Report");
        System.out.println("5. Delete Account");
        System.out.println("6. View All Users");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.print("Choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.println("Add Staff - Coming soon");
                break;
            case "2":
                System.out.println("Remove Staff - Coming soon");
                break;
            case "3":
                System.out.println("Update Staff - Coming soon");
                break;
            case "4":
                System.out.println(
                    "Report: " + bank.getCurrentUser().getName() + " logged in"
                );
                break;
            case "5":
                System.out.println("Delete Account - Coming soon");
                break;
            case "6":
                System.out.println(
                    "Users in system: " + bank.getCurrentUser().getClass()
                );
                break;
            case "7":
                bank.getCurrentUser().logout();
                System.out.println("Logged out");
                break;
            case "8":
                return false;
            default:
                System.out.println("Invalid choice");
        }
        return true;
    }

    /**
     * Client options menu.
     */
    private static boolean showClientMenu() {
        System.out.println("\n[Client Menu]");
        System.out.println("1. View Accounts");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View History");
        System.out.println("6. Manage Card");
        System.out.println("7. Pay Bills");
        System.out.println("8. Update Profile");
        System.out.println("9. Logout");
        System.out.println("0. Exit");
        System.out.print("Choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.println("Accounts: [placeholder]");
                break;
            case "2":
                System.out.println("Deposit: [placeholder]");
                break;
            case "3":
                System.out.println("Withdraw: [placeholder]");
                break;
            case "4":
                System.out.println("Transfer: [placeholder]");
                break;
            case "5":
                System.out.println("History: [placeholder]");
                break;
            case "6":
                System.out.println("Manage Card - Coming soon");
                break;
            case "7":
                System.out.println("Pay Bills - Coming soon");
                break;
            case "8":
                System.out.println("Update Profile - Coming soon");
                break;
            case "9":
                bank.getCurrentUser().logout();
                System.out.println("Logged out");
                break;
            case "0":
                return false;
            default:
                System.out.println("Invalid choice");
        }
        return true;
    }
   
}
