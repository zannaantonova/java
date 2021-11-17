package ee.bcs.java.tasks;

import java.util.Arrays;

public class LessonA {
    public static int e1(int a) {
        // tagasta vastasmärgiline arv

        return -a;
    }

    public static int e2(int a, int b) {
        // tagasta kahe arvu keskmine
        return (a + b) / 2;
    }

    public static int e3(int x) {
        // lahuta sisendist 5 ja siis korruta 99
        return (x - 5) * 99;
    }

    public static int e4(int a1, int b1, int a2, int b2, int a3, int b3) {
        // korruta a1 b1-ga, a2 b2-ga jne. Ning siis liida saadud numbrid
        return (a1 * b1) + (a2 * b2) + (a3 * b3);
    }

    public static int e5() {
        // return the answer to the Life, the Universe, and Everything.
        return 42;
    }

    public static boolean e6(int x) {
        // Kas arv on liigaasta
        // Wikipeediast:
        // Iga aasta, mis jagub neljaga, on liigaasta (kui ta samal ajal ei jagu sajaga). Kui aasta jagub sajaga ja ei jagu neljasajaga siis ta ei ole liigaasta. Aasta, mis jagub neljasajaga, on alati liigaasta.
        //See tähendab näiteks, et aastad 1984 ja 2000 olid liigaastad, 1900 aga mitte.


        if (x % 4 == 0 && x % 100 != 0) {
            return true;
        } else if (x % 100 == 0 && x % 400 != 0) {
            return false;
        } else if (x % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean e7(boolean x) {
        // tagasta x-i vastand väärtus
        //saab teha nii, et return !x;

        if (x == true) {
            return false;
        } else {
            return true;
        }
        // return !x;
    }

    public static boolean e8(boolean x1, boolean x2) {
        // tagasta true kui ainult 1 sisend muutujatest on true

        if (x1 == true && x2 == true) {
            return false;
        } else if (x1 != true && x2 != true) {
            return false;
        } else if (x1 == true && x2 == false) {
            return true;
        } else if (x1 != true && x2 != false) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean e9(boolean x1, boolean x2, boolean x3, boolean x4) {
        // tagasta true kui paaritu arv sisend muutujatest on true. int count muutuja
        //nagu variant XOR renturn x1 ^ x2 ^ x3 ^ x4;
        int count = 0;
        if (x1 == true) {
           count = count + 1;
        }
        if (x2 == true) {
           count = count + 1;
        }
        if (x3 == true) {
           count = count + 1;
        }
        if (x4 == true) {
            count = count + 1;
        }
        //saab ka nüüd panna return count % 2 == 1;

        if (count == 1 || count == 3) {
            return true;
        } else {
            return false;
        }
    }

    public static void e10(int x[]) {
        // muuda sisend massiivi nii et kõik elemendid oleksid 2x suuremad
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] * 2;
        }
        System.out.println(x);

    }

    public static void e11(int x[]) {
        // määra sisend massiivi teine element (index 1) 0-iks
        x[1] = 0;
    }

    public static void e12(int x[]) {
        // vaheta massiivi esimene ja teine element omavahel
        //oluline, et peale muutuja kirjeldamist peaks andma väärtuse sellele, mida muutsid.
        int tmp = x[0];
        x[0] = x[1];
        x[1] = tmp;
    }

    public static void e13(int x[]) {
        // määra massiivi teise elemendi väärtuseks sama mis esimesel elemendil
        x[1] = x[0];
    }

    public static void e14(int x[]) {
        // määra massiivi teise elemendi väärtuseks sama mis esimesel elemendil
        // määra massiivi neljanda elemendi väärtuseks sama mis kolmandal elemendil
        // määra massiivi kuuenda elemendi väärtuseks sama mis viiendal elemendil
        // määra massiivi kaheksanda elemendi väärtuseks sama mis seitsmendal elemendil
        x[1] = x[0];
        x[3] = x[2];
        x[5] = x[4];
        x[7] = x[6];
    }

    public static void e15(int x[]) {
        // määra iga teine (indeksid 1, 3, jne) element massiivis samaks, mis oli talle eelnenud elemendi väärtus
        //for (int i = 0; i < x.length; i++) {
        //    if (i % 2 == 1) {
        //        x[i] = x[i - 1];
        //    } else {
        //        x[i] = x[i];
        //    }
        //}
        for (int i = 1; i < x.length; i = i+2) {
                x[i] = x[i-1];
            }
        System.out.println(x);
    }

}
