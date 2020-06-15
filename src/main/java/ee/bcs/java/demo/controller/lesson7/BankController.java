package ee.bcs.java.demo.controller.lesson7;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController()
public class BankController {

    private static Map<String, BigDecimal> accounts = new HashMap<>();

    @GetMapping("create-account")
    public BigDecimal createAccount(@RequestParam("accontNr") String accountNr) {
        accounts.put(accountNr, BigDecimal.ZERO);
        return BigDecimal.ZERO;
    }

    @GetMapping("test-error")
    public String testError() {
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Something is mandatory");
    }

    // TODO
    // kasuta staatilist muutujat andmete salvestamiseks
    // defineeri rest enpoindid:
    // createAccount(String accountNr) | loob uue konto etteantud konto numbriga
    // getAccount(String accountNr) | tagasta kui palju raha on vastaval kontol
    // depositMoney(String accountNr, amount) | kannab loodud kontole raha (suurendab kontoga seotud raha muutujat)
    // withdrawMoney(String accountNr, amount) | võtab kontolt raha (vähendab kontol olevat rahasummat)
    // transferMoney(String account1, String account2, amount) | kanna raha esimeselt kontolt teisele kontole
}
