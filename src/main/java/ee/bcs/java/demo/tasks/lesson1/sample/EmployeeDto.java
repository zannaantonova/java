package ee.bcs.java.demo.tasks.lesson1.sample;

public class EmployeeDto {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public EmployeeDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeDto setAddress(String address) {
        this.address = address;
        return this;
    }
}
