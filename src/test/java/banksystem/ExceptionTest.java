package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionTest {

    @Test
    void testBankExceptionMessage() {
        String expectedMessage = "Lỗi giao dịch ngân hàng";
        BankException exception = new BankException(expectedMessage);

        // CỐ TÌNH SO SÁNH SAI ĐỂ BOT CHỬI:
        // Mong đợi là chữ "Alo 123 bot co biet bat loi khong", nhưng thực tế là "Lỗi giao dịch ngân hàng"
        assertEquals("Alo 123 bot co biet bat loi khong", exception.getMessage(), "Thông báo lỗi không khớp!");
    }
}