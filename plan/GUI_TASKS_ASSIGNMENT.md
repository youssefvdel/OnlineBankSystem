# GUI Tasks Assignment - Phase 2

**Last Updated:** April 22, 2026  
**Project:** OnlineBankSystem  
**Goal:** Each member implements GUI for their user type + File I/O + Exceptions  
**Master Plan:** See `PHASE2_PERFECT_PLAN.md` for full distribution + timeline

---

## Priority Legend
- 🔴 P0 = Critical (must have for grade)
- 🟡 P1 = Important (should have)
- 🟢 P2 = Nice to have (extra credit)

---

## Team GUI Tasks (Redistributed — Abdelrahman Minimal Scope)

| Priority | Component | Owner | Time | Notes |
|----------|-----------|-------|------|-------|
| 🔴 P0 | LoginFrame.java | YousefMohiey | 45 min | Read users.csv, authenticate |
| 🔴 P0 | RegisterFrame.java | YoussefAdel | 45 min | Write to users.csv ✅ DONE |
| 🔴 P0 | Toast.java (utility) | YoussefAdel | 20 min | Shared notification popup ✅ DONE |
| 🟡 P1 | AdminDashboard.java | **YoussefAdel** | 30 min | 4 buttons: Add/Remove/Update/Report ✅ DONE |
| 🟡 P1 | ViewReportsDialog.java | YoussefAdel | 25 min | View system reports in JTable ✅ DONE |
| 🟡 P1 | AddStaffDialog.java | YousefMohiey | 25 min | Auth-related, writes to staff.csv |
| 🟡 P1 | ViewStaffListDialog.java | YousefMohiey | 25 min | Display all staff in table |
| 🟡 P1 | AdminActionLogger.java | YousefMohiey | 20 min | Utility to log admin actions |
| 🟡 P1 | RemoveStaffDialog.java | YosefOsama | 20 min | Simple delete from collection |
| 🟡 P1 | UpdateStaffDialog.java | TarekSaeed | 25 min | Edit staff fields, save to CSV |
| 🟡 P1 | DeleteAccountDialog.java | YousifHafez | 20 min | Remove account from accounts.csv |
| 🟡 P1 | CustomerDashboard.java | YosefOsama | 45 min | Main customer menu |
| 🟡 P1 | TransactionDialog.java | YousifHafez | 30 min | Deposit/Withdraw only |
| 🟡 P1 | TransferMoneyDialog.java | YosefOsama | 30 min | Transfer between accounts |
| 🟡 P1 | CardManagementFrame.java | YousifHafez | 40 min | Issue/update card status |
| 🟢 P2 | ViewTransactionHistoryDialog.java | **AbdelrahmanMazen** | 25 min | Filterable transaction table (OPTIONAL) |
| 🟡 P1 | ViewAccountsDialog.java | TarekSaeed | 25 min | View all customer accounts |
| 🟡 P1 | StaffDashboard.java | TarekSaeed | 45 min | Teller operations |
| 🟢 P2 | ForgotPasswordFrame.java | YousefMohiey | 30 min | Extra credit |
| 🟢 P2 | ProfileEditFrame.java | Any | 25 min | Extra credit |

---

## GUI Tasks by Team Member

### YoussefAdel (258270) — System Core + Registration + Admin Dashboard ✅
**Already Done:** File I/O engine, CSVHelper, DataLoadException, Main.java menu
**GUI Tasks:**
1. 🔴 P0: `RegisterFrame.java` (45 min) — Registration form ✅ DONE
2. 🔴 P0: `Toast.java` (20 min) — Reusable notification popup ✅ DONE
3. 🟡 P1: `ViewReportsDialog.java` (25 min) — View system reports in JTable ✅ DONE
4. 🟡 P1: `AdminDashboard.java` (30 min) — Main admin menu (took from Abdelrahman) ✅ DONE
**Exception:** `DataLoadException.java` ✅ Already done
**File I/O:** users.csv (write), reports.csv (read+write)

---

### YousefMohiey (248679) — Authentication + Staff Management + Admin Actions
**GUI Tasks:**
1. 🔴 P0: `LoginFrame.java` (45 min) — Login with 3-attempt limit, role routing
2. 🟡 P1: `AddStaffDialog.java` (25 min) — Admin adds staff, writes to staff.csv
3. 🟡 P1: `ViewStaffListDialog.java` (25 min) — Display all staff in table (for Admin)
4. 🟡 P1: `AdminActionLogger.java` (20 min) — Utility to log admin actions to CSV
**Exception:** `StaffCreationException.java` — Throw on duplicate email
**File I/O:** users.csv (read for auth), staff.csv (read + write)

---

### AbdelrahmanMazen (251979) — Minimal Scope (1 Optional GUI)
**Note:** If not completed by 2:00 PM on sprint day → YoussefAdel or YousefMohiey will complete
**GUI Tasks:**
1. 🟢 P2: `ViewTransactionHistoryDialog.java` (25 min) — Filterable transaction table (OPTIONAL - Nice to have)
**Exception:** — (moved to YousefMohiey)
**File I/O:** transactions.csv (read only)

---

### YosefOsama (255796) — Customer Dashboard + Staff Remove + Transfer
**GUI Tasks:**
1. 🟡 P1: `CustomerDashboard.java` (45 min) — Account ops menu
2. 🟡 P1: `RemoveStaffDialog.java` (20 min) — Search & remove staff from staff.csv
3. 🟡 P1: `TransferMoneyDialog.java` (30 min) — Transfer between accounts with validation
**Exception:** `StaffNotFoundException.java` — Throw if staff not found
**File I/O:** accounts.csv (read + update), staff.csv (read + delete), transactions.csv (write)

---

### TarekSaeed (252382) — Staff Dashboard + Staff Update + Accounts View
**GUI Tasks:**
1. 🟡 P1: `StaffDashboard.java` (45 min) — Teller operations interface
2. 🟡 P1: `UpdateStaffDialog.java` (25 min) — Edit staff fields, save to staff.csv
3. 🟡 P1: `ViewAccountsDialog.java` (25 min) — View all customer accounts (for Staff/Admin)
**Exception:** `StaffUpdateException.java` — Throw on invalid phone/job
**File I/O:** staff.csv (read + update), accounts.csv (read)

---

### YousifHafez (258612) — Customer Features + Account Delete
**GUI Tasks:**
1. 🟡 P1: `TransactionDialog.java` (30 min) — Deposit/Withdraw
2. 🟡 P1: `CardManagementFrame.java` (40 min) — Issue/update card status
3. 🟡 P1: `DeleteAccountDialog.java` (20 min) — Admin deletes account (balance=0 check)
**Exception:** `AccountDeletionException.java` — Throw if balance > 0
**File I/O:** accounts.csv (read + delete), transactions.csv (read + delete related), cards.csv (read + write)

---

## Summary: Work Distribution

| Member | GUI Count | Total Time | Exceptions | Files |
|--------|-----------|------------|------------|-------|
| YoussefAdel | 4 | ~120 min | DataLoadException ✅ | users.csv, reports.csv |
| YousefMohiey | 4 | ~115 min | StaffCreationException | users.csv, staff.csv |
| AbdelrahmanMazen | 1 | ~25 min | — | transactions.csv |
| YosefOsama | 3 | ~95 min | StaffNotFoundException | accounts.csv, staff.csv, transactions.csv |
| TarekSaeed | 3 | ~95 min | StaffUpdateException | staff.csv, accounts.csv |
| YousifHafez | 3 | ~90 min | AccountDeletionException | accounts.csv, transactions.csv, cards.csv |

**Total: 18 GUIs, ~545 min (~9 hours) — Abdelrahman has minimal scope**

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

## Quick Start Guide

```bash
# 1. Pull latest
git pull origin main

# 2. Create your feature branch
git checkout -b feature/yourname-gui-task

# 3. Create your 3 assigned GUI files
mkdir -p src/gui/{auth,admin,customer,staff,util}

# 4. Compile and test
javac -d out -sourcepath src src/gui/yourfile/*.java

# 5. Commit when working
git add src/gui/
git commit -m "feat: Add your 3 GUI components"
git push origin feature/yourname-gui-task
```

**Starter Code Templates:** See individual task files in `plan/tasks/` for each member.

**You got this!** Start with your P0 task first. If stuck, message the team on Discord. 🚀
