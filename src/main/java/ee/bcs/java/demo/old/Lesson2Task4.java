import java.util.Scanner;

public class Lesson2Task4 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Sisesta x: ");
        int x = in.nextInt();
        System.out.println("Sisesta x: ");
        int y = in.nextInt();
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrg
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        for(int j = 1; j <= y; j++){
            for(int i = 1; i <= x; i++){
                System.out.print(i*j + " ");
            }
            System.out.println("");
        }
    }
}
