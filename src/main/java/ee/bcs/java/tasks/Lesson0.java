package ee.bcs.java.tasks;

import java.util.Scanner;

public class Lesson0 {
    public static void main(String[] args) {
        Scanner todo = new Scanner(System.in);
        System.out.println("Kas tahad *?");
        System.out.println("Kas tahad /?");
        System.out.println("Kas tahad +?");
        System.out.println("Kas tahad -?");
        System.out.println("Kas tahad %?");
        String choice = todo.next();
        if (choice.equals("*")) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("sisesta b: ");
            int b = todo.nextInt();
            System.out.println("korrutame: " + (a * b));
        }
        else if (choice.equals("/")) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("sisesta b: ");
            int b = todo.nextInt();
            System.out.println("jagame: " + (a / b));
        }
        else if (choice.equals("+")) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("sisesta b: ");
            int b = todo.nextInt();
            System.out.println("liidame: " + (a + b));
        }
        else if (choice.equals("'-'")) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("sisesta b: ");
            int b = todo.nextInt();
            System.out.println("lahutame: " + (a - b));
        }
        else if (choice.equals("%")) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("sisesta b: ");
            int b = todo.nextInt();
            System.out.println("jagatise jääk: " + (a % b));
        }
        else {
            System.out.println("vale tehe");
        }
    }
        // TODO
        //  defineeri 3 muutujat a = 1, b = 1, c = 3
        //  Prindi välja a==b
        //  Prindi välja a==c
        //  Lisa rida a = c
        //  Prindi välja a==b
        //  Prindi välja a==c, mis muutus???
        public static void excersie1 () {

            int a = 1;
            int b = 1;
            int c = 3;
            System.out.println(a == b);
            System.out.println(a == c);
            a = c;
            System.out.println(a == b);
            System.out.println(a == c);


        }

        // TODO
        //  Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
        //  Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
        //  Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
        //  Analüüsi tulemusi
        public static void excersie2 () {

            int x1 = 10;
            int x2 = 20;
            int y1 = ++x1;
            System.out.println(x1);
            System.out.println(y1);
            int y2 = x2++;
            System.out.println(x2);
            System.out.println(y2);


        }

        // TODO
        //  Loo arvulised muutujad
        //  a = 18 % 3
        //  b = 19 % 3
        //  c = 20 % 3
        //  d = 21 % 3
        //  Prindi välja kõigi muutujate väärtused
        public static void excersie3 () {

            int a = 18 % 3;
            int b = 19 % 3;
            int c = 20 % 3;
            int d = 21 % 3;
            System.out.println("a: " + a);
            System.out.println("b: " + b);
            System.out.println("c: " + c);
            System.out.println("d: " + d);

        }
    }
