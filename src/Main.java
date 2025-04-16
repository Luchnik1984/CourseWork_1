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
        System.out.println("\nСреднее значение зарплат за месяц =  " + calculateAverageSalaryInMonth());
        System.out.println();
        printFullName();
        int percentageOfSalaryIndexation = 10; // Процент индексации ЗП всех сотрудников
        indexingAllSalaries(percentageOfSalaryIndexation);
        printEmployees();

        int targetDepartment = 4; // Номер отдела для анализа
        System.out.println("\n Сотрудник с наименьшей зарплатой в отделе №" + targetDepartment + " это - "
                + lookingEmployeeWithLowestSalaryInDepartment(targetDepartment));
        System.out.println("\n Сотрудник с наибольшей зарплатой в отделе №" + targetDepartment + " это - "
                + lookingEmployeeWithHighestSalaryInDepartment(targetDepartment));

        System.out.println("\nСумма затрат на ЗП в отделе №" + targetDepartment + " в месяц = "
                + salaryCostsInMonthByDepartment(targetDepartment));

        System.out.println("\nСреднее значение зарплат в отделе №" + targetDepartment + " в месяц = "
                + calculateAverageSalaryInMonthByDepartment(targetDepartment));

        printDepartmentEmployees(targetDepartment);
        percentageOfSalaryIndexation = 20; // Процент индексации зп в отделе
        indexingSalariesInDepartment(targetDepartment, percentageOfSalaryIndexation);
        printDepartmentEmployees(targetDepartment);
        int targetSalary = 150000; // число для вывода сотрудников с меньшей и большей или равной этому числу ЗП
        printFilteredEmployeesWithLowestSalary(targetSalary);
        printFilteredEmployeesWithHighestSalary(targetSalary);

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

    private static double calculateAverageSalaryInMonth() {

        return salaryCostsInMonth() / EMPLOYEES.length;
    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

    private static void indexingAllSalaries(double indexPercentage) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary(Math.ceil(employee.getSalary() * (1 + (indexPercentage) / 100)));
        }
    }

    private static Employee lookingEmployeeWithLowestSalaryInDepartment(int departmentNumber) {
        Employee employeeWithLowestSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithLowestSalary == null || employee.getSalary() < employeeWithLowestSalary.getSalary()) {
                    employeeWithLowestSalary = employee;
                }
            }
        }

        return employeeWithLowestSalary;
    }

    private static Employee lookingEmployeeWithHighestSalaryInDepartment(int departmentNumber) {
        Employee employeeWithHighestSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithHighestSalary == null || employee.getDepartment() == departmentNumber && employee.getSalary() > employeeWithHighestSalary.getSalary()) {
                    employeeWithHighestSalary = employee;
                }
            }
        }
        return employeeWithHighestSalary;
    }

    private static double salaryCostsInMonthByDepartment(int departmentNumber) {
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    private static double calculateAverageSalaryInMonthByDepartment(int departmentNumber) {
        int employeeInDepartment = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employeeInDepartment++;
            }
        }
        return salaryCostsInMonthByDepartment(departmentNumber) / employeeInDepartment;
    }


    private static void indexingSalariesInDepartment(int departmentNumber, double indexPercentage) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employee.setSalary(Math.ceil(employee.getSalary() * (1 + (indexPercentage) / 100)));
            }
        }
    }

    private static void printDepartmentEmployees(int department) {
        System.out.println("\nОтдел №" + department);
        boolean found = false;

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id:" + employee.getId() + " | " + employee.getFullName() + " | зарплата = " + employee.getSalary());
                found = true;
            }
        }
        if (!found) {
            System.out.println("В отделе №" + department + " нет сотрудников.");
        }
    }

    private static void printFilteredEmployeesWithLowestSalary(int salary) {
        System.out.println("\nПоиск сотрудников  с зарплатой меньше " + salary + " :");

        boolean found = false;

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("id:" + employee.getId() + " | " + employee.getFullName() + " | зарплата = " + employee.getSalary());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Сотрудников с зарплатой меньше " + salary + " не найдено");
        }
    }

    private static void printFilteredEmployeesWithHighestSalary(int salary) {
        System.out.println("\nПоиск сотрудников  с зарплатой больше или равной " + salary + " :");

        boolean found = false;

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("id:" + employee.getId() + " | " + employee.getFullName() + " | зарплата = " + employee.getSalary());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Сотрудников с зарплатой больше или равной " + salary + " не найдено.");
        }
    }
}





