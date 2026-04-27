package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testDeposit() {
        // [FIX]: Dung CheckingAccount
        Account acc = new CheckingAccount("A1", 100);
        acc.deposit(50);
        assertEquals(150.0, acc.getBalance());
    }

    @Test
    void testWithdrawSuccess() throws InsufficientFundsException {
        Account acc = new CheckingAccount("A1", 100);
        acc.withdraw(40);
        // CheckingAccount co phi rut tien la 1.0 (nhu trong code main toi gui)
        // Rut 40 + phi 1 = 41. Con lai 100 - 41 = 59
        assertEquals(59.0, acc.getBalance());
    }

    @Test
    void testWithdrawOverBalance() {
        Account acc = new CheckingAccount("A1", 50);
        assertThrows(InsufficientFundsException.class, () -> acc.withdraw(100));
    }
}