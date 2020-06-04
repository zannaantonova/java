package ee.bcs.java.demo.old.sample;

public class SampleLesson4 {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }

        int i = 0;
        while(i < 10){
            System.out.println(i);
            i++;
        }

        int x = alamfunktsioon();
        System.out.println(x);

        int[] massiiv = new int[10];
        massiiv[0] = 4;
        massiiv[1] = 5;
        massiiv[2] = 2;
        System.out.println(massiiv[0] + massiiv[1] + massiiv[2]);
    }

    private static int alamfunktsioon() {
        return 0;
    }
}
