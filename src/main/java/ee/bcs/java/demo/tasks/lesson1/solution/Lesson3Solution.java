package ee.bcs.java.demo.tasks.lesson1.solution;

import java.util.HashMap;
import java.util.Map;

public class Lesson3Solution {

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String result = "";
        for (int i = a.length(); i > 0; i--) {
            result += a.substring(i - 1, i);  // Hello World
        }
        return result;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] > a[i]) {
                    int tmp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = tmp;
                }
            }
        }
        return a;
    }

    // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
    public static int evenFibonacci(int x) {
        // 0 1 1 2 3 5 8
        if (x < 2) {
            return 0;
        }
        int a = 1;
        int b = 1;
        int sum = 0;
        while (a + b <= x) {
            int uusNr = a + b;
            a = b;
            b = uusNr;
            if (uusNr % 2 == 0) {
                sum += uusNr;
            }
        }
        return sum;
    }

    // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
    // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
    public static String morseCode(String text) {
        Map<String, String> morseMap = new HashMap<>();
        morseMap.put("e", ".");
        morseMap.put("h", "....");
        morseMap.put("l", ".-..");
        morseMap.put("o", "---");
        morseMap.put("s", "...");

        String result = "";
        for (int i = 0; i < text.length(); i++) {
            String x = text.substring(i, i + 1);
            if (result.length() > 0) {
                result += " ";
            }
            result += morseMap.get(x);
        }

        return result;
    }
}
