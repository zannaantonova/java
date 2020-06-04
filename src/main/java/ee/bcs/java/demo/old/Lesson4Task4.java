public class Lesson4Task4 {
    public static void main(String[] args) {
        StaticVariableTest a = new StaticVariableTest("a", "b");
        StaticVariableTest b = new StaticVariableTest("c", "d");
        a.printVariables();
        b.printVariables();
        System.out.println(a.a);
        System.out.println(a.b);
        System.out.println(StaticVariableTest.b);
        // TODO loe kood läbi pane programm tööle ja selgita kuidas tuleb väljund
    }
}
