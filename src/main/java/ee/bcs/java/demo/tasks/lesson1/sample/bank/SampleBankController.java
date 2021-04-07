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

    @PostMapping("account")
    public void createAccount(@RequestParam("accountNumber") String accountNumber){
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, 0)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("account/{accountNumber}")
    public double getBalance(@PathVariable("accountNumber") String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Double.class);
    }

    @PutMapping("account/{accountNumber}/deposit")
    public void depositMoney(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        double balance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        double newBalance = balance + amount;

        String sql2 = "UPDATE account SET balance = :newBalance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("accountNumber", accountNumber);
        paramMap2.put("newBalance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public void withdrawMoney() {

    }

    public void transferMoney() {

    }
}
