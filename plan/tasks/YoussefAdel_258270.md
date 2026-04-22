# Youssef Adel (258270) - Phase 2 Tasks ✅ COMPLETE

**Role:** System Core + File I/O + Registration GUI + Admin Dashboard  
**Student ID:** 258270  
**Status:** ✅ COMPLETE - Ready to Merge

---

## ✅ Completed Tasks

### 1. File Persistence Engine (.ser) ✅
**File:** `src/manager/BankSystem.java`
```java
public void saveAllData()  // Saves to .ser files using serialization
public void loadAllData()  // Loads from .ser files
```
- [x] Create `data/` folder structure ✅
- [x] Implement serialization for User/Account/Transaction ✅
- [x] Handle file not found → create new empty files ✅
- [x] Test: Add data → restart app → data still there ✅

**Files Created:**
- `data/users.ser` ✅
- `data/accounts.ser` ✅
- `data/transactions.ser` ✅

---

### 2. Remove Hard-Coded Data ✅
- [x] Delete all test data from `Main.java` ✅
- [x] Replace with `loadAllData()` call on startup ✅
- [x] Ensure `saveAllData()` called on exit/critical changes ✅

---

### 3. Interactive Main Menu Loop ✅
**File:** `src/Main.java`
- [x] Use `Scanner` for user input ✅
- [x] Implement `switch` for menu options ✅
- [x] Add "Logout" and "Exit" options ✅

---

### 4. Custom Exception for File I/O ✅
**File:** `src/exceptions/DataLoadException.java`
```java
public class DataLoadException extends Exception {
    public DataLoadException(String file, String operation, Throwable cause)
    public String getUserMessage()
}
```
- [x] Create 1 custom exception for file operations ✅
- [x] Wrap file read/write in try/catch blocks ✅
- [x] Show user-friendly error messages ✅

---

### 5. GUI Components (NetBeans Format) ✅

#### RegisterFrame.java ✅
**File:** `src/gui/auth/RegisterFrame.java` + `.form`
- Registration form with 5 fields
- Validation (email, password match, min length)
- Writes to `users.ser` via `bank.addUser()` + `bank.saveAllData()`
- Uses Toast for notifications

#### Toast.java ✅
**File:** `src/gui/util/Toast.java`
- `showSuccess()` - Green toast
- `showError()` - Red toast
- `showInfo()` - Blue toast
- Reusable by ALL teammates

#### ViewReportsDialog.java ✅
**File:** `src/gui/admin/ViewReportsDialog.java` + `.form`
- Reads `reports.ser` (if exists)
- Displays in JTable
- Refresh + Close buttons

#### AdminDashboard.java ✅
**File:** `src/gui/admin/AdminDashboard.java` + `.form`
- Main admin menu with 5 buttons
- Opens respective dialogs
- Welcome message with admin name

---

### 6. Serialization Support ✅
**All model classes implement `Serializable`:**
- `User.java` + all subclasses (Admin, Client, StandardClient, etc.) ✅
- `Account.java` + all subclasses (SavingsAccount, CurrentAccount, etc.) ✅
- `Transaction.java` + all subclasses (Deposit, Withdrawal, Transfer) ✅

---

## ✅ Testing Checklist
- [x] App starts → loads existing data from .ser files ✅
- [x] Add new user → restart → user persists ✅
- [x] Menu is interactive (not hard-coded print statements) ✅
- [x] Logout works → returns to login screen ✅
- [x] No console errors on file operations ✅
- [x] All 4 GUIs compile and open ✅
- [x] NetBeans Design tab works for all GUIs ✅

---

## 📁 File I/O Format (.ser)

**Using Java Serialization:**
```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/users.ser"));
oos.writeObject(users);  // Save entire ArrayList

ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/users.ser"));
ArrayList<User> users = (ArrayList<User>) ois.readObject();  // Load back
```

**All data stored in binary .ser files:**
- `users.ser` - ArrayList<User>
- `accounts.ser` - ArrayList<Account>
- `transactions.ser` - ArrayList<Transaction>

---

## 🤝 Team Coordination
- [x] Merge PRs from teammates ⏳ Pending
- [ ] Resolve conflicts in `BankSystem.java` ⏳ If any
- [x] Run full test suite before submission ✅

---

## ✅ Grade Checklist

| Requirement | Status | Evidence |
|-------------|--------|----------|
| **GUI (40%)** | ✅ | 4 GUIs: RegisterFrame, AdminDashboard, ViewReportsDialog, Toast |
| **File I/O (30%)** | ✅ | .ser files, BankSystem.saveAllData()/loadAllData(), all models Serializable |
| **Exceptions (30%)** | ✅ | DataLoadException thrown/caught in File I/O |

---

## 🚀 Next Steps
1. Push to branch: `feature/youssefadel-gui`
2. Create PR on GitHub
3. Notify team to review
4. Merge to main
5. Help teammates integrate

---

**Last Updated:** April 22, 2026  
**Compiled:** ✅ Success  
**Ready for Merge:** ✅ Yes

> 🎯 **All Phase 2 requirements complete!**
