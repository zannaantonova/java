package ee.bcs.java.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
    @GetMapping("test2")
    public String test2(String test){
        return "test-template";
    }
}
