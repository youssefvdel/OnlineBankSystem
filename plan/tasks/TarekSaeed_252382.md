# TarekSaeed_252382 - Phase 2 Tasks

**Role:** Staff Dashboard + Staff Update + Accounts View  
**Student ID:** 252382  
**Time Estimate:** ~95 minutes total

---

##  Your Tasks

### Task 1: StaffDashboard.java (~45 min) [ORIGINAL]

**Goal:** Teller/staff operations interface

**Key Features:**
- View assigned tasks
- Process customer transactions (deposit/withdraw helper)
- Update customer info (with admin approval flow)
- Logout button

**Integration:**
- Loads staff data from `staff.ser`
- Uses `bank.getStaffTasks(staffId)`

**File I/O (.ser format):**
```java
// BankSystem loads from staff.ser automatically
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/staff.ser"));
ArrayList<Staff> staff = (ArrayList<Staff>) ois.readObject();
```

---

### Task 2: UpdateStaffDialog.java (~25 min) [REDISTRIBUTED]

**Goal:** Admin updates existing staff details

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog for admin to update staff information.
 * @author Tarek Saeed 252382
 */
public class UpdateStaffDialog extends JDialog {
  
  private Staff selectedStaff;
  private JTextField phoneField, jobField, passField;
  
  public UpdateStaffDialog(Frame parent, Admin admin, Staff staff) {
      super(parent, "Update Staff: " + staff.getName(), true);
      this.selectedStaff = staff;
      setupUI();
      populateFields();
  }
  
  private void setupUI() {
      setSize(350, 250);
      setLocationRelativeTo(getOwner());
      setLayout(new GridLayout(5, 2, 5, 5));
      
      add(new JLabel("Phone:"));
      phoneField = new JTextField();
      add(phoneField);
      
      add(new JLabel("Job Title:"));
      jobField = new JTextField();
      add(jobField);
      
      add(new JLabel("New Password (optional):"));
      passField = new JPasswordField();
      add(passField);
      
      JButton save = new JButton("Save Changes");
      save.addActionListener(e -> handleSave());
      add(save);
      
      JButton cancel = new JButton("Cancel");
      cancel.addActionListener(e -> dispose());
      add(cancel);
  }
  
  private void populateFields() {
      // Fill fields with current staff data
      phoneField.setText(selectedStaff.getPhone());
      jobField.setText(selectedStaff.getJobTitle());
  }
  
  private void handleSave() {
      // TODO: Update staff object, save to staff.ser
      // Throw StaffUpdateException if validation fails
      dispose();
  }
}
```

**File I/O (.ser format):**
- Reads `staff.ser` to find staff by ID
- Updates fields and rewrites the file using ObjectOutputStream

**Exception Handling:**
- Create `StaffUpdateException.java` (extends Exception)
- Throw if phone format invalid or job title empty

**Done Criteria:**
- [ ] Dialog opens with current staff data pre-filled
- [ ] Phone/job fields can be edited
- [ ] Save button validates and updates staff.ser
- [ ] StaffUpdateException thrown on invalid input
- [ ] Cancel button closes without saving

---

### Task 3: ViewAccountsDialog.java (~25 min) [NEW]

**Goal:** View all customer accounts (for Staff/Admin)

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Dialog to view all customer accounts.
 * @author Tarek Saeed 252382
 */
public class ViewAccountsDialog extends JDialog {
  
  public ViewAccountsDialog(Frame parent) {
      super(parent, "Customer Accounts", true);
      setupUI();
      loadAccounts();
  }
  
  private void setupUI() {
      setSize(700, 400);
      setLocationRelativeTo(getOwner());
      setLayout(new BorderLayout(10, 10));
      
      String[] columns = {"Account #", "Owner", "Type", "Balance", "Status"};
      DefaultTableModel model = new DefaultTableModel(columns, 0);
      JTable table = new JTable(model);
      
      add(new JScrollPane(table), BorderLayout.CENTER);
      
      JButton close = new JButton("Close");
      close.addActionListener(e -> dispose());
      add(close, BorderLayout.SOUTH);
  }
  
  private void loadAccounts() {
      // TODO: Read from accounts.ser using ObjectInputStream
      // Display in JTable
  }
}
```

**File I/O (.ser format):**
- Reads `accounts.ser` using deserialization

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

---

## Note:  Exception Handling

**File:** `src/exceptions/StaffUpdateException.java`

**Code:**
```java
package exceptions;

/**
 * Thrown when staff update fails validation.
 * @author Tarek Saeed 252382
 */
public class StaffUpdateException extends Exception {
  
  public StaffUpdateException(String message) {
      super(message);
  }
  
  public StaffUpdateException(String message, Throwable cause) {
      super(message, cause);
  }
}
```

**Usage Example:**
```java
// In UpdateStaffDialog.java
private void handleSave() throws StaffUpdateException {
  String phone = phoneField.getText().trim();
  
  // Validate phone format
  if (!phone.matches("^01[0-9]{9}$")) {
      throw new StaffUpdateException("Invalid phone format");
  }
  
  // ... update staff
}
```

**Done Criteria:**
- [ ] StaffUpdateException.java compiles
- [ ] At least one method throws it
- [ ] Caller catches and shows user-friendly message

---

##  Testing

```bash
# Test UpdateStaffDialog
# 1. Login as admin
# 2. Click "Update Staff" (from AdminDashboard)
# 3. Select a staff member
# 4. Change phone number → Save
# 5. Verify staff.ser shows updated phone
# 6. Try invalid phone format → should show error

# Test ViewAccountsDialog
# 1. Login as admin or staff
# 2. Open ViewAccountsDialog
# 3. Verify all accounts displayed in table
# 4. Close dialog
```

---

##  Team Handoff

**You provide:**
- StaffDashboard.java (teller interface)
- UpdateStaffDialog.java (admin feature)
- ViewAccountsDialog.java (admin/staff feature)
- StaffUpdateException.java for validation errors

**You receive:**
- File I/O from YoussefAdel (BankSystem with .ser support)
- AdminDashboard from YoussefAdel (to integrate UpdateStaffDialog)
- Staff list from YousefMohiey's AddStaffDialog

**Message when done:**
> " Staff GUI + UpdateStaff done: Dashboard shows tasks, 
>  UpdateStaffDialog edits staff.ser with validation + exceptions.
>  ViewAccountsDialog displays all accounts from accounts.ser. Ready for integration."

---

##  Quick Help

| Topic | Video |
|-------|-------|
| Pre-filling form fields | https://youtu.be/a7rX_VbJL8k?t=180 |
| Java Serialization | https://youtu.be/ue06TSYXJpY |
| Validation exceptions | https://youtu.be/6u4vqVvqJ8k?t=120 |

---

##  Submission Checklist

- [ ] StaffDashboard.java - displays tasks, buttons functional
- [ ] UpdateStaffDialog.java - loads data, saves updates to staff.ser
- [ ] ViewAccountsDialog.java - displays accounts from accounts.ser
- [ ] StaffUpdateException.java - thrown on invalid input
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] All GUIs have NetBeans .form files
- [ ] Pushed to feature/tareksaeed-staff branch

---

**Note:** All file I/O now uses .ser (Java Serialization) format, NOT .csv. This is what the TA requires.

**You got this!** Start with StaffDashboard first. If stuck for >10 min, message the team on Discord. 
