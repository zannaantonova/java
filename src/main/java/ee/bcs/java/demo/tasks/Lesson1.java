package ee.bcs.java.demo.tasks;

import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        System.out.println("Min funktsioon. Sisesta 2 väärtust");
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(min(a, b));
        System.out.println("Abs funktsioon. Sisesta 1 väärtus");
        a = in.nextInt();
        System.out.println(abs(a));
        System.out.println("Neg funktsioon. Sisesta 1 väärtus");
        a = in.nextInt();
        System.out.println(neg(a));
        System.out.println("closestToZero funktsioon. Sisesta 1 väärtus");
        a = in.nextInt();
        b = in.nextInt();
        int c = in.nextInt();
        System.out.println(closestToZero(a, b, c));
        System.out.println("isNumberEven funktsioon. Sisesta 1 väärtus");
        a = in.nextInt();
        System.out.println(isNumberEven(a));
        System.out.println("seq3n funktsioon. Sisesta 1 väärtus");
        a = in.nextInt();
        System.out.println(seq3n(a));
        System.out.println("max funktsioon. Sisesta 2 väärtust");
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(max(a, b));*/
        System.out.println(closestTo(3, new int[] {2, -5, 2, 6, 8, 4}));
    }

    // leia 2 arvu miinimum väärtus
    // Näited:
    // min (3, 5) = 3
    // min (-3, 8) = -3
    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    // TODO: Leia arvu absoluutväärtus
    // Näited:
    // abs(3) = 3
    // abs(-5) = 5
    public static int abs(int x) {
        if (x >= 0) {
            return x;
        } else {
            return -x;
        }
    }

    // TODO: Luua funktsioon, mis tagastab vastava arvu alati negatiivsena
    // Näited:
    // neg(0) = 0
    // neg(-1) = -1
    // neg(8) = -8
    public static int neg(int x) {
        return -abs(x);
        /*if(x <= 0){
            return x;
        } else {
            return -x;
        }*/
    }

    // TODO: Luua funktsioon mis leiab sisend muutujates numbri mis on kõige lähemal 0-ile
    // Näited
    // (-5, -2, 0) -> 0
    // (2, 3, 4) -> 2
    public static int closestToZero(int a, int b, int c) {
        if (abs(a) <= abs(b) && abs(a) <= abs(c)) {
            return a;
        } else if (abs(b) <= abs(c) && abs(b) <= abs(a)) {
            return b;
        } else {
            return c;
        }
    }

    // TODO: Luua funktsioon, mis tagastab kas a on paaris arv
    // Näited
    // isNumberEven(4) = true
    // isNumberEven(1) = false
    public static boolean isNumberEven(int a) {
        return a % 2 == 0;
    }

    // TODO: Luua funktsioon, mis
    // Juhul kui a on paaris arv, siis jaga sisend 2
    // Juhul kui a on paaritu arv, siis korruta sisend 3 ja liida 1
    public static int seq3n(int a) {
        if (isNumberEven(a)) {
            return a / 2;
        } else {
            return a * 3 + 1;
        }
    }

    // TODO tagasta maksimum väärtus

    /**
     * @param a
     * @param b
     * @return
     */
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta maksimum väärtus
    public static int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= c && b >= a) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta suurim paaris arv
    // Kui kumbki arv ei ole paaris siis tagasta 0
    public static int largestEven(int a, int b) {
        if(isNumberEven(a) && isNumberEven(b)){
            return max(a, b);
        } else if(isNumberEven(a)){
            return a;
        } else if(isNumberEven(b)){
            return b;
        }
        return 0;
    }

    // TODO tagasta suurim paaris arv
    // Kui ükski arv ei ole paaris siis tagasta 0
    public static int largestEven(int a, int b, int c) {
        int maxEvenNumber = Integer.MIN_VALUE;
        if(isNumberEven(a) && a > maxEvenNumber){
            maxEvenNumber = a;
        }
        if (isNumberEven(b) && b > maxEvenNumber) {
            maxEvenNumber = b;
        }
        if(isNumberEven(c) && c > maxEvenNumber) {
            maxEvenNumber = c;
        }
        if(isNumberEven(a) || isNumberEven(b) || isNumberEven(c)){
            return maxEvenNumber;
        } else {
            return 0;
        }
    }

    // int[] test = {2, 5, 6, 7, 8, 9};
    // closestTo(4, test);
    // TODO tagasta listist arv mis on kõige lähem numbrile nr
    public static int closestTo(int nr, int[] numbers) {
        int minDistance = Math.abs(nr - numbers[0]);
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if(Math.abs(nr - numbers[i]) < minDistance){
                minDistance = Math.abs(nr - numbers[i]);
                minIndex = i;
            }
        }
        return numbers[minIndex];
        // TODO 1 | trükkige välja kõik numbers massivis olevad väärtused
        // TODO 2 | trükkge välja kõigi elementide kohta kui kaugel nad on nr
        // TODO 3 | salvestage miinimum number muutujasse
    }
}
