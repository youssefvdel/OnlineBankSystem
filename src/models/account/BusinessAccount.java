package models.account;

import java.util.ArrayList;
import models.user.User;

/**
 * BusinessAccount represents a business bank account with employee management.
 * Extends Account with additional features for business operations.
 *
 * @author Youssef Adel
 * @version 1.0
 * @since Phase 1
 */
public class BusinessAccount extends Account {

    /** Name of the business */
    private String businessName;

    /** List of employee accounts associated with this business */
    private ArrayList<Account> employeesList;

    /**
     * Creates a new BusinessAccount with specified details.
     *
     * @param accountNumber the unique account identifier
     * @param balance the initial balance
     * @param owner the User who owns this account
     * @param businessName the name of the business
     */
    public BusinessAccount(
        String accountNumber,
        double balance,
        User owner,
        String businessName
    ) {
        super(accountNumber, balance, owner);
        this.businessName = businessName;
        this.employeesList = new ArrayList<>();
    }

    /**
     * Generates a report containing business account details.
     *
     * @return a string representation of the business account report
     */
    public String generateReport() {
        String report = "=== Business Account Report ===\n";
        report += "Business Name: " + businessName + "\n";
        report += "Account Number: " + getAccountNumber() + "\n";
        report += "Balance: $" + getBalance() + "\n";
        report += "Owner: " + getOwner().getName() + "\n";
        report += "Employee Count: " + employeesList.size() + "\n";
        report += "Yearly Fee: $150.00\n";
        report += "================================";
        return report;
    }

    /**
     * Adds an employee account to this business account.
     *
     * @param employee the employee account to add
     */
    public void addEmployee(Account employee) {
        employeesList.add(employee);
        System.out.println("Employee added to Business: " + businessName);
    }

    /**
     * Removes an employee account from this business account.
     *
     * @param employee the employee account to remove
     */
    public void removeEmployee(Account employee) {
        if (employeesList.remove(employee)) {
            System.out.println(
                "Employee removed from Business: " + businessName
            );
        }
    }

    /**
     * Applies the yearly fee for this business account.
     *
     * @return the fee amount that was applied ($150.00)
     */
    public double applyYearlyFee() {
        double fee = 150.0;
        withdraw(fee);
        return fee;
    }

    /**
     * Gets the name of the business.
     *
     * @return the business name
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * Gets the list of employee accounts.
     *
     * @return ArrayList of employee accounts
     */
    public ArrayList<Account> getEmployeesList() {
        return employeesList;
    }

    /**
     * Gets the count of employees in this business account.
     *
     * @return the number of employees
     */
    public int getEmployeeCount() {
        return employeesList.size();
    }
}
