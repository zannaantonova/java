package ee.bcs.java.demo.tasks.lesson1.extra;

public class ExtraLesson {

    // TODO täiendada all olevat koodi
    // vaja on vahetada omavahel muutuja a ja b väärtus
    // kasutamata kolmandat muutujat
    public static void main(String[] args) {
        int a = 4;
        int b = 9;
        int c = a; // seda rida ei tohi olla
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);
    }
}
