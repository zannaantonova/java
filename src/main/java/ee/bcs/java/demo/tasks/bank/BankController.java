package ee.bcs.java.demo.tasks.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank")
@RestController
public class BankController {
    @Autowired
    private BankService bankService;

    private final Logger logger = LoggerFactory.getLogger(BankController.class);

    // http://localhost:8080/bank/createaccount?iban=EE124
    @GetMapping("createaccount")
    public void createAccount(@RequestParam("iban") String iban) {
        try{
            throw new NullPointerException();
        } catch (Exception e){
            logger.error("vea täpsustav tekst", e);
        }
    //    bankService.createAccount(iban);
    }

    // http://localhost:8080/bank/getAccountBalance?iban=EE123
    @GetMapping("getAccountBalance")
    public int getAccountBalance(@RequestParam("iban") String iban) {
        return bankService.getAccountBalance(iban);
    }

    // http://localhost:8080/bank/depositMoney?iban=EE123&amount=100
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("iban") String iban,
                             @RequestParam("amount") Integer amount) {
        bankService.depositMoney(iban, amount);
    }

    // http://localhost:8080/bank/withdrawMoney?iban=EE123&amount=100
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("iban") String iban,
                              @RequestParam("amount") int amount) {
        bankService.withdrawMoney(iban, amount);
    }

    // http://localhost:8080/bank2/transferMoney?from=EE123&to=EE124&amount=100
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("amount") int amount) {
        bankService.transferMoney(from, to, amount);
    }
}




