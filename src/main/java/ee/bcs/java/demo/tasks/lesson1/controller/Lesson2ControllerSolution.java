package ee.bcs.java.demo.tasks.lesson1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2ControllerSolution {

    @GetMapping("solution/lesson2/table")
    public int[][] getTable(@RequestParam("x") int x,
                         @RequestParam("y") int y) {
        int[][] result2 = new int[x][y];
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                result2[i-1][j-1] = i * j;
            }
        }
        return result2;
    }
}
