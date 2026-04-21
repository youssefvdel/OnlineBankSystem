# Online Banking System

**BUE - Programming in Java (25CSCI04C)**

---

## Project Overview

| Item            | Details                         |
| --------------- | ------------------------------- |
| **Course**      | 25CSCI04C - Programming in Java |
| **Phase**       | Phase 1 (Console-Based)         |
| **Team Number** | **40**                          |

This project is a comprehensive console-based banking system that demonstrates advanced object-oriented programming concepts in Java. The system provides core banking functionality including user authentication, account management, money transfers, and transaction history tracking.

---

## Team Members

|  #  | Member                | Student ID | Group | Responsibilities                                                                                                                                                   |
| :-: | --------------------- | ---------- | ----- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
|  1  | **Youssef Adel**      | `258270`   | A-13  | Account, BusinessAccount, CurrentAccount, BankSystem<br>GitHub Repository Management<br>Project Planning & Management<br>Class Diagram & OOP Logic Design |
|  2  | **Tarek Saeed**       | `252382`   | A-12  | Transaction, Deposit, Withdrawal, TransactionHistory, Transferable<br>Class Diagram & OOP Logic Design                                                             |
|  3  | **Yousif Hafez**      | `258612`   | A-13  | FirstClassClient, PremiumClient, StandardClient<br>Insurable and LoanEligible Interfaces<br>Class Diagram & OOP Logic <br>Word File                                                                         |
|  4  | **Yosef Osama**       | `255796`   | A-13  | SavingsAccount, PremiumAccount, Transfer <br>Class Diagram & OOP Logic                                                                                                                         |
|  5  | **Yousef Mohiey**     | `248679`   | A-13  | User, Admin, Client<br>Class Diagram & OOP Logic Design <br>Word File                                                                                                            |
|  6  | **Abdelrahman Mazen** | `251979`   | A-9   | Join WhatsApp Group                                                                                                                                                |

---

## Features (Phase 1)

- **User Authentication** - Login/Logout functionality for all user types
- **Account Management** - Create, view, add, and remove accounts
- **Transactions** - Deposit, withdraw, and transfer operations using transaction classes
- **Balance Inquiry** - Check account balance and total balance across all accounts
- **Transaction History** - View all transactions for an account with count and lookup
- **File Persistence** - Save and load data to files (placeholder for future implementation)
- **Multiple User Types** - StandardClient, PremiumClient, FirstClassClient, Admin
- **Multiple Account Types** - SavingsAccount, CurrentAccount, PremiumAccount, BusinessAccount
- **Special Features** - Interest calculation, overdraft facility, yearly fees, employee management

---

## Project Structure

```
OnlineBankSystem/
├── src/
│   ├── Main.java                          # Entry point and comprehensive testing (50+ tests)
│   ├── manager/
│   │   └── BankSystem.java                # Main system controller with Javadoc
│   └── models/
│       ├── user/                          # User hierarchy (6 classes)
│       │   ├── User.java                  # Abstract base class
│       │   ├── Client.java                # Abstract client class
│       │   ├── StandardClient.java        # Standard client with Insurable interface
│       │   ├── PremiumClient.java         # Premium client with LoanEligible interface
│       │   ├── FirstClassClient.java      # VIP client with priority services
│       │   └── Admin.java                 # Administrator with user management
│       ├── account/                       # Account hierarchy (5 classes)
│       │   ├── Account.java               # Abstract base account class
│       │   ├── SavingsAccount.java        # Savings with interest and minimum balance
│       │   ├── CurrentAccount.java        # Current with overdraft facility
│       │   ├── PremiumAccount.java        # Premium with higher limits and benefits
│       │   └── BusinessAccount.java       # Business with employee management
│       ├── transaction/                   # Transaction hierarchy (5 classes)
│       │   ├── Transaction.java           # Abstract base transaction class
│       │   ├── Deposit.java               # Deposit transaction
│       │   ├── Withdrawal.java            # Withdrawal transaction
│       │   ├── Transfer.java              # Transfer between accounts
│       │   └── TransactionHistory.java    # Transaction history management
│       └── interfaces/                    # 3 interfaces
│           ├── Transferable.java          # Money transfer capability
│           ├── Insurable.java             # Insurance claim capability
│           └── LoanEligible.java          # Loan application capability
├── out/                                   # Compiled class files
└── README.md                              # Project documentation
```

**Total: 21 Java source files**

---

## Class Diagram

### User Hierarchy

```
User (Abstract)
├── Client (Abstract)
│   ├── StandardClient       [implements Insurable]
│   ├── PremiumClient        [implements LoanEligible]
│   └── FirstClassClient
└── Admin
```

### Account Hierarchy

```
Account (Abstract) [implements Transferable]
├── SavingsAccount
├── CurrentAccount
├── PremiumAccount
└── BusinessAccount
```

### Transaction Hierarchy

```
Transaction (Abstract)
├── Deposit
├── Withdrawal
├── Transfer
└── TransactionHistory (Composition with Account)
```

### Interfaces

- **Transferable** - Enables money transfer functionality between accounts
- **Insurable** - Provides insurance-related capabilities (getInsurance, claimInsurable)
- **LoanEligible** - Determines loan eligibility (getLoanLimit, applyForLoan)

---

## OOP Concepts Applied

### Inheritance

- Multi-level inheritance in User hierarchy (User -> Client -> StandardClient/PremiumClient/FirstClassClient)
- Inheritance in Account hierarchy (Account -> SavingsAccount/CurrentAccount/PremiumAccount/BusinessAccount)
- Inheritance in Transaction hierarchy (Transaction -> Deposit/Withdrawal/Transfer)

### Polymorphism

- Method overriding in account types (withdraw, applyYearlyFee)
- Abstract methods implemented differently across subclasses
- Runtime polymorphism through parent class references
- Interface implementation (Insurable, LoanEligible, Transferable)

### Encapsulation

- Private attributes with public getters and setters
- Controlled access to sensitive banking operations
- Data hiding for user credentials and account balances

### Abstraction

- Abstract classes (User, Client, Account, Transaction)
- Interfaces defining contracts (Transferable, Insurable, LoanEligible)
- Abstract methods requiring implementation by subclasses

---

## Testing Scenario

The `Main.java` class includes **50+ comprehensive test cases** organized in **11 sections**:

### Section 1: Bank System Setup

- Create and initialize the banking system

### Section 2: User Types

- Create StandardClient, PremiumClient, FirstClassClient, Admin
- Test user-specific methods and benefits

### Section 3: Client Methods

- Add users to bank system
- Test getter/setter methods
- Test Insurable interface (claimInsurable, getInsurance)
- Admin createUser functionality

### Section 4: Account Types

- Create SavingsAccount, CurrentAccount, PremiumAccount, BusinessAccount
- Test account-specific methods (addInterest, getPremiumBenefits, generateReport)
- Business employee management (addEmployee, removeEmployee)

### Section 5: Transactions

- Deposit operations with validation
- Withdrawal operations with balance checks
- Transfer between accounts
- Failed transaction handling (negative amounts, insufficient funds)
- Savings account interest calculation
- Premium account withdrawal with limits
- Current account overdraft facility

### Section 6: Transaction History

- View complete transaction history
- Get transaction count
- View specific transaction by ID

### Section 7: Client Account Management

- Get total balance across all accounts
- Remove account from client

### Section 8: Bank System Methods

- Login with valid/invalid credentials
- getAccountByNumber lookup
- mainMenu display
- saveToFile and loadFromFile
- getCurrentUser

### Section 9: Apply Yearly Fees

- Test applyYearlyFee for all account types

### Section 10: User Authentication

- Logout functionality
- Login for different user types

### Section 11: LoanEligible Interface

- Test getLoanLimit and applyForLoan for PremiumClient

---

## How to Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line or terminal access

### Compilation

```bash
cd OnlineBankSystem
javac -d out src/Main.java src/manager/BankSystem.java src/models/user/*.java src/models/account/*.java src/models/transaction/*.java src/models/interfaces/*.java
```

### Execution

```bash
java -cp out Main
```

### Expected Output

The program runs 50+ tests across 11 sections and displays:

- User creation and authentication results
- Account creation and management results
- Transaction results (deposit, withdrawal, transfer)
- Transaction history details
- Yearly fee applications
- Test summary

---

## File Persistence

The system includes placeholder methods for file persistence:

- **saveToFile()** - Intended to save users, accounts, and transactions to persistent storage
- **loadFromFile()** - Intended to load previously saved data from files

_Note: Full file persistence implementation is planned for Phase 2._

---

## Key Features by Account Type

### SavingsAccount

- Interest calculation (addInterest method)
- Minimum balance requirement
- Withdrawal restrictions

### CurrentAccount

- Overdraft facility
- Configurable overdraft limit
- Transaction limits
- Yearly fee

### PremiumAccount

- Higher withdrawal limits
- Premium benefits display
- Premium rate bonuses
- Higher yearly fee

### BusinessAccount

- Employee account management
- Business report generation
- Business-specific yearly fee

---

## Future Enhancements (Phase 2) ✅ IN PROGRESS

**Phase 2 Plan**: [View Work Distribution →](PHASE2_DISTRIBUTION.md)

### Core Requirements
- [x] **GUI Implementation** (Swing) - Interactive menus for Admin/Client
- [x] **File Persistence** - Save/load users, accounts, transactions
- [x] **Exception Handling** - Custom exceptions + try/catch everywhere
- [x] **Authentication** - Login with 3-attempt limit + role-based routing

### New Features (From Feedback)
- [x] Interactive main menu (switch + loop + user input)
- [x] Remove hard-coded data → load from files
- [x] Simplify architecture: deposit/withdraw as methods, not classes
- [x] **Admin**: Update Staff, Delete Account (archive), Generate Reports
- [x] **Client**: Manage Card Details, Pay Bills, Update Account Info

### Work Distribution
| Member | Focus | Task File |
|--------|-------|-----------|
| Youssef Adel | System Core + File I/O | [`tasks/YoussefAdel_258270.md`](YoussefAdel_258270.md) |
| Tarek Saeed | Transactions + GUI Refactor | [`tasks/TarekSaeed_252382.md`](TarekSaeed_252382.md) |
| Yousif Hafez | Client Features + Cards | [`tasks/YousifHafez_258612.md`](YousifHafez_258612.md) |
| Yosef Osama | Account GUI + Exceptions | [`tasks/YosefOsama_255796.md`](YosefOsama_255796.md) |
| Yousef Mohiey | Auth System + Login GUI | [`tasks/YousefMohiey_248679.md`](YousefMohiey_248679.md) |
| Abdelrahman Mazen ⭐ | Admin Dashboard + Reports | [`tasks/AbdelrahmanMazen_251979.md`](AbdelrahmanMazen_251979.md) |

> 📋 Each file has: priority tasks, code snippets, testing checklist, resources 🎥

---

## License

This project is created for educational purposes as part of the Programming in Java course at the British University in Egypt.

---

## Contact

**Team 40 - Online Banking System**
British University in Egypt
Course: 25CSCI04C - Programming in Java
