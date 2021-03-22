package ee.bcs.java.demo.tasks.lesson1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController2 {

    // http://localhost:8080/employee/4
    @GetMapping("employee/{id}")
    public String helloWorld(@PathVariable("id") Integer employeeId){
        return "Hello World " + employeeId ;
    }

    // http://localhost:8080/employee?employeeId=6&testId=425342
    @GetMapping("employee")
    public String test(@RequestParam("employeeId") Integer a,
                       @RequestParam("testId") Integer b){
        return a + " " + b;
    }
}
