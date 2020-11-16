package ee.bcs.java.demo.tasks.bank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BankController {
    private List<BankAccount> bankAccountList = new ArrayList<>();

    // localhost:8080/bank/createaccount?iban=EE123
    @GetMapping("bank/createaccount")
    public void createAccount(@RequestParam("iban") String iban){
        BankAccount bankAccount = new BankAccount(iban, 0);
        bankAccountList.add(bankAccount);
    }

    public double getAccountBalance(int i){
        return bankAccountList.get(i).balance;
    }

    public void depositMoney(int i, double amount){

    }
    // withdrawMoney
    // transferMoney
}
