package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("sample_old")
@RestController
public class SampleBankControllerWithoutService {

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

    @PutMapping("account/deposit/{accountNumber}")
    public void depositMoney(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        if(amount > 0){
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
    }

    @PutMapping("account/withdraw/{accountNumber}")
    public void withdrawMoney(@PathVariable("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        if(amount > 0) {
            String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("accountNumber", accountNumber);
            double balance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            if (balance >= amount) {
                double newBalance = balance - amount;
                String sql2 = "UPDATE account SET balance = :newBalance WHERE account_number = :accountNumber";
                Map<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("accountNumber", accountNumber);
                paramMap2.put("newBalance", newBalance);
                jdbcTemplate.update(sql2, paramMap2);
            }
        }
    }

    @PutMapping("account/transfer")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") Double amount) {
        if(amount > 0){
            String sql = "SELECT balance FROM account WHERE account_number = :fromAccount";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("fromAccount", fromAccount);
            double fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            if (fromAccountBalance >= amount) {
                String sql2 = "SELECT balance FROM account WHERE account_number = :toAccount";
                Map<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("toAccount", toAccount);
                double toAccountBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Double.class);

                double newFromAccountBalance = fromAccountBalance - amount;
                double newToAccountBalance = toAccountBalance + amount;

                String sql3 = "UPDATE account SET balance = :newBalance WHERE account_number = :accountNumber";
                Map<String, Object> paramMap3= new HashMap<>();
                paramMap3.put("accountNumber", fromAccount);
                paramMap3.put("newBalance", newFromAccountBalance);
                jdbcTemplate.update(sql3, paramMap3);

                String sql4 = "UPDATE account SET balance = :newBalance WHERE account_number = :accountNumber";
                Map<String, Object> paramMap4 = new HashMap<>();
                paramMap4.put("accountNumber", toAccount);
                paramMap4.put("newBalance", newToAccountBalance);
                jdbcTemplate.update(sql4, paramMap4);
            }
        }
    }
}
