package ee.bcs.java.tasks;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decreasingArray(9)));
        System.out.println(Arrays.toString(decreasingArray(3)));
        System.out.println(Arrays.toString(decreasingArray(2)));
        System.out.println(Arrays.toString(decreasingArray(-5)));
        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}


    public static int[] generateArray(int n) {
        int[] a = new int[n];
        for (int y = 0; y < a.length; y++) {
            a[y] = y + 1;
        }
        return a;
    }


    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
        if (n > 0) {
            int[] a = new int[n + 1];
            //todo kui n on positiivne arv
            //a[0]=5; i=0, a.length=6
            //a[1]=4; i=1, a.length=6
            //a[2]=3; i=2, a.length=6
            //a[3]=2; i=3, a.length=6
            //a[4]=1; i=4, a.length=6
            //a[5]=0; i=5, a.length=6
            for (int i = 0; i < a.length; i++) {
                int vastus = n - i;
                a[i] = vastus;
            }
            return a;
        } else {
            int[] a = new int[-n + 1];
            //todo kui negatiivne arv
            //a[0]=-3; i=0, a.length=4
            //a[1]=-2; i=1, a.length=4
            //a[2]=-1; i=2, a.length=4
            //a[3]=0; i=3, a.length=4
            for (int i = 0; i < a.length; i++) {
                a[i] = n + i;
            }
            return a;
        }
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++){
            a[i] = 3;
        }
        return a;
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] a = new int[5];// a [0;0;0;0;0]
        a[0] = 1; // a [1;0;0;0;0]
        a[1] = 2;// a [0;2;0;0;0]
        a[2] = 3;// a [0;0;3;0;0]
        a[3] = 4;// a [0;0;0;4;0]
        a[4] = 5;// a [0;0;0;0;5]
        return a;
    }
}
