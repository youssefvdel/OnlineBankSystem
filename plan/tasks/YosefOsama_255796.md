# YosefOsama_255796 - Phase 2 Tasks

**Role:** Customer Dashboard + Staff Removal + Transfer  
**Student ID:** 255796  
**Time Estimate:** ~95 minutes total

---

##  Your Tasks

### Task 1: CustomerDashboard.java (~45 min) [ORIGINAL]

**Goal:** Main customer menu with account operations

**Key Features:**
- Display account balance
- Buttons: Deposit, Withdraw, Transfer, View History, Manage Card
- Logout button returns to LoginFrame

**Integration:**
- Loads customer data from `users.ser` + `accounts.ser`
- Uses `bank.getCustomerAccounts(customerId)`

**File I/O (.ser format):**
```java
// BankSystem loads from .ser files automatically
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/accounts.ser"));
ArrayList<Account> accounts = (ArrayList<Account>) ois.readObject();
```

---

### Task 2: RemoveStaffDialog.java (~20 min) [REDISTRIBUTED]

**Goal:** Admin removes staff by ID or name

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog for admin to remove staff member.
 * @author Yosef Osama 255796
 */
public class RemoveStaffDialog extends JDialog {
  
  private JTextField searchField;
  private JComboBox<String> resultsCombo;
  
  public RemoveStaffDialog(Frame parent, Admin admin) {
      super(parent, "Remove Staff", true);
      setupUI();
  }
  
  private void setupUI() {
      setSize(400, 200);
      setLocationRelativeTo(getOwner());
      setLayout(new GridLayout(3, 2, 5, 5));
      
      add(new JLabel("Search by Name or ID:"));
      searchField = new JTextField();
      add(searchField);
      
      JButton search = new JButton("Search");
      search.addActionListener(e -> handleSearch());
      add(search);
      
      add(new JLabel("Select to Remove:"));
      resultsCombo = new JComboBox<>();
      add(resultsCombo);
      
      JButton remove = new JButton("Remove Selected");
      remove.addActionListener(e -> handleRemove());
      add(remove);
      
      JButton cancel = new JButton("Cancel");
      cancel.addActionListener(e -> dispose());
      add(cancel);
  }
  
  private void handleSearch() {
      // TODO: Search staff.ser, populate resultsCombo
      // Use ObjectInputStream to read staff.ser
  }
  
  private void handleRemove() {
      // TODO: Remove selected staff from collection + staff.ser
      // Throw StaffNotFoundException if not found
      dispose();
  }
}
```

**File I/O (.ser format):**
- Reads `staff.ser` to find staff
- Removes entry and rewrites file using ObjectOutputStream

**Exception Handling:**
- Create `StaffNotFoundException.java` (extends Exception)
- Throw if search returns no results or remove fails

**Done Criteria:**
- [ ] Dialog opens from AdminDashboard "Remove Staff" button
- [ ] Search finds staff by name or ID
- [ ] Remove button deletes from staff.ser
- [ ] StaffNotFoundException thrown if not found
- [ ] Cancel button closes dialog

---

### Task 3: TransferMoneyDialog.java (~30 min) [NEW]

**Goal:** Transfer between accounts with validation

**Starter Code:**
```java
package gui.customer;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog for transferring money between accounts.
 * @author Yosef Osama 255796
 */
public class TransferMoneyDialog extends JDialog {
  
  private JTextField amountField, targetAccountField;
  
  public TransferMoneyDialog(Frame parent, Account sourceAccount) {
      super(parent, "Transfer Money", true);
      setupUI();
  }
  
  private void setupUI() {
      setSize(350, 200);
      setLocationRelativeTo(getOwner());
      setLayout(new GridLayout(4, 2, 5, 5));
      
      add(new JLabel("Target Account:"));
      targetAccountField = new JTextField();
      add(targetAccountField);
      
      add(new JLabel("Amount:"));
      amountField = new JTextField();
      add(amountField);
      
      JButton transfer = new JButton("Transfer");
      transfer.addActionListener(e -> handleTransfer());
      add(transfer);
      
      JButton cancel = new JButton("Cancel");
      cancel.addActionListener(e -> dispose());
      add(cancel);
  }
  
  private void handleTransfer() {
      // TODO: Validate amount, execute transfer
      // Update accounts.ser and transactions.ser
      // Throw exception if insufficient funds
      dispose();
  }
}
```

**File I/O (.ser format):**
- Updates `accounts.ser` (both source and target)
- Appends to `transactions.ser`

**Done Criteria:**
- [ ] Dialog opens from CustomerDashboard
- [ ] Validates amount > 0
- [ ] Validates sufficient balance
- [ ] Updates both accounts in accounts.ser
- [ ] Logs transaction in transactions.ser

---

##  File Contracts (.ser Format)

### staff.ser
```java
// ArrayList<Staff> serialized
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/staff.ser"));
oos.writeObject(staff);
```

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

---

## Note:  Exception Handling

**File:** `src/exceptions/StaffNotFoundException.java`

**Code:**
```java
package exceptions;

/**
 * Thrown when staff member is not found.
 * @author Yosef Osama 255796
 */
public class StaffNotFoundException extends Exception {
  
  public StaffNotFoundException(String staffId) {
      super("Staff not found: " + staffId);
  }
  
  public StaffNotFoundException(String staffId, Throwable cause) {
      super("Staff not found: " + staffId, cause);
  }
}
```

**Usage Example:**
```java
// In RemoveStaffDialog.java
private void handleRemove() throws StaffNotFoundException {
  String staffId = getSelectedStaffId();
  
  if (!staffExists(staffId)) {
      throw new StaffNotFoundException(staffId);
  }
  
  // ... remove staff
}
```

**Done Criteria:**
- [ ] StaffNotFoundException.java compiles
- [ ] At least one method throws it
- [ ] Caller catches and shows user-friendly message

---

##  Testing

```bash
# Test RemoveStaffDialog
# 1. Login as admin
# 2. Click "Remove Staff"
# 3. Search for existing staff ID
# 4. Select and remove
# 5. Verify staff.ser no longer has that entry
# 6. Try removing non-existent ID → should show error

# Test TransferMoneyDialog
# 1. Login as customer
# 2. Click "Transfer"
# 3. Enter target account and amount
# 4. Verify both accounts updated in accounts.ser
# 5. Verify transaction logged in transactions.ser
```

---

##  Team Handoff

**You provide:**
- CustomerDashboard.java (main customer interface)
- RemoveStaffDialog.java (admin feature)
- TransferMoneyDialog.java (customer feature)
- StaffNotFoundException.java for error handling

**You receive:**
- File I/O from YoussefAdel (BankSystem with .ser support)
- AdminDashboard from YoussefAdel (to integrate RemoveStaffDialog)

**Message when done:**
> " Customer GUI + RemoveStaff done: Dashboard shows account ops, 
>  RemoveStaffDialog searches/removes from staff.ser with exception handling.
>  TransferMoneyDialog updates accounts.ser + transactions.ser. Ready for integration."

---

##  Quick Help

| Topic | Video |
|-------|-------|
| JComboBox search | https://youtu.be/5K8vVvZqJ8E?t=180 |
| Java Serialization | https://youtu.be/ue06TSYXJpY |
| Custom exception pattern | https://youtu.be/6u4vqVvqJ8k |

---

##  Submission Checklist

- [ ] CustomerDashboard.java - displays balance, buttons work
- [ ] RemoveStaffDialog.java - search + remove works, updates staff.ser
- [ ] TransferMoneyDialog.java - transfer works, updates accounts.ser + transactions.ser
- [ ] StaffNotFoundException.java - thrown when staff not found
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] All GUIs have NetBeans .form files
- [ ] Pushed to feature/yosefosama-customer branch

---

**Note:** All file I/O now uses .ser (Java Serialization) format, NOT .csv. This is what the TA requires.

**You got this!** Start with CustomerDashboard first. If stuck for >10 min, message the team on Discord. 
