package ee.bcs.java.demo.controller;

import java.math.BigDecimal;

public class Account {
    private BigDecimal accountBalance;

    public Account(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
