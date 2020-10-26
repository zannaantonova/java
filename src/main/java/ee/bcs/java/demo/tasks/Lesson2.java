package ee.bcs.java.demo.tasks;

import java.util.Scanner;

// TODO, lisa siia klassi eelmises tunnis tehtud abs() meetod
// TODO anna konsoolilt sisseloetud number funktsioonile ette ja prindi välja väljund
public class Lesson2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(abs(n));
    }

    // Leia arvu absoluutväärtus
    public static int abs(int x) {
        if (x >= 0) {
            return x;
        } else {
            return -x;
        }
    }

    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    private static void calculateArray(int x) {

    }

    // TODO loe konsoolist sisse 10 täisarvu
    // TODO trüki varem sisestatud arvud välja vastupidises järiekorras
    private static void reverseOrder(){

    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrg
    // näiteks x = 3 y = 3
    // väljund:
    // 1 2 3
    // 2 4 6
    // 3 6 9
    private static void multiplyingTable(int x, int y){
        System.out.println("asd"); // paneb rea lõppu tühja rea
        System.out.print("asd"); // ei pane tühja rida
    }
}
