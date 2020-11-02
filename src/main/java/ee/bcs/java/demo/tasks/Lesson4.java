package ee.bcs.java.demo.tasks;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Lesson4 {
    // TODO arvuta kasutades BigDecimali 1.89 * ((394486820345 / 15 ) + 4 )
    public static void yl1(String[] args) {
        BigDecimal a = new BigDecimal(1.89);
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");
    }

    public static void yl2(){
        // TODO loo float muutuja ja väärtusta see 1.89
        // TODO korruta see läbi täisarvuga 11
        // TODO trüki tulemus välja
        // TODO nüüd tee seda kasutades klassi BigDecimal ja võrdle tulemust
    }

    /* TODO all olev on näidis, loo uus klass selle ülesande jaoks
     * Loo uus klass ruut
     * ruudu kontstruktor peab vastu võtma x ja y kordinaadi ning külje pikkuse.
     * objektil peab olema meetod pindala, mis tagastab ruudu pindala
     */
}
