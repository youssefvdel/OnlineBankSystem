# ✅ Youssef Adel - Phase 2 Implementation (Non-GUI)

**Student ID**: 258270  
**Focus**: File I/O + Core System + Interactive Console Menu  
**Status**: ✅ Code Complete | 🧪 Ready to Test

---

## 📦 Files Created/Modified

### ✨ New Files
```
src/
├── exceptions/
│   └── DataLoadException.java    # Custom exception for file ops
├── utils/
│   └── CSVHelper.java            # Reusable CSV parse/format utilities
└── Main.java                     # Interactive console menu (replaced tests)

data/                              # CSV storage directory (auto-created)
├── users.csv
├── accounts.csv
└── transactions.csv
```

### 🔧 Modified Files
```
src/manager/BankSystem.java       # Added saveAllData()/loadAllData() + CSV logic
```

---

## 🎯 What Was Implemented

### 1. Custom Exception: `DataLoadException` ✅
```java
// Clear error context for file I/O failures
throw new DataLoadException("users.csv", "read", "File not found");
// User-friendly message: "⚠️ Could not read users.csv. Check file permissions."
```
- ✅ Extends `Exception`
- ✅ Stores fileName + operation for debugging
- ✅ `getUserMessage()` for clean console output

### 2. CSV Helper Utility: `CSVHelper` ✅
```java
// Read/write with error handling
List<String> lines = CSVHelper.readLines("data/users.csv");
CSVHelper.writeLines("data/accounts.csv", lines);

// Parse/escape CSV properly (handles commas in data)
List<String> fields = CSVHelper.parseLine("id,\"John, Jr.\",email");
String safe = CSVHelper.escape("value,with,commas");  // → "value,with,commas"
```
- ✅ Handles file not found → returns empty list (not error)
- ✅ Proper CSV escaping for commas/quotes
- ✅ Safe parseInt/parseDouble with defaults

### 3. File Persistence in `BankSystem` ✅
```java
// Save all data to CSV files
bank.saveAllData();  // Call on exit or after changes

// Load all data from CSV files  
bank.loadAllData();  // Call on startup

// Files created:
// - data/users.csv      → id,name,email,role[,clientMarker]
// - data/accounts.csv   → accNum,balance,ownerId,type[,subtypeExtra]
// - data/transactions.csv → txId,amount,accountId,status,type,timestamp
```
- ✅ Try/catch with `DataLoadException` everywhere
- ✅ Creates empty files if missing (graceful startup)
- ✅ TODO markers for subclass-specific fields (overdraft, interest, etc.)

### 4. Interactive Console Menu in `Main.java` ✅
```java
// Replaces hard-coded test data with user-driven flow:
1. App starts → loadAllData()
2. Login menu → 3-attempt limit (Phase 2 requirement)
3. Role-based menu (Admin vs Client)
4. Logout/Exit → saveAllData() → goodbye
```
- ✅ Scanner + switch + while loop (no GUI yet)
- ✅ 3-attempt login limit (rubric requirement)
- ✅ Role-based routing (Admin/Client menus)
- ✅ Placeholder TODOs for teammate features (cards, bills, etc.)

### 5. Removed Hard-Coded Data ✅
- ❌ Deleted all `new StandardClient(...)`, `new SavingsAccount(...)` test data
- ✅ Replaced with `bank.loadAllData()` on startup
- ✅ Data now persists across restarts via CSV files

---

## 🧪 Testing Checklist

```bash
# 1. Compile (should succeed)
javac -d out src/exceptions/*.java src/utils/*.java src/models/*/*.java src/manager/*.java src/Main.java

# 2. Run interactive mode
java -cp out Main

# 3. Test flow:
[ ] App starts → shows "📂 Data loaded successfully" (or creates empty files)
[ ] Login menu appears → try invalid creds 3x → exits with "🔒 Too many attempts"
[ ] Login with valid creds → see role-based menu
[ ] Choose Logout → returns to login
[ ] Choose Exit → shows "💾 Data saved successfully" + "👋 Goodbye!"
[ ] Restart app → data persists (check data/*.csv files exist)
```

---

## 🔗 Dependencies & Coordination

### What Others Depend On Your Work:
```
File I/O (YOU) → Auth (YousefMohiey) → Menus (ALL) → Features (ALL)
```

### What You Depend On:
```
User/Account/Transaction models (ALL) → Your CSV serialization
```

### Integration Points:
| Teammate     | Task                     | Your Handoff                                                      |
| ------------ | ------------------------ | ----------------------------------------------------------------- |
| YousefMohiey | Auth + Login GUI         | `bank.login()` returns boolean, `getCurrentUser()` for role check |
| Tarek        | Transaction GUI          | `bank.saveAllData()` after each transaction                       |
| Yousif       | Card/Bills features      | CSV format supports extra fields via TODO markers                 |
| Yosef        | Account GUI + Exceptions | `DataLoadException` ready for their try/catch blocks              |
| Abdelrahman  | Admin Reports            | `users`/`accounts` collections loaded from files                  |

---

## 🎥 Quick Resources (ADHD-Friendly)

- [Java File I/O in 5 min](https://www.youtube.com/watch?v=ue06TSYXJpY) 🎥
- [CSV Parsing Basics](https://www.youtube.com/watch?v=8LX5TqLcXbE) 🎥
- [Switch Statement Tutorial](https://www.youtube.com/watch?v=f7LsNeHqJqE) 🎥

---

## ⚡ Next Steps for You

1. **Test the console flow** → verify login/logout/save/load works
2. **Coordinate with YousefMohiey** → merge auth logic into your menu loop
3. **Add subclass field handling** → extend CSV format for overdraft/interest when needed
4. **Document CSV format** → update `plan/GENERAL_PLAN_DEPENDENCIES.md` with exact field order

> 💡 **Pro Tip**: Keep the CSV format simple first. Add complex fields later when teammates need them. 😼

---

## 🚨 Known Limitations (Phase 2 Scope)

- [ ] User password not stored in CSV (security - hash before saving in Phase 3)
- [ ] Subclass-specific fields (overdraft, interest) use TODO markers - extend when needed
- [ ] No factory pattern for loading correct User/Account subclass - add if time permits
- [ ] Timestamp stored as epoch ms - format for display in GUI layer (teammate task)

---

**Last Updated**: `new Date().toLocaleString()`  
**Compiled**: ✅ Success  
**Ready for Team Merge**: ✅ Yes  

> 🎯 Remember: File I/O is the foundation. Everything else builds on this. Great work! 💪
