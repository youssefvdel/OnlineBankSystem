# AbdelrahmanMazen_251979 - Phase 2 Tasks (MINIMAL SCOPE)

**Role:** Admin GUI - Reduced to 1 Optional GUI Only  
**Student ID:** 251979  
**Time Estimate:** ~25 minutes total (if choosing to complete)

---

## ⚠️ IMPORTANT: Scope Reduced

**Reason:** Team redistribution to ensure Phase 2 completion  
**Your tasks moved to:** YoussefAdel (AdminDashboard), YousefMohiey (AdminActionLogger)

---

## ✅ Your 1 Task (OPTIONAL - P2 Nice to Have)

### Task 1: ViewTransactionHistoryDialog.java (~25 min)

**Goal:** Display all transactions in a filterable table

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Dialog to view all system transactions.
 * @author Abdelrahman Mazen 251979
 */
public class ViewTransactionHistoryDialog extends JDialog {
    
    public ViewTransactionHistoryDialog(Frame parent) {
        super(parent, "Transaction History", true);
        setupUI();
        loadData();
    }
    
    private void setupUI() {
        setSize(600, 400);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout(10, 10));
        
        // Table for displaying data
        String[] columns = {"TX ID", "Account", "Type", "Amount", "Timestamp"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        // Close button
        JButton close = new JButton("Close");
        close.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void loadData() {
        // TODO: Read from transactions.ser using ObjectInputStream
        // Display in JTable
    }
}
```

**Done Criteria:**
- [ ] Dialog opens when called
- [ ] Table displays transactions from `transactions.ser`
- [ ] Close button works

---

## 📁 File I/O (Your 30%)

**File:** `data/transactions.ser` (read only)

**Implementation:**
```java
// Use ObjectInputStream to deserialize ArrayList<Transaction>
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/transactions.ser"));
ArrayList<Transaction> transactions = (ArrayList<Transaction>) ois.readObject();
```

---

## ⚠️ Exception Handling

**MOVED to YousefMohiey:** `AdminActionException.java`

**You don't need to create any exceptions.**

---

## 🤝 Team Handoff

**You provide:**
- ViewTransactionHistoryDialog.java (optional, nice-to-have)

**You receive:**
- File I/O from YoussefAdel (serialization utilities)

**Note:** If not completed by 2:00 PM on sprint day → Team will complete

---

## ✅ Final Submission Checklist

- [ ] ViewTransactionHistoryDialog.java - compiles, opens, shows data (OPTIONAL)
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] Pushed to your feature branch (if completing)

**Message when done:**
> "✅ ViewTransactionHistoryDialog done (optional). Ready for integration."

---

**Note:** This is a reduced scope to help team complete Phase 2 on time. If you cannot complete this, the team will cover it.
