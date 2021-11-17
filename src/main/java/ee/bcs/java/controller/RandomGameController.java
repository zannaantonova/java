package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.desktop.AboutEvent;
import java.util.Random;

@RestController
public class RandomGameController {
    Random random = new Random();
    int i = random.nextInt(100);
    int count = 0;

    //http://localhost:8080/guess-number?nr=54
    @GetMapping("guess-number")
    public String guess(@RequestParam("nr") int nr) {
        count ++;
        if (nr >= 0 && nr <= 99 && nr == i) {
            i = random.nextInt(100);
            int tmp = count;
            count = 0;
            return "väga tubli oled! Kokku katseid "+ tmp;
        } else if (nr >= 0 && nr <= 99 && i < nr) {
            return "otsitav number on väiksem";
        } else if (nr >= 0 && nr <= 99 && i > nr) {
            return "otsitav number on suurem";
        } else {
            return "otsitav number on vale";
        }

    }

    //http://localhost:8080/guess-numberP/56
    @GetMapping("guess-numberP/{nrp}")
    public String guessP(@PathVariable("nrp") int nrp) {
        count ++;
        if (nrp >= 0 && nrp <= 99 && nrp == i) {
            return "väga tubli oled! Kokku katseid "+ count;
        } else if (nrp >= 0 && nrp <= 99 && i < nrp) {
            return "otsitav number on väiksem";
        } else if (nrp >= 0 && nrp <= 99 && i > nrp) {
            return "otsitav number on suurem";
        } else {
            return "otsitav number on vale";
        }

    }
}