# 🎯 Yousef Mohiey (248679) - Phase 2 Tasks

**Focus**: Authentication System + Login GUI + Session Management

---

## 📋 Priority Tasks

### 1. Login GUI with 3-Attempt Limit 🔐
```java
// TODO: Create LoginFrame.java (extends JFrame)
public class LoginFrame extends JFrame {
    private int failedAttempts = 0;
    private static final int MAX_ATTEMPTS = 3;
    
    private void checkCredentials(String username, String password) {
        User user = BankSystem.getInstance().authenticate(username, password);
        
        if (user != null) {
            failedAttempts = 0; // reset
            openDashboardForRole(user); // route to Admin/Client view
            dispose(); // close login window
        } else {
            failedAttempts++;
            if (failedAttempts >= MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(this, 
                    "❌ Too many failed attempts. Exiting.", 
                    "Access Denied", 
                    JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "❌ Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - failedAttempts),
                    "Login Failed", 
                    JOptionPane.WARNING_MESSAGE);
                clearFields();
            }
        }
    }
}
```
- [ ] Build login form: username, password fields + login button
- [ ] Track failed attempts (max 3) → exit on 4th failure
- [ ] Clear password field after each failed attempt
- [ ] Add "Exit" button to quit gracefully

### 2. Role-Based Routing After Login 🎭
```java
// TODO: Implement in BankSystem.java
public void openDashboardForRole(User user) {
    if (user instanceof Admin) {
        new AdminDashboard(user).setVisible(true);
    } else if (user instanceof Client) {
        new ClientDashboard((Client) user).setVisible(true);
    }
}
```
- [ ] Create `AdminDashboard.java` (menu: manage staff, reports, delete account)
- [ ] Create `ClientDashboard.java` (menu: transactions, cards, pay bills)
- [ ] Hide/show menu items based on user role (principle of least privilege)

### 3. Logout + Session Management 🚪
```java
// TODO: Add to all dashboard classes
private void logout() {
    BankSystem.getInstance().saveAllData(); // persist changes
    currentUser = null; // clear session
    dispose(); // close current dashboard
    new LoginFrame().setVisible(true); // return to login
}
```
- [ ] Add "Logout" button to all dashboards (top-right corner)
- [ ] Save all data before logout (critical!)
- [ ] Clear sensitive data from memory after logout
- [ ] Return to login screen (not exit app)

### 4. Authentication Security 🔒
- [ ] Store passwords hashed (simple: SHA-256) — not plain text 🔐
- [ ] Validate username/password not empty before checking
- [ ] Disable login button during authentication (prevent double-click)
- [ ] Add "Show/Hide Password" toggle (eye icon)

---

## ✅ Testing Checklist
- [ ] Valid credentials → opens correct dashboard (Admin vs Client)
- [ ] Invalid password 3 times → shows warning → 4th attempt exits app
- [ ] Logout → saves data → returns to login screen
- [ ] After logout, can login again with same/different user
- [ ] Password field masked (shows •••••), not plain text

---

## 📚 Resources
- [Java Swing Login Form](https://www.youtube.com/watch?v=KmgnH8Tca4Q) 🎥
- [Password Hashing in Java](https://www.youtube.com/watch?v=8LX5TqLcXbE) 🎥
- [JFrame Best Practices](https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html) 📖

---

> 💡 **Pro Tip**: Always save data BEFORE logout — never trust users to "save manually"! 😼
