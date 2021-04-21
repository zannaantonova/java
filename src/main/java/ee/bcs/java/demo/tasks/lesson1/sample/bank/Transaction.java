package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import java.time.LocalDate;

public class Transaction {
    private double amount;
    private String accountNumber;
    private LocalDate date;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
