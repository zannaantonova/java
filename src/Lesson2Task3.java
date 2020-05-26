import java.util.Scanner;

public class Lesson2Task3 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        // TODO loo 10 elemendile täisarvude massiv
        int[] massiiv = new int[10];
        // TODO loe sisse konsoolist 10 täisarvu
        for (int i = 0; i < 10; i++){
            massiiv[i] = in.nextInt();
        }
        // TODO trüki arvud välja vastupidises järiekorras
        for (int i = 9; i >= 0; i--){
            System.out.println(massiiv[i]);
        }
    }
}
