# 🎯 Yousif Hafez (258612) - Phase 2 Tasks

**Focus**: Client Features + Card Management + Pay Bills

---

## 📋 Priority Tasks

### 1. Manage Card Details Feature 💳
```java
// TODO: Add to Client.java
public enum CardStatus { ACTIVE, INACTIVE, LOST, STUCK }

public class Client {
    private CardStatus cardStatus = CardStatus.INACTIVE;
    
    public void issueCard() {
        if (cardStatus != CardStatus.INACTIVE) 
            throw new CardAlreadyIssuedException();
        cardStatus = CardStatus.ACTIVE;
    }
    
    public void updateCardStatus(CardStatus newStatus) {
        this.cardStatus = newStatus;
        logAction("Card status: " + newStatus);
    }
}
```
- [ ] Add `CardStatus` enum + card-related fields to `Client`
- [ ] Implement: issue, activate, deactivate, report lost/stuck
- [ ] Save card status to file (persistence) 💾

### 2. Card Management GUI 🎨
```java
// TODO: Create CardPanel.java
JPanel cardPanel = new JPanel();
JLabel statusLabel = new JLabel("Status: INACTIVE");
JButton issueBtn = new JButton("Issue Card");
JButton reportLostBtn = new JButton("Report Lost");

issueBtn.addActionListener(e -> {
    try {
        currentUser.issueCard();
        statusLabel.setText("Status: ACTIVE ✅");
    } catch (CardAlreadyIssuedException ex) {
        JOptionPane.showMessageDialog(null, "Card already active!", "Warning", JOptionPane.WARNING_MESSAGE);
    }
});
```
- [ ] Display current card status prominently
- [ ] Buttons enabled/disabled based on current status
- [ ] Confirmation dialogs for destructive actions (report lost)

### 3. Pay Bills Feature 💸
```java
// TODO: Add to Client.java
public boolean payBill(String billType, double amount) {
    if (amount > balance) throw new InsufficientFundsException();
    if (amount <= 0) throw new InvalidAmountException();
    
    balance -= amount;
    logTransaction(new Transaction("BILL_PAYMENT", amount, billType));
    return true;
}
```
- [ ] Support bill types: "Credit Card", "Utilities", "Subscription"
- [ ] Validate amount ≤ account balance
- [ ] Record as special transaction type in history

### 4. Client Account Update GUI ✏️
- [ ] Form to edit: phone number, password, email
- [ ] Validate phone format (+20XXXXXXXXXX)
- [ ] Password change: require old password + confirm new
- [ ] Save changes to file immediately

---

## ✅ Testing Checklist
- [ ] Issue card → status changes to ACTIVE → persists after restart
- [ ] Report lost → status = LOST → card functions disabled
- [ ] Pay bill with sufficient funds → balance updates + appears in history
- [ ] Pay bill with insufficient funds → shows error, no balance change
- [ ] Update phone/password → changes saved + work on next login

---

## 📚 Resources
- [Java Enums Tutorial](https://www.youtube.com/watch?v=lILvOnKbODE) 🎥
- [Swing Event Handling](https://www.youtube.com/watch?v=58D0Gg9lEYc) 🎥
- [Input Validation in Java](https://www.youtube.com/watch?v=KmgnH8Tca4Q) 🎥

---

> 💡 **Pro Tip**: Use enums for card status — prevents invalid states! 😼
