# TarekSaeed_252382 - Phase 2 Tasks

**Role:** Staff Dashboard + Staff Update GUI  
**Student ID:** 252382  
**Time Estimate:** ~70 minutes total

---

## ✅ Your Tasks

### Task 1: StaffDashboard.java (~45 min) [ORIGINAL]

**Goal:** Teller/staff operations interface

**Key Features:**
- View assigned tasks
- Process customer transactions (deposit/withdraw helper)
- Update customer info (with admin approval flow)
- Logout button

**Integration:**
- Loads staff data from `staff.csv`
- Uses `bank.getStaffTasks(staffId)`

---

### Task 2: UpdateStaffDialog.java (~25 min) [NEW - redistributed from Abdelrahman]

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
        // TODO: Fill fields with current staff data
        phoneField.setText(selectedStaff.getPhone());
        jobField.setText(selectedStaff.getJobTitle());
    }
    
    private void handleSave() {
        // TODO: Update staff object, save to staff.csv
        // Throw StaffUpdateException if validation fails
        dispose();
    }
}
```

**File I/O:**
- Reads `staff.csv` to find staff by ID
- Updates fields and rewrites the file

**Exception Handling:**
- Create `StaffUpdateException.java` (extends Exception)
- Throw if phone format invalid or job title empty

**Done Criteria:**
- [ ] Dialog opens with current staff data pre-filled
- [ ] Phone/job fields can be edited
- [ ] Save button validates and updates staff.csv
- [ ] StaffUpdateException thrown on invalid input
- [ ] Cancel button closes without saving

---

## 📁 File Contracts

### staff.csv (you read + update)
```
id,name,email,password,phone,role,jobTitle,createdAt,status
S001,John Staff,john@test.com,pass456,01112345678,Staff,Teller,2026-04-02,ACTIVE
```

**Update logic:** Find line by ID, replace phone/job/password fields, keep rest unchanged

---

## 🧪 Testing

```bash
# Test UpdateStaffDialog
# 1. Login as admin
# 2. Click "Update Staff" (from AdminDashboard)
# 3. Select a staff member
# 4. Change phone number → Save
# 5. Verify staff.csv shows updated phone
# 6. Try invalid phone format → should show error
```

---

## 🤝 Team Handoff

**You provide:**
- StaffDashboard.java (teller interface)
- UpdateStaffDialog.java (admin feature)
- StaffUpdateException.java for validation errors

**You receive:**
- File I/O from YoussefAdel (CSVHelper update methods)
- AdminDashboard from AbdelrahmanMazen (to integrate UpdateStaffDialog)
- Staff list from YousefMohiey's AddStaffDialog

**Message when done:**
> "✅ Staff GUI + UpdateStaff done: Dashboard shows tasks, 
>  UpdateStaffDialog edits staff.csv with validation + exceptions. 
>  Ready for integration testing."

---

## 🎥 Quick Help

| Topic | Video |
|-------|-------|
| Pre-filling form fields | https://youtu.be/a7rX_VbJL8k?t=180 |
| File update pattern | https://youtu.be/9XJicRt_FaI?t=300 |
| Validation exceptions | https://youtu.be/6u4vqVvqJ8k?t=120 |

---

## ✅ Submission Checklist

- [ ] StaffDashboard.java - displays tasks, buttons functional
- [ ] UpdateStaffDialog.java - loads data, saves updates to staff.csv
- [ ] StaffUpdateException.java - thrown on invalid input
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] Pushed to feature/tarek-staff branch
