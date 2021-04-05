package ee.bcs.java.demo.tasks.lesson1.controller.employee;

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
    public List<String> getEmployees(){
        String sql = "SELECT first_name FROM employee";
        return jdbcTemplate.queryForList(sql, new HashMap<>(), String.class);
    }

    @GetMapping("employee/{id}")
    public String getEmployee(@PathVariable("id") int id){
        String sql = "SELECT first_name FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        String firstName = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return firstName;
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
