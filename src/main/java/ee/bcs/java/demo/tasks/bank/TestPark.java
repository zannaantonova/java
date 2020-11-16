package ee.bcs.java.demo.tasks.bank;

import java.util.ArrayList;
import java.util.List;

public class TestPark {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("EE123", 24);
        BankAccount account2 = new BankAccount("DE123", 55);
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(account1);
        bankAccountList.add(account2);
        System.out.println(bankAccountList);
        System.out.println(bankAccountList.get(0).balance);
        BankAccount firstAccount = bankAccountList.get(0);
        firstAccount.balance = 1000;
        System.out.println(bankAccountList);
    }
}
