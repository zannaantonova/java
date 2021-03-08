package ee.bcs.java.demo.tasks.lesson1.sample;

public class LoopSamples {
    public static void main(String[] args) {
        int[] sisend = {2, 5, 7, 3, 5, 7, 2, 7, 2, 6, 1, 9};

        int x = 0;
        double sum = 0;
        while(x < sisend.length){
            sum += Math.sqrt(sisend[x]);
            x++;
        }
        System.out.println(sum);

        double sum2 = 0;
        for(int i = 0; i < sisend.length; i++){
            sum2 += Math.sqrt(sisend[i]);
        }
        System.out.println(sum2);

        double sum3 = 0;
        for (int i : sisend) {
            sum3 += Math.sqrt(i);
        }
        System.out.println(sum3);

        int y = 0;
        while(true){
            y++;
            if(y % 2 == 0){
                continue;
            }
            System.out.println(y);
            if(y > 9){
                break;
            }
        }
    }
}
