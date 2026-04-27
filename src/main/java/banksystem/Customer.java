package banksystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Account> accounts; // Danh sach cac tai khoan cua khach hang

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }
}