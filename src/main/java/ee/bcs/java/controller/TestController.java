package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {


    //http://localhost:8080/hello-world?name=Siim
    @GetMapping("hello-world")
    public String helloWorld(@RequestParam("name") String firstname) {
        return "Hello " + firstname;
    }

    //http://localhost:8080/lesson1/min?a=222&b=9
    @GetMapping("lesson1/min")
    public int min(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.min(a, b);
    }

    //http://localhost:8080/lesson1/max?a=222&b=9
    @GetMapping("lesson1/max")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.max(a, b);
    }

    //http://localhost:8080/lesson1/abs?a=-1
    @GetMapping("lesson1/abs")
    public int abs(@RequestParam("a") int a) {
        return Lesson1.abs(a);
    }

    //http://localhost:8080/lesson1/isEven?a=3
    @GetMapping("lesson1/isEven")
    public boolean isEven(@RequestParam("a") int a) {
        return Lesson1.isEven(a);
    }

    //http://localhost:8080/lesson1/max3?a=3&b=4&c=5
    @GetMapping("lesson1/max3")
    public int max3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.max3(a, b, c);
    }

    //http://localhost:8080/lesson1/min3?a=3&b=4&c=5
    @GetMapping("lesson1/min3")
    public int min3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.min3(a, b, c);
    }

    //http://localhost:8080/lesson1/somestring?
    @GetMapping("lesson1/somestring")
    public String someString() {
        return Lesson1.someString();
    }

    //http://localhost:8080/dtoMapping
    //http://localhost:8080/dtoMapping?name=John&aadress=USA
    @GetMapping("dtoMapping")
    public List<ClietDyo> dtoTest(@RequestParam("name") String name, @RequestParam("aadress") String aadress, @RequestParam(value = "age", required = false) Integer age) {
        //ClietDyo [] result = new ClietDyo[2];
        List<ClietDyo> result2 = new ArrayList<>();
        //result2.add(client);>lisab 1 juurde
        //result2(set (1, client);>kirjutab olemasoleva juurde
        //result2.get(1);>array[1]
        //result2.remove(1);>kustutab elemendi indeksil 1

        ClietDyo client = new ClietDyo();
        client.setName(name);
        client.setAadress(aadress);
        client.setAge(age);
        //result[0] = client;
        result2.add(client);

        ClietDyo client2 = new ClietDyo();
        client.setName("JOhn Smith");
        client.setAadress("Estonia");
        client.setAge(44);
        //result[1] = client2;
        result2.add(client2);

        return result2;

    }

}


