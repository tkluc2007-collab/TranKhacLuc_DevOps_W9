package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionTest {

    @Test
    void testBankExceptionMessage() {
        // Test xem class BankException có lưu đúng thông báo lỗi không
        String expectedMessage = "Lỗi giao dịch ngân hàng";
        BankException exception = new BankException(expectedMessage);

        // Kiểm tra xem message lấy ra có khớp với message truyền vào không
        assertEquals(expectedMessage, exception.getMessage(), "Thông báo lỗi không khớp!");
    }
}