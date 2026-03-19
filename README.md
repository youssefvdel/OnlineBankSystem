# Online Banking System

**BUE - Programming in Java (25CSCI04C)**

---

## Project Overview

| Item                  | Details                         |
| --------------------- | ------------------------------- |
| **Course**            | 25CSCI04C - Programming in Java |
| **Phase**             | Phase 1 (Console-Based)         |
| **Deadline**          | Week 6 (19/3/2025, 23:59)       |
| **Assessment Weight** | 25% of total course mark        |
| **Team Number**       | **40**                          |

---

## Team Members

|  #  | Member           | Student ID | Role             | Responsibilities                                                                                     |
| :-: | ---------------- | ---------- | ---------------- | ---------------------------------------------------------------------------------------------------- |
|  1  | **Youssef Adel** | `258270`   | 🎯 **Team Lead** | • Account, BusinessAccount, CurrentAccount, BankSystem, Main<br>• GitHub Repository Management<br>• Project Planning & Management |
|  2  | **Tarek Saeed**         | `252382`   | 👤 Member        | • Transaction, Deposit, Withdrawal, TransactionHistory, Transferable<br>• Class Diagram & OOP Logic Design |                                                                                       
|  3  | **Yousif Hafez**         | `258612`   | 👤 Member        | **First Class Client,premium Client,Standard Client,(Insurable,Loan Eligible)Interfaces**                                                                                          
|  4  | **Yosef Osama**         | `255796`   | 👤 Member        | **• SavingsAccount,PremiumAccount,Transfer**                                                                                               |
|  5  | **\_\_**         | `______`   | 👤 Member        | **\_\_**                                                                                             |
|  6  | **\_\_**         | `______`   | 👤 Member        | **\_\_**                                                                                             |

---

## Features (Phase 1)

- ✅ **User Authentication** - Login/Logout with 3-attempt limit
- ✅ **Account Management** - Create, View, Delete accounts
- ✅ **Transactions** - Deposit, Withdraw, Transfer
- ✅ **Balance Inquiry** - Check account balance
- ✅ **Transaction History** - View all transactions for an account
- ✅ **File Persistence** - Save/Load data to files
- ✅ **Custom Exceptions** - 7 exception classes

---

## Project Structure

```
src/
├── Main.java                          # Entry point & testing scenario
├── manager/
│   ├── BankSystem.java                # Main system controller
│   └── TransactionManager.java        # Transaction handling
├── exceptions/                        # 7 custom exception classes
└── models/
    ├── user/                          # User hierarchy (6 classes)
    ├── account/                       # Account hierarchy (5 classes)
    ├── transaction/                   # Transaction hierarchy (5 classes)
    └── interfaces/                    # 3 interfaces
```

---

## Class Diagram

> 📌 _Need to add the class diagram image here!!!_

### User Hierarchy

```
User (Abstract)
├── Client (Abstract)
│   ├── PremiumClient
│   ├── StandardClient
│   └── FirstClassClient
└── Admin
```

### Account Hierarchy

```
Account
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
└── TransactionHistory
```

### Interfaces

- `Transferable`
- `Insurable`
- `LoanEligible`

---

## Testing Scenario

The `Main.java` class includes the following test cases:

1. Create users (Admin, PremiumClient, StandardClient, FirstClassClient)
2. User login with 3-attempt limit
3. Create accounts for clients
4. Deposit, Withdraw, Transfer operations
5. View balance and transaction history
6. File save/load functionality
7. Custom exception handling

---
