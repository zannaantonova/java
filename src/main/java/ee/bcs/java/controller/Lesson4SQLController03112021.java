package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public class Lesson4SQLController03112021 {

    @Autowired
    private BankService bankService;


    @GetMapping("banksql/createAccount")
    // http://localhost:8080/banksql/createAccount?accountNumber=EE123
    public String createAccount2(@RequestParam("accountNumber") String accountNumber) {
        return bankService.createAccount2(accountNumber);

    }

    @GetMapping("banksql/getBalance3/{accountNumber}")
    // http://localhost:8080/banksql/getBalance3/EE123
    public String getBalance3(@PathVariable("accountNumber") String accountNumber) {
        return bankService.getBalance3(accountNumber);
    }


    @GetMapping("banksql/depositMoney2")
    // http://localhost:8080/banksql/depositMoney2?accountNumber=EE123&amount=1600
    public String depositMoney2(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") int amount) {
        return bankService.depositMoney2(accountNumber, amount);
    }


    @GetMapping("banksql/withdrawMoney2")
    // http://localhost:8080/banksql/withdrawMoney2?accountNumber=EE123&amount=1600
    public String withdrawMoney2(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") int amount) {
        return bankService.withdrawMoney2(accountNumber, amount);
    }


    @GetMapping("bank2/transferMoney2/{fromAccountNumber}/{toAccountNumber}/{amount}")
    //http://localhost:8080/bank2/transferMoney2/EE123/LT226/400
    public String transferMoney2(@PathVariable("fromAccountNumber") String fromAccountNumber, @PathVariable("toAccountNumber") String toAccountNumber, @PathVariable("amount") Integer amount) {
        return bankService.transferMoney2(fromAccountNumber, toAccountNumber, amount);
    }

    //konto väljavõte

    @GetMapping("bank2/transactiondata/{accountNumber}")
    //http://localhost:8080/bank2/transactiondata/EE123?from=2021-11-01?to=2021-11-01
    public List transactiondata(@PathVariable("accountNumber") String accountNumber, @RequestParam("from") String from, @RequestParam(value = "to", required = false) String to) {

        return bankService.transactiondata(accountNumber, from, to);
    }

}

