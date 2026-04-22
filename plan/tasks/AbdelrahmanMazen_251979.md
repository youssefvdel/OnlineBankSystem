# AbdelrahmanMazen_251979 - Phase 2 Tasks

**Role:** Admin GUI (Reduced Scope - 2 Windows Only)  
**Student ID:** 251979  
**Time Estimate:** ~45 minutes total

---

## ✅ Your 2 Tasks (Simple & Achievable)

### Task 1: AdminDashboard.java (~25 min)

**Goal:** Simple admin menu with 4 buttons

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Main admin dashboard window.
 * @author Abdelrahman Mazen 251979
 */
public class AdminDashboard extends JFrame {
    
    private Admin admin;
    
    public AdminDashboard(Admin admin) {
        this.admin = admin;
        setupUI();
    }
    
    private void setupUI() {
        setTitle("Admin Dashboard - " + admin.getName());
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JButton addStaff = new JButton("Add Staff");
        JButton removeStaff = new JButton("Remove Staff");
        JButton updateStaff = new JButton("Update Staff");
        JButton generateReport = new JButton("Generate Report");
        
        // TODO: Add action listeners later
        // For now, just print to console
        addStaff.addActionListener(e -> System.out.println("Add Staff clicked"));
        removeStaff.addActionListener(e -> System.out.println("Remove Staff clicked"));
        updateStaff.addActionListener(e -> System.out.println("Update Staff clicked"));
        generateReport.addActionListener(e -> {
            new GenerateReportDialog(this).setVisible(true);
        });
        
        panel.add(addStaff);
        panel.add(removeStaff);
        panel.add(updateStaff);
        panel.add(generateReport);
        
        add(panel);
    }
}
```

**Done Criteria:**
- [ ] Window opens with title "Admin Dashboard"
- [ ] 4 buttons display correctly
- [ ] Clicking "Generate Report" opens the dialog
- [ ] Other buttons print message to console (for now)

---

### Task 2: GenerateReportDialog.java (~20 min)

**Goal:** Display transaction data from CSV in a table

**Starter Code:**
```java
package gui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple dialog to show transaction report data.
 * @author Abdelrahman Mazen 251979
 */
public class GenerateReportDialog extends JDialog {
    
    public GenerateReportDialog(Frame parent) {
        super(parent, "Transaction Report", true);
        setupUI();
        loadData();
    }
    
    private void setupUI() {
        setSize(500, 400);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout(10, 10));
        
        // Table for displaying data
        String[] columns = {"Timestamp", "Admin ID", "Action", "Details"};
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
        // TODO: Use CSVHelper to read reports.csv
        // For now, add sample data to test UI
        DefaultTableModel model = (DefaultTableModel) 
            ((JScrollPane) getContentPane().getComponent(0))
            .getViewport().getView();
        
        // Sample data - replace with CSV reading later
        model.addRow(new Object[]{"2026-04-02", "ADMIN001", "REPORT", "Q1 Summary"});
        model.addRow(new Object[]{"2026-04-02", "ADMIN001", "STAFF_ADDED", "John Teller"});
    }
}
```

**Done Criteria:**
- [ ] Dialog opens when "Generate Report" clicked
- [ ] Table displays at least sample data
- [ ] Close button works
- [ ] Window is modal (blocks parent until closed)

---

## 📁 File I/O (Your 30%)

**File:** `data/reports.csv`

**Format:**
```
timestamp,adminId,actionType,details
2026-04-02T11:00,ADMIN001,REPORT_GENERATED,Transaction summary Q1
```

**Implementation:**
```java
// In AdminDashboard.java, when button clicked:
private void logAdminAction(String action, String details) {
    try (PrintWriter writer = new PrintWriter(
            new FileWriter("data/reports.csv", true))) {
        String timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        writer.printf("%s,%s,%s,%s%n", 
            timestamp, admin.getId(), action, details);
    } catch (IOException e) {
        // TODO: Handle with AdminActionException
        System.err.println("Failed to log action: " + e.getMessage());
    }
}
```

**Done Criteria:**
- [ ] `data/reports.csv` created automatically if missing
- [ ] Each admin action appends one line to the file
- [ ] File can be read back by GenerateReportDialog

---

## ⚠️ Exception Handling (Your 30%)

**File:** `src/exceptions/AdminActionException.java`

**Code:**
```java
package exceptions;

/**
 * Thrown when an admin action fails validation.
 * @author Abdelrahman Mazen 251979
 */
public class AdminActionException extends Exception {
    
    public AdminActionException(String message) {
        super(message);
    }
    
    public AdminActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

**Usage Example:**
```java
// In AdminDashboard.java
public void removeStaff(String staffId) throws AdminActionException {
    if (staffId == null || staffId.isEmpty()) {
        throw new AdminActionException("Staff ID cannot be empty");
    }
    // ... rest of logic
}
```

**Done Criteria:**
- [ ] AdminActionException.java compiles
- [ ] At least one method throws it
- [ ] Caller catches and shows user-friendly message

---

## 🧪 Testing Checklist

```bash
# 1. Compile your files
javac -d out -sourcepath src \
  src/exceptions/AdminActionException.java \
  src/gui/admin/AdminDashboard.java \
  src/gui/admin/GenerateReportDialog.java

# 2. Run a quick test (create a simple Main to test)
java -cp out gui.admin.AdminDashboardTest

# 3. Verify:
#    - AdminDashboard window opens
#    - Buttons respond to clicks
#    - GenerateReportDialog shows table
#    - reports.csv gets appended on actions
```

---

## 🎥 Quick Video Help

| What you need | Watch this |
|--------------|------------|
| JFrame basics | https://youtu.be/9XJicRt_FaI (first 5 min) |
| JButton + ActionListener | https://youtu.be/a7rX_VbJL8k (3 min) |
| JTable simple example | https://youtu.be/5K8vVvZqJ8E (first 4 min) |
| FileWriter append mode | https://youtu.be/9XJicRt_FaI?t=180 (2 min) |

---

## 🤝 Team Handoff

**You provide:**
- AdminDashboard.java (opens other admin dialogs)
- GenerateReportDialog.java (displays report data)
- reports.csv format documentation

**You receive:**
- Login from YousefMohiey (to test admin login)
- AddStaffDialog from YousefMohiey (to integrate later)
- RemoveStaffDialog from YosefOsama (to integrate later)

**Message when done:**
> "✅ Admin GUI basics done: AdminDashboard + GenerateReportDialog. 
>  reports.csv logging works. Ready for dialog integration."

---

## 🚨 Common Pitfalls (Avoid These)

1. **Don't overcomplicate** - Just make buttons work, logic can be simple
2. **Don't forget `dispose()`** - Dialogs won't close without it
3. **Don't hardcode file paths** - Use `"data/reports.csv"` relative path
4. **Don't skip the exception** - Even 1 throw/catch meets the 30% requirement

---

## ✅ Final Submission Checklist

- [ ] AdminDashboard.java - compiles, opens, 4 buttons work
- [ ] GenerateReportDialog.java - opens, shows table, closes
- [ ] reports.csv - created, appends on admin actions
- [ ] AdminActionException.java - compiles, used in at least 1 place
- [ ] Code has @author tag with your name + ID
- [ ] No compilation errors
- [ ] Pushed to your feature branch

**You got this!** Start with AdminDashboard, test it works, then do GenerateReportDialog. 
If stuck for >10 min, message the team on Discord. 🚀
