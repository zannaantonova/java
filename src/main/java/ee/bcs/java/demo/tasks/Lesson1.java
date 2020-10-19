package ee.bcs.java.demo.tasks;

public class Lesson1 {
    public static void main(String[] args) {
        System.out.println(min(12, 3));
        System.out.println(abs(-8));
    }

    // leia 2 arvu miinimum väärtus
    // Näited:
    // min (3, 5) = 3
    // min (-3, 8) = -3
    private static int min(int a, int b) {
        return 0;
    }

    // TODO: Leia arvu absoluutväärtus
    // Näited:
    // abs(3) = 3
    // abs(-5) = 5
    private static int abs(int x) {
        return 0;
    }

    // TODO: Luua funktsioon, mis tagastab vastava arvu alati negatiivsena
    // Näited:
    // neg(0) = 0
    // neg(-1) = -1
    // neg(8) = -8
    public static int neg(int x){
        return 0;
    }

    // TODO: Luua funktsioon mis leiab sisend muutujates numbri mis on kõige lähemal 0-ile
    // Näited
    // (-5, -2, 0) -> 0
    // (2, 3, 4) -> 2
    public static int closestToZero(int a, int b, int c){
        return 0;
    }

    // TODO: Luua funktsioon, mis tagastab kas a on paaris arv
    // Näited
    // isNumberEven(4) = true
    // isNumberEven(1) = false
    public boolean isNumberEven(int a){
        return true;
    }

    // TODO: Luua funktsioon, mis
    // Juhul kui a on paaris arv, siis jaga sisend 2
    // Juhul kui a on paaritu arv, siis korruta sisend 3 ja liida 1
    public int seq3n(int a){
        return 0;
    }
}
