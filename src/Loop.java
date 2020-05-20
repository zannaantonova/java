public class Loop {

    public static void main(String[] args) {

        int i = 0;
        while(i < 10){
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while(i < 10);

        int[] massiiv = { 5, 1, 3, 7, 8 };
        for(int j = 0; j < massiiv.length; j++){
            System.out.println(massiiv[j]);
        }

        for (int element : massiiv) {
            System.out.println(element);
        }


    }
}
