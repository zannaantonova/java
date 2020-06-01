import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Lesson4Task1 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1.89);
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820345 / 15 ) + 4 )
        BigDecimal uusMuutuja = b.divide(c, RoundingMode.HALF_UP);
        System.out.println(uusMuutuja);
        uusMuutuja = uusMuutuja.add(BigDecimal.valueOf(4));
        System.out.println(uusMuutuja);
        uusMuutuja = uusMuutuja.multiply(a);
        System.out.println(uusMuutuja);
        a.divide(a);
        a.add(a);

        float a2 = 1.89f;
        int a3 = 11;
        System.out.println(a2*a3);
    }
}
