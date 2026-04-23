# YousifHafez_258612 - Phase 2 Tasks

**Role:** Customer Features + Account Deletion  
**Student ID:** 258612  
**Time Estimate:** ~90 minutes total

---

##  Your Tasks

### Task 1: TransactionDialog.java (~30 min) [ORIGINAL]

**Goal:** Handle deposit/withdraw operations

**Key Features:**
- Amount field with validation
- Type selector (Deposit/Withdraw)
- Category dropdown

**Integration:**
- Calls `account.deposit()`, `account.withdraw()`
- Updates `transactions.ser` via ObjectOutputStream

**File I/O (.ser format):**
```java
// BankSystem saves to transactions.ser automatically
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/transactions.ser"));
oos.writeObject(transactions);
```

---

### Task 2: CardManagementFrame.java (~40 min) [ORIGINAL]

**Goal:** Issue/update credit card status

**Key Features:**
- Issue new card button
- Status dropdown: Active/Deactivated/Lost/ATM_Stuck
- Card number display (masked)
- Expiry date field

**File I/O (.ser format):**
- Reads/writes `cards.ser`

**Done Criteria:**
- [ ] Frame opens with card list
- [ ] Can issue new card
- [ ] Can update card status
- [ ] Changes persist in cards.ser

---

### Task 3: DeleteAccountDialog.java (~20 min) [REDISTRIBUTED]

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
      // TODO: Find account in accounts.ser, display details in confirmArea
      // Throw AccountNotFoundException if not found
  }
  
  private void handleDelete() {
      // TODO: Remove account from accounts.ser + related transactions from transactions.ser
      // Throw AccountDeletionException if account has balance > 0
      dispose();
  }
}
```

**File I/O (.ser format):**
- Reads `accounts.ser` to find account
- Removes account and rewrites file
- Also removes related transactions from `transactions.ser`

**Exception Handling:**
- Create `AccountDeletionException.java` (extends Exception)
- Throw if account has balance > 0 or has pending transactions

**Done Criteria:**
- [ ] Dialog opens from AdminDashboard "Delete Account" button
- [ ] Search finds account and displays details
- [ ] Delete button validates (balance = 0) then removes from accounts.ser
- [ ] AccountDeletionException thrown if balance > 0
- [ ] Related transactions also removed from transactions.ser

---

##  File Contracts (.ser Format)

### accounts.ser
```java
// ArrayList<Account> serialized
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/accounts.ser"));
oos.writeObject(accounts);
```

### transactions.ser
```java
// ArrayList<Transaction> serialized
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/transactions.ser"));
oos.writeObject(transactions);
```

### cards.ser (for CardManagementFrame)
```java
// ArrayList<Card> serialized
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/cards.ser"));
oos.writeObject(cards);
```

---

## Note:  Exception Handling

**File:** `src/exceptions/AccountDeletionException.java`

**Code:**
```java
package exceptions;

/**
 * Thrown when account deletion fails validation.
 * @author Yousif Hafez 258612
 */
public class AccountDeletionException extends Exception {
  
  public AccountDeletionException(String accountId, String reason) {
      super("Cannot delete account " + accountId + ": " + reason);
  }
  
  public AccountDeletionException(String accountId, String reason, Throwable cause) {
      super("Cannot delete account " + accountId + ": " + reason, cause);
  }
}
```

**Usage Example:**
```java
// In DeleteAccountDialog.java
private void handleDelete() throws AccountDeletionException {
  Account account = findAccount(accountIdField.getText());
  
  if (account.getBalance() > 0) {
      throw new AccountDeletionException(
          accountIdField.getText(), 
          "Account has balance > 0"
      );
  }
  
  // ... delete account
}
```

**Done Criteria:**
- [ ] AccountDeletionException.java compiles
- [ ] At least one method throws it
- [ ] Caller catches and shows user-friendly message

---

##  Testing

```bash
# Test DeleteAccountDialog
# 1. Login as admin
# 2. Click "Delete Account"
# 3. Search for test account with balance = 0
# 4. Click Delete → verify removed from accounts.ser
# 5. Verify related transactions also removed from transactions.ser
# 6. Try deleting account with balance > 0 → should show error

# Test CardManagementFrame
# 1. Login as customer
# 2. Open Card Management
# 3. Issue new card
# 4. Verify cards.ser created/updated
# 5. Update card status → verify persists

# Test TransactionDialog
# 1. Login as customer
# 2. Deposit money → verify accounts.ser + transactions.ser updated
# 3. Withdraw money → verify both files updated
```

---

##  Team Handoff

**You provide:**
- TransactionDialog.java (customer operations)
- CardManagementFrame.java (card status management)
- DeleteAccountDialog.java (admin feature)
- AccountDeletionException.java for validation

**You receive:**
- File I/O from YoussefAdel (BankSystem with .ser support)
- AdminDashboard from YoussefAdel (to integrate DeleteAccountDialog)
- Account data from YoussefAdel's loadAccounts()

**Message when done:**
> " Customer features + DeleteAccount done: Transaction/Card GUIs working, 
>  DeleteAccountDialog validates balance=0 before removing from accounts.ser + transactions.ser.
>  All exceptions implemented. Ready for full integration."

---

##  Quick Help

| Topic | Video |
|-------|-------|
| JTextArea for display | https://youtu.be/a7rX_VbJL8k?t=240 |
| Java Serialization | https://youtu.be/ue06TSYXJpY |
| Business logic exceptions | https://youtu.be/6u4vqVvqJ8k?t=180 |

---

##  Submission Checklist

- [ ] TransactionDialog.java - deposit/withdraw work
- [ ] CardManagementFrame.java - issue/update card status works
- [ ] DeleteAccountDialog.java - search + delete with validation works
- [ ] AccountDeletionException.java - thrown when balance > 0
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] All GUIs have NetBeans .form files
- [ ] Pushed to feature/yousifhafez-customer branch

---

**Note:** All file I/O now uses .ser (Java Serialization) format, NOT .csv. This is what the TA requires.

**You got this!** Start with TransactionDialog first. If stuck for >10 min, message the team on Discord. 
