# 🎯 Youssef Adel (258270) - Phase 2 Tasks

**Focus**: System Core + File I/O + Project Coordination

---

## 📋 Priority Tasks

### 1. File Persistence Engine ⚡
```java
// TODO: Implement in BankSystem.java
public void saveAllData() {
    saveUsersToFile("data/users.csv");
    saveAccountsToFile("data/accounts.csv");
    saveTransactionsToFile("data/transactions.csv");
}

public void loadAllData() {
    loadUsersFromFile("data/users.csv");
    loadAccountsFromFile("data/accounts.csv");
    loadTransactionsFromFile("data/transactions.csv");
}
```
- [ ] Create `data/` folder structure
- [ ] Implement CSV parsers for User/Account/Transaction
- [ ] Handle file not found → create new empty files
- [ ] Test: Add data → restart app → data still there 💾

### 2. Remove Hard-Coded Data 🧹
- [ ] Delete all test data from `Main.java`
- [ ] Replace with `loadAllData()` call on startup
- [ ] Ensure `saveAllData()` called on exit/critical changes

### 3. Interactive Main Menu Loop 🔄
```java
// TODO: Replace static menu with interactive loop
while (currentUser != null) {
    displayMenuForRole(currentUser);
    int choice = getUserInput();
    handleChoice(choice); // switch-case
}
```
- [ ] Use `Scanner` for user input
- [ ] Implement `switch` for menu options
- [ ] Add "Logout" and "Exit" options

### 4. Custom Exception for File I/O 🚨
```java
// TODO: Create exceptions/DataLoadException.java
public class DataLoadException extends Exception {
    public DataLoadException(String file, String reason) {
        super("Failed to load " + file + ": " + reason);
    }
}
// Use in loadAllData() with try/catch
```
- [ ] Create 1 custom exception for file operations
- [ ] Wrap file read/write in try/catch blocks
- [ ] Show user-friendly error messages

### 5. Coordinate Team 🤝
- [ ] Merge PRs from teammates
- [ ] Resolve conflicts in `BankSystem.java`
- [ ] Run full test suite before submission

---

## ✅ Testing Checklist
- [ ] App starts → loads existing data from files
- [ ] Add new user → restart → user persists
- [ ] Menu is interactive (not hard-coded print statements)
- [ ] Logout works → returns to login screen
- [ ] No console errors on file operations

---

## 📚 Resources
- [Java File I/O Tutorial](https://www.youtube.com/watch?v=ue06TSYXJpY) 🎥
- [CSV Parsing in Java](https://www.youtube.com/watch?v=8LX5TqLcXbE) 🎥
- [Swing Basics](https://www.youtube.com/watch?v=KmgnH8Tca4Q) 🎥

---

> 💡 **Pro Tip**: Start with file I/O first — everything else depends on data persistence! 😼
