# 🎯 Abdelrahman Mazen (251979) - Phase 2 Tasks ⭐

**Focus**: Admin Dashboard + Staff Management + Reporting

---

## 📋 Priority Tasks

### 1. Admin Dashboard GUI 🎛️
```java
// TODO: Create AdminDashboard.java (extends JFrame)
public class AdminDashboard extends JFrame {
    public AdminDashboard(Admin admin) {
        setTitle("🏦 Admin Dashboard - " + admin.getName());
        
        // Sidebar navigation
        JList<String> menu = new JList<>(new String[]{
            "👥 Manage Staff",
            "🗑️ Delete Account", 
            "📊 Generate Report",
            "⚙️ Settings",
            "🚪 Logout"
        });
        
        menu.addListSelectionListener(e -> {
            switch (menu.getSelectedIndex()) {
                case 0: showStaffPanel(); break;
                case 1: showDeleteAccountPanel(); break;
                case 2: showReportPanel(); break;
                case 4: logout(); break;
            }
        });
    }
}
```
- [ ] Build sidebar navigation menu (JList or JTree)
- [ ] Main panel area that changes based on selection
- [ ] Display admin name + role prominently in header
- [ ] Consistent styling with client dashboard (shared CSS/theme)

### 2. Update Staff Feature ✏️
```java
// TODO: Add to Admin.java
public boolean updateStaff(String staffId, StaffUpdateRequest request) {
    Staff staff = findStaffById(staffId);
    if (staff == null) throw new StaffNotFoundException(staffId);
    
    // Update only provided fields (null = keep existing)
    if (request.getPhone() != null) staff.setPhone(request.getPhone());
    if (request.getPassword() != null) staff.setPassword(hash(request.getPassword()));
    if (request.getJobTitle() != null) staff.setJobTitle(request.getJobTitle());
    
    saveAllData(); // persist changes
    return true;
}
```
- [ ] Search staff by name/ID (autocomplete textbox)
- [ ] Form to edit: phone, password, job title
- [ ] Validate phone format, password strength
- [ ] Confirmation dialog before saving: "Update staff XYZ?"

### 3. Delete Account (Archive, Not Hard Delete) 🗑️
```java
// TODO: Add to Admin.java + Account.java
public class Account {
    private boolean isActive = true;
    
    public void archive() {
        this.isActive = false;
        this.archivedAt = LocalDateTime.now();
        // Keep all data, just mark as inactive
    }
}

public boolean deleteCustomerAccount(String accountId) {
    Account acc = findAccount(accountId);
    if (acc == null) throw new InvalidAccountException(accountId);
    
    acc.archive(); // soft delete
    logAction("Account archived: " + accountId);
    saveAllData();
    return true;
}
```
- [ ] Search customer by name/account number
- [ ] Show account details + warning: "This will archive the account"
- [ ] Require confirmation + admin password for destructive action
- [ ] Archived accounts hidden from normal views, visible in "Archived" tab

### 4. Generate Report Feature 📊
```java
// TODO: Add to Admin.java
public String generateSpendingReport(Client client, DateRange range) {
    List<Transaction> txns = client.getTransactionsInRange(range);
    
    StringBuilder report = new StringBuilder();
    report.append("📊 Spending Report for ").append(client.getName()).append("\n");
    report.append("Period: ").append(range.getStart()).append(" to ").append(range.getEnd()).append("\n\n");
    
    double total = txns.stream().mapToDouble(Transaction::getAmount).sum();
    report.append("Total Spent: $").append(String.format("%.2f", total)).append("\n");
    
    // Group by category
    Map<String, Double> byCategory = txns.stream()
        .collect(Collectors.groupingBy(Transaction::getType, 
                 Collectors.summingDouble(Transaction::getAmount)));
    
    for (Map.Entry<String, Double> entry : byCategory.entrySet()) {
        report.append("• ").append(entry.getKey()).append(": $")
              .append(String.format("%.2f", entry.getValue())).append("\n");
    }
    
    return report.toString();
}
```
- [ ] Date range picker (start/end date)
- [ ] Generate report: total spent, breakdown by category
- [ ] Display in scrollable text area + "Export to File" button 📤
- [ ] Optional: simple chart using JFreeChart (bonus)

---

## ✅ Testing Checklist
- [ ] Search staff → find by name/ID → update phone → change persists after restart
- [ ] Delete account → account marked inactive → disappears from client view
- [ ] Generate report → shows correct totals + category breakdown
- [ ] Export report → saves to `reports/spending_YYYYMMDD.txt`
- [ ] Admin actions logged to `logs/admin_actions.log`

---

## 📚 Resources
- [Java Swing Navigation](https://www.youtube.com/watch?v=58D0Gg9lEYc) 🎥
- [Date Picker in Swing](https://www.youtube.com/watch?v=KmgnH8Tca4Q) 🎥
- [String Formatting in Java](https://www.youtube.com/watch?v=8LX5TqLcXbE) 🎥

---

> 💡 **Pro Tip**: Archive ≠ delete! Keep data for audit trails — just hide from normal views 😼
