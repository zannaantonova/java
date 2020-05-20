public class Lesson1Task2 {
    public static void main(String[] args) {
        int a = -5;
        int b = 6;
        int c = 0;

        int aMin = abs(a);
        System.out.println(aMin);
        int bMin = abs(b);
        System.out.println(bMin);
        int cMin = abs(c);
        System.out.println(cMin);
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
