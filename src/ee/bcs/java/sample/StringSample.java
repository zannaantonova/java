package ee.bcs.java.sample;

public class StringSample {
    public static void main(String[] args) {
        String a = "Hello World ";
        System.out.println(a.substring(2));
        System.out.println(a.substring(1,2));
        System.out.println(a.toLowerCase());
        System.out.println(a.toUpperCase());
        System.out.println(a.getBytes());
        System.out.println(a.trim());
        System.out.println(a.startsWith("Hello"));
        System.out.println(a.equalsIgnoreCase("hello world "));
        System.out.println(a.split("W"));
    }
}
