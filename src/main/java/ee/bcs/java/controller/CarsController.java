package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarsController {
    private List<Cars> autod = new ArrayList<>();

    //http://localhost:8080/auto
    @PostMapping("auto")
    public String registerAuto(@RequestBody List<Cars> auto) {
        autod.addAll(auto);
        return "autod on lisatud";
    }

    //http://localhost:8080/auto
    @GetMapping("auto")
    public List<Cars> getAllAutod() {
        return autod;
    }

    //http://localhost:8080/auto/1
    @DeleteMapping("auto/{index}")
    public String deleteAuto(@PathVariable("index") int index){
        autod.remove(index);
        return "kustutatud";
    }

    //http://localhost:8080/auto/1?mudel=Infiniti

    @PatchMapping("auto/{index}")
    public String updateAuto(@PathVariable("index") int index, @RequestBody Cars auto) {
        autod.set(index, auto);
        return "auto andmed on muudetud";
    }

  /*

    [{
        "mudel": "Audi a4",
                "regnr": "333AAA",
                "lepingunr": 444
    },
    {
        "mudel": "MB",
            "regnr": "001GFD",
            "lepingunr": 123
    }]
   */

}
