package ee.bcs.java.demo.tasks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTestController {

    @GetMapping("json/test")
    public JsonMessage jsonTest(){
        JsonMessage jsonMessage = new JsonMessage();
        jsonMessage.name = "John";
        jsonMessage.address = "USA";
        return jsonMessage;
    }

    @PostMapping("json/test")
    public void samplePost(@RequestBody LoginRequest request){
        System.out.println(request.username);
        System.out.println(request.password);
    }
}
