package ee.bcs.java.demo.controller.lesson7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("math")
@RestController()
public class MathController {

    // TODO, loo endpoint, mis sisaldaks GET teenuseid
    // *multiply (korruta 2 arvu)
    // *divide (jaga 2 arvu)
    // *abs (tagasta absoluut väärtus)
    // *min (tagasta 2-st arvust kõige väiksem)
    // *max (tagasta 2-st arvust kõige suurem)

    // http://localhost:8080/math/multiply?v1=2&v2=2
    @GetMapping("multiply")
    public BigDecimal multiply(@RequestParam("v1") BigDecimal v1, @RequestParam("v2") BigDecimal v2){
        return v1.multiply(v2);
    }



}
