package ee.bcs.java.demo.tasks.lesson1.sample.employee;

public class SolutionEmployee {
    private Integer id;
    private String firstName;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public SolutionEmployee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SolutionEmployee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SolutionEmployee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
