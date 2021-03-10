package ee.bcs.java.demo.tasks.lesson1.solution;

public class Lesson2cSolution {

    public static void main(String[] args) {
        int a = 4;
        int b = 9;
        int c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);
    }

    // TODO
    // trükkida välja numbrid n-ist 0-ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    // Kasuta while loopi
    public static void yl1(int n){
        if(n >= 0){
            while(n >= 0){
                System.out.println(n);
                n--;
            }
        } else {
            while(n <= 0){
                System.out.println(n);
                n++;
            }
        }
    }

    // TODO
    // sama sisu nagu yl1
    // Kasuta for loopi
    public static void yl2(int n){
        if(n >= 0){
            for(;n >= 0; n--){
                System.out.println(n);
            }
        } else {
            for(; n<= 0; n++){
                System.out.println(n);
            }
        }
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n){
        int[] x = new int[n];
        for(int i = 0; i < n; i++){
            x[i] = 3;
        }
        return x;
    }

}
