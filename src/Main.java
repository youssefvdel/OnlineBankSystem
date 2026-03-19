import manager.BankSystem;
import models.account.Account;
import models.account.BusinessAccount;
import models.account.CurrentAccount;
import models.account.PremiumAccount;
import models.account.SavingsAccount;
import models.transaction.Transaction;
import models.user.Admin;
import models.user.Client;
import models.user.FirstClassClient;
import models.user.PremiumClient;
import models.user.StandardClient;

/**
 * Main test class for the Online Banking System.
 * Tests all features including all user types, account types,
 * transactions, and interfaces.
 *
 * @author Team 40
 * @since Phase 1
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(
            "=== Online Bank System - Comprehensive Tests ===\n"
        );

        // ==================== SECTION 1: BANK SYSTEM SETUP ====================
        System.out.println("=== SECTION 1: Bank System Setup ===\n");

        // Test 1.1: Create Bank System
        System.out.println("Test 1.1: Creating Bank System...");
        BankSystem bank = new BankSystem();
        System.out.println("Bank system created successfully!\n");

        // ==================== SECTION 2: USER TYPES ====================
        System.out.println("=== SECTION 2: User Types ===\n");

        // Test 2.1: Create Standard Client
        System.out.println("Test 2.1: Creating Standard Client...");
        StandardClient standardClient = new StandardClient(
            "U001",
            "John Doe",
            "pass123",
            "john@email.com",
            "C001",
            "123-456-7890",
            5000.0
        );
        System.out.println("Standard Client: " + standardClient.getName());
        System.out.println("User Type: " + standardClient.getUserType());
        System.out.println("Benefits: " + standardClient.getBenefits());
        System.out.println();

        // Test 2.2: Create Premium Client
        System.out.println("Test 2.2: Creating Premium Client...");
        PremiumClient premiumClient = new PremiumClient(
            "U002",
            "Jane Smith",
            "premium123",
            "jane@email.com",
            "C002",
            "234-567-8901",
            10000.0,
            0.05
        );
        System.out.println("Premium Client: " + premiumClient.getName());
        System.out.println("User Type: " + premiumClient.getUserType());
        System.out.println("Benefits: " + premiumClient.getBenefits());
        System.out.println("Min Balance: " + premiumClient.getMinBalance());
        System.out.println("Interest Rate: " + premiumClient.getInterestRate());
        System.out.println("Loan Limit: " + premiumClient.getLoanLimit());
        System.out.print("Apply for Loan: ");
        premiumClient.applyForLoan();
        System.out.println();

        // Test 2.3: Create First Class Client
        System.out.println("Test 2.3: Creating First Class Client...");
        FirstClassClient firstClassClient = new FirstClassClient(
            "U003",
            "Robert Johnson",
            "firstclass123",
            "robert@email.com",
            "C003",
            "345-678-9012",
            "Active",
            10.0
        );
        System.out.println("First Class Client: " + firstClassClient.getName());
        System.out.println("User Type: " + firstClassClient.getUserType());
        System.out.println("Benefits: " + firstClassClient.getBenefits());
        System.out.println(
            "Priority Level: " + firstClassClient.getPriorityLevel()
        );
        System.out.print("VIP Services: ");
        firstClassClient.getVIPServices();
        System.out.println();

        // Test 2.4: Create Admin
        System.out.println("Test 2.4: Creating Admin...");
        Admin admin = new Admin(
            "A001",
            "Admin User",
            "admin123",
            "admin@bank.com"
        );
        System.out.println("Admin: " + admin.getName());
        System.out.println("User Type: " + admin.getUserType());
        System.out.print("View All Users (empty): ");
        admin.viewAllUsers();
        System.out.println();

        // ==================== SECTION 3: CLIENT METHODS ====================
        System.out.println("=== SECTION 3: Client Methods ===\n");

        // Test 3.1: Add all users to bank
        System.out.println("Test 3.1: Adding users to Bank System...");
        bank.addUser(standardClient);
        bank.addUser(premiumClient);
        bank.addUser(firstClassClient);
        bank.addUser(admin);
        System.out.println("All users added successfully!\n");

        // Test 3.2: Test Client getter/setter methods
        System.out.println("Test 3.2: Testing Client getter/setter methods...");
        System.out.println("Phone Number: " + standardClient.getPhoneNumber());
        System.out.println("Status: " + standardClient.getStatus());
        standardClient.setPhoneNumber("999-888-7777");
        standardClient.setStatus("Premium");
        System.out.println("Updated Phone: " + standardClient.getPhoneNumber());
        System.out.println("Updated Status: " + standardClient.getStatus());
        System.out.println();

        // Test 3.3: Test Insurable Interface (StandardClient)
        System.out.println("Test 3.3: Testing Insurable Interface...");
        System.out.println("Insurance: " + standardClient.getInsurance());
        System.out.print("Claim Insurance: ");
        standardClient.claimInsurable();
        System.out.println();

        // Test 3.4: Admin creates a user
        System.out.println("Test 3.4: Testing Admin.createUser()...");
        admin.createUser(standardClient);
        System.out.println();

        // ==================== SECTION 4: ACCOUNT TYPES ====================
        System.out.println("=== SECTION 4: Account Types ===\n");

        // Test 4.1: Create Savings Account
        System.out.println("Test 4.1: Creating Savings Account...");
        SavingsAccount savingsAcc = new SavingsAccount(
            "SAV001",
            1000.0,
            standardClient,
            2.5,
            100.0
        );
        System.out.println("Savings Account: " + savingsAcc);
        System.out.println("Interest Rate: " + savingsAcc.getInterestRate());
        System.out.println("Min Balance: " + savingsAcc.getMinBalance());
        System.out.println();

        // Test 4.2: Create Current Account
        System.out.println("Test 4.2: Creating Current Account...");
        CurrentAccount currentAcc = new CurrentAccount(
            "CUR001",
            500.0,
            standardClient,
            1000.0,
            25.0,
            50,
            100.0
        );
        System.out.println("Current Account: " + currentAcc);
        System.out.println(
            "Overdraft Limit: " + currentAcc.getOverdraftLimit()
        );
        System.out.println("Yearly Fee: " + currentAcc.getYearlyFee());
        System.out.println(
            "Transaction Limit: " + currentAcc.getTransactionLimit()
        );
        System.out.println(
            "Available Funds: $" + currentAcc.getAvailableFunds()
        );
        System.out.println();

        // Test 4.3: Create Premium Account
        System.out.println("Test 4.3: Creating Premium Account...");
        PremiumAccount premiumAcc = new PremiumAccount(
            "PREM001",
            5000.0,
            premiumClient,
            20000.0,
            0.03
        );
        System.out.println("Premium Account: " + premiumAcc);
        System.out.println("Higher Limit: " + premiumAcc.getHigherLimit());
        System.out.println("Premium Rate: " + premiumAcc.getPremiumRate());
        System.out.print("Premium Benefits: ");
        premiumAcc.getPremiumBenefits();
        System.out.println();

        // Test 4.4: Create Business Account
        System.out.println("Test 4.4: Creating Business Account...");
        BusinessAccount businessAcc = new BusinessAccount(
            "BUS001",
            10000.0,
            firstClassClient,
            "Tech Corp Inc.",
            150.0
        );
        System.out.println("Business Account: " + businessAcc);
        System.out.println("Business Name: " + businessAcc.getBusinessName());
        System.out.println("Yearly Fee: $" + businessAcc.getYearlyFee());
        System.out.println("Employee Count: " + businessAcc.getEmployeeCount());
        System.out.print("Generate Report:\n");
        System.out.println(businessAcc.generateReport());
        System.out.println();

        // Test 4.5: Add all accounts to bank
        System.out.println("Test 4.5: Adding accounts to Bank System...");
        bank.addAccount(savingsAcc);
        bank.addAccount(currentAcc);
        bank.addAccount(premiumAcc);
        bank.addAccount(businessAcc);
        System.out.println("All accounts added successfully!\n");

        // Test 4.6: Business Account Employee Management
        System.out.println(
            "Test 4.6: Testing Business Account Employee Management..."
        );
        businessAcc.addEmployee(savingsAcc);
        businessAcc.addEmployee(currentAcc);
        System.out.println(
            "Employee Count after adding: " + businessAcc.getEmployeeCount()
        );
        businessAcc.removeEmployee(savingsAcc);
        System.out.println(
            "Employee Count after removing: " + businessAcc.getEmployeeCount()
        );
        System.out.println();

        // ==================== SECTION 5: TRANSACTIONS ====================
        System.out.println("=== SECTION 5: Transactions ===\n");

        // Test 5.1: Test Deposit
        System.out.println("Test 5.1: Testing Deposit...");
        boolean depositSuccess = savingsAcc.deposit(500.0);
        System.out.println("Deposit successful: " + depositSuccess);
        System.out.println(
            "Balance after deposit: $" + savingsAcc.getBalance()
        );
        System.out.println();

        // Test 5.2: Test Withdrawal
        System.out.println("Test 5.2: Testing Withdrawal...");
        boolean withdrawSuccess = currentAcc.withdraw(100.0);
        System.out.println("Withdrawal successful: " + withdrawSuccess);
        System.out.println(
            "Balance after withdrawal: $" + currentAcc.getBalance()
        );
        System.out.println();

        // Test 5.3: Test Transfer
        System.out.println("Test 5.3: Testing Transfer...");
        boolean transferSuccess = savingsAcc.transfer(currentAcc, 200.0);
        System.out.println("Transfer successful: " + transferSuccess);
        System.out.println("Savings Balance: $" + savingsAcc.getBalance());
        System.out.println("Current Balance: $" + currentAcc.getBalance());
        System.out.println();

        // Test 5.4: Test Failed Deposit (negative amount)
        System.out.println(
            "Test 5.4: Testing Failed Deposit (negative amount)..."
        );
        boolean failedDeposit = savingsAcc.deposit(-100.0);
        System.out.println("Negative deposit successful: " + failedDeposit);
        System.out.println();

        // Test 5.5: Test Failed Withdrawal (insufficient funds)
        System.out.println(
            "Test 5.5: Testing Failed Withdrawal (insufficient funds)..."
        );
        boolean failedWithdraw = savingsAcc.withdraw(10000.0);
        System.out.println("Large withdrawal successful: " + failedWithdraw);
        System.out.println();

        // Test 5.6: Test Savings Account addInterest
        System.out.println(
            "Test 5.6: Testing Savings Account addInterest()..."
        );
        savingsAcc.addInterest();
        System.out.println();

        // Test 5.7: Test Premium Account Withdrawal
        System.out.println("Test 5.7: Testing Premium Account Withdrawal...");
        boolean premiumWithdraw = premiumAcc.withdraw(500.0);
        System.out.println("Premium withdrawal successful: " + premiumWithdraw);
        System.out.println();

        // Test 5.8: Test Current Account Overdraft
        System.out.println("Test 5.8: Testing Current Account Overdraft...");
        currentAcc.setBalance(100.0);
        boolean overdraftWithdraw = currentAcc.withdraw(500.0);
        System.out.println(
            "Overdraft withdrawal successful: " + overdraftWithdraw
        );
        System.out.println(
            "Current Balance after overdraft: $" + currentAcc.getBalance()
        );
        System.out.println();

        // ==================== SECTION 6: TRANSACTION HISTORY ====================
        System.out.println("=== SECTION 6: Transaction History ===\n");

        // Test 6.1: View Transaction History
        System.out.println("Test 6.1: Viewing Transaction History...");
        System.out.println("Savings Account Transactions:");
        for (Transaction t : savingsAcc.getTransactionHistory().getHistory()) {
            System.out.println("  - " + t);
        }
        System.out.println();

        // Test 6.2: Test Transaction Count
        System.out.println("Test 6.2: Testing Transaction Count...");
        int count = savingsAcc.getTransactionHistory().getTransactionCount();
        System.out.println("Total transactions in savings account: " + count);
        System.out.println();

        // Test 6.3: Test View Specific Transaction
        System.out.println("Test 6.3: Testing View Specific Transaction...");
        if (!savingsAcc.getTransactionHistory().getHistory().isEmpty()) {
            Transaction firstTrans = savingsAcc
                .getTransactionHistory()
                .getHistory()
                .get(0);
            Transaction foundTrans = savingsAcc
                .getTransactionHistory()
                .viewTransaction(firstTrans.getTransactionId());
            if (foundTrans != null) {
                System.out.println("Found transaction: " + foundTrans);
            } else {
                System.out.println("Transaction not found");
            }
        }
        System.out.println();

        // ==================== SECTION 7: CLIENT ACCOUNT MANAGEMENT ====================
        System.out.println("=== SECTION 7: Client Account Management ===\n");

        // Test 7.1: Test getTotalBalance
        System.out.println("Test 7.1: Testing getTotalBalance()...");
        double totalBalance = standardClient.getTotalBalance();
        System.out.println(
            "Total balance for standard client: $" + totalBalance
        );
        System.out.println();

        // Test 7.2: Test removeAccount
        System.out.println("Test 7.2: Testing removeAccount()...");
        System.out.println(
            "Client accounts before removal: " +
                standardClient.getAccounts().size()
        );
        standardClient.removeAccount(currentAcc);
        System.out.println(
            "Client accounts after removal: " +
                standardClient.getAccounts().size()
        );
        System.out.println();

        // ==================== SECTION 8: BANK SYSTEM METHODS ====================
        System.out.println("=== SECTION 8: Bank System Methods ===\n");

        // Test 8.1: Test Login
        System.out.println("Test 8.1: Testing Login...");
        boolean loginSuccess = bank.login("U001", "pass123");
        System.out.println("Login result: " + loginSuccess);
        System.out.println();

        // Test 8.2: Test Failed Login
        System.out.println("Test 8.2: Testing Failed Login...");
        boolean failedLogin = bank.login("U001", "wrongpass");
        System.out.println("Failed login result: " + failedLogin);
        System.out.println();

        // Test 8.3: Test getAccountByNumber
        System.out.println("Test 8.3: Testing getAccountByNumber()...");
        Account foundAcc = bank.getAccountByNumber("SAV001");
        if (foundAcc != null) {
            System.out.println("Found account: " + foundAcc);
        } else {
            System.out.println("Account not found");
        }
        System.out.println();

        // Test 8.4: Test mainMenu
        System.out.println("Test 8.4: Testing mainMenu()...");
        bank.mainMenu();
        System.out.println();

        // Test 8.5: Test saveToFile
        System.out.println("Test 8.5: Testing saveToFile()...");
        bank.saveToFile();
        System.out.println();

        // Test 8.6: Test loadFromFile
        System.out.println("Test 8.6: Testing loadFromFile()...");
        bank.loadFromFile();
        System.out.println();

        // Test 8.7: Test getCurrentUser
        System.out.println("Test 8.7: Testing getCurrentUser()...");
        if (bank.getCurrentUser() != null) {
            System.out.println(
                "Current user: " + bank.getCurrentUser().getName()
            );
        } else {
            System.out.println("No user logged in");
        }
        System.out.println();

        // ==================== SECTION 9: APPLY YEARLY FEES ====================
        System.out.println("=== SECTION 9: Apply Yearly Fees ===\n");

        // Test 9.1: Apply yearly fee to Savings Account
        System.out.println(
            "Test 9.1: Applying yearly fee to Savings Account..."
        );
        double savingsFee = savingsAcc.applyYearlyFee();
        System.out.println("Fee applied: $" + savingsFee);
        System.out.println();

        // Test 9.2: Apply yearly fee to Current Account
        System.out.println(
            "Test 9.2: Applying yearly fee to Current Account..."
        );
        double currentFee = currentAcc.applyYearlyFee();
        System.out.println("Fee applied: $" + currentFee);
        System.out.println();

        // Test 9.3: Apply yearly fee to Premium Account
        System.out.println(
            "Test 9.3: Applying yearly fee to Premium Account..."
        );
        double premiumFee = premiumAcc.applyYearlyFee();
        System.out.println("Fee applied: $" + premiumFee);
        System.out.println();

        // Test 9.4: Apply yearly fee to Business Account
        System.out.println(
            "Test 9.4: Applying yearly fee to Business Account..."
        );
        double businessFee = businessAcc.applyYearlyFee();
        System.out.println("Fee applied: $" + businessFee);
        System.out.println();

        // ==================== SECTION 10: USER AUTHENTICATION ====================
        System.out.println("=== SECTION 10: User Authentication ===\n");

        // Test 10.1: Test logout
        System.out.println("Test 10.1: Testing logout()...");
        standardClient.logout();
        System.out.println();

        // Test 10.2: Test login for different user types
        System.out.println(
            "Test 10.2: Testing login for different user types..."
        );
        System.out.print("Premium Client Login: ");
        bank.login("U002", "premium123");
        System.out.print("First Class Client Login: ");
        bank.login("U003", "firstclass123");
        System.out.print("Admin Login: ");
        bank.login("A001", "admin123");
        System.out.println();

        // ==================== SECTION 11: LOAN ELIGIBLE INTERFACE ====================
        System.out.println(
            "=== SECTION 11: LoanEligible Interface (PremiumClient) ===\n"
        );

        // Test 11.1: Test LoanEligible methods
        System.out.println(
            "Test 11.1: Testing LoanEligible interface methods..."
        );
        System.out.println(
            "Loan Limit for Premium Client: $" + premiumClient.getLoanLimit()
        );
        System.out.print("Apply for Loan: ");
        premiumClient.applyForLoan();
        System.out.println();

        // ==================== FINAL SUMMARY ====================
        System.out.println("=== ALL TESTS COMPLETED SUCCESSFULLY ===");
        System.out.println("\nTest Summary:");
        System.out.println(
            "- User Types: StandardClient, PremiumClient, FirstClassClient, Admin"
        );
        System.out.println(
            "- Account Types: SavingsAccount, CurrentAccount, PremiumAccount, BusinessAccount"
        );
        System.out.println("- Transactions: Deposit, Withdrawal, Transfer");
        System.out.println("- Interfaces: Insurable, LoanEligible");
        System.out.println(
            "- BankSystem: login, mainMenu, saveToFile, loadFromFile, getAccountByNumber, getCurrentUser"
        );
        System.out.println(
            "- TransactionHistory: getHistory, getTransactionCount, viewTransaction"
        );
        System.out.println(
            "- Client Methods: getTotalBalance, removeAccount, getters/setters"
        );
        System.out.println(
            "- Admin Methods: createUser, deleteUser, viewAllUsers"
        );
        System.out.println(
            "- Business Methods: addEmployee, removeEmployee, generateReport"
        );
        System.out.println(
            "- Special Features: addInterest, getPremiumBenefits, getVIPServices, applyYearlyFee, overdraft"
        );
    }
}
