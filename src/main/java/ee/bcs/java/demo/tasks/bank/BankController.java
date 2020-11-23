package ee.bcs.java.demo.tasks.bank;

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
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/bank/createaccount?iban=EE124
    @GetMapping("createaccount")
    public void createAccount(@RequestParam("iban") String iban) {
        String sql = "INSERT INTO account (account_nr, balance) " +
                "VALUES (:accountNr, 0)";
        Map paramMap = new HashMap<>();
        paramMap.put("accountNr", iban);
        jdbcTemplate.update(sql, paramMap);
    }

    // http://localhost:8080/bank/getAccountBalance?iban=EE123
    @GetMapping("getAccountBalance")
    public int getAccountBalance(@RequestParam("iban") String iban) {
        String sql = "SELECT balance FROM account WHERE account_nr = :iban";
        Map paramMap = new HashMap();
        paramMap.put("iban", iban);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    // http://localhost:8080/bank/depositMoney?iban=EE123&amount=100
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("iban") String iban,
                             @RequestParam("amount") Integer amount) {
        if (amount > 0) {
            String sql = "SELECT balance FROM account WHERE account_nr = :iban";
            Map paramMap = new HashMap();
            paramMap.put("iban", iban);
            int currentAmount = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
            int newAmount = currentAmount + amount;
            String sql2 = "UPDATE account SET balance = :amount " +
                    "WHERE account_nr = :iban";
            Map paramMap2 = new HashMap();
            paramMap2.put("iban", iban);
            paramMap2.put("amount", newAmount);
            jdbcTemplate.update(sql2, paramMap2);
        }
    }

    // http://localhost:8080/bank/withdrawMoney?iban=EE123&amount=100
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("iban") String iban,
                              @RequestParam("amount") int amount) {
        if (amount > 0) { // kas sa üritad võtta välja negatiivse koguse raha
            String sql = "SELECT balance FROM account WHERE account_nr = :iban";
            Map paramMap = new HashMap();
            paramMap.put("iban", iban);
            int currentAmount = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
            int newAmount = currentAmount - amount;
            if (newAmount >= 0) { // kas sul on piisavalt vabu vahendeid
                String sql2 = "UPDATE account SET balance = :amount " +
                        "WHERE account_nr = :iban";
                Map paramMap2 = new HashMap();
                paramMap2.put("iban", iban);
                paramMap2.put("amount", newAmount);
                jdbcTemplate.update(sql2, paramMap2);
            }
        }
    }

    // http://localhost:8080/bank/transferMoney?from=EE123&to=EE124&amount=100
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("amount") int amount) {

        if (amount >= 0) {
            String sql = "SELECT balance FROM account WHERE account_nr = :iban";
            Map paramMap = new HashMap();
            paramMap.put("iban", from);
            int fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

            String sql2 = "SELECT balance FROM account WHERE account_nr = :iban";
            Map paramMap2 = new HashMap();
            paramMap2.put("iban", to);
            int toAccountBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

            if (fromAccountBalance >= amount) {
                String sql3 = "UPDATE account SET balance = :amount " +
                        "WHERE account_nr = :iban";
                Map paramMap3 = new HashMap();
                paramMap3.put("iban", from);
                paramMap3.put("amount", fromAccountBalance - amount);
                jdbcTemplate.update(sql3, paramMap3);

                String sql4 = "UPDATE account SET balance = :amount " +
                        "WHERE account_nr = :iban";
                Map paramMap4 = new HashMap();
                paramMap4.put("iban", to);
                paramMap4.put("amount", toAccountBalance + amount);
                jdbcTemplate.update(sql4, paramMap4);
            }
        }
    }
}




