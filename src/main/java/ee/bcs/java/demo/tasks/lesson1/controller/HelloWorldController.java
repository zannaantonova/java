package ee.bcs.java.demo.tasks.lesson1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("test")
    public String helloWorld(){
        return "Hello World";
    }
}
