package banksystem;

public class CheckingAccount extends Account {
    // Phi co dinh moi lan rut tien
    private static final double FEE = 1.0;

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // [BAI 5]: Logic kiem tra so du bao gom ca phi dich vu
        if (amount + FEE > balance) {
            logger.error("Rut tien that bai: Tai khoan {} khong du so du de tra phi {}", accountNumber, FEE);
            throw new InsufficientFundsException("Not enough balance for withdrawal and fee");
        }
        balance -= (amount + FEE);
        logger.info("Tai khoan {}: Rut {} (Phi: {})", accountNumber, amount, FEE);
    }
}