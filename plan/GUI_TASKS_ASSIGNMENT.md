# GUI Tasks Assignment - Phase 2

**Last Updated:** April 2026  
**Project:** OnlineBankSystem  
**Goal:** Each member implements GUI for their user type + File I/O + Exceptions

---

## Priority Legend
- 🔴 P0 = Critical (must have for grade)
- 🟡 P1 = Important (should have)
- 🟢 P2 = Nice to have (extra credit)

---

## Team GUI Tasks

| Priority | Component | Owner | Time | Notes |
|----------|-----------|-------|------|-------|
| 🔴 P0 | LoginFrame.java | YousefMohiey | 45 min | Read users.csv, authenticate |
| 🔴 P0 | RegisterFrame.java | YoussefAdel | 45 min | Write to users.csv |
| 🔴 P0 | Toast.java (utility) | YoussefAdel | 20 min | Shared notification popup |
| 🟡 P1 | AdminDashboard.java | **AbdelrahmanMazen** | 25 min | **SIMPLE**: 4 buttons, no complex logic |
| 🟡 P1 | GenerateReportDialog.java | **AbdelrahmanMazen** | 20 min | **SIMPLE**: Display data from CSV in JTable |
| 🟡 P1 | AddStaffDialog.java | YousefMohiey | 25 min | Auth-related, writes to staff.csv |
| 🟡 P1 | RemoveStaffDialog.java | YosefOsama | 20 min | Simple delete from collection |
| 🟡 P1 | UpdateStaffDialog.java | TarekSaeed | 25 min | Edit staff fields, save to CSV |
| 🟡 P1 | DeleteAccountDialog.java | YousifHafez | 20 min | Remove account from accounts.csv |
| 🟡 P1 | CustomerDashboard.java | YosefOsama | 45 min | Main customer menu |
| 🟡 P1 | TransactionDialog.java | YousifHafez | 30 min | Deposit/Withdraw/Transfer |
| 🟡 P1 | CardManagementFrame.java | YousifHafez | 40 min | Issue/update card status |
| 🟡 P1 | PayBillsFrame.java | YousifHafez | 30 min | Pay outstanding fees |
| 🟡 P1 | StaffDashboard.java | TarekSaeed | 45 min | Teller operations |
| 🟢 P2 | ForgotPasswordFrame.java | YousefMohiey | 30 min | Extra credit |
| 🟢 P2 | ProfileEditFrame.java | Any | 25 min | Extra credit |

---

## AbdelrahmanMazen - Reduced Scope (2 Windows Only)

### Why reduced:
- Focus on learning basics first
- Still covers all grading criteria (GUI + Files + Exceptions)
- Team picks up complex dialogs

### Your 2 Tasks:

#### 1. AdminDashboard.java (~25 min)
```java
// Starter code - just fill in the button actions
public class AdminDashboard extends JFrame {
    public AdminDashboard(Admin admin) {
        setTitle("Admin Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // 4 simple buttons
        JButton addStaff = new JButton("Add Staff");
        JButton removeStaff = new JButton("Remove Staff");
        JButton updateStaff = new JButton("Update Staff");
        JButton generateReport = new JButton("Generate Report");
        
        // TODO: Add action listeners that open the respective dialogs
        // For now: System.out.println("Button clicked");
        
        // Layout code here...
    }
}
```

#### 2. GenerateReportDialog.java (~20 min)
```java
// Starter code - just display data from CSV
public class GenerateReportDialog extends JDialog {
    public GenerateReportDialog(Frame parent) {
        super(parent, "Transaction Report", true);
        setSize(500, 400);
        
        // Read from reports.csv using CSVHelper
        // Display in JTable (no editing needed)
        
        JButton close = new JButton("Close");
        close.addActionListener(e -> dispose());
        add(close, BorderLayout.SOUTH);
    }
}
```

#### File I/O (your 30%):
- Create `saveAdminActions.csv` with format: `timestamp,adminId,actionType,details`
- Use your existing `CSVHelper.appendRow()` method
- No complex parsing needed

#### Exception (your 30%):
```java
// AdminActionException.java - 5 lines max
public class AdminActionException extends Exception {
    public AdminActionException(String message) {
        super(message);
    }
}
```

#### Grade Checklist for Abdelrahman:
- [ ] AdminDashboard has 4 working buttons (can just print for now)
- [ ] GenerateReportDialog shows data from CSV in a table
- [ ] Admin actions append to saveAdminActions.csv
- [ ] AdminActionException thrown on invalid action
- [ ] Code compiles and runs

**Total time: ~45 min** - achievable!

---

## File Contracts (Agreed CSV Formats)

### users.csv
```
id,name,email,password,phone,role,createdAt
258270,Youssef Adel,youssef@test.com,pass123,010...,StandardClient,2026-04-01
```

### staff.csv
```
id,name,email,password,phone,role,jobTitle,createdAt
S001,John Staff,john@test.com,pass456,011...,Staff,Teller,2026-04-02
```

### accounts.csv
```
accountId,ownerId,accountType,balance,createdAt,status
ACC001,258270,Savings,1000.00,2026-04-01,ACTIVE
```

### transactions.csv
```
txId,accountId,type,amount,timestamp,description
TX001,ACC001,DEPOSIT,500.00,2026-04-02T10:30,Initial deposit
```

### reports.csv (for Abdelrahman)
```
timestamp,adminId,actionType,details
2026-04-02T11:00,ADMIN001,REPORT_GENERATED,Transaction summary Q1
```

---

## Git Workflow

```bash
# Everyone: create your feature branch
git checkout -b feature/yourname-gui-task

# Code your 1-2 components
# Test locally
# Commit with clear message
git add src/gui/YourComponent.java
git commit -m "feat: Add YourComponent GUI"

# Push and create PR
git push origin feature/yourname-gui-task
# Then open PR on GitHub

# Review teammates' PRs before merging
```

---

## Testing Protocol (Run in This Order)

1. **File I/O Test** (YoussefAdel):
   ```bash
   java -cp out Main
   # Register user → exit → restart → verify data loads
   ```

2. **Auth Test** (YousefMohiey):
   ```bash
   # Login with registered user → verify role-based menu loads
   ```

3. **Admin Flow Test** (AbdelrahmanMazen):
   ```bash
   # Login as Admin → click Generate Report → verify table shows data
   ```

4. **Full Integration**:
   ```bash
   # All teammates run together, test cross-component flows
   ```

---

## Discord Sync Rules

- Post progress every 30 min: "Working on X, ETA Y min"
- Blockers? Post screenshot + error message immediately
- Done with task? Tag team: "✅ YourComponent ready for review"
- PR ready? Link + "Ready for review @teammate"

---

## Video Resources (ADHD-Friendly)

| Topic | Link | Duration |
|-------|------|----------|
| Java Swing Basics | https://youtu.be/9XJicRt_FaI | 12 min |
| JFrame + JButton Tutorial | https://youtu.be/a7rX_VbJL8k | 8 min |
| JTable from CSV | https://youtu.be/5K8vVvZqJ8E | 10 min |
| Custom Exceptions in Java | https://youtu.be/6u4vqVvqJ8k | 6 min |
| File I/O in Java | https://youtu.be/9XJicRt_FaI?t=180 | 5 min |

---

## Quick Start for Abdelrahman

```bash
# 1. Pull latest
git pull origin main

# 2. Create your branch
git checkout -b feature/abdelrahman-admin-gui

# 3. Create the 2 files (copy starter code above)
mkdir -p src/gui/admin
touch src/gui/admin/AdminDashboard.java
touch src/gui/admin/GenerateReportDialog.java

# 4. Compile and test
javac -d out -sourcepath src src/gui/admin/*.java

# 5. Commit when working
git add src/gui/admin/
git commit -m "feat: Add AdminDashboard + GenerateReportDialog"
git push origin feature/abdelrahman-admin-gui
```

**You got this!** Start with AdminDashboard first. If stuck, message the team on Discord. 🚀
