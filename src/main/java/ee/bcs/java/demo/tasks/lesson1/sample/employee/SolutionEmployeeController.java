package ee.bcs.java.demo.tasks.lesson1.sample.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("solution")
@RestController
public class SolutionEmployeeController {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("employee")
    public List<SolutionEmployee> getEmployees(){
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new HashMap<>(), new SolutionEmployeeRowMapper());
    }

    @GetMapping("employee/{id}")
    public SolutionEmployee getEmployee(@PathVariable("id") int id){
        String sql = "SELECT first_name FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcTemplate.queryForObject(sql, paramMap, new SolutionEmployeeRowMapper());
    }

    @PutMapping("employee/{id}")
    public void updateEmployee(@RequestBody SolutionEmployee employee, @PathVariable("id") int id){
        String sql = "UPDATE employee SET first_name = :firstName, last_name=:lastName WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", employee.getFirstName());
        paramMap.put("lastName", employee.getLastName());
        paramMap.put("id", id);
        jdbcTemplate.update(sql, paramMap);
    }

    @PostMapping("employee")
    public void insertEmployee(@RequestBody SolutionEmployee employee){
        String sql = "INSERT INTO employee (first_name, last_name) VALUES (:firstName, :lastName)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", employee.getFirstName());
        paramMap.put("lastName", employee.getLastName());
        jdbcTemplate.update(sql, paramMap);
    }

    @DeleteMapping("employee/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        String sql = "DELETE FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbcTemplate.update(sql, paramMap);
    }
}
