package banksystem;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * [BAI 8]: Diem chay ung dung (Entry Point).
     * Cho phep dong goi va chay file JAR tu dong qua GitHub Actions.
     */
    public static void main(String[] args) {
        System.out.println("--- HE THONG NGAN HANG DANG KHOI DONG ---");
        Bank bank = new Bank();
        Customer c = new Customer("Luc Tran");

        // Khoi tao tai khoan mac dinh de kiem tra he thong
        Account acc = new CheckingAccount("ACC123", 1000.0);
        c.addAccount(acc);
        bank.addCustomer(c);

        acc.deposit(500);
        System.out.println("Khach hang: " + c.getName());
        System.out.println("So du cuoi cung: " + acc.getBalance());
    }
}