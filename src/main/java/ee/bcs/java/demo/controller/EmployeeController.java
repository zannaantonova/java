package ee.bcs.java.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("employee")
@RestController
public class EmployeeController {

    private static List<Employee> employeeList = new ArrayList<>();

    @GetMapping("")
    public List<Employee> getEmployees() {
        return employeeList;
    }

    @PostMapping("")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeList.get(id);
    }

    @PutMapping("{id}")
    public Employee getEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
        employeeList.set(id, employee);
        return employee;
    }

    @DeleteMapping("{id}")
    public Employee deleteEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeList.get(id);
        employeeList.remove(id.intValue());
        return employee;
    }
}
