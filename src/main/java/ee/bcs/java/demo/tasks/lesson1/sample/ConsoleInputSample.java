package ee.bcs.java.demo.tasks.lesson1.sample;

import java.util.Scanner;

public class ConsoleInputSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palun sisesta number");
        int a = scanner.nextInt();
        double vastus = Math.sqrt(a);
        System.out.println("Ruutjuur " + a + " on " + vastus);
    }
}
