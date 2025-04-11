import java.util.Random;

public class Main {

    private final static Employee[] EMPLOYEES = new Employee[10];

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Сергей", "Иван", "Владимир", "Фёдор", "Степан"};
    private final static String[] PATRONYMICS = {"Иванович", "Петрович", "Сергеевич", "Ильич", "Кузьмич"};
    private final static String[] SURNAMES = {"Петров", "Ленин", "Иванов", "Сидоров", "Ильф"};

    private final static int[] DEPARTMENTS = {1, 2, 3, 4, 5};

    static void initializationEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {

            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMICS[RANDOM.nextInt(0, PATRONYMICS.length)];

            int department = DEPARTMENTS[RANDOM.nextInt(0, DEPARTMENTS.length)];

            double salary = RANDOM.nextInt(50_000, 100_000);

            EMPLOYEES[i] = new Employee(fullName, department, salary);
        }
    }

    public static void main(String[] args) {
        initializationEmployees();
        printEmployees();
        System.out.println("\nСумма затрат на ЗП в месяц = " + salaryCostsInMonth());
        System.out.println("\nСотрудник с наименьшей зарплатой это - " + lookingEmployeeWithLowestSalary());
        System.out.println("\nСотрудник с наибольшей зарплатой это - " + lookingEmployeeWithHighestSalary());
        System.out.println("\nСреднее значение зарплат за месяц =  " + CalculateAverageSalaryInMonth());
        System.out.println();
        printFullName();

    }

    private static void printEmployees() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static double salaryCostsInMonth() {
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee lookingEmployeeWithLowestSalary() {
        Employee employeeWithLowestSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithLowestSalary == null || employee.getSalary() < employeeWithLowestSalary.getSalary()) {
                employeeWithLowestSalary = employee;
            }
        }
        return employeeWithLowestSalary;
    }

    private static Employee lookingEmployeeWithHighestSalary() {
        Employee employeeWithHighestSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithHighestSalary == null || employee.getSalary() > employeeWithHighestSalary.getSalary()) {
                employeeWithHighestSalary = employee;
            }
        }
        return employeeWithHighestSalary;
    }

    private static double CalculateAverageSalaryInMonth() {

        return salaryCostsInMonth() / EMPLOYEES.length;
    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }


}