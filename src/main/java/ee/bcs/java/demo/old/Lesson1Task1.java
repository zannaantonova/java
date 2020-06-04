public class Lesson1Task1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = -3;
        // + - * /
        System.out.println(a*c+c);
        int minValu = min(a,b);
        System.out.println(minValu);
        System.out.println(min(a, b));
        System.out.println(abs(c));
    }

    // leia 2 arvu miinimum väärtus
    private static int min(int a, int b) {
        if(a < b){
            return a;
        } else {
            return b;
        }
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
