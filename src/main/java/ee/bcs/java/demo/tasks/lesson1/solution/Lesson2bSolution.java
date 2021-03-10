package ee.bcs.java.demo.tasks.lesson1.solution;

import java.util.Arrays;

public class Lesson2bSolution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray(12)));
    }
    // TODO trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static void exercise1(int n){
        for(int i = 1; i <= n; i++){
            System.out.println(i);
        }
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray(){
        return new int[]{1, 2, 3, 4, 5};
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray2(){
        int[] x = new int[5];
        x[0] = 1;
        x[1] = 2;
        x[2] = 3;
        x[3] = 4;
        x[4] = 5;
        return x;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n){
        int[] array = new int[n];
        for(int i = 1; i <= n; i++){
            array[i-1] = i;
        }
        return array;
    }
}
