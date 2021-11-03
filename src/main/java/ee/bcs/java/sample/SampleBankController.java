package ee.bcs.java.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SampleBankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/sample/bank2/createAccount?accountNumber=EE123
    @GetMapping("sample/bank2/createAccount")
    public String createAccount(@RequestParam("accountNumber") String accountNumber) {
        String sql = "INSERT INTO account (account_number, balance) VALUES (:sqlAccNo, 0)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccNo", accountNumber);
        jdbcTemplate.update(sql, paramMap);
        return "Konto on loodud";
    }

    // http://localhost:8080/sample/bank2/getBalance?accountNumber=EE123
    @GetMapping("sample/bank2/getBalance")
    public Integer getBalance(@RequestParam("accountNumber") String accountNumber){
        String sql = "SELECT balance FROM account WHERE account_number = :sqlAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccNo", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    // http:localhost:8080/sample/bank2/depositMoney?accountNumber=EE123&amount=100
    @GetMapping("sample/bank2/depositMoney")
    public String depositMoney(@RequestParam("accountNumber") String accountNumber,
                               @RequestParam("amount") int amount) {
        if(amount < 0){
            return "Summa peab olema positiivne number";
        }
        String sql = "SELECT balance FROM account WHERE account_number = :sqlAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccNo", accountNumber);
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        int newBalance = currentBalance + amount;

        String sql2 = "UPDATE account SET balance = :newBalance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("newBalance", newBalance);
        paramMap2.put("accountNumber", accountNumber);
        jdbcTemplate.update(sql2, paramMap2);

        String sql3 = "INSERT INTO transaction (account_number, type, amount) VALUES " +
                "(:accountNumber, :type, :amount)";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("accountNumber", accountNumber);
        paramMap3.put("type", "deposit");
        paramMap3.put("amount", amount);
        jdbcTemplate.update(sql3, paramMap3);
        return "Raha lisamine õnnestus";
    }

    // http:localhost:8080/sample/bank2/withdrawMoney?accountNumber=EE123&amount=100
    @GetMapping("sample/bank2/withdrawMoney")
    public String withdrawMoney(@RequestParam("accountNumber") String accountNumber,
                               @RequestParam("amount") int amount) {
        if(amount < 0){
            return "Summa peab olema positiivne number";
        }
        String sql = "SELECT balance FROM account WHERE account_number = :sqlAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccNo", accountNumber);
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        int newBalance = currentBalance - amount;
        if(newBalance < 0){
            return "Kontol pole piisavalt raha";
        }
        String sql2 = "UPDATE account SET balance = :newBalance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("newBalance", newBalance);
        paramMap2.put("accountNumber", accountNumber);
        jdbcTemplate.update(sql2, paramMap2);

        String sql3 = "INSERT INTO transaction (account_number, type, amount) VALUES " +
                "(:accountNumber, :type, :amount)";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("accountNumber", accountNumber);
        paramMap3.put("type", "withdraw");
        paramMap3.put("amount", amount);
        jdbcTemplate.update(sql3, paramMap3);

        return "Raha välja võtmine õnnestus";
    }

    // http://localhost:8080/sample/bank2/transferMoney?fromAccountNumber=EE123&toAccountNumber=DE123&amount=100
    @GetMapping("sample/bank2/transferMoney")
    public String transferMoney(@RequestParam("fromAccountNumber") String fromAccountNumber,
                                @RequestParam("toAccountNumber") String toAccountNumber,
                                @RequestParam("amount") int amount) {
        if(amount < 0){
            return "Summa peab olema positiivne arv";
        }
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", fromAccountNumber);
        int fromAccountCurrentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        if (fromAccountCurrentBalance < amount) {
            return "Kontol pole piisavalt palju raha";
        }

        String sql2  = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("accountNumber", toAccountNumber);
        int toAccountCurrentBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        int fromAccountNewBalance = fromAccountCurrentBalance - amount;
        int toAccountNewBalance = toAccountCurrentBalance + amount;

        String sql3 = "UPDATE account SET balance = :amount WHERE account_number = :accountNumber";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("amount", fromAccountNewBalance);
        paramMap3.put("accountNumber", fromAccountNumber);
        jdbcTemplate.update(sql3, paramMap3);

        String sql4 = "UPDATE account SET balance = :amount WHERE account_number = :accountNumber";
        Map<String, Object> paramMap4 = new HashMap<>();
        paramMap4.put("amount", toAccountNewBalance);
        paramMap4.put("accountNumber", toAccountNumber);
        jdbcTemplate.update(sql4, paramMap4);

        String sql5 = "INSERT INTO transaction (account_number, type, amount, to_account) VALUES " +
                "(:accountNumber, :type, :amount, :toAccount)";
        Map<String, Object> paramMap5 = new HashMap<>();
        paramMap5.put("accountNumber", fromAccountNumber);
        paramMap5.put("type", "transfer");
        paramMap5.put("amount", amount);
        paramMap5.put("toAccount", toAccountNumber);
        jdbcTemplate.update(sql5, paramMap5);

        return "Raha on ülekantud";
    }

    // http://localhost:8080/sample/bank2/transactionHistory?accountNumber=EE123&from=2021-11-01&to=2021-11-03
    // http://localhost:8080/sample/bank2/transactionHistory?accountNumber=EE123&from=2021-11-01
    @GetMapping("sample/bank2/transactionHistory")
    public List<SampleTransactionDto> getTransactionHistory(
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to
            ){
        String sql = "SELECT * FROM transaction WHERE (account_number = :accountNumber OR to_account = :accountNumber) ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        if (from != null) {
            sql = sql + " AND created >= :from";
            LocalDate fromDate = LocalDate.parse(from);
            paramMap.put("from", fromDate);
        }
        if(to != null){
            sql = sql + "  AND created < :to";
            LocalDate toDate = LocalDate.parse(to);
            paramMap.put("to", toDate.plusDays(1));
        }
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(SampleTransactionDto.class));
    }
}
