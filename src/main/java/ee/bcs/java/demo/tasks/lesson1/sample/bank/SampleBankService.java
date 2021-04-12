package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SampleBankService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNumber){
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, 0)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        jdbcTemplate.update(sql, paramMap);
    }
}
