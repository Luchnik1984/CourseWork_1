
import java.util.Objects;

public class Employee {

    private static int idCounter = 1;

    private final int id;
    private final String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        id = idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getDepartment() == employee.getDepartment() && getSalary() == employee.getSalary() && getId() == employee.getId() && Objects.equals(getFullName(), employee.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getDepartment(), getSalary(), getId());
    }

    @Override
    public String toString() {
        return
                "id:" + id +
                        " | " + fullName + " |" +
                        " департамент №" + department + " |" +
                        " зарплата = " + salary +
                        ';';
    }
}
