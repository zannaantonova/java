package ee.bcs.java.demo.tasks.lesson1.solution;

import java.util.Random;
import java.util.Scanner;

public class Lesson3HardSolution {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int count = 0;

        while(true){
            count ++;
            System.out.println("Arva number 0-99");
            int quess = scanner.nextInt();
            if (quess == randomNumber) {
                System.out.println("Arvasid õigesti");
                System.out.println("Arvasid kokku " + count + " korda");
                break;
            } else if (quess < randomNumber) {
                System.out.println("Number oli liiga väike");
            } else {
                System.out.println("Number oli liiga suur");
            }
        }
    }
}
