package ee.bcs.java.demo;

import ee.bcs.java.demo.tasks.Lesson1;
import ee.bcs.java.demo.tasks.Lesson1b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson1Test {

    // funktsiooniNimi_sisend_eeldatavVäljund
    @Test
    public void neg_negativeValue_negativeValue(){
        int result = Lesson1b.neg(-4);
    }

    @Test
    public void neg_positiveValue_negativeValue(){
        int result = Lesson1b.neg(4);
    }
}
