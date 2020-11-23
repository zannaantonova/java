package ee.bcs.java.demo.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {
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

    public void depositMoney(String iban, Integer amount) {
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

    public void withdrawMoney(String iban, int amount) {
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

    public void transferMoney(String from, String to, int amount) {
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
