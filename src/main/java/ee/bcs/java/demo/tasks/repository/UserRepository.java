package ee.bcs.java.demo.tasks.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String getUserPassword(String username) {
        String sql = "SELECT password from users where username = :username";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
}
