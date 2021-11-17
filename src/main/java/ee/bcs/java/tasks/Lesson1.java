package ee.bcs.java.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Sisesta number millist funktsiooni tahad käivitada:");
            System.out.println("1 on min");
            System.out.println("2 on max");
            System.out.println("3 on absoluut");
            System.out.println("4 on paaris arv");
            System.out.println("5 on min3");
            System.out.println("6 on max3");
            System.out.println("7 on tekst");
            System.out.println("0 kui soovid väljuda");


            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("sisesta a:");
                int a1 = in.nextInt();
                System.out.println("sisesta b: ");
                int b1 = in.nextInt();
                System.out.println("Min on: ");
                System.out.println(min(a1, b1));
            } else if (choice == 2) {
                System.out.println("sisesta a:");
                int a2 = in.nextInt();
                System.out.println("sisesta b: ");
                int b2 = in.nextInt();
                System.out.println("Max on: " + max(a2, b2));
            } else if (choice == 3) {
                System.out.println("sisesta number: ");
                int a3 = in.nextInt();
                System.out.println("Selle absoluutarv on: ");
                System.out.println(abs(a3));
            } else if (choice == 4) {
                System.out.println("sisesta number: ");
                int a4 = in.nextInt();
                System.out.println("Kas on paaris? Vastus on: ");
                System.out.println(isEven(a4));
            } else if (choice == 5) {
                System.out.println("sisesta number a: ");
                int a5 = in.nextInt();
                System.out.println("sisesta number b: ");
                int b5 = in.nextInt();
                System.out.println("sisesta number c: ");
                int c5 = in.nextInt();
                System.out.println("Nende kolme numbri min on: ");
                System.out.println(min3(a5, b5, c5));
            } else if (choice == 6) {
                System.out.println("sisesta number a: ");
                int a6 = in.nextInt();
                System.out.println("sisesta number b: ");
                int b6 = in.nextInt();
                System.out.println("sisesta number c: ");
                int c6 = in.nextInt();
                System.out.println("Nende kolme numbri max on: ");
                System.out.println(max3(a6, b6, c6));
            } else if (choice == 7) {
                System.out.println(someString());
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Tundmatu ülesande nr");
            }

        }
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {

        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {

        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv > kõige suurem number, kui on miinus, siis võtame seda maha, a la 5 ja -5 on mõlematel 5
    public static int abs(int a) {
        if (a > 0) {
            return a;
        } else {
            return a * -1;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a >= b && c >= b) {
            return b;
        } else if (b >= c && a >= c) {
            return c;
        } else {
            return a;
        }

    }

    // TODO tagasta kolmest arvust kõige suurem

    //return max(a, max(b, c)) > nagu variant kasutada sellist variant

    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        return "\"\\\"\\\\\"\"";
    }

}
