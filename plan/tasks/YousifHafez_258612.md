# YousifHafez_258612 - Phase 2 Tasks

**Role:** Customer Features + Account Deletion GUI  
**Student ID:** 258612  
**Time Estimate:** ~90 minutes total

---

## ✅ Your Tasks

### Task 1: TransactionDialog.java (~30 min) [ORIGINAL]

**Goal:** Handle deposit/withdraw/transfer operations

**Key Features:**
- Amount field with validation
- Type selector (Deposit/Withdraw/Transfer)
- Target account field (for transfers)
- Category dropdown

**Integration:**
- Calls `account.deposit()`, `account.withdraw()`, `bank.transfer()`
- Updates `transactions.csv` via `CSVHelper.appendTransaction()`

---

### Task 2: CardManagementFrame.java (~40 min) [ORIGINAL]

**Goal:** Issue/update credit card status

**Key Features:**
- Issue new card button
- Status dropdown: Active/Deactivated/Lost/ATM_Stuck
- Card number display (masked)
- Expiry date field

**File I/O:**
- Reads/writes `cards.csv`

---

### Task 3: PayBillsFrame.java (~30 min) [ORIGINAL]

**Goal:** Pay credit card/account fees

**Key Features:**
- Bill amount display
- Payment method selector
- Confirmation dialog
- Receipt generation

---

### Task 4: DeleteAccountDialog.java (~20 min) [NEW - redistributed from Abdelrahman]

**Goal:** Admin deletes customer account

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog for admin to delete customer account.
 * @author Yousif Hafez 258612
 */
public class DeleteAccountDialog extends JDialog {
    
    private JTextField accountIdField;
    private JTextArea confirmArea;
    
    public DeleteAccountDialog(Frame parent, Admin admin) {
        super(parent, "Delete Account", true);
        setupUI();
    }
    
    private void setupUI() {
        setSize(400, 250);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout(10, 10));
        
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Account ID:"));
        accountIdField = new JTextField();
        inputPanel.add(accountIdField);
        
        JButton search = new JButton("Find Account");
        search.addActionListener(e -> handleSearch());
        inputPanel.add(search);
        add(inputPanel, BorderLayout.NORTH);
        
        confirmArea = new JTextArea(5, 30);
        confirmArea.setEditable(false);
        confirmArea.setText("Search for account to see details...");
        add(new JScrollPane(confirmArea), BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        JButton delete = new JButton("Delete Account");
        delete.addActionListener(e -> handleDelete());
        buttonPanel.add(delete);
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> dispose());
        buttonPanel.add(cancel);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void handleSearch() {
        // TODO: Find account in accounts.csv, display details in confirmArea
        // Throw AccountNotFoundException if not found
    }
    
    private void handleDelete() {
        // TODO: Remove account from accounts.csv + related transactions
        // Throw AccountDeletionException if account has balance > 0
        dispose();
    }
}
```

**File I/O:**
- Reads `accounts.csv` to find account
- Removes account line + related transactions from `transactions.csv`

**Exception Handling:**
- Create `AccountDeletionException.java` (extends Exception)
- Throw if account has balance > 0 or has pending transactions

**Done Criteria:**
- [ ] Dialog opens from AdminDashboard "Delete Account" button
- [ ] Search finds account and displays details
- [ ] Delete button validates (balance = 0) then removes from accounts.csv
- [ ] AccountDeletionException thrown if balance > 0
- [ ] Related transactions also removed from transactions.csv

---

## 📁 File Contracts

### accounts.csv (you read + modify)
```
accountId,ownerId,accountType,balance,createdAt,status
ACC001,258270,Savings,1000.00,2026-04-01,ACTIVE
```

### transactions.csv (you also modify)
```
txId,accountId,type,amount,timestamp,description
TX001,ACC001,DEPOSIT,500.00,2026-04-02T10:30,Initial deposit
```

**Delete logic:** Remove account line + all transactions with matching accountId

---

## 🧪 Testing

```bash
# Test DeleteAccountDialog
# 1. Login as admin
# 2. Click "Delete Account"
# 3. Search for test account with balance = 0
# 4. Click Delete → verify removed from accounts.csv
# 5. Verify related transactions also removed from transactions.csv
# 6. Try deleting account with balance > 0 → should show error
```

---

## 🤝 Team Handoff

**You provide:**
- TransactionDialog.java (customer operations)
- CardManagementFrame.java (card status management)
- PayBillsFrame.java (bill payment)
- DeleteAccountDialog.java (admin feature)
- AccountDeletionException.java for validation

**You receive:**
- File I/O from YoussefAdel (CSVHelper methods)
- AdminDashboard from AbdelrahmanMazen (to integrate DeleteAccountDialog)
- Account data from YoussefAdel's loadAccounts()

**Message when done:**
> "✅ Customer features + DeleteAccount done: Transaction/Card/PayBills GUIs working, 
>  DeleteAccountDialog validates balance=0 before removing from accounts.csv + transactions.csv. 
>  All exceptions implemented. Ready for full integration."

---

## 🎥 Quick Help

| Topic | Video |
|-------|-------|
| JTextArea for display | https://youtu.be/a7rX_VbJL8k?t=240 |
| Multi-file update pattern | https://youtu.be/9XJicRt_FaI?t=360 |
| Business logic exceptions | https://youtu.be/6u4vqVvqJ8k?t=180 |

---

## ✅ Submission Checklist

- [ ] TransactionDialog.java - deposit/withdraw/transfer work
- [ ] CardManagementFrame.java - issue/update card status works
- [ ] PayBillsFrame.java - payment flow works
- [ ] DeleteAccountDialog.java - search + delete with validation works
- [ ] AccountDeletionException.java - thrown when balance > 0
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] Pushed to feature/yousif-customer branch
