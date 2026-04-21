# 🎯 Tarek Saeed (252382) - Phase 2 Tasks

**Focus**: Transaction Logic Refactor + Transaction GUI

---

## 📋 Priority Tasks

### 1. Refactor Transaction Classes → Methods 🔧
```java
// TODO: Move logic from Deposit.java → Account.java
public class Account {
    public boolean deposit(double amount) {
        if (amount <= 0) throw new InvalidAmountException();
        this.balance += amount;
        logTransaction(new Transaction("DEPOSIT", amount));
        return true;
    }
    
    public boolean withdraw(double amount) {
        if (amount > balance) throw new InsufficientFundsException();
        this.balance -= amount;
        logTransaction(new Transaction("WITHDRAW", amount));
        return true;
    }
}
```
- [ ] Move deposit/withdraw logic into `Account.java`
- [ ] Keep `Transaction.java` as data model only (no business logic)
- [ ] Delete redundant `Deposit.java`/`Withdrawal.java` classes
- [ ] Update all references in tests

### 2. Transaction GUI Panel 🎨
```java
// TODO: Create TransactionPanel.java (extends JPanel)
JPanel transactionPanel = new JPanel();
JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Deposit", "Withdraw", "Transfer"});
JTextField amountField = new JTextField(10);
JButton executeBtn = new JButton("Execute");

executeBtn.addActionListener(e -> {
    try {
        processTransaction(typeCombo.getSelectedItem(), Double.parseDouble(amountField.getText()));
        showMessage("✅ Success!");
    } catch (Exception ex) {
        showError("❌ " + ex.getMessage());
    }
});
```
- [ ] Build form with: type selector, amount input, target account (for transfer)
- [ ] Add real-time balance display
- [ ] Show success/error messages with `JOptionPane`

### 3. Interactive Transaction Flow 🔄
- [ ] Validate input before processing (non-empty, positive numbers)
- [ ] Confirm dialog for withdrawals/transfers: "Are you sure?"
- [ ] Update transaction history immediately after success
- [ ] Refresh balance display after each transaction

---

## ✅ Testing Checklist
- [ ] Deposit via GUI → balance updates + appears in history
- [ ] Withdraw with insufficient funds → shows error (no crash)
- [ ] Transfer between accounts → both balances update correctly
- [ ] Invalid input (letters, negative) → caught by exception + user-friendly message
- [ ] Transaction history shows all operations with timestamps

---

## 📚 Resources
- [Java Swing Forms Tutorial](https://www.youtube.com/watch?v=58D0Gg9lEYc) 🎥
- [Exception Handling Best Practices](https://www.youtube.com/watch?v=H62VhtM3ZKc) 🎥
- [JOptionPane Examples](https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html) 📖

---

> 💡 **Pro Tip**: Keep business logic in backend classes, GUI only handles input/output! 😼
