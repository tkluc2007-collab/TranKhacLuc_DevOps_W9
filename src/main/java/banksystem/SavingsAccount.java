package banksystem;

public class SavingsAccount extends Account {
    private double interestRate = 0.05; // Lai suat mac dinh 5%

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in savings");
        }
        balance -= amount;
        logger.info("Tai khoan tiet kiem {}: Da rut {}", accountNumber, amount);
    }

    // Tinh va cong lai suat vao so du hien tai
    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        logger.info("Da cong lai suat {} vao tai khoan {}", interest, accountNumber);
    }
}