package ee.bcs.java.demo.tasks;

import java.util.*;

public class Lesson3b {

    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }

    private static void test(Map<String, String> testMap) {
        testMap.put("test", "test");
    }

    public static int uusSumma(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        return 0;
    }

    public static int sum(int[] x){
        // Todo liida kokku kõik numbrid massivis x
        System.out.println("Tere");
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
        String a = "1";
        int b = Integer.parseInt(a);
        return 0;
    }

    public static int factorial(int x) {
        if(x <= 1){
            return 1;
        }
        return x * factorial(x - 1);
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        return new int[0];
    }

    public static boolean isPrime(int x){
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        return false;
    }

}
