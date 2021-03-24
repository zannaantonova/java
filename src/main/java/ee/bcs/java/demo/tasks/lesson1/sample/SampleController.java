package ee.bcs.java.demo.tasks.lesson1.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("sample/test")
    public EmployeeDto getSampleEmployee(){
        EmployeeDto employee = new EmployeeDto();
        employee.setFirstName("Siim");
        employee.setLastName("Rebane");
        return employee;
    }
}
