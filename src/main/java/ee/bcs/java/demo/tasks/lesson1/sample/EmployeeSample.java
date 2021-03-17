package ee.bcs.java.demo.tasks.lesson1.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSample {
    static List<Employee> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Sisesta käsklus");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            } else if("createEmployee".equals(line)){
                System.out.println("Palun sisesta töötaja eesnimi");
                String firstName = scanner.nextLine();
                System.out.println("Palun sisesta töötaja perekonna nimi");
                String lastName = scanner.nextLine();
                System.out.println("Palun sisesta töötaja tel nr");
                String phoneNumber = scanner.nextLine();
                list.add(new Employee(firstName, lastName, phoneNumber));
                System.out.println("Sisestati töötaja indeksiga" + (list.size() - 1));
            } else if("getEmployees".equals(line)) {
                System.out.println("Töötajate nimekiri on: ");
                System.out.println(list);
            } else if("deleteEmployee".equals(line)) {
                System.out.println("Sisesta töötaja id");
                list.remove(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Töötaja kustutatud");
            } else {
                System.out.println("Unknown command");
            }
        }
    }

}
