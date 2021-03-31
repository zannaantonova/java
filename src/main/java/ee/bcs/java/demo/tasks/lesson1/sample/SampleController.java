package ee.bcs.java.demo.tasks.lesson1.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("sample")
@RestController
public class SampleController {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private List<EmployeeDto> employees = new ArrayList<>();

    @GetMapping("test")
    public List<EmployeeDto> getSampleEmployee(){
        return employees;
    }

    @PostMapping("test")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employee){
        employees.add(employee);
        return employee;
    }

    @GetMapping("database-insert-test")
    public void insertAccount(@RequestParam("accountNr") String accountNr){
        String sql = "INSERT INTO account (account_number, balance) " +
                "VALUES (:sqlAccountNr, 55)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccountNr", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("database-get-test")
    public Integer getAccount(){
        String sql = "SELECT count(*) FROM account";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}
