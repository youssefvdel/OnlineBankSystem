# Phase 2 GUI Tasks - Team Assignment

## Overview

| Total GUI Components | 12 frames/dialogs |
|---------------------|-------------------|
| Estimated Time | 8-10 hours total |
| Deadline | Week 11 |
| Grade Weight | GUI 10% + Auth 10% + Files 30% + Exceptions 30% |

---

##  Priority 1: Core System (Week 1-2)

### 1. LoginFrame.java
| Owner | YousefMohiey (Auth Owner) |
|-------|---------------------------|
| Time | 45 min |
| Dependencies | None - START HERE |
| Connects To | `bank.authenticateUser()` |

**Fields:**
- Username (JTextField)
- Password (JPasswordField)
- Login Button
- Register Button → opens RegisterFrame
- Exit Button

**Done Criteria:**
- [ ] Validates against users.csv
- [ ] 3 failed attempts → exit program
- [ ] Successful login → opens role-specific menu
- [ ] "Remember Me" checkbox (optional)

---

### 2. RegisterFrame.java
| Owner | YoussefAdel (File I/O Owner) |
|-------|------------------------------|
| Time | 45 min |
| Dependencies | CSVHelper.saveUser() |
| Connects To | `bank.registerUser()` |

**Fields:**
- Full Name (JTextField)
- Email (JTextField)
- Password (JPasswordField)
- Phone (JTextField)
- Initial Deposit (JNumberField)
- Submit Button
- Back to Login Button

**Done Criteria:**
- [ ] Generates unique user ID
- [ ] Writes to users.csv
- [ ] Shows success Toast
- [ ] Returns to LoginFrame on success

---

### 3. MainRouter.java
| Owner | YoussefAdel + YousefMohiey |
|-------|---------------------------|
| Time | 30 min |
| Dependencies | LoginFrame, all menu frames |
| Connects To | User role detection |

**Logic:**
```
Login Success → Check Role → Open Menu
  Admin → AdminDashboardFrame
  Staff → StaffDashboardFrame  
  Customer → CustomerDashboardFrame
```

**Done Criteria:**
- [ ] Routes based on user type
- [ ] Handles logout → returns to LoginFrame
- [ ] Clean window transitions

---

##  Priority 2: Admin Features (Week 2-3)

### 4. AdminDashboardFrame.java
| Owner | AbdelrahmanMazen |
|-------|------------------|
| Time | 1.5 hours |
| Dependencies | LoginFrame, all admin dialogs |
| Connects To | Admin methods in BankSystem |

**Menu Items:**
- Manage Staff (Add/Remove/Update)
- View All Customers
- Delete Customer Account
- Generate Reports
- Logout

**Done Criteria:**
- [ ] Sidebar navigation or menu bar
- [ ] Each button opens respective dialog
- [ ] Clean layout (GridBagLayout)
- [ ] Logout button visible

---

### 5. AddStaffDialog.java
| Owner | AbdelrahmanMazen |
|-------|------------------|
| Time | 45 min |
| Dependencies | AdminDashboardFrame |
| Connects To | `admin.addStaff()` |

**Fields:**
- Name, ID, Age, Phone, Job Title, Temporary Password

**Done Criteria:**
- [ ] Validates all fields not empty
- [ ] Writes to staff.csv
- [ ] Shows success message

---

### 6. RemoveStaffDialog.java
| Owner | AbdelrahmanMazen |
|-------|------------------|
| Time | 30 min |
| Dependencies | AdminDashboardFrame |
| Connects To | `admin.removeStaff()` |

**Fields:**
- Search by ID or Name (JTextField)
- Results Table (JTable)
- Confirm Delete Button

**Done Criteria:**
- [ ] Search filters staff list
- [ ] Delete removes from staff.csv
- [ ] Confirmation dialog before delete

---

### 7. GenerateReportFrame.java
| Owner | AbdelrahmanMazen |
|-------|------------------|
| Time | 1 hour |
| Dependencies | Transaction data loaded |
| Connects To | `admin.generateReport()` |

**Features:**
- Date Range Picker (From/To)
- Report Type Dropdown (Transactions, Spending Trends, Account Summary)
- Export to PDF/CSV Button
- Preview Panel (JTextArea or JTable)

**Done Criteria:**
- [ ] Filters transactions by date
- [ ] Shows summary statistics
- [ ] Export button works

---

### 8. DeleteAccountDialog.java
| Owner | AbdelrahmanMazen |
|-------|------------------|
| Time | 30 min |
| Dependencies | AdminDashboardFrame |
| Connects To | `admin.deleteAccount()` |

**Fields:**
- Search Customer (by ID/Email)
- Show Account Details
- Confirm Delete (with warning)

**Done Criteria:**
- [ ] Searches users.csv + accounts.csv
- [ ] Shows balance before delete
- [ ] Note: "This action cannot be undone"

---

##  Priority 3: Customer Features (Week 3-4)

### 9. CustomerDashboardFrame.java
| Owner | YousifHafez + YosefOsama |
|-------|-------------------------|
| Time | 1 hour |
| Dependencies | LoginFrame, customer dialogs |
| Connects To | Customer account methods |

**Menu Items:**
- View Accounts
- Deposit
- Withdraw
- Transfer
- Pay Bills
- Card Management
- Transaction History
- Logout

**Done Criteria:**
- [ ] Shows welcome message with user name
- [ ] Account balance visible on dashboard
- [ ] All buttons open respective dialogs
- [ ] Logout works

---

### 10. TransactionDialog.java (Deposit/Withdraw/Transfer)
| Owner | YosefOsama |
|-------|------------|
| Time | 1 hour |
| Dependencies | CustomerDashboardFrame |
| Connects To | `account.deposit()`, `account.withdraw()`, `bank.transfer()` |

**Fields:**
- Amount (JNumberField)
- Target Account (for transfers only)
- Category Dropdown (optional)
- Confirm Button

**Done Criteria:**
- [ ] Validates amount > 0
- [ ] Checks sufficient balance (withdraw)
- [ ] Updates accounts.csv after transaction
- [ ] Shows success/error Toast

---

### 11. CardManagementFrame.java
| Owner | YousifHafez |
|-------|-------------|
| Time | 1 hour |
| Dependencies | CustomerDashboardFrame |
| Connects To | `customer.manageCard()` |

**Features:**
- Issue New Card Button
- Card Status Dropdown (Active/Inactive/Lost/Stuck)
- Update Status Button
- Card Details Display (masked number)

**Done Criteria:**
- [ ] Creates card record in cards.csv
- [ ] Status updates persist to file
- [ ] Shows card info (last 4 digits only)

---

### 12. PayBillsDialog.java
| Owner | YousifHafez |
|-------|-------------|
| Time | 45 min |
| Dependencies | CustomerDashboardFrame, CardManagementFrame |
| Connects To | `customer.payBills()` |

**Fields:**
- Bill Type Dropdown (Electricity/Water/Internet/Credit Card)
- Bill Amount (auto-fill or manual)
- Payment Method (Account/Card)
- Confirm Pay Button

**Done Criteria:**
- [ ] Deducts from account balance
- [ ] Creates transaction record
- [ ] Shows receipt after payment

---

### 13. TransactionHistoryFrame.java
| Owner | YosefOsama |
|-------|------------|
| Time | 45 min |
| Dependencies | Transaction data loaded |
| Connects To | `customer.viewTransactionHistory()` |

**Features:**
- Date Range Filter (From/To)
- Transaction Type Filter (All/Deposit/Withdraw/Transfer)
- JTable with columns: Date, Type, Amount, Balance After
- Export Button (optional)

**Done Criteria:**
- [ ] Loads from transactions.csv
- [ ] Filters work correctly
- [ ] Sorted by date (newest first)

---

##  Priority 4: Shared Utilities (Week 1 - Parallel)

### 14. Toast.java (Notification System)
| Owner | YoussefAdel |
|-------|-------------|
| Time | 20 min |
| Dependencies | None |
| Used By | ALL team members |

**Methods:**
```java
Toast.showSuccess(JFrame parent, String message)
Toast.showError(JFrame parent, String message)
Toast.showWarning(JFrame parent, String message)
```

**Done Criteria:**
- [ ] Custom styling (green/red/yellow)
- [ ] Auto-dismiss after 3 seconds
- [ ] Replaces all JOptionPane.showMessageDialog

---

### 15. StaffDashboardFrame.java
| Owner | TarekSaeed |
|-------|------------|
| Time | 1 hour |
| Dependencies | LoginFrame |
| Connects To | Staff methods |

**Menu Items:**
- Process Customer Transactions
- View Customer Accounts (read-only)
- Update Customer Info
- Logout

**Done Criteria:**
- [ ] Limited permissions vs Admin
- [ ] Cannot delete accounts
- [ ] Clean professional layout

---

##  Dependency Graph

```
Week 1                    Week 2                    Week 3-4
─────────────────────────────────────────────────────────────────
LoginFrame ──────→ MainRouter ──────→ AdminDashboardFrame
  ↓                                      ↓
RegisterFrame                            AddStaffDialog
  ↓                                      ↓
Toast (utility)                    RemoveStaffDialog
  ↓                                      ↓
CustomerDashboardFrame ──────→ GenerateReportFrame
  ↓                                      ↓
TransactionDialog                  DeleteAccountDialog
  ↓
CardManagementFrame
  ↓
PayBillsDialog
```

---

##  Grade Coverage Matrix

| Requirement | Who Covers It | Files Involved |
|-------------|---------------|----------------|
| **GUI (10%)** | ALL members | All Frame.java files |
| **Auth (10%)** | YousefMohiey | LoginFrame, users.csv |
| **Files (30%)** | YoussefAdel + ALL | All .csv files |
| **Exceptions (30%)** | ALL | Custom exceptions in each dialog |

---

##  Testing Protocol

**Before submitting, run this sequence:**

1. Start app → Register new user → Exit
2. Restart app → Login with new user → Verify data loads
3. Perform 3 transactions → Exit
4. Restart → Verify transactions persist
5. Login as Admin → Add Staff → Verify staff.csv
6. Login as Staff → Process transaction → Verify
7. Trigger error (wrong password 3x) → Verify exit
8. Trigger exception (insufficient funds) → Verify Toast error

---

##  Team Sync Rules

| Rule | Details |
|------|---------|
| **Branch Naming** | `feature/yourname-gui-component` |
| **Commit Messages** | `GUI: Add LoginFrame with validation` |
| **PR Required** | Yes - at least 1 teammate review |
| **Merge Conflicts** | Message team immediately on Discord |
| **Daily Check-in** | Post progress in group chat |

---

##  Quick Resources

| Topic | Video (5-10 min) |
|-------|------------------|
| JFrame Basics | [Java Swing JFrame Tutorial](https://youtu.be/a9rDw8l_8u8) |
| Layout Managers | [GridBagLayout Explained](https://youtu.be/7UqU-8zFjzE) |
| Event Handling | [Button Click Events](https://youtu.be/kNlXKIG0sPQ) |
| JTable | [Display Data in Table](https://youtu.be/9X6yqKz1zXU) |

---

##  Escalation Path

Stuck for >30 min? → Message team Discord → Pair program

**Final Deadline:** Week 11, 23:59 via e-Learning

**Submission Checklist:**
- [ ] All source code in zipped project folder
- [ ] PDF with class diagram + work division
- [ ] Coursework submission form (signed)
- [ ] Academic Honesty Form (signed)
- [ ] All team members present for oral presentation
