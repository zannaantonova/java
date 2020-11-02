package ee.bcs.java.demo.tasks;

import java.util.Scanner;

// TODO, lisa siia klassi eelmises tunnis tehtud abs() meetod
// TODO anna konsoolilt sisseloetud number funktsioonile ette ja prindi välja väljund
public class Lesson2 {
    public static void main(String[] args) {
        multiplyingTable(5, 5);
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
        for(int i = 1; i <= x; i++){
            System.out.println(i*2);
        }
        for(int i = 2; i <= x*2; i = i + 2){
            System.out.println(i);
        }
        for(int i = 1; i <= x*2; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }

    // TODO loe konsoolist sisse 4 täisarvu
    // TODO trüki varem sisestatud arvud välja vastupidises järiekorras
    private static void reverseOrder(){
        Scanner scanner = new Scanner(System.in);
        // TODO 1 defineeri massiiv milles on 4 täisarvu
        int[] a = new int[4];
        // TODO 2 loo for tsükkel, loe 4 täisarvu kasutades scanner.nextInt()
        for(int i = 0; i < 4; i++){
            a[i] = scanner.nextInt();
        }
        // TODO 3 täienda tsüklit, täida massiiv sisse loetud numbritega
        // TODO 4  prindi välja massiivist numbrid vastupidises järeikorras
        for (int i = 3; i >= 0; i--){
            System.out.println(a[i]);
        }
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrg
    // näiteks x = 3 y = 3
    // väljund:
    // 1 2 3
    // 2 4 6
    // 3 6 9
    private static void multiplyingTable(int x, int y){
        //System.out.println("asd"); // paneb rea lõppu tühja rea
        //System.out.print("asd"); // ei pane tühja rida

        // TODO 1 Kirjuta kood mis trükib numbrid 1st x-ini
        for(int j = 1; j <=y; j++){
            for(int i = 1; i <= x; i++){
                System.out.print(i + " ");
            }
        }
        // TODO 2 Tee tsükkel nii, et kood trükiks välja eelmist rida y korda
        // TODO 3 Vormista väljund tabeliks kasutades print ja println käeske
        // TODO 4 Mõtle mida peaks tegema, et ülejäänud read ka õigeks muutuks
    }
}
