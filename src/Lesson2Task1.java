import java.util.Scanner;

// TODO, lisa siia klassi eelmises tunnis tehtud abs() meetod
// TODO anna konsoolilt sisseloetud number funktsioonile ette ja prindi välja väljund
public class Lesson2Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = abs(n);
        System.out.println(m);
    }

    // Leia arvu absoluutväärtus
    private static int abs(int x) {
        if(x < 0){
            return x * -1;
        } else {
            return x;
        }
    }
}
