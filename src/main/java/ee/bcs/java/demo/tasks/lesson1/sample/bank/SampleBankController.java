package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import ee.bcs.java.demo.tasks.lesson1.solution.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @CrossOrigin
    @GetMapping("account/{accountNumber}")
    public double getBalance(@PathVariable("accountNumber") String accountNumber) {
        return bankService.getBalance(accountNumber);
    }

    @GetMapping("account/{accountNumber}/name")
    public String getName(@PathVariable("accountNumber") String accountNumber) {
        return bankService.getName(accountNumber);
    }

    @PutMapping("account/deposit/{accountNumber}")
    public void depositMoney(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        bankService.depositMoney(accountNumber, amount);
    }

    @PutMapping("account/withdraw/{accountNumber}")
    public ErrorResponse withdrawMoney(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        bankService.withdrawMoney(accountNumber, amount);
        ErrorResponse response = new ErrorResponse();
        response.setMessage("Raha väljavõtmine õnnestus");
        return response;
    }

    @PutMapping("account/transfer")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") Double amount) {
        bankService.transferMoney(fromAccount, toAccount, amount);
    }

    @GetMapping("account/transactionHistory")
    public List<Transaction> getTransactions(@RequestParam("accountNumber") String accountNumber) {
        return bankService.getTransactionHistory(accountNumber);
    }
}
