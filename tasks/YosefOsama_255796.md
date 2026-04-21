# 🎯 Yosef Osama (255796) - Phase 2 Tasks

**Focus**: Account Types GUI + Custom Exception Handling

---

## 📋 Priority Tasks

### 1. Custom Exceptions 🚨
```java
// TODO: Create in exceptions/ package
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(double balance, double amount) {
        super("Insufficient funds! Balance: $" + balance + ", Attempted: $" + amount);
    }
}

public class InvalidAccountException extends Exception {
    public InvalidAccountException(String accountNumber) {
        super("Account not found: " + accountNumber);
    }
}

public class OverdraftLimitExceededException extends Exception {
    public OverdraftLimitExceededException(double limit, double amount) {
        super("Overdraft limit exceeded! Limit: $" + limit + ", Attempted: $" + amount);
    }
}
```
- [ ] Create `exceptions/` package
- [ ] Implement 3+ custom exceptions (extend `Exception`)
- [ ] Use meaningful messages with context (balance, limits, IDs)

### 2. Add Try/Catch Everywhere 🛡️
```java
// TODO: Wrap all risky operations
public void processWithdrawal(String accountId, double amount) {
    try {
        Account acc = findAccount(accountId);
        acc.withdraw(amount); // throws InsufficientFundsException
        saveAllData();
    } catch (InsufficientFundsException e) {
        showErrorToUser(e.getMessage());
    } catch (InvalidAccountException e) {
        logError(e);
        showErrorToUser("Account not found!");
    }
}
```
- [ ] Add try/catch to: deposit, withdraw, transfer, account creation
- [ ] Catch specific exceptions first, then general `Exception`
- [ ] Log errors to file for debugging

### 3. Account Management GUI 🎨
```java
// TODO: Create AccountPanel.java with tabbed view
JTabbedPane accountTabs = new JTabbedPane();
accountTabs.addTab("Savings", createSavingsPanel());
accountTabs.addTab("Current", createCurrentPanel()); // shows overdraft info
accountTabs.addTab("Premium", createPremiumPanel()); // shows benefits

// Each panel shows: balance, type-specific features, action buttons
```
- [ ] Display account type-specific info (interest, overdraft, benefits)
- [ ] Show available actions based on account type
- [ ] Visual indicators for special features (🎁 Premium, 🏦 Business)

### 4. Account-Type-Specific Logic ✨
- [ ] **Savings**: Show interest earned, enforce minimum balance
- [ ] **Current**: Display overdraft limit, allow negative balance within limit
- [ ] **Premium**: Show premium benefits, higher transaction limits
- [ ] **Business**: Show employee count, business report button

---

## ✅ Testing Checklist
- [ ] Withdraw more than balance → `InsufficientFundsException` caught → user sees friendly error
- [ ] Invalid account number → `InvalidAccountException` → "Account not found" message
- [ ] Current account overdraft within limit → succeeds, shows remaining overdraft
- [ ] Premium account gets higher withdrawal limit → enforced correctly
- [ ] All exceptions logged to `logs/errors.log` for debugging

---

## 📚 Resources
- [Custom Exceptions in Java](https://www.youtube.com/watch?v=H62VhtM3ZKc) 🎥
- [Try-Catch Best Practices](https://www.youtube.com/watch?v=58D0Gg9lEYc) 🎥
- [JTabbedPane Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html) 📖

---

> 💡 **Pro Tip**: Catch specific exceptions first — order matters in catch blocks! 😼
