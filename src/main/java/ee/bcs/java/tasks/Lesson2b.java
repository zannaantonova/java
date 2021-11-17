package ee.bcs.java.tasks;

public class Lesson2b {

    public static void main(String[] args) {
        evenNumbers(3);
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    /*public static int[] reverseArray(int[] inputArray) {
        int[] a = new int[inputArray.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = inputArray[a.length-i-1];
        }
        return a;
    }*/

    public static int[] reverseArray(int[] inputArray) {

        for (int i = 0; i < inputArray.length / 2; i++) {
            int tmp = inputArray[i];
            inputArray[i] = inputArray[inputArray.length - i - 1];
            inputArray[inputArray.length - i - 1] = tmp;
        }

        return inputArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu (n >= 0)
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {

        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i * 2;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                array[i / 2 - 1] = i;
            }
        }

        return array;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) {
        int tmp = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] < tmp) {
                tmp = x[i];
            }
        }
        return tmp;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int tmp = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] > tmp) {
                tmp = x[i];
            }
        }
        return tmp;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int tmp = 0;
        for (int i = 0; i < x.length; i++) {
            tmp = x[i] + tmp;
        }
        return tmp;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        return;
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        return 0;
    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 1 ja 10 puhul on vastus 20

    public static int sequence3n(int x, int y) {
        return 0;
    }


}
