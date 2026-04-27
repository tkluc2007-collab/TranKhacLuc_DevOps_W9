package banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lop truu tuong dinh nghia cau truc chung cho moi loai tai khoan.
 * [BAI 9]: Tich hop SLF4J Logger de ghi lai lich su giao dich.
 */
public abstract class Account {
    protected static final Logger logger = LoggerFactory.getLogger(Account.class);
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        logger.info("Khoi tao tai khoan {} voi so du ban dau: {}", accountNumber, balance);
    }

    // Phuong thuc truu tuong buoc cac lop con phai trien khai logic rut tien rieng
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public void deposit(double amount) {
        if (amount <= 0) {
            logger.error("So tien nap khong hop le: {}", amount);
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
        logger.info("Tai khoan {}: Da nap vao {}", accountNumber, amount);
    }

    public double getBalance() {
        return balance;
    }
}