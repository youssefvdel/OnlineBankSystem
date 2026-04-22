# Phase 2 — Perfect Work Distribution Plan

**Last Updated:** April 22, 2026  
**Goal:** 100% Grade Coverage (GUI + File I/O + Exceptions)  
**Principle:** Equal distribution, preserve original tasks, add missing GUIs

---

## 📊 Current State Analysis

### What Exists ✅
- **File I/O Engine:** `BankSystem.saveAllData()/loadAllData()` (YoussefAdel)
- **CSV Helper:** `CSVHelper.java` (YoussefAdel)
- **Console Menu:** Interactive login/register (YoussefAdel)
- **LoginFrame:** GUI skeleton (YousefMohiey)
- **Models:** User, Admin, Client, Account, Transaction hierarchy

### What Missing ❌
- **17 GUI components** (see table below)
- **5 custom exceptions** (StaffCreation, StaffNotFound, StaffUpdate, AdminAction, AccountDeletion)
- **Staff model** (not in codebase yet)
- **Card model + cards.csv** (not in codebase yet)

---

## 🎯 Perfect Distribution (Abdelrahman Minimal - 1 GUI Only)

### YoussefAdel (258270) — System Core + Registration + Admin Reports
**Original Tasks (Keep):**
- ✅ File I/O engine (done)
- ✅ CSVHelper (done)
- ✅ DataLoadException (done)
- ✅ Main.java menu loop (done)

**GUI Tasks (Added - took from Abdelrahman):**
1. 🔴 P0: `RegisterFrame.java` (45 min) — Registration form → writes users.csv ✅ DONE
2. 🔴 P0: `Toast.java` (20 min) — Static utility: showSuccess(), showError() ✅ DONE
3. 🟡 P1: `ViewReportsDialog.java` (25 min) — Display reports.csv in JTable ✅ DONE
4. 🟡 P1: `AdminDashboard.java` (30 min) — Main admin menu (took from Abdelrahman)

**Exception:** `DataLoadException.java` ✅ Already done

**File I/O:** users.csv (write), reports.csv (read+write), admin_actions.csv (append)

**Branch:** `feature/youssefadel-registration-gui`

---

### YousefMohiey (248679) — Authentication + Staff Add + Staff List + Admin Actions
**Original Tasks (Keep):**
1. 🔴 P0: `LoginFrame.java` (45 min) — Login with 3-attempt limit ✅ In progress
2. 🟡 P1: `AddStaffDialog.java` (25 min) — Admin adds staff → staff.csv

**New Tasks (Added from Abdelrahman):**
3. 🟡 P1: `ViewStaffListDialog.java` (25 min) — Display all staff in JTable (for Admin)
4. 🟡 P1: `AdminActionLogger.java` (20 min) — Utility to log admin actions to CSV

**Exception:** `StaffCreationException.java` — Throw on duplicate email

**File I/O:** users.csv (read for auth), staff.csv (write for new staff, read for list)

**Branch:** `feature/yousefmohiey-auth-staff-gui`

---

### AbdelrahmanMazen (251979) — Minimal Scope (1 GUI Only - Non-Critical)
**Reduced Tasks (Waiting for him - team will complete if not done):**
1. 🟢 P2: `ViewTransactionHistoryDialog.java` (25 min) — Filterable transaction table (NICE TO HAVE)

**Exception:** `AdminActionException.java` — Throw on invalid admin action (MOVED to YousefMohiey)

**Note:** If not completed by 2:00 PM sprint day → YoussefAdel or YousefMohiey will complete

**File I/O:** transactions.csv (read only)

**Branch:** `feature/abdelrahman-admin-gui`

---

### YosefOsama (255796) — Customer Dashboard + Staff Remove + Transfer
**Original Tasks (Keep):**
1. 🟡 P1: `CustomerDashboard.java` (45 min) — Account ops menu
2. 🟡 P1: `RemoveStaffDialog.java` (20 min) — Search & remove staff from staff.csv

**New Task (Added for balance):**
3. 🟡 P1: `TransferMoneyDialog.java` (30 min) — Transfer between accounts with validation

**Exception:** `StaffNotFoundException.java` — Throw if staff not found

**File I/O:** accounts.csv (read + update), staff.csv (read + delete), transactions.csv (write for transfer)

**Branch:** `feature/yosefosama-customer-gui`

---

### TarekSaeed (252382) — Staff Dashboard + Staff Update + Accounts View
**Original Tasks (Keep):**
1. 🟡 P1: `StaffDashboard.java` (45 min) — Teller operations interface
2. 🟡 P1: `UpdateStaffDialog.java` (25 min) — Edit staff fields → staff.csv

**New Task (Added for balance):**
3. 🟡 P1: `ViewAccountsDialog.java` (25 min) — View all customer accounts (for Staff/Admin)

**Exception:** `StaffUpdateException.java` — Throw on invalid phone/job

**File I/O:** staff.csv (read + update), accounts.csv (read)

**Branch:** `feature/tareksaeed-staff-gui`

---

### YousifHafez (258612) — Customer Features + Account Delete
**Original Tasks (Keep):**
1. 🟡 P1: `TransactionDialog.java` (30 min) — Deposit/Withdraw (Transfer moved to YosefOsama)
2. 🟡 P1: `CardManagementFrame.java` (40 min) — Issue/update card status
3. 🟡 P1: `DeleteAccountDialog.java` (20 min) — Admin deletes account (balance=0 check)

**Removed for balance:**
- ❌ `PayBillsFrame.java` (removed — Yousif already has 3 GUIs)

**Exception:** `AccountDeletionException.java` — Throw if balance > 0

**File I/O:** accounts.csv (read + delete), transactions.csv (read + delete related), cards.csv (read + write)

**Branch:** `feature/yousifhafez-customer-gui`

---

## 📋 Summary Table

| Member | GUI Count | GUIs | Total Time | Exception | Files |
|--------|-----------|------|------------|-----------|-------|
| **YoussefAdel** | 4 | RegisterFrame✅, Toast✅, ViewReportsDialog✅, AdminDashboard | ~120 min | DataLoadException ✅ | users.csv, reports.csv |
| **YousefMohiey** | 4 | LoginFrame, AddStaffDialog, ViewStaffListDialog, AdminActionLogger | ~115 min | StaffCreationException | users.csv, staff.csv |
| **AbdelrahmanMazen** | 1 | ViewTransactionHistoryDialog (P2 - optional) | ~25 min | — | transactions.csv |
| **YosefOsama** | 3 | CustomerDashboard, RemoveStaffDialog, TransferMoneyDialog | ~95 min | StaffNotFoundException | accounts.csv, staff.csv, transactions.csv |
| **TarekSaeed** | 3 | StaffDashboard, UpdateStaffDialog, ViewAccountsDialog | ~95 min | StaffUpdateException | staff.csv, accounts.csv |
| **YousifHafez** | 3 | TransactionDialog, CardManagementFrame, DeleteAccountDialog | ~90 min | AccountDeletionException | accounts.csv, transactions.csv, cards.csv |

**Total: 18 GUIs, ~545 min (~9 hours) — Abdelrahman has minimal scope**

---

## 🗓️ Execution Timeline — ONE DAY SPRINT

**Total Time:** 6-7 hours (with breaks)  
**Start Time:** 9:00 AM  
**Target Finish:** 4:00 PM (with buffer)

### Session 1: Core Foundation (9:00 AM - 11:00 AM) — 2 hours

**Parallel Work (Everyone starts):**

| Person | Task | Duration | Done Criteria |
|--------|------|----------|---------------|
| **YoussefAdel** | `RegisterFrame.java` + `Toast.java` | 90 min | Registration works, Toast shows messages |
| **YousefMohiey** | Fix `LoginFrame.java` → integrate BankSystem | 90 min | Login works with users.csv, 3-attempt limit |
| **AbdelrahmanMazen** | `AdminDashboard.java` | 45 min | 4 buttons display, open dialogs |
| **AbdelrahmanMazen** | `GenerateReportDialog.java` | 45 min | Shows reports.csv in JTable |
| **YosefOsama** | `CustomerDashboard.java` | 90 min | Shows balance, 5 buttons work |
| **TarekSaeed** | `StaffDashboard.java` | 90 min | Shows tasks, logout works |
| **YousifHafez** | `TransactionDialog.java` | 90 min | Deposit/Withdraw execute |

**11:00 AM — Sync #1 (15 min)**
- Each person: "Done X, starting Y"
- Blockers? → Team solves immediately
- Merge first PRs (YoussefAdel, YousefMohiey, Abdelrahman)

---

### Session 2: Admin + Staff Features (11:15 AM - 1:15 PM) — 2 hours

| Person | Task | Duration | Done Criteria |
|--------|------|----------|---------------|
| **YoussefAdel** | `ViewReportsDialog.java` | 45 min | Reads reports.csv, displays table |
| **YoussefAdel** | Create `Staff.java` model | 45 min | Extends User, has jobTitle field |
| **YousefMohiey** | `AddStaffDialog.java` | 45 min | Form writes to staff.csv |
| **YousefMohiey** | `ViewStaffListDialog.java` | 45 min | Shows all staff in table |
| **YousefMohiey** | `StaffCreationException.java` | 15 min | Thrown on duplicate email |
| **YosefOsama** | `RemoveStaffDialog.java` | 45 min | Search + delete from staff.csv |
| **YosefOsama** | `StaffNotFoundException.java` | 15 min | Thrown when not found |
| **TarekSaeed** | `UpdateStaffDialog.java` | 60 min | Edit fields → save to staff.csv |
| **TarekSaeed** | `StaffUpdateException.java` | 15 min | Thrown on invalid input |
| **YousifHafez** | `CardManagementFrame.java` | 90 min | Issue card, update status |
| **YousifHafez** | Create `Card.java` model | 30 min | Card fields + cards.csv format |

**1:15 PM — Lunch Break (30 min)**

---

### Session 3: Customer Features + Exceptions (1:45 PM - 3:15 PM) — 90 min

| Person | Task | Duration | Done Criteria |
|--------|------|----------|---------------|
| **YoussefAdel** | Review PRs + merge | 30 min | All merged, conflicts resolved |
| **YoussefAdel** | Fix integration issues | 60 min | Help teammates with File I/O |
| **YousefMohiey** | Test auth flow end-to-end | 30 min | Register → Login → Dashboard |
| **YousefMohiey** | Help Abdelrahman integrate | 60 min | AdminDashboard opens AddStaffDialog |
| **AbdelrahmanMazen** | `ViewTransactionHistoryDialog.java` | 60 min | Filterable transactions table |
| **AbdelrahmanMazen** | `AdminActionException.java` | 30 min | Thrown on invalid action |
| **YosefOsama** | `TransferMoneyDialog.java` | 60 min | Transfer between accounts |
| **YosefOsama** | Test with YousifHafez | 30 min | Transfer updates transactions.csv |
| **TarekSaeed** | `ViewAccountsDialog.java` | 60 min | Show all accounts in table |
| **TarekSaeed** | Test staff flow | 30 min | Update → Verify staff.csv |
| **YousifHafez** | `DeleteAccountDialog.java` | 60 min | Validate balance=0, delete |
| **YousifHafez** | `AccountDeletionException.java` | 30 min | Thrown if balance > 0 |

---

### Session 4: Full Integration Testing (3:15 PM - 4:00 PM) — 45 min

**All Team Members Together:**

```bash
# 1. Pull latest main
git pull origin main

# 2. Compile everything
javac -d out src/**/*.java

# 3. Run full flow test
java -cp out Main
```

**Test Script (Run in Order):**

1. **Register New User** (YoussefAdel)
   - Register → Exit → Restart → Verify loads

2. **Login Flow** (YousefMohiey)
   - Login with new user → Verify role menu
   - Try 3 wrong passwords → Verify exit

3. **Admin Flow** (AbdelrahmanMazen)
   - Login as Admin → Add Staff → Generate Report
   - Verify staff.csv + reports.csv

4. **Staff Flow** (TarekSaeed)
   - Login as Staff → Update Staff → View Accounts
   - Verify staff.csv updates

5. **Customer Flow** (YosefOsama + YousifHafez)
   - Login as Customer → Deposit → Withdraw → Transfer
   - Manage Card → Delete Account (if balance=0)
   - Verify accounts.csv + transactions.csv + cards.csv

**4:00 PM — Final Sync (15 min)**
- ✅ All 18 GUIs compile
- ✅ All 6 CSV files work
- ✅ All 6 exceptions used
- ✅ Integration test passes
- ✅ All PRs merged

**DONE! 🎉**

---

### Critical Path (Must Finish On Time)

**Bottleneck:** `Staff.java` model (YoussefAdel must finish by 11:00 AM)  
**Why:** Blocks AddStaffDialog, RemoveStaffDialog, UpdateStaffDialog, ViewStaffListDialog

**Contingency:**
- If Staff.java late → YoussefAdel pairs with YousefMohiey
- If Card.java late → YousifHafez uses placeholder, adds later
- If integration fails → YoussefAdel leads debugging, others document

---

### Work Distribution Summary

| Person | GUIs | Exceptions | Models | Total Time |
|--------|------|------------|--------|------------|
| **YoussefAdel** | 3 | DataLoadException ✅ | Staff.java | 6.5 hrs |
| **YousefMohiey** | 3 | StaffCreationException | — | 6 hrs |
| **AbdelrahmanMazen** | 3 | AdminActionException | — | 6 hrs |
| **YosefOsama** | 3 | StaffNotFoundException | — | 6 hrs |
| **TarekSaeed** | 3 | StaffUpdateException | — | 6 hrs |
| **YousifHafez** | 3 | AccountDeletionException | Card.java | 6.5 hrs |

**Average:** 6 hours per person (including breaks + buffer)

---

## 📁 File Contracts (Final)

### users.csv
```
id,name,email,password,phone,role,createdAt
U1234567890,Youssef Adel,youssef@test.com,pass123,010...,StandardClient,2026-04-22
```

### staff.csv
```
id,name,email,password,phone,role,jobTitle,createdAt,status
S001,John Staff,john@test.com,pass456,011...,Staff,Teller,2026-04-22,ACTIVE
```

### accounts.csv
```
accountId,ownerId,accountType,balance,createdAt,status
ACC001,U1234567890,Savings,1000.00,2026-04-22,ACTIVE
```

### transactions.csv
```
txId,accountId,type,amount,timestamp,description
TX001,ACC001,DEPOSIT,500.00,2026-04-22T10:30,Initial deposit
```

### reports.csv
```
timestamp,adminId,actionType,details
2026-04-22T11:00,ADMIN001,REPORT_GENERATED,Transaction summary Q1
```

### cards.csv (new — YousifHafez)
```
cardId,accountId,cardNumber,status,expiryDate,issueDate
CARD001,ACC001,4111********1234,ACTIVE,2028-04,2026-04-22
```

---

## 🧪 Testing Protocol (Run in Order)

### 1. File I/O Test (YoussefAdel leads)
```bash
java -cp out Main
# Register new user → Exit → Restart → Verify user loads
```

### 2. Auth Test (YousefMohiey leads)
```bash
# Login with registered user → Verify role-based menu loads
# Try 3 wrong passwords → Verify exit
```

### 3. Admin Flow Test (AbdelrahmanMazen leads)
```bash
# Login as Admin → Click Add Staff → Fill form → Save
# Verify staff.csv has new entry
# Click Generate Report → Verify table shows data
```

### 4. Staff Flow Test (TarekSaeed leads)
```bash
# Login as Staff → View dashboard → Update staff info → Save
# Verify staff.csv updated
```

### 5. Customer Flow Test (YosefOsama + YousifHafez lead)
```bash
# Login as Customer → View balance → Deposit → Withdraw → Transfer
# Verify accounts.csv + transactions.csv update
# Manage card → Verify cards.csv updates
```

### 6. Full Integration (All)
```bash
# All teammates run together
# Test cross-component flows
# Verify no CSV corruption
```

---

## 🤝 Handoff Matrix

| From | To | What |
|------|-----|------|
| YoussefAdel | All | CSVHelper methods, File I/O patterns |
| YousefMohiey | Abdelrahman | LoginFrame → AdminDashboard integration |
| YousefMohiey | Tarek | AddStaffDialog → staff.csv format |
| Abdelrahman | All | AdminDashboard as hub for admin dialogs |
| YosefOsama | Yousif | CustomerDashboard → TransactionDialog integration |
| TarekSaeed | YosefOsama | UpdateStaffDialog → RemoveStaffDialog coordination |
| YousifHafez | YoussefAdel | cards.csv format for File I/O |

---

## ⚠️ Risk Mitigation — ONE DAY SPRINT

### Risk 1: Staff Model Delayed (CRITICAL)
**Impact:** Blocks 4 teammates (YousefMohiey, YosefOsama, TarekSaeed, Abdelrahman)  
**Owner:** YoussefAdel  
**Mitigation:** Must finish by 11:00 AM (Session 1 end)  
**Contingency:** If late → pair with YousefMohiey, skip Toast.java temporarily

### Risk 2: Card Model Delayed
**Impact:** Blocks CardManagementFrame  
**Owner:** YousifHafez  
**Mitigation:** Create minimal Card.java by 1:45 PM (Session 3 start)  
**Contingency:** Use hardcoded data first, add File I/O later

### Risk 3: Integration Conflicts
**Impact:** Wastes 30+ min if not caught early  
**Owner:** YoussefAdel  
**Mitigation:** Merge PRs every hour, not at end  
**Contingency:** 3:15-4:00 PM reserved for conflict resolution

### Risk 4: Person Falls Behind
**Impact:** Chain reaction on teammates  
**Mitigation:** 
- 10:30 AM check-in → "On track or blocked?"
- 12:30 PM check-in → "What's remaining?"
- 2:30 PM check-in → "Can you finish by 4 PM?"
**Contingency:** Faster members help slower members (pair programming)

### Risk 5: Compilation Errors
**Impact:** Can't test integration  
**Owner:** Each person tests their own code before PR  
**Mitigation:** `javac -d out src/yourfiles/*.java` before pushing  
**Contingency:** YoussefAdel leads debugging session at 3:15 PM

---

## ✅ Grade Checklist (100% Coverage)

### GUI (40%)
- [ ] 18 GUI components created
- [ ] All components compile
- [ ] All buttons/dialogs functional
- [ ] Role-based routing works (Admin/Staff/Customer)

### File I/O (30%)
- [ ] users.csv read/write works
- [ ] staff.csv read/write works
- [ ] accounts.csv read/write works
- [ ] transactions.csv read/write works
- [ ] reports.csv append works
- [ ] cards.csv read/write works
- [ ] Data persists across restarts

### Exceptions (30%)
- [ ] DataLoadException ✅ (YoussefAdel)
- [ ] StaffCreationException (YousefMohiey)
- [ ] StaffNotFoundException (YosefOsama)
- [ ] StaffUpdateException (TarekSaeed)
- [ ] AdminActionException (AbdelrahmanMazen)
- [ ] AccountDeletionException (YousifHafez)
- [ ] All exceptions thrown + caught correctly

---

## 📞 Communication Protocol — ONE DAY SPRINT

### In-Person / Discord Voice (Recommended for Speed)

**Stay on voice call entire session** for:
- Instant help when stuck
- Screen share for debugging
- Quick decisions without typing

### Check-In Schedule

| Time | Check-In Type | Duration | What to Report |
|------|---------------|----------|----------------|
| 9:00 AM | Kickoff | 5 min | "Ready, branch created" |
| 10:30 AM | Progress | 5 min | "Done X, starting Y" or "Blocked on Z" |
| 11:00 AM | Sync #1 | 15 min | Merge first PRs, solve blockers |
| 12:30 PM | Progress | 5 min | "On track for lunch?" |
| 1:45 PM | Sync #2 | 10 min | Merge Session 2 PRs |
| 2:30 PM | Progress | 5 min | "Can finish by 4 PM?" |
| 3:15 PM | Integration Start | 5 min | "Ready for group test?" |
| 4:00 PM | Final Sync | 15 min | Celebrate + document |

### Blocker Protocol
**Stuck >10 min?** → Immediately:
1. Post error in Discord + screenshot
2. Screen share if on voice
3. Team member jumps in to pair
4. If not solved in 10 more min → skip, come back later

### PR Rules (Speed Mode)
- **Create PR as soon as first GUI compiles** (don't wait for all 3)
- **Review within 15 min** of notification
- **Test locally** → Approve → Merge immediately
- **Delete branch** after merge

---

## 🎯 Success Criteria

**Phase 2 Complete When:**
1. All 18 GUIs compile + run
2. All 6 CSV files read/write correctly
3. All 6 exceptions used in code
4. Full integration test passes
5. All PRs merged to main
6. `result.json` + `report.md` created

**Expected Time:** 6-7 hours total (one day sprint)  
**Start:** 9:00 AM → **Finish:** 4:00 PM (with breaks + buffer)

---

**Let's build this! 🚀**

Start with your P0 task first. If stuck >10 min, message team on Discord.
