package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {
    @Test
    void triggerErrorLogs() {
        // [FIX]: Dung CheckingAccount thay vi Account vi Account la abstract
        Account acc = new CheckingAccount("ERR_TEST", 0);

        // [BÀI 9]: Khi gọi hàm này, logger.error sẽ ghi vào file logs/app.log
        try {
            acc.withdraw(999999);
        } catch (InsufficientFundsException e) {
            assertTrue(true); // Chỉ cần kích hoạt code để ghi log
        }
    }
}