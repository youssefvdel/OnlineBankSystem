package manager;

import java.util.ArrayList;
import models.account.Account;
import models.user.User;

public class BankSystem {

    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions; // You'll create Transaction later
    private User currentUser;

    public BankSystem() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Methods to implement
    public boolean login(String userId, String password) {}

    public void mainMenu() {}

    public void saveToFile() {}

    public void loadFromFile() {}
}
