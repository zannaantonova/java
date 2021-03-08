package ee.bcs.java.demo.tasks.lesson1.sample;

public class ArraySample {
    public static void main(String[] args) {
        int y = 4;
        int[] x = new int[y];
        if(x[0] == 0){
            x[0] = 4;
            x[0]++;
        }
        System.out.println(x.length);
        System.out.println(x[0]);
    }
}
