# OnlineBankSystem - Project Status Report

**Phase:** 2 - GUI Implementation & File I/O  
**Report Date:** April 22, 2026  
**Prepared By:** Youssef Adel  
**Format:** Java Serialization (.ser files)

---

## Executive Summary

| Metric | Value |
|--------|-------|
| **Overall Completion** | 71% |
| **Total Files Required** | 59 |
| **Files Completed** | 42 |
| **Files Missing** | 17 |
| **Team Members Active** | 2/6 |

---

## 1. Completed Work (42 files)

### 1.1 YoussefAdel (258270) — 100% Complete ✅

| File | Type | Purpose | Status |
|------|------|---------|--------|
| `RegisterFrame.java` | GUI | User registration form | ✅ Done |
| `RegisterFrame.form` | Form | NetBeans GUI Builder metadata | ✅ Done |
| `AdminDashboard.java` | GUI | Admin main menu | ✅ Done |
| `AdminDashboard.form` | Form | NetBeans GUI Builder metadata | ✅ Done |
| `ViewReportsDialog.java` | GUI | Reports table viewer | ✅ Done |
| `ViewReportsDialog.form` | Form | NetBeans GUI Builder metadata | ✅ Done |
| `Toast.java` | Utility | Reusable notification popup | ✅ Done |
| `BankSystem.java` | Manager | .ser File I/O engine | ✅ Done |
| `DataLoadException.java` | Exception | File load error handling | ✅ Done |
| `Main.java` | Entry | GUI application entry point | ✅ Done |

**Total:** 10 files | **Time Invested:** ~120 minutes

---

### 1.2 Existing Project Files (32 files)

#### Models - User Hierarchy (6 files)
| File | Purpose |
|------|---------|
| `User.java` | Base user class |
| `Admin.java` | Administrator user type |
| `Client.java` | Base client class |
| `StandardClient.java` | Standard tier client |
| `PremiumClient.java` | Premium tier client |
| `FirstClassClient.java` | First class tier client |

#### Models - Account Hierarchy (5 files)
| File | Purpose |
|------|---------|
| `Account.java` | Base account class |
| `SavingsAccount.java` | Savings account type |
| `CurrentAccount.java` | Current account type |
| `PremiumAccount.java` | Premium account type |
| `BusinessAccount.java` | Business account type |

#### Models - Transaction Hierarchy (5 files)
| File | Purpose |
|------|---------|
| `Transaction.java` | Base transaction class |
| `Deposit.java` | Deposit transaction |
| `Withdrawal.java` | Withdrawal transaction |
| `Transfer.java` | Transfer transaction |
| `TransactionHistory.java` | Transaction history tracker |

#### Interfaces (3 files)
| File | Purpose |
|------|---------|
| `Transferable.java` | Transfer capability interface |
| `Insurable.java` | Insurance capability interface |
| `LoanEligible.java` | Loan eligibility interface |

#### Exceptions (3 files)
| File | Purpose | Owner |
|------|---------|-------|
| `InsufficientFundsException.java` | Balance check error | Existing |
| `InvalidLoginException.java` | Authentication error | Existing |
| `DataLoadException.java` | File I/O error | YoussefAdel |

#### Utilities & Tests (4 files)
| File | Purpose |
|------|---------|
| `CSVHelper.java` | Legacy CSV utility (not used in .ser) |
| `SerializationTest.java` | .ser file I/O test |
| `LoginFrame.java` | Login GUI (YousefMohiey) |
| `LoginFrame.form` | Login GUI metadata (YousefMohiey) |

#### Data Files (Auto-generated) (3 files)
| File | Contents |
|------|----------|
| `data/users.ser` | Serialized user list |
| `data/accounts.ser` | Serialized account list |
| `data/transactions.ser` | Serialized transaction list |

---

## 2. Missing Work (17 files)

### 2.2 YousefMohiey (248679) — 17% Complete

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `AddStaffDialog.java` + `.form` | P0 | ❌ Missing | Admin adds new staff |
| `ViewStaffListDialog.java` + `.form` | P0 | ❌ Missing | Display all staff in table |
| `AdminActionLogger.java` | P1 | ❌ Missing | Log admin actions to reports.ser |
| `StaffCreationException.java` | P1 | ❌ Missing | Throw on duplicate email |
| `ForgotPasswordFrame.java` + `.form` | P2 | ❌ Missing | Password reset (optional) |

**Completed:** 1/6 (LoginFrame only)

---

### 2.3 YosefOsama (255796) — 0% Complete

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `CustomerDashboard.java` + `.form` | P0 | ❌ Missing | Customer main menu |
| `RemoveStaffDialog.java` + `.form` | P1 | ❌ Missing | Delete staff from system |
| `TransferMoneyDialog.java` + `.form` | P1 | ❌ Missing | Transfer between accounts |
| `StaffNotFoundException.java` | P1 | ❌ Missing | Throw if staff not found |

**Completed:** 0/4

---

### 2.4 TarekSaeed (252382) — 0% Complete

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `StaffDashboard.java` + `.form` | P0 | ❌ Missing | Teller operations interface |
| `UpdateStaffDialog.java` + `.form` | P1 | ❌ Missing | Edit staff details |
| `ViewAccountsDialog.java` + `.form` | P1 | ❌ Missing | View all customer accounts |
| `StaffUpdateException.java` | P1 | ❌ Missing | Throw on invalid update |

**Completed:** 0/4

---

### 2.5 YousifHafez (258612) — 0% Complete

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `TransactionDialog.java` + `.form` | P0 | ❌ Missing | Deposit/Withdraw GUI |
| `CardManagementFrame.java` + `.form` | P1 | ❌ Missing | Card operations |
| `DeleteAccountDialog.java` + `.form` | P1 | ❌ Missing | Admin deletes account |
| `AccountDeletionException.java` | P1 | ❌ Missing | Throw if balance > 0 |

**Completed:** 0/4

---

### 2.6 AbdelrahmanMazen (251979) — 0% Complete (Optional Scope)

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `ViewTransactionHistoryDialog.java` + `.form` | P2 | ❌ Missing | Transaction history viewer |

**Note:** Minimal scope due to non-participation. This file is optional.

**Completed:** 0/1

---

## 3. Completion Statistics

### 3.1 By Category

| Category | Required | Completed | Missing | % |
|----------|----------|-----------|---------|---|
| GUI Components (.java) | 18 | 5 | 13 | 28% |
| GUI Metadata (.form) | 18 | 5 | 13 | 28% |
| Exception Classes | 7 | 3 | 4 | 43% |
| Model Classes | 19 | 19 | 0 | 100% |
| Manager/Utils | 4 | 4 | 0 | 100% |
| Data Files (.ser) | 3 | 3 | 0 | 100% |
| Documentation | 8 | 8 | 0 | 100% |
| **TOTAL** | **59** | **42** | **17** | **71%** |

---

### 3.2 By Team Member

| Member | ID | Assigned | Done | Missing | % Complete |
|--------|----|----------|------|---------|------------|
| **YoussefAdel** | 258270 | 10 | 10 | 0 | **100%** ✅ |
| YousefMohiey | 248679 | 6 | 1 | 5 | 17% |
| YosefOsama | 255796 | 4 | 0 | 4 | 0% |
| TarekSaeed | 252382 | 4 | 0 | 4 | 0% |
| YousifHafez | 258612 | 4 | 0 | 4 | 0% |
| AbdelrahmanMazen | 251979 | 1 | 0 | 1 | 0% |

---

## 4. File I/O Specification (.ser Format)

### 4.1 Serialized Files

| File | Data Type | Owner |
|------|-----------|-------|
| `data/users.ser` | `ArrayList<User>` | YousefMohiey (read), YoussefAdel (write) |
| `data/staff.ser` | `ArrayList<Staff>` | YousefMohiey, YosefOsama, TarekSaeed |
| `data/accounts.ser` | `ArrayList<Account>` | YoussefAdel, YosefOsama, TarekSaeed, YousifHafez |
| `data/transactions.ser` | `ArrayList<Transaction>` | YoussefAdel, YousifHafez |
| `data/reports.ser` | `ArrayList<String>` | YousefMohiey (optional) |
| `data/cards.ser` | `ArrayList<Card>` | YousifHafez (optional) |

### 4.2 Serialization Code Pattern

```java
// Write
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/users.ser"));
oos.writeObject(users);
oos.close();

// Read
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/users.ser"));
ArrayList<User> users = (ArrayList<User>) ois.readObject();
ois.close();
```

---

## 5. Testing Status

### 5.1 Completed Tests

| Test | Status | Owner |
|------|--------|-------|
| SerializationTest | ✅ Pass | YoussefAdel |
| RegisterFrame GUI | ✅ Pass | YoussefAdel |
| AdminDashboard GUI | ✅ Pass | YoussefAdel |
| ViewReportsDialog GUI | ✅ Pass | YoussefAdel |
| Main.java Entry Point | ✅ Pass | YoussefAdel |

### 5.2 Pending Tests

| Test | Blocked By |
|------|------------|
| Login Authentication | YousefMohiey |
| Customer Dashboard Flow | YosefOsama |
| Staff Dashboard Flow | TarekSaeed |
| Transaction Operations | YousifHafez |
| Full Integration | All teammates |

---

## 6. Known Issues

### 6.1 Resolved

| Issue | Resolution | Date |
|-------|------------|------|
| AdminDashboard NPE | Removed null test from main() | Apr 22 |
| ViewReportsDialog tblReports | Added missing variable declaration | Apr 22 |
| Console menu in Main.java | Changed to GUI entry point | Apr 22 |
| Emoji usage in code | Removed all emojis | Apr 22 |

### 6.2 Outstanding

| Issue | Owner | Priority |
|-------|-------|----------|
| 13 GUI components missing | Teammates | P0 |
| 4 exception classes missing | Teammates | P1 |
| Integration testing blocked | All | P0 |

---

## 7. Git Repository Status

### 7.1 Branch Structure

```
main (protected)
├── feature/youssefadel-registration (merged)
├── feature/youssefadel-admin-dashboard (merged)
├── feature/youssefadel-view-reports (merged)
├── feature/youssefadel-toaster (merged)
├── feature/youssefadel-serialization (merged)
├── feature/yousefmohiey-login (open)
├── feature/yosefosama-customer (not created)
├── feature/tareksaeed-staff (not created)
└── feature/yousifhafez-transaction (not created)
```

### 7.2 Commit History (Last 10)

```
- feat: Fix AdminDashboard NPE (YoussefAdel)
- feat: Add ViewReportsDialog GUI (YoussefAdel)
- feat: Add AdminDashboard GUI (YoussefAdel)
- feat: Add RegisterFrame GUI (YoussefAdel)
- feat: Add Toast utility (YoussefAdel)
- feat: Implement BankSystem .ser I/O (YoussefAdel)
- feat: Add DataLoadException (YoussefAdel)
- refactor: Remove emojis from codebase (YoussefAdel)
- docs: Update task assignments (YoussefAdel)
- initial: Project setup (Team)
```

---

## 8. Recommendations

### 8.1 Immediate Actions (Next 24 Hours)

1. **YousefMohiey:** Complete AddStaffDialog, ViewStaffListDialog, AdminActionLogger
2. **YosefOsama:** Create CustomerDashboard, RemoveStaffDialog, TransferMoneyDialog
3. **TarekSaeed:** Create StaffDashboard, UpdateStaffDialog, ViewAccountsDialog
4. **YousifHafez:** Create TransactionDialog, CardManagementFrame, DeleteAccountDialog

### 8.2 Submission Strategy

**Option A: Submit Now (YoussefAdel Only)**
- Submit your 10 completed files
- Grade based on individual contribution
- No dependency on teammates

**Option B: Wait for Team (Risk: Late Submission)**
- Wait for teammates to complete their 17 files
- Submit as complete project
- Risk: Teammates may not deliver

**Recommended:** Option A - Your work is submission-ready

---

## 9. Appendix

### 9.1 Project Structure

```
OnlineBankSystem/
├── src/
│   ├── Main.java
│   ├── exceptions/
│   │   ├── DataLoadException.java
│   │   ├── InsufficientFundsException.java
│   │   └── InvalidLoginException.java
│   ├── gui/
│   │   ├── LoginFrame.java + .form
│   │   ├── admin/
│   │   │   ├── AdminDashboard.java + .form
│   │   │   └── ViewReportsDialog.java + .form
│   │   ├── auth/
│   │   │   └── RegisterFrame.java + .form
│   │   └── util/
│   │       └── Toast.java
│   ├── manager/
│   │   ├── BankSystem.java
│   │   └── SerializationTest.java
│   ├── models/
│   │   ├── account/ (5 files)
│   │   ├── transaction/ (5 files)
│   │   ├── user/ (6 files)
│   │   └── interfaces/ (3 files)
│   └── utils/
│       └── CSVHelper.java
├── data/
│   ├── users.ser
│   ├── accounts.ser
│   └── transactions.ser
├── plan/
│   ├── GUI_TASKS_ASSIGNMENT.md
│   ├── PHASE2_PERFECT_PLAN.md
│   └── tasks/ (6 member task files)
├── graphify-out/
│   ├── GRAPH_REPORT.md
│   └── graph.json
├── pom.xml
├── run.sh
└── PROJECT_STATUS_REPORT.md (this file)
```

### 9.2 Contact Information

| Member | ID | Email | Status |
|--------|----|-------|--------|
| YoussefAdel | 258270 | youssef.adel@bue.edu.eg | ✅ Active |
| YousefMohiey | 248679 | yousef.mohiey@bue.edu.eg | ⚠️ Partial |
| YosefOsama | 255796 | yosef.osama@bue.edu.eg | ❌ Inactive |
| TarekSaeed | 252382 | tarek.saeed@bue.edu.eg | ❌ Inactive |
| YousifHafez | 258612 | yousif.hafez@bue.edu.eg | ❌ Inactive |
| AbdelrahmanMazen | 251979 | abdelrahman.mazen@bue.edu.eg | ❌ Inactive |

---

## 10. Conclusion

**YoussefAdel has completed 100% of assigned work:**
- 4 GUI components with NetBeans .form files
- Complete .ser File I/O implementation
- All required exception handling
- Full documentation
- Professional code quality (no emojis, JavaDoc comments)

**Project is blocked on 17 files from 5 teammates.**

**Recommendation:** Submit individual portion now to guarantee grade. Team portion can be submitted later if teammates deliver.

---

**Report Generated:** April 22, 2026  
**Version:** 1.0  
**Status:** Ready for Submission (Individual)
