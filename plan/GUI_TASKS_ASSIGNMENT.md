# GUI Tasks Assignment - Phase 2

**Last Updated:** April 22, 2026  
**Project:** OnlineBankSystem  
**Goal:** Each member implements GUI for their user type + File I/O (.ser) + Exceptions  
**Master Plan:** See `PHASE2_PERFECT_PLAN.md` for full distribution + timeline

---

## Priority Legend
-  P0 = Critical (must have for grade)
-  P1 = Important (should have)
-  P2 = Nice to have (extra credit)

---

## Team GUI Tasks (Final Distribution - .ser Format)

| Priority | Component | Owner | Time | Notes |
|----------|-----------|-------|------|-------|
|  P0 | LoginFrame.java | YousefMohiey | 45 min | Read users.ser, authenticate |
|  P0 | RegisterFrame.java | **YoussefAdel** | 45 min | Write to users.ser  DONE |
|  P0 | Toast.java (utility) | **YoussefAdel** | 20 min | Shared notification popup  DONE |
|  P1 | AdminDashboard.java | **YoussefAdel** | 30 min | 4 buttons (took from Abdelrahman)  DONE |
|  P1 | ViewReportsDialog.java | **YoussefAdel** | 25 min | View reports in JTable  DONE |
|  P1 | AddStaffDialog.java | YousefMohiey | 25 min | Writes to staff.ser |
|  P1 | ViewStaffListDialog.java | YousefMohiey | 25 min | Display all staff in table |
|  P1 | AdminActionLogger.java | YousefMohiey | 20 min | Log admin actions to reports.ser |
|  P1 | RemoveStaffDialog.java | YosefOsama | 20 min | Delete from staff.ser |
|  P1 | UpdateStaffDialog.java | TarekSaeed | 25 min | Edit staff, save to staff.ser |
|  P1 | DeleteAccountDialog.java | YousifHafez | 20 min | Remove from accounts.ser |
|  P1 | CustomerDashboard.java | YosefOsama | 45 min | Main customer menu |
|  P1 | TransactionDialog.java | YousifHafez | 30 min | Deposit/Withdraw |
|  P1 | TransferMoneyDialog.java | YosefOsama | 30 min | Transfer between accounts |
|  P1 | CardManagementFrame.java | YousifHafez | 40 min | Issue/update card status |
|  P2 | ViewTransactionHistoryDialog.java | **AbdelrahmanMazen** | 25 min | Filterable table (OPTIONAL) |
|  P1 | ViewAccountsDialog.java | TarekSaeed | 25 min | View all customer accounts |
|  P1 | StaffDashboard.java | TarekSaeed | 45 min | Teller operations |
|  P2 | ForgotPasswordFrame.java | YousefMohiey | 30 min | Extra credit |
|  P2 | ProfileEditFrame.java | Any | 25 min | Extra credit |

---

## GUI Tasks by Team Member

### YoussefAdel (258270) — System Core + Registration + Admin Dashboard 
**Already Done:** File I/O engine, DataLoadException, Main.java menu
**GUI Tasks:**
1.  P0: `RegisterFrame.java` (45 min) — Registration form  DONE
2.  P0: `Toast.java` (20 min) — Reusable notification popup  DONE
3.  P1: `ViewReportsDialog.java` (25 min) — View reports in JTable  DONE
4.  P1: `AdminDashboard.java` (30 min) — Main admin menu  DONE
**Exception:** `DataLoadException.java`  Already done
**File I/O:** users.ser, accounts.ser, transactions.ser (read+write via serialization)

---

### YousefMohiey (248679) — Authentication + Staff Management + Admin Actions
**GUI Tasks:**
1.  P0: `LoginFrame.java` (45 min) — Login with 3-attempt limit
2.  P1: `AddStaffDialog.java` (25 min) — Admin adds staff
3.  P1: `ViewStaffListDialog.java` (25 min) — Display all staff in table
4.  P1: `AdminActionLogger.java` (20 min) — Log admin actions to reports.ser
**Exception:** `StaffCreationException.java` — Throw on duplicate email
**File I/O:** users.ser (read), staff.ser (write)

---

### AbdelrahmanMazen (251979) — Minimal Scope (1 Optional GUI)
**Note:** If not completed by 2:00 PM on sprint day → Team will complete
**GUI Tasks:**
1.  P2: `ViewTransactionHistoryDialog.java` (25 min) — Filterable transaction table (OPTIONAL)
**Exception:** — (moved to YousefMohiey)
**File I/O:** transactions.ser (read only)

---

### YosefOsama (255796) — Customer Dashboard + Staff Remove + Transfer
**GUI Tasks:**
1.  P1: `CustomerDashboard.java` (45 min) — Account ops menu
2.  P1: `RemoveStaffDialog.java` (20 min) — Search & remove staff
3.  P1: `TransferMoneyDialog.java` (30 min) — Transfer between accounts
**Exception:** `StaffNotFoundException.java` — Throw if staff not found
**File I/O:** accounts.ser, staff.ser, transactions.ser

---

### TarekSaeed (252382) — Staff Dashboard + Staff Update + Accounts View
**GUI Tasks:**
1.  P1: `StaffDashboard.java` (45 min) — Teller operations interface
2.  P1: `UpdateStaffDialog.java` (25 min) — Edit staff fields
3.  P1: `ViewAccountsDialog.java` (25 min) — View all customer accounts
**Exception:** `StaffUpdateException.java` — Throw on invalid phone/job
**File I/O:** staff.ser, accounts.ser

---

### YousifHafez (258612) — Customer Features + Account Delete
**GUI Tasks:**
1.  P1: `TransactionDialog.java` (30 min) — Deposit/Withdraw
2.  P1: `CardManagementFrame.java` (40 min) — Issue/update card status
3.  P1: `DeleteAccountDialog.java` (20 min) — Admin deletes account
**Exception:** `AccountDeletionException.java` — Throw if balance > 0
**File I/O:** accounts.ser, transactions.ser, cards.ser

---

## Summary: Work Distribution

| Member | GUI Count | Total Time | Exceptions | Files |
|--------|-----------|------------|------------|-------|
| YoussefAdel | 4  | ~120 min | DataLoadException  | users.ser, accounts.ser, transactions.ser |
| YousefMohiey | 4 | ~115 min | StaffCreationException | users.ser, staff.ser |
| AbdelrahmanMazen | 1 | ~25 min | — | transactions.ser |
| YosefOsama | 3 | ~95 min | StaffNotFoundException | accounts.ser, staff.ser, transactions.ser |
| TarekSaeed | 3 | ~95 min | StaffUpdateException | staff.ser, accounts.ser |
| YousifHafez | 3 | ~90 min | AccountDeletionException | accounts.ser, transactions.ser, cards.ser |

**Total: 18 GUIs, ~545 min (~9 hours) — Abdelrahman has minimal scope**

---

## File Contracts (.ser Format - Java Serialization)

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

### reports.ser (optional - for admin action logging)
```java
// ArrayList<String> or custom Report class
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/reports.ser"));
oos.writeObject(reports);
```

### cards.ser (for YousifHafez)
```java
// ArrayList<Card> serialized
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/cards.ser"));
oos.writeObject(cards);
```

---

## Git Workflow

```bash
# Everyone: create your feature branch
git checkout -b feature/yourname-gui-task

# Code your components
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
 java -cp out manager.SerializationTest
 # Verify .ser files created and data persists
 ```

2. **Auth Test** (YousefMohiey):
 ```bash
 java -cp out Main
 # Login with registered user → verify role-based menu loads
 ```

3. **Admin Flow Test** (YoussefAdel + YousefMohiey):
 ```bash
 # Login as Admin → AdminDashboard opens → Click buttons
 # Verify reports.ser gets appended
 ```

4. **Full Integration**:
 ```bash
 # All teammates run together, test cross-component flows
 # Verify all .ser files persist correctly
 ```

---

## Discord Sync Rules

- Post progress every 30 min: "Working on X, ETA Y min"
- Blockers? Post screenshot + error message immediately
- Done with task? Tag team: " YourComponent ready for review"
- PR ready? Link + "Ready for review @teammate"

---

## Video Resources (ADHD-Friendly)

| Topic | Link | Duration |
|-------|------|----------|
| Java Swing Basics | https://youtu.be/9XJicRt_FaI | 12 min |
| JFrame + JButton Tutorial | https://youtu.be/a7rX_VbJL8k | 8 min |
| JTable from CSV | https://youtu.be/5K8vVvZqJ8E | 10 min |
| Custom Exceptions in Java | https://youtu.be/6u4vqVvqJ8k | 6 min |
| Java Serialization | https://youtu.be/ue06TSYXJpY | 5 min |

---

## Quick Start Guide

```bash
# 1. Pull latest
git pull origin main

# 2. Create your feature branch
git checkout -b feature/yourname-gui-task

# 3. Create your assigned GUI files (NetBeans GUI Builder)
mkdir -p src/gui/{auth,admin,customer,staff,util}

# 4. Compile and test
javac -d out $(find src -name "*.java" -type f)

# 5. Run serialization test
java -cp out manager.SerializationTest

# 6. Commit when working
git add src/gui/
git commit -m "feat: Add your GUI components"
git push origin feature/yourname-gui-task
```

**Starter Code Templates:** See individual task files in `plan/tasks/` for each member.

**Important:** All GUIs must be NetBeans GUI Builder format (`.form` files required).

**You got this!** Start with your P0 task first. If stuck, message the team on Discord. 
