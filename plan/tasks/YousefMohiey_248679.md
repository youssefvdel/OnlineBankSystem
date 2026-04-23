# YousefMohiey_248679 - Phase 2 Tasks

**Role:** Authentication + Staff Management + Admin Actions  
**Student ID:** 248679  
**Time Estimate:** ~115 minutes total

---

##  Your Tasks

### Task 1: LoginFrame.java (~45 min) [ORIGINAL]

**Goal:** User login with 3-attempt limit

**Key Requirements:**
- Username + Password fields
- Login/Register/Exit buttons
- Max 3 failed attempts → exit app
- On success: open role-specific dashboard

**Integration Points:**
- Reads from `users.ser` using ObjectInputStream
- Calls `bank.login(userId, password)`
- On success: opens AdminDashboard/CustomerDashboard based on role

**File I/O (.ser format):**
```java
// BankSystem loads from users.ser automatically
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/users.ser"));
ArrayList<User> users = (ArrayList<User>) ois.readObject();
```

---

### Task 2: AddStaffDialog.java (~25 min) [REDISTRIBUTED]

**Goal:** Admin adds new staff member

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog for admin to add new staff member.
 * @author Yousef Mohiey 248679
 */
public class AddStaffDialog extends JDialog {
  
  private JTextField nameField, emailField, phoneField, jobField, passField;
  
  public AddStaffDialog(Frame parent, Admin admin) {
      super(parent, "Add New Staff", true);
      setupUI();
  }
  
  private void setupUI() {
      setSize(350, 300);
      setLocationRelativeTo(getOwner());
      setLayout(new GridLayout(6, 2, 5, 5));
      
      add(new JLabel("Name:"));
      nameField = new JTextField();
      add(nameField);
      
      add(new JLabel("Email:"));
      emailField = new JTextField();
      add(emailField);
      
      add(new JLabel("Phone:"));
      phoneField = new JTextField();
      add(phoneField);
      
      add(new JLabel("Job Title:"));
      jobField = new JTextField();
      add(jobField);
      
      add(new JLabel("Temp Password:"));
      passField = new JPasswordField();
      add(passField);
      
      JButton save = new JButton("Save Staff");
      save.addActionListener(e -> handleSave());
      add(save);
      
      JButton cancel = new JButton("Cancel");
      cancel.addActionListener(e -> dispose());
      add(cancel);
  }
  
  private void handleSave() {
      // TODO: Validate fields, create Staff object, save to staff.ser
      // Use bank.addStaff() method from BankSystem
      // Call bank.saveAllData() to persist
      dispose();
  }
}
```

**File I/O (.ser format):**
- Appends to `staff.ser` using ObjectOutputStream
- Format: `ArrayList<Staff>` serialized

**Exception Handling:**
- Create `StaffCreationException.java` (extends Exception)
- Throw if email already exists or fields invalid

**Done Criteria:**
- [ ] Dialog opens from AdminDashboard "Add Staff" button
- [ ] All fields accept input
- [ ] Save button validates and writes to staff.ser
- [ ] Cancel button closes dialog
- [ ] StaffCreationException thrown on duplicate email

---

### Task 3: ViewStaffListDialog.java (~25 min) [NEW]

**Goal:** Display all staff in table (for Admin)

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;

/**
 * Dialog to view all staff members.
 * @author Yousef Mohiey 248679
 */
public class ViewStaffListDialog extends JDialog {
  
  public ViewStaffListDialog(Frame parent) {
      super(parent, "Staff List", true);
      setupUI();
      loadStaff();
  }
  
  private void setupUI() {
      setSize(600, 400);
      setLocationRelativeTo(getOwner());
      
      String[] columns = {"ID", "Name", "Email", "Phone", "Job Title"};
      DefaultTableModel model = new DefaultTableModel(columns, 0);
      JTable table = new JTable(model);
      
      add(new JScrollPane(table), BorderLayout.CENTER);
      
      JButton close = new JButton("Close");
      close.addActionListener(e -> dispose());
      add(close, BorderLayout.SOUTH);
  }
  
  private void loadStaff() {
      // TODO: Read from staff.ser using ObjectInputStream
      // Display in JTable
  }
}
```

**File I/O (.ser format):**
- Reads `staff.ser` using deserialization

---

### Task 4: AdminActionLogger.java (~20 min) [NEW - Took from Abdelrahman]

**Goal:** Utility to log admin actions to reports.ser

**Code:**
```java
package gui.admin;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility to log admin actions to reports.ser
 * @author Yousef Mohiey 248679
 */
public class AdminActionLogger {
  
  /**
   * Logs an admin action to reports.ser
   */
  public static void logAction(String adminId, String actionType, String details) {
      try {
          File file = new File("data/reports.ser");
          ArrayList<String[]> reports = new ArrayList<>();
          
          // Load existing reports
          if (file.exists()) {
              ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
              reports = (ArrayList<String[]>) ois.readObject();
              ois.close();
          }
          
          // Add new report
          String timestamp = LocalDateTime.now()
              .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
          reports.add(new String[]{timestamp, adminId, actionType, details});
          
          // Save back
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
          oos.writeObject(reports);
          oos.close();
          
      } catch (Exception e) {
          System.err.println("Failed to log action: " + e.getMessage());
      }
  }
}
```

**File I/O (.ser format):**
- Appends to `reports.ser`
- Format: `ArrayList<String[]>` where each array = {timestamp, adminId, actionType, details}

---

##  File Contracts (.ser Format)

### users.ser
```java
// ArrayList<User> serialized
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/users.ser"));
oos.writeObject(users);
```

### staff.ser
```java
// ArrayList<Staff> serialized
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/staff.ser"));
oos.writeObject(staff);
```

### reports.ser (for AdminActionLogger)
```java
// ArrayList<String[]> serialized
// Each array: {timestamp, adminId, actionType, details}
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/reports.ser"));
oos.writeObject(reports);
```

---

## Note:  Exception Handling

**File:** `src/exceptions/StaffCreationException.java`

**Code:**
```java
package exceptions;

/**
 * Thrown when staff creation fails validation.
 * @author Yousef Mohiey 248679
 */
public class StaffCreationException extends Exception {
  
  public StaffCreationException(String message) {
      super(message);
  }
  
  public StaffCreationException(String message, Throwable cause) {
      super(message, cause);
  }
}
```

**Usage Example:**
```java
// In AddStaffDialog.java
private void handleSave() throws StaffCreationException {
  String email = emailField.getText().trim();
  
  // Check if email already exists
  if (emailExists(email)) {
      throw new StaffCreationException("Email already exists");
  }
  
  // ... create and save staff
}
```

**Done Criteria:**
- [ ] StaffCreationException.java compiles
- [ ] At least one method throws it
- [ ] Caller catches and shows user-friendly message

---

##  Testing

```bash
# Test LoginFrame
javac -d out -sourcepath src src/gui/auth/LoginFrame.java
# Run with test user from users.ser

# Test AddStaffDialog
# 1. Login as admin
# 2. Click "Add Staff" 
# 3. Fill form → Save
# 4. Verify staff.ser has new entry
# 5. Try duplicate email → should show error

# Test AdminActionLogger
# 1. Call AdminActionLogger.logAction("ADMIN001", "TEST", "Test action")
# 2. Verify reports.ser created
# 3. Check data persists
```

---

##  Team Handoff

**You provide:**
- LoginFrame.java (entry point for all users)
- AddStaffDialog.java (admin feature)
- ViewStaffListDialog.java (display staff)
- AdminActionLogger.java (utility for all admin dialogs)
- StaffCreationException.java for validation errors

**You receive:**
- File I/O layer from YoussefAdel (BankSystem with .ser support)
- AdminDashboard from YoussefAdel (to integrate AddStaffDialog)

**Message when done:**
> " Auth + Staff Management done: LoginFrame handles 3-attempt limit, 
>  AddStaffDialog writes to staff.ser with validation + exceptions.
>  AdminActionLogger ready for team use. Ready for integration testing."

---

##  Quick Help

| Topic | Video |
|-------|-------|
| JPasswordField | https://youtu.be/a7rX_VbJL8k?t=120 |
| Dialog modality | https://youtu.be/9XJicRt_FaI?t=300 |
| Java Serialization | https://youtu.be/ue06TSYXJpY |
| Custom exception | https://youtu.be/6u4vqVvqJ8k |

---

##  Submission Checklist

- [ ] LoginFrame.java - 3-attempt limit works, role routing works
- [ ] AddStaffDialog.java - validates, saves to staff.ser
- [ ] ViewStaffListDialog.java - displays staff from staff.ser
- [ ] AdminActionLogger.java - logs actions to reports.ser
- [ ] StaffCreationException.java - used for duplicate email
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] All GUIs have NetBeans .form files
- [ ] Pushed to feature/yousefmohiey-auth branch

---

**Note:** All file I/O now uses .ser (Java Serialization) format, NOT .csv. This is what the TA requires.

**You got this!** Start with LoginFrame first. If stuck for >10 min, message the team on Discord. 
