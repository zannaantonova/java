package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("sample")
@RestController
public class SampleBankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private SampleBankService bankService;

    @PostMapping("account")
    public void createAccount(@RequestParam("accountNumber") String accountNumber){
        bankService.createAccount(accountNumber);
    }

    @GetMapping("account/{accountNumber}")
    public double getBalance(@PathVariable("accountNumber") String accountNumber) {
        return bankService.getBalance(accountNumber);
    }

    @PutMapping("account/deposit/{accountNumber}")
    public void depositMoney(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        bankService.depositMoney(accountNumber, amount);
    }

    @PutMapping("account/withdraw/{accountNumber}")
    public void withdrawMoney(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        bankService.withdrawMoney(accountNumber, amount);
    }

    @PutMapping("account/transfer")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") Double amount) {
        bankService.transferMoney(fromAccount, toAccount, amount);
    }
}
