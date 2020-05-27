package ee.bcs.java.sample;

public class BoxingSample {
    // Bad sample, but never compare objects with ==
    public static void main(String[] args) {
        Integer a = new Integer("5");
        Integer b = new Integer("5");
        int c = a;
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
