# YosefOsama_255796 - Phase 2 Tasks

**Role:** Customer GUI + Staff Removal  
**Student ID:** 255796  
**Time Estimate:** ~65 minutes total

---

## ✅ Your Tasks

### Task 1: CustomerDashboard.java (~45 min) [ORIGINAL]

**Goal:** Main customer menu with account operations

**Key Features:**
- Display account balance
- Buttons: Deposit, Withdraw, Transfer, View History, Manage Card
- Logout button returns to LoginFrame

**Integration:**
- Loads customer data from `users.csv` + `accounts.csv`
- Uses `bank.getCustomerAccounts(customerId)`

---

### Task 2: RemoveStaffDialog.java (~20 min) [NEW - redistributed from Abdelrahman]

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
        // TODO: Search staff.csv, populate resultsCombo
        // Use CSVHelper to find matching staff
    }
    
    private void handleRemove() {
        // TODO: Remove selected staff from collection + csv
        // Throw StaffNotFoundException if not found
        dispose();
    }
}
```

**File I/O:**
- Reads `staff.csv` to find staff
- Removes entry and rewrites file (or marks as DELETED)

**Exception Handling:**
- Create `StaffNotFoundException.java` (extends Exception)
- Throw if search returns no results or remove fails

**Done Criteria:**
- [ ] Dialog opens from AdminDashboard "Remove Staff" button
- [ ] Search finds staff by name or ID
- [ ] Remove button deletes from staff.csv
- [ ] StaffNotFoundException thrown if not found
- [ ] Cancel button closes dialog

---

## 📁 File Contracts

### staff.csv (you read + modify)
```
id,name,email,password,phone,role,jobTitle,createdAt,status
S001,John Staff,john@test.com,pass456,011...,Staff,Teller,2026-04-02,ACTIVE
```

**Note:** Use `status` field for soft delete (DELETED) or physically remove line

---

## 🧪 Testing

```bash
# Test RemoveStaffDialog
# 1. Login as admin
# 2. Click "Remove Staff"
# 3. Search for existing staff ID
# 4. Select and remove
# 5. Verify staff.csv no longer has that entry (or shows DELETED)
# 6. Try removing non-existent ID → should show error
```

---

## 🤝 Team Handoff

**You provide:**
- CustomerDashboard.java (main customer interface)
- RemoveStaffDialog.java (admin feature)
- StaffNotFoundException.java for error handling

**You receive:**
- File I/O from YoussefAdel (CSVHelper methods)
- AdminDashboard from AbdelrahmanMazen (to integrate RemoveStaffDialog)

**Message when done:**
> "✅ Customer GUI + RemoveStaff done: Dashboard shows account ops, 
>  RemoveStaffDialog searches/removes from staff.csv with exception handling. 
>  Ready for integration."

---

## 🎥 Quick Help

| Topic | Video |
|-------|-------|
| JComboBox search | https://youtu.be/5K8vVvZqJ8E?t=180 |
| File rewrite in Java | https://youtu.be/9XJicRt_FaI?t=240 |
| Custom exception pattern | https://youtu.be/6u4vqVvqJ8k |

---

## ✅ Submission Checklist

- [ ] CustomerDashboard.java - displays balance, buttons work
- [ ] RemoveStaffDialog.java - search + remove works, updates staff.csv
- [ ] StaffNotFoundException.java - thrown when staff not found
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] Pushed to feature/yosef-customer branch
