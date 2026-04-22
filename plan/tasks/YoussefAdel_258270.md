# YoussefAdel (258270) - Phase 2 Tasks (Updated)

**Role:** System Core + Registration + Admin Dashboard  
**Student ID:** 258270  
**Status:** ✅ Core Done | 🟡 GUI In Progress

---

## ✅ Already Done (Non-GUI)
- File I/O engine (`BankSystem.saveAllData()/loadAllData()`)
- `CSVHelper.java` utility
- `DataLoadException.java`
- Interactive console menu in `Main.java`
- Data persistence to `data/*.csv`

---

## 📋 Your GUI Tasks (4 Total - NetBeans Format)

### 1. RegisterFrame.java ✅ DONE
**File:** `src/gui/auth/RegisterFrame.java` + `.form`  
**Time:** 45 min  
**Status:** ✅ Complete + Tested

**What it does:**
- Registration form with 5 fields (Name, Email, Phone, Password, Confirm)
- Validation (email format, password match, min 6 chars)
- Writes to `users.csv` via `bank.addUser()` + `bank.saveAllData()`
- Uses Toast for notifications

**NetBeans:** Open in NetBeans → Design tab works → Can drag-drop

---

### 2. Toast.java ✅ DONE
**File:** `src/gui/util/Toast.java`  
**Time:** 20 min  
**Status:** ✅ Complete

**What it does:**
- `showSuccess()` - Green toast (2.5 sec auto-close)
- `showError()` - Red toast
- `showInfo()` - Blue toast
- `showConfirm()` - Confirmation dialog
- Reusable by ALL teammates

---

### 3. ViewReportsDialog.java ✅ DONE
**File:** `src/gui/admin/ViewReportsDialog.java` + `.form`  
**Time:** 25 min  
**Status:** ✅ Complete

**What it does:**
- Reads `data/reports.csv`
- Displays in JTable (4 columns: Timestamp, AdminID, Action, Details)
- Refresh + Close buttons
- Handles missing file gracefully

**NetBeans:** Open in NetBeans → Design tab works

---

### 4. AdminDashboard.java (NEW - took from Abdelrahman)
**File:** `src/gui/admin/AdminDashboard.java` + `.form`  
**Time:** 30 min  
**Status:** ⏳ TODO

**What it does:**
- Main admin menu window
- 4 buttons: Add Staff, Remove Staff, Update Staff, Generate Report
- Opens respective dialogs (created by teammates)
- Logs admin actions to `reports.csv`

**Starter Code (NetBeans Format):**
```java
// Will create with NetBeans GUI Builder
// Buttons open: AddStaffDialog, RemoveStaffDialog, UpdateStaffDialog, ViewReportsDialog
```

---

## 📁 File I/O (Your 30%)
- ✅ `users.csv` - Write (registration)
- ✅ `reports.csv` - Read+Write (admin actions log)
- ✅ `DataLoadException.java` - Already created

---

## 🧪 Testing
```bash
# Compile all
javac -d out $(find src -name "*.java" -type f)

# Test your GUIs
java -cp out gui.YoussefAdelGUITest
```

---

## ✅ Submission Checklist
- [x] RegisterFrame.java - compiles, opens, registers users ✅
- [x] Toast.java - showSuccess/showError work ✅
- [x] ViewReportsDialog.java - displays reports.csv ✅
- [ ] AdminDashboard.java - 4 buttons open dialogs
- [x] All files have NetBeans `.form` companion
- [x] Code has `@author Youssef Adel 258270`
- [ ] Pushed to `feature/youssefadel-registration-gui`

---

## 🤝 Team Handoff
**You provide:**
- Toast.java → All teammates use for notifications
- RegisterFrame → YousefMohiey integrates with LoginFrame
- AdminDashboard → Opens dialogs from YousefMohiey, YosefOsama, TarekSaeed

**You receive:**
- LoginFrame from YousefMohiey (to test admin login flow)
- Staff dialogs from teammates (to integrate into AdminDashboard)

---

**Message when done:**
> "✅ YoussefAdel GUI done: RegisterFrame, Toast, ViewReportsDialog, AdminDashboard.
>  All NetBeans format with .form files. Toast ready for team use."
