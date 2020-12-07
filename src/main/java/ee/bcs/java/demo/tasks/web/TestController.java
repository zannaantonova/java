package ee.bcs.java.demo.tasks.web;

import ee.bcs.java.demo.tasks.Lesson1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    int savedValue = 0;
    // lesson2/add?x=5
    // siis savedValue5 += 5 ja trüki x välja
    // lesson2/multiply?x=4
    // lesson2/subtract/4

    List elements = new ArrayList();
    public void testList(){
        elements.add(new SampleResult());// Lisa element
        elements.get(0); // Küsi element kohal 0
        elements.remove(0); // eemalda element kohal 0
        elements.set(0, new SampleResult()); // kirjuta üle element kohal 0
    }

    @GetMapping("testing/min")
    public int testing(@RequestParam("a") int a, @RequestParam("b") int b){
        return Lesson1.min(a, b);
    }

    @GetMapping("lesson2/add")
    public int lesson2add(@RequestParam("x") int x){
        savedValue = savedValue + x;
        return savedValue;
    }

    @GetMapping("lesson3")
    public SampleResult lesson3(){
        SampleResult a = new SampleResult();
        a.setStatus("OK");
        a.setMessage("Sõnum");
        System.out.println(a.getMessage());
        return a;
    }

    @GetMapping("employee/{id}")
    public String test2(@PathVariable("id") Integer employeeId){
        return "See on uus http meetod! " + employeeId;
    }

    @GetMapping("math/max/{a}/{b}")
    public String maxEndpoint(@PathVariable("a") Integer a,
                      @PathVariable("b") Integer b){
        System.out.println("Max väärtus on: " + Lesson1.max(a, b));
        return "Max väärtus on: " + Lesson1.max(a, b);
    }

    @GetMapping("math/min/{pathVariableA}/{pathVariableB}")
    public int min(
            @PathVariable("pathVariableA") int a,
            @PathVariable("pathVariableB") int b){
        return Lesson1.min(a, b);
    }

    @GetMapping("math/max")
    public String max3(@RequestParam("aKey") int a,
                    @RequestParam("bKey") int b,
                    @RequestParam("cKey")int c){
        return "See on kõige suurem arv: " + Lesson1.max(a, b, c);
    }
}
