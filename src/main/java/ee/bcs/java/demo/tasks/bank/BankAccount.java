package ee.bcs.java.demo.tasks.bank;

public class BankAccount {
    public String iban;
    public double balance;

    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
