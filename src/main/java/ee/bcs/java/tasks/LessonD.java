package ee.bcs.java.tasks;

import java.util.Scanner;

public class LessonD {
    public static void main(String[] args) {

        yl7();
    }

    // Kõiki alljärgnevaid ülesandeid lahenda kasutades tsükleid
    // TODO trüki numbrid 1 -> 10
    public static void yl1() {
        for (int y1 = 1; y1 <= 10; y1++) {
            System.out.println(y1);
        }


    }

    // TODO trüki numbrid 10 -> 1
    public static void yl2() {
        int y2 = 10;
        while (y2 >= 1) {
            System.out.println(y2);
            y2 = y2 - 1;

        }

    }

    // TODO trüki paaris numberid 2->20
    public static void yl3() {
        for (int y3 = 2; y3 <= 20; y3++) {
            if (y3 % 2 == 1) {
                continue;
            }
            System.out.println(y3);
        }
    }

    // TODO trüki numbrid 1 -> n
    public static void yl4(int n) {
        for (int y4 = 1; y4 <= n; y4++) {
            System.out.println(y4);
        }
    }

    // TODO trüki numbrid n -> 1
    public static void yl5(int n) {
        int y5 = n;
        while (y5 >= 1) {
            System.out.println(y5);
            y5 = y5 - 1;
        }
    }

    // TODO trüki paaris numberid 2->n
    public static void yl6(int n) {

        for (int y6 = 2; y6 <= n; y6++) {
            if (y6 % 2 != 0) {
                continue;
            }
            System.out.println(y6);
        }

        int y66 = 1;
        while (y66 <= n) {
            y66 ++;
            if (y66 % 2 == 1) {
                continue;
            }
            System.out.println(y66);

        }
    }

    // TODO kasutades Scannerit loe sisse üks number, korruta see 2-ga ja trüki välja
    // TODO2 kasutades while loopi, tee seda nii kaua kuni kasutaja sisestab 0-i
    public static void yl7() {
        Scanner todo = new Scanner(System.in);
        System.out.println("sisestage number: ");

        while (true) {
            int valik = todo.nextInt();
            System.out.println("vastus on: " + (valik * 2));
            if (valik == 0) {
                break;
            }
        }
    }

    // TODO täienda yl1 main meetodit
    // TODO tee nii, et kasutaja saaks lõputult valida uusi valikuid
    // TODO lisa uus käsklus (exit) valikusse
    // TODO kui kasutaja valib exit käsu siis lõpeta programmi töö
    public static void yl8() {

    }

    // TODO jätka Lesson3Hard
}
