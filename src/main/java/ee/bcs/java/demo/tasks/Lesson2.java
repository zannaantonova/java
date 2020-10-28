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

    private static void sampleTest(){
        for(int i = 0; i < 10; i = i + 1){
            System.out.println(i);
        }
    }

    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend x = 5
    // Väljund 2 4 6 8 10
    private static void calculateArray(int x) {

    }

    // TODO loe konsoolist sisse 4 täisarvu
    // TODO trüki varem sisestatud arvud välja vastupidises järiekorras
    private static void reverseOrder(){
        Scanner scanner = new Scanner(System.in);
        // TODO 1 defineeri massiiv milles on 4 täisarvu
        // TODO 2 loo for tsükkel, loe 4 täisarvu kasutades scanner.nextInt()
        // TODO 3 loo for tsükkel, loe 4 täisarvu ja täida massiiv nendega
        // TODO 4  prindi välja massiivist numbrid vastupidises järeikorras
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
