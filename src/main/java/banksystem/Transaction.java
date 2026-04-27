package banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transaction {
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    /**
     * Thuc hien chuyen tien giua hai tai khoan bat ky.
     * [BAI 9]: Log lai trang thai truoc va sau khi giao dich.
     */
    public void transfer(Account from, Account to, double amount) throws InsufficientFundsException {
        logger.info("Bat dau chuyen {} tu {} sang {}", amount, from.getBalance(), to.getBalance());

        from.withdraw(amount); // Rut tu tai khoan nguon
        to.deposit(amount);    // Nap vao tai khoan dich

        logger.info("Giao dich hoan tat thanh cong.");
    }
}