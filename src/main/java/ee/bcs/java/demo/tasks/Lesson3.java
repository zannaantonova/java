package ee.bcs.java.demo.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Lesson3 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(fibonacci1(6));
    }

    // TODO
    // Fibonacci arv on defineeritud kui
    // fib(n) = fib(n-1) + fib(n-2)
    // Näiteks: 0 1 1 2 3 5 8 13 ...
    // leia nii mitmes arv fibonacci jadas
    // lahenda iteratiivselt
    private static int fibonacci1(int nr) {
        if (nr < 1){
            return 0;
        } else if (nr == 1){
            return  1;
        }
        int eelmine = 1;
        int eelmine2 = 0;
        for(int i = 2; i <= nr; i++){
            int uus = eelmine + eelmine2;
            eelmine2 = eelmine;
            eelmine = uus;
        }
        return eelmine;
    }

    // TODO
    // leia nii mitmes arb fibonacci jadas
    // lahenda rekursiivselt
    private static int fibonacci2(int nr) {
        return 0;
    }

    // TODO Prindi välja faili iga teine täht
    public static void readFromFile() throws FileNotFoundException {
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }

    // TODO tagasta sisestatud String s tagurpidi
    // Näiteks
    // Sisend = "Tere" / Väljund = "ereT"
    public String reverse(String s){
        return "";
    }
}
