package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SampleBankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNumber){
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, 0)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        jdbcTemplate.update(sql, paramMap);
    }

    public double getBalance(String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Double.class);
    }

    public void updateAccountBalance(String accountNumber, double balance){
        String sql2 = "UPDATE account SET balance = :newBalance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("accountNumber", accountNumber);
        paramMap2.put("newBalance", balance);
        jdbcTemplate.update(sql2, paramMap2);
    }

}
