# YousefMohiey_248679 - Phase 2 Tasks

**Role:** Authentication + Staff Management GUI  
**Student ID:** 248679  
**Time Estimate:** ~70 minutes total

---

## ✅ Your Tasks

### Task 1: LoginFrame.java (~45 min) [ORIGINAL]

**Goal:** User login with 3-attempt limit

**Key Requirements:**
- Username + Password fields
- Login/Register/Exit buttons
- Max 3 failed attempts → exit app
- On success: open role-specific dashboard

**Integration Points:**
- Reads from `users.csv` using `CSVHelper.parseUser()`
- Calls `bank.authenticateUser(email, password)`
- On success: opens AdminDashboard/CustomerDashboard based on role

---

### Task 2: AddStaffDialog.java (~25 min) [NEW - redistributed from Abdelrahman]

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
        // TODO: Validate fields, create Staff object, save to staff.csv
        // Use bank.addStaff() method from BankSystem
        dispose();
    }
}
```

**File I/O:**
- Appends to `staff.csv` using format:
  ```
  id,name,email,password,phone,role,jobTitle,createdAt
  S002,Jane Teller,jane@test.com,temp123,012...,Staff,Teller,2026-04-02
  ```

**Exception Handling:**
- Create `StaffCreationException.java` (extends Exception)
- Throw if email already exists or fields invalid

**Done Criteria:**
- [ ] Dialog opens from AdminDashboard "Add Staff" button
- [ ] All fields accept input
- [ ] Save button validates and writes to staff.csv
- [ ] Cancel button closes dialog
- [ ] StaffCreationException thrown on duplicate email

---

## 📁 File Contracts

### users.csv (you read)
```
id,name,email,password,phone,role,createdAt
```

### staff.csv (you write)
```
id,name,email,password,phone,role,jobTitle,createdAt
S001,John Staff,john@test.com,pass456,011...,Staff,Teller,2026-04-02
```

---

## 🧪 Testing

```bash
# Test LoginFrame
javac -d out -sourcepath src src/gui/auth/LoginFrame.java
# Run with test user from users.csv

# Test AddStaffDialog
# 1. Login as admin
# 2. Click "Add Staff" 
# 3. Fill form → Save
# 4. Verify staff.csv has new entry
# 5. Try duplicate email → should show error
```

---

## 🤝 Team Handoff

**You provide:**
- LoginFrame.java (entry point for all users)
- AddStaffDialog.java (admin feature)
- staff.csv format + validation logic

**You receive:**
- File I/O layer from YoussefAdel (CSVHelper, BankSystem.loadUsers)
- AdminDashboard from AbdelrahmanMazen (to integrate AddStaffDialog)

**Message when done:**
> "✅ Auth + AddStaff done: LoginFrame handles 3-attempt limit, 
>  AddStaffDialog writes to staff.csv with validation. 
>  Ready for integration testing."

---

## 🎥 Quick Help

| Topic | Video |
|-------|-------|
| JPasswordField | https://youtu.be/a7rX_VbJL8k?t=120 |
| Dialog modality | https://youtu.be/9XJicRt_FaI?t=300 |
| Custom exception | https://youtu.be/6u4vqVvqJ8k |

---

## ✅ Submission Checklist

- [ ] LoginFrame.java - 3-attempt limit works, role routing works
- [ ] AddStaffDialog.java - validates, saves to staff.csv
- [ ] StaffCreationException.java - used for duplicate email
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] Pushed to feature/youesf-auth branch
