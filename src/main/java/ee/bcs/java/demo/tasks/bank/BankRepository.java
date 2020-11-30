package ee.bcs.java.demo.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String iban) {
        String sql = "INSERT INTO account (account_nr, balance) " +
                "VALUES (:accountNr, 0)";
        Map paramMap = new HashMap<>();
        paramMap.put("accountNr", iban);
        jdbcTemplate.update(sql, paramMap);
    }

    public int getAccountBalance(String iban) {
        String sql = "SELECT balance FROM account WHERE account_nr = :iban";
        Map paramMap = new HashMap();
        paramMap.put("iban", iban);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void updateBalance(int newBalance, String iban) {
        String sql2 = "UPDATE account SET balance = :amount " +
                "WHERE account_nr = :iban";
        Map paramMap2 = new HashMap();
        paramMap2.put("iban", iban);
        paramMap2.put("amount", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }
}
