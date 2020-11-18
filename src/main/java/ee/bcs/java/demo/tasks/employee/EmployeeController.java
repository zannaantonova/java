package ee.bcs.java.demo.tasks.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    // Globaalne muutuja
    List<Employee> employeeList = new ArrayList<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/employees/get
    @GetMapping("employees/get")
    public List<Employee> getEmployees(){
        return employeeList;
    }

    //http://localhost:8080/employee/get?id=1
    @GetMapping("employee/get")
    public Employee getEmployee(@RequestParam("id") int id){
        String sql = "SELECT name FROM employee WHERE id = 1";
        String result = jdbcTemplate.queryForObject(sql, new HashMap<>(), String.class);
        return employeeList.get(id);
    }

    // http://localhost:8080/employee/add?name=siim&age=34
    @GetMapping("employee/add")
    public void addEmployee(@RequestParam("name") String name,
                            @RequestParam("age") int age){
        Employee employee = new Employee();
        employee.age = age;
        employee.name = name;
        employeeList.add(employee);
    }

    // http://localhost:8080/employee/update?name=unknown&age=34&id=1
    @GetMapping("employee/update")
    public void updateEmployee(@RequestParam("name") String name,
                               @RequestParam("age") int age,
                               @RequestParam("id") int id){
        Employee employee = employeeList.get(id);
        employee.name = name;
        employee.age = age;
    }

    // http://localhost:8080/employee/delete?id=0
    @GetMapping("employee/delete")
    public void deleteEmployee(@RequestParam("id") int id){
        employeeList.remove(id);
    }
}




