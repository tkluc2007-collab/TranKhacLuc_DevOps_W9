package banksystem;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Đại diện cho một giao dịch. */
public class Transaction {
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    // Các hàm getter/setter giữ nguyên...
    public int getType() { return type; }
    public void setType(int type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public double getInitialBalance() { return initialBalance; }
    public void setInitialBalance(double initialBalance) { this.initialBalance = initialBalance; }
    public double getFinalBalance() { return finalBalance; }
    public void setFinalBalance(double finalBalance) { this.finalBalance = finalBalance; }

    /** Lấy chuỗi mô tả loại giao dịch. */
    public static String getTypeString(int typeCode) {
        switch (typeCode) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
            default:
                return "Không rõ";
        }
    }

    /** Lấy tóm tắt giao dịch. */
    public String getTransactionSummary() {
        logger.debug("Bắt đầu xử lý summary cho loại giao dịch: {}", this.type);

        String typeStr = getTypeString(type);
        String formattedInitBal = String.format(Locale.US, "%.2f", initialBalance);
        String formattedAmount = String.format(Locale.US, "%.2f", amount);
        String formattedFinalBal = String.format(Locale.US, "%.2f", finalBalance);

        return String.format(
                "- Kiểu giao dịch: %s. Số dư ban đầu: $%s. Số tiền: $%s. Số dư cuối: $%s.",
                typeStr, formattedInitBal, formattedAmount, formattedFinalBal);
    }
}