import manager.BankSystem;
import models.account.Account;
import models.account.CurrentAccount;
import models.account.SavingsAccount;
import models.transaction.Transaction;
import models.user.Client;
import models.user.StandardClient;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Online Bank System Tests ===\n");

        // Test 1: Create Bank System
        System.out.println("Test 1: Creating Bank System...");
        BankSystem bank = new BankSystem();
        System.out.println("Bank system created successfully!\n");

        // Test 2: Create a Client
        System.out.println("Test 2: Creating a Client...");
        Client client1 = new StandardClient(
            "U001", // userId
            "John Doe", // name
            "pass123", // password
            "john@email.com", // email
            "C001", // client_ID
            "123-456-7890", // phoneNumber
            5000.0 // withdrawalLimit
        );
        System.out.println("Client created: " + client1.getName());
        System.out.println("Client ID: " + client1.getClientId());
        System.out.println("User Type: " + client1.getUserType());
        System.out.println("Benefits: " + client1.getBenefits());
        System.out.println();

        // Test 3: Add Client to Bank System
        System.out.println("Test 3: Adding Client to Bank System...");
        bank.addUser(client1);
        System.out.println("Client added successfully!\n");

        // Test 4: Create Accounts
        System.out.println("Test 4: Creating Accounts...");
        Account savingsAcc = new SavingsAccount(
            "SAV001",
            1000.0,
            client1,
            2.5,
            100.0
        );
        Account currentAcc = new CurrentAccount(
            "CUR001",
            500.0,
            client1,
            1000.0,
            25.0,
            50,
            100.0
        );

        System.out.println("Savings Account: " + savingsAcc);
        System.out.println("Current Account: " + currentAcc);
        System.out.println();

        // Test 5: Add Accounts to Bank System
        System.out.println("Test 5: Adding Accounts to Bank System...");
        bank.addAccount(savingsAcc);
        bank.addAccount(currentAcc);
        System.out.println("Accounts added successfully!\n");

        // Test 6: Test Deposit
        System.out.println("Test 6: Testing Deposit...");
        savingsAcc.deposit(500.0);
        System.out.println(
            "Balance after deposit: $" + savingsAcc.getBalance()
        );
        System.out.println();

        // Test 7: Test Withdrawal
        System.out.println("Test 7: Testing Withdrawal...");
        currentAcc.withdraw(100.0);
        System.out.println(
            "Balance after withdrawal: $" + currentAcc.getBalance()
        );
        System.out.println();

        // Test 8: Test Transfer Between Accounts
        System.out.println("Test 8: Testing Transfer...");
        boolean transferSuccess = savingsAcc.transfer(currentAcc, 200.0);
        System.out.println("Transfer successful: " + transferSuccess);
        System.out.println("Savings Balance: $" + savingsAcc.getBalance());
        System.out.println("Current Balance: $" + currentAcc.getBalance());
        System.out.println();

        // Test 9: Test Login
        System.out.println("Test 9: Testing Login...");
        boolean loginSuccess = bank.login("U001", "pass123");
        System.out.println("Login result: " + loginSuccess);
        System.out.println();

        // Test 10: View Client's Total Balance
        System.out.println("Test 10: Viewing Client's Total Balance...");
        double totalBalance = client1.getTotalBalance();
        System.out.println(
            "Total balance across all accounts: $" + totalBalance
        );
        System.out.println();

        // Test 11: View Transaction History
        System.out.println("Test 11: Viewing Transaction History...");
        System.out.println("Savings Account Transactions:");
        for (Transaction t : savingsAcc.getTransactionHistory().getHistory()) {
            System.out.println("  - " + t);
        }
        System.out.println();

        // Test 12: Test Failed Login
        System.out.println("Test 12: Testing Failed Login...");
        boolean failedLogin = bank.login("U001", "wrongpass");
        System.out.println("Failed login result: " + failedLogin);
        System.out.println();

        System.out.println("=== All Tests Completed ===");
    }
}
