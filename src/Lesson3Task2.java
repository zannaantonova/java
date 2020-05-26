// Rekursiooni näide
public class Lesson3Task2 {
    public static void main(String[] args) {
        System.out.println(fibonacci1(5));
        System.out.println(fibonacci2(5));
    }

    // leia nii mitmes arb fibonacci jadas
    // lahenda iteratiivselt
    private static int fibonacci1(int nr) {
        int esimeneElement = 0;
        int teineElement = 1;
        if(nr <= 0){
            return esimeneElement;
        } else if(nr == 1){
            return teineElement;
        } else {
            int eelmine = teineElement;
            int eelmine2 = esimeneElement;
            int uusElement = 0;
            for(int i = 1; i < nr; i++){
                uusElement = eelmine + eelmine2;
                eelmine2 = eelmine;
                eelmine = uusElement;
            }
            return uusElement;
        }
    }

    // leia nii mitmes arb fibonacci jadas
    // lahenda rekursiivselt
    private static int fibonacci2(int nr) {
        if(nr == 0){
            return 0;
        } else if (nr == 1){
            return 1;
        } else {
            return fibonacci2(nr - 1) + fibonacci2(nr - 2);
        }
    }
}
