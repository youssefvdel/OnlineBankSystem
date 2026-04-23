# OnlineBankSystem - Project Status Report

**Phase:** 2 - GUI Implementation & File I/O  
**Report Date:** April 23, 2026  
**Prepared By:** Youssef Adel  
**Format:** CSV Files (changed from .ser)

---

## Executive Summary

| Metric | Value |
|--------|-------|
| **Overall Completion** | 85% |
| **Total Files Required** | 65 |
| **Files Completed** | 55 |
| **Files Missing** | 10 |
| **Team Members Active** | 3/6 |

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
| `BankSystem.java` | Manager | CSV File I/O engine | ✅ Done |
| `DataLoadException.java` | Exception | File load error handling | ✅ Done |
| `Main.java` | Entry | GUI application entry point | ✅ Done |
| `CSVHelper.java` | Utility | CSV read/write utility | ✅ Done |
| `CardStatus.java` | Enum | Card status types | ✅ Done |

**Total:** 12 files | **Time Invested:** ~180 minutes

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

## 2. Missing Work (6 files)

**Note:** Staff-related features deleted (no Staff user type). See TODO list for unassigned features.

### 2.2 YousefMohiey (248679) — 33% Complete

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `AdminActionLogger.java` | P1 | ❌ Missing | Log admin actions |
| `ForgotPasswordFrame.java` + `.form` | P2 | ❌ Missing | Password reset (optional) |

**Completed:** 1/3 (LoginFrame done, AddStaff/ViewStaff deleted as not needed)

---

### 2.3 YosefOsama (255796) — 0% Complete

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `CustomerDashboard.java` + `.form` | P0 | ❌ Missing | Customer main menu |
| `RemoveStaffDialog.java` + `.form` | P1 | ❌ Not Needed | **DELETED** - no Staff role |
| `TransferMoneyDialog.java` + `.form` | P1 | ❌ Missing | Moved to TODO list |
| `StaffNotFoundException.java` | P1 | ❌ Not Needed | **DELETED** - no Staff role |

**Completed:** 0/2 (2 staff tasks deleted as not needed)

---

### 2.4 TarekSaeed (252382) — 40% Complete (Off-Track)

**What he actually did (not his assigned tasks):**

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `TransactionFailedException.java` | P1 | ✅ Done | Generic transaction failure exception |
| `TransactionPanel.java` + `.form` | P1 | ✅ Done | Deposit/Withdraw GUI (duplicates Hafez) |
| Transaction exceptions in Account classes | P1 | ✅ Done | Added to all Account subclasses |
| `TransactionHistory` file handling | P1 | ✅ Done | Loads from transactions.txt |

**His ASSIGNED work evaluation:**

| File | Priority | Status | Decision | Reason |
|------|----------|--------|----------|--------|
| `StaffDashboard.java` + `.form` | P0 | ❌ Not Needed | **DELETE** | No Staff user type exists (only Admin/Client) |
| `UpdateStaffDialog.java` + `.form` | P1 | ❌ Not Needed | **DELETE** | No Staff user type exists |
| `StaffUpdateException.java` | P1 | ❌ Not Needed | **DELETE** | No Staff user type exists |
| `ViewAccountsDialog.java` + `.form` | P1 | ❌ Missing | **TODO** | Useful for Admin - moved to general backlog |
| `TransferMoneyDialog.java` + `.form` | P1 | 🚧 Under Work | **TODO** | Needed for customer transfers |
| `TransactionHistoryDialog.java` + `.form` | P2 | ❌ Missing | **TODO** | Useful for viewing history |

**Note:** Tarek's assigned staff features are NOT NEEDED because there's no Staff user type in the system. Only Admin and Client roles exist. His transaction work (TransactionFailedException, TransactionPanel) is useful and kept.

**Completed:** 4/7 (0/3 assigned staff tasks done, but staff tasks deleted as unnecessary)

---

### 2.5 YousifHafez (258612) — 100% Complete ✅

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `TransactionDialog.java` + `.form` | P0 | ✅ Done | Deposit/Withdraw GUI |
| `CardManagementFrame.java` + `.form` | P1 | ✅ Done | Card operations (was CardForm) |
| `DeleteAccountDialog.java` + `.form` | P1 | ✅ Done | Admin deletes account |
| `AccountDeletionException.java` | P1 | ✅ Done | Throw if balance > 0 |
| `PayBillForm.java` + `.form` | P2 | ✅ Extra | Bill payment (not assigned) |

**Completed:** 5/5 (1 extra)

---

### 2.6 AbdelrahmanMazen (251979) — 0% Complete (Optional Scope)

| File | Priority | Status | Purpose |
|------|----------|--------|---------|
| `ViewTransactionHistoryDialog.java` + `.form` | P2 | ✅ Done | Transaction history viewer |

**Note:** Abdelrahman submitted unusable hand-coded Swing (deleted). Created proper NetBeans GUI Builder version with .form file.

**Completed:** 1/1

---

## 3. Completion Statistics

### 3.1 By Category

| Category | Required | Completed | Missing | % |
|----------|----------|-----------|---------|---|
| GUI Components (.java) | 15 | 13 | 2 | 87% |
| GUI Metadata (.form) | 15 | 12 | 3 | 80% |
| Exception Classes | 6 | 5 | 1 | 83% |
| Model Classes | 20 | 20 | 0 | 100% |
| Manager/Utils | 4 | 4 | 0 | 100% |
| Data Files (.csv) | 4 | 0 | 4 | 0% |
| Documentation | 8 | 8 | 0 | 100% |
| **TOTAL** | **61** | **56** | 5 | **92%** |

---

### 3.2 By Team Member

| Member | ID | Assigned | Done | Missing | % Complete |
|--------|----|----------|------|---------|------------|
| **YoussefAdel** | 258270 | 12 | 12 | 0 | **100%** ✅ |
| YousifHafez | 258612 | 5 | 5 | 0 | **100%** ✅ |
| AbdelrahmanMazen | 251979 | 1 | 1 | 0 | **100%** ✅ |
| TarekSaeed | 252382 | 10 | 4 | 6 | **40%** ⚠️ |
| YousefMohiey | 248679 | 6 | 1 | 5 | 17% |
| YosefOsama | 255796 | 4 | 0 | 4 | 0% |

---

## 4. File I/O Specification (CSV Format)

### 4.1 CSV Files

| File | Format | Owner |
|------|--------|-------|
| `data/users.csv` | Headers: type,userId,name,password,email,clientId,phone,status,cardStatus | YoussefAdel |
| `data/accounts.csv` | Headers: type,accountNumber,balance,ownerUserId,extra1,extra2 | YoussefAdel |
| `data/transactions.csv` | Headers: type,transactionId,amount,timestamp,accountId,status,destAccountId | YoussefAdel |
| `data/cards.csv` | Headers: clientUserId,cardStatus | YoussefAdel |

### 4.2 CSV Code Pattern

```java
// Write
List<String> lines = new ArrayList<>();
lines.add("header1,header2,header3");
lines.add("value1,value2,value3");
CSVHelper.writeLines("data/file.csv", lines);

// Read
List<String> lines = CSVHelper.readLines("data/file.csv");
for (int i = 1; i < lines.size(); i++) {
    List<String> fields = CSVHelper.parseLine(lines.get(i));
    // process fields...
}
```

---

## 5. Testing Status

### 5.1 Completed Tests

| Test | Status | Owner |
|------|--------|-------|
| CSV BankSystem | ✅ Pass | YoussefAdel |
| RegisterFrame GUI | ✅ Pass | YoussefAdel |
| AdminDashboard GUI | ✅ Pass | YoussefAdel |
| ViewReportsDialog GUI | ✅ Pass | YoussefAdel |
| TransactionDialog GUI | ✅ Pass | YousifHafez |
| CardManagementFrame GUI | ✅ Pass | YousifHafez |
| DeleteAccountDialog GUI | ✅ Pass | YousifHafez |
| PayBillForm GUI | ✅ Pass | YousifHafez (extra) |
| Main.java Entry Point | ✅ Pass | YoussefAdel |

### 5.2 Pending Tests

| Test | Blocked By |
|------|------------|
| Login Authentication | YousefMohiey |
| Customer Dashboard Flow | YosefOsama |
| Full Integration | YousefMohiey + YosefOsama + TODO items |

---

## 6. Known Issues

### 6.1 Resolved

| Issue | Resolution | Date |
|-------|------------|------|
| AdminDashboard NPE | Removed null test from main() | Apr 22 |
| ViewReportsDialog tblReports | Added missing variable declaration | Apr 22 |
| Console menu in Main.java | Changed to GUI entry point | Apr 22 |
| Emoji usage in code | Removed all emojis | Apr 22 |
| File I/O format | Switched from .ser to CSV | Apr 23 |
| CardForm naming | Renamed to CardManagementFrame | Apr 23 |
| Card persistence | Changed from card.txt to cards.csv | Apr 23 |
| Merge conflicts | Fixed all conflict markers | Apr 23 |
| ClientUpdateForm extra | Deleted (not needed) | Apr 23 |
| Staff features deleted | No Staff user type in system | Apr 23 |
| BankSystem enhanced | Added getAccountsByUser(), getAllAccounts() | Apr 23 |

### 6.2 Outstanding

| Issue | Owner | Priority |
|-------|-------|----------|
| 3 GUI components missing | Teammates | P0 |
| 1 exception class missing | Teammates | P1 |
| Integration testing blocked | All | P0 |

---

## 7. General TODO List (Unassigned)

These features are needed but not assigned to anyone yet. Pick up if you have time:

| Priority | Feature | Description | Estimated Time |
|----------|---------|-------------|----------------|
| P1 | `ViewAccountsDialog.java` + `.form` | Admin views all customer accounts in table | 25 min |
| P1 | `TransferMoneyDialog.java` + `.form` | Transfer between accounts GUI | 30 min |
| P2 | `TransactionHistoryDialog.java` + `.form` | View transaction history with filters | 25 min |
| P2 | `ForgotPasswordFrame.java` + `.form` | Password reset functionality | 30 min |

**Note:** Staff-related features (StaffDashboard, UpdateStaffDialog, StaffUpdateException) were **deleted** from requirements because there's no Staff user type in the system.

---

## 8. Git Repository Status

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

## 9. Recommendations

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

## 10. Appendix

### 9.1 Project Structure

```
OnlineBankSystem/
├── src/
│   ├── Main.java
│   ├── exceptions/
│   │   ├── AccountDeletionException.java     (Hafez)
│   │   ├── DataLoadException.java            (YoussefAdel)
│   │   ├── InsufficientFundsException.java
│   │   ├── InvalidAmountException.java       (Hafez)
│   │   └── InvalidLoginException.java
│   ├── gui/
│   │   ├── admin/
│   │   │   ├── AdminDashboard.java + .form   (YoussefAdel)
│   │   │   ├── DeleteAccountDialog.java + .form (Hafez)
│   │   │   └── ViewReportsDialog.java + .form (YoussefAdel)
│   │   ├── auth/
│   │   │   ├── LoginFrame.java + .form       (YousefMohiey)
│   │   │   └── RegisterFrame.java + .form    (YoussefAdel)
│   │   ├── customer/
│   │   │   ├── CardManagementFrame.java + .form (Hafez)
│   │   │   ├── ClientDashboard.java          (YosefOsama)
│   │   │   ├── PayBillForm.java + .form      (Hafez - extra)
│   │   │   └── TransactionDialog.java + .form (Hafez)
│   │   └── util/
│   │       └── Toast.java                    (YoussefAdel)
│   ├── manager/
│   │   ├── BankSystem.java                   (YoussefAdel - CSV)
│   │   └── SerializationTest.java
│   ├── models/
│   │   ├── account/ (5 files)
│   │   ├── transaction/ (5 files)
│   │   ├── user/ (7 files including CardStatus)
│   │   └── interfaces/ (3 files)
│   └── utils/
│       └── CSVHelper.java                    (YoussefAdel)
├── data/
│   ├── users.csv
│   ├── accounts.csv
│   ├── transactions.csv
│   └── cards.csv
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
| TarekSaeed | 252382 | tarek.saeed@bue.edu.eg | ⚠️ Off-Track |
| YousifHafez | 258612 | yousif.hafez@bue.edu.eg | ✅ Active |
| AbdelrahmanMazen | 251979 | abdelrahman.mazen@bue.edu.eg | ✅ Task Done (by YoussefAdel) |

---

## 11. Conclusion

**YoussefAdel has completed 100% of assigned work:**
- 4 GUI components with NetBeans .form files
- Complete CSV File I/O implementation (BankSystem + CSVHelper)
- All required exception handling
- Full documentation
- Professional code quality (no emojis, JavaDoc comments)

**YousifHafez has completed 100% of assigned work (plus 1 extra):**
- TransactionDialog.java + .form (Deposit/Withdraw)
- CardManagementFrame.java + .form (Card operations)
- DeleteAccountDialog.java + .form (Account deletion)
- AccountDeletionException.java
- PayBillForm.java + .form (Extra - not assigned)

**TarekSaeed partial completion (40% - off track):**
- TransactionFailedException.java ✅
- TransactionPanel.java + .form ✅ (but duplicates Hafez's work)
- Transaction exceptions in Account classes ✅
- TransactionHistory file handling ✅
- ❌ Missing all assigned staff features

**Project Status:**
- 13/15 GUIs complete (87%)
- 6/7 exceptions complete (86%)
- All models complete (100%)
- BankSystem enhanced with getAccountsByUser(), getAllAccounts(), getAllTransactions()

**Features deleted (not needed):**
- StaffDashboard, UpdateStaffDialog, StaffUpdateException, AddStaffDialog, ViewStaffListDialog, StaffCreationException, RemoveStaffDialog, StaffNotFoundException
- Reason: No Staff user type exists in system (only Admin and Client)

**Still missing:**
- YousefMohiey: AdminActionLogger, ForgotPasswordFrame (optional)
- YosefOsama: CustomerDashboard (partial - ClientDashboard placeholder exists)
- TODO List (unassigned): ViewAccountsDialog, TransferMoneyDialog

**Recommendation:** System is 92% complete. Core functionality done.

---

**Report Generated:** April 23, 2026
**Version:** 2.3
**Status:** 92% Complete - Abdelrahman's task completed
