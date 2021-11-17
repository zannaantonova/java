package ee.bcs.java.tasks;

import java.util.Scanner;

public class LessonB {

    public static void main(String[] args) {
        // TODO kasuta scannerit nii, et mainist oleks võimalik kõiki meetodeid välja kutsuda
        // Täpselt nii nagu Lesson 1 main meetod

        //selline võib olla kontroll>>>System.out.println(checkOrder(1, 3, -1));


        Scanner todo = new Scanner(System.in);
        System.out.println("Sisesta 1, kui vaatame kolm numbrit võrreldatakse: ");
        System.out.println("Sisesta 2, kui vaatame kolm numbrit on võrdsed: ");
        System.out.println("Sisesta 3, kui soovid kontrollida absoluutarvu võrdlust 1000-ga: ");
        int valik = todo.nextInt();
        if (valik == 1) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("sisesta b: ");
            int b = todo.nextInt();
            System.out.println("sisesta c: ");
            int c = todo.nextInt();
            System.out.println("võrdlesime ja sisestatud numbrid on: " + checkOrder(a, b, c));
        } else if (valik == 2) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("sisesta b: ");
            int b = todo.nextInt();
            System.out.println("sisesta c: ");
            int c = todo.nextInt();
            System.out.println("kas sisestatud numbrid on võrdsed omavahel? vastus: " + checkEqual(a, b, c));
        } else if (valik == 3) {
            System.out.println("sisesta a: ");
            int a = todo.nextInt();
            System.out.println("kas sisestatud numbri absoluutarv on väiksem kui 1000? vastus: " + isSmall(a));
        } else {
            System.out.println("vale nr");
        }
    }

    public static String checkOrder(int a, int b, int c) {
        // Print "increasing" if c > b > a
        // Print "decreasing" if c < b < a
        // Print "neither" if none of them is true

        if (c > b && b > a) {
            return "increasing";
        } else if (c < b && b < a) {
            return "decreasing";
        } else {
            return "neither";
        }
    }

    public static boolean checkEqual(int a, int b, int c) {
        // return true if all 3 parameters are the same
        if (a == b && b == c && a == c) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSmall(int a) {
        // return true if the absolute number of a is smaller than 1000
        if (a < 1000 && a > -1000) {
            return true;
        } else {
            return false;
        }
    }
}

