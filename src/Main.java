
import java.util.ArrayList;
import java.util.List;
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

        int targetDepartment = 5; // Номер отдела для анализа
        Employee[] employeesInDepartment = filterByDepartment(targetDepartment);

        System.out.println("\n Сотрудник с наименьшей зарплатой в отделе №"+targetDepartment+" это - "
                +lookingEmployeeWithLowestSalaryInDepartment(List.of(employeesInDepartment)));
        System.out.println("\n Сотрудник с наибольшей зарплатой в отделе №"+targetDepartment+" это - "
                +lookingEmployeeWithHighestSalaryInDepartment(List.of(employeesInDepartment)));

        System.out.println("\nСумма затрат на ЗП в отделе №"+targetDepartment+" в месяц = "
                +salaryCostsInMonthByDepartment(List.of(employeesInDepartment)));

        System.out.println("\nСреднее значение зарплат в отделе №"+targetDepartment+" в месяц = "
                +calculateAverageSalaryInMonthByDepartment(List.of(employeesInDepartment)));


        percentageOfSalaryIndexation = 20; // Процент индексации зп в отделе
        indexingSalariesInDepartment(List.of(employeesInDepartment),percentageOfSalaryIndexation);
        printDepartmentEmployees(targetDepartment, List.of(employeesInDepartment));

        int targetSalary = 75000; // число для вывода сотрудников с меньшей и большей или равной этому числу ЗП

        printFilteredEmployeesWithLowestSalary(List.of(filterWithLowestSalary(targetSalary)), targetSalary);
        printFilteredEmployeesWithHighestSalary(List.of(filterWithHighestSalary(targetSalary)),targetSalary);



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

    private static void indexingAllSalaries(double index) {
                      for (Employee employee : EMPLOYEES) {
            employee.setSalary(Math.ceil(employee.getSalary() * (1 + (index) / 100)));
        }
    }

    private static Employee[] filterByDepartment( int numberDepartment) {
        List<Employee> filteredEmployees = new ArrayList<>();
                  for (Employee employee : EMPLOYEES) {
                if (employee != null && employee.getDepartment() == numberDepartment) {
                    filteredEmployees.add(employee);
                }
            }
              return filteredEmployees.toArray(new Employee[0]);
    }

    private static Employee lookingEmployeeWithLowestSalaryInDepartment(List<Employee> employeesInDepartment) {
        Employee employeeWithLowestSalary = null;
        for (Employee employee : employeesInDepartment) {
            if (employeeWithLowestSalary == null || employee.getSalary() < employeeWithLowestSalary.getSalary()) {
                employeeWithLowestSalary = employee;
            }
        }
        return employeeWithLowestSalary;
    }

    private static Employee lookingEmployeeWithHighestSalaryInDepartment(List<Employee> employeesInDepartment) {

                    Employee employeeWithHighestSalary = null;
            for (Employee employee : employeesInDepartment) {
                if (employeeWithHighestSalary == null || employee.getSalary() > employeeWithHighestSalary.getSalary()) {
                    employeeWithHighestSalary = employee;
                }
            }
            return employeeWithHighestSalary;
        }

    private static double salaryCostsInMonthByDepartment(List<Employee> employeesInDepartment) {
        double sum = 0;
        for (Employee employee : employeesInDepartment) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static double calculateAverageSalaryInMonthByDepartment(List<Employee> employeesInDepartment) {
               if (!employeesInDepartment.isEmpty()){
        return salaryCostsInMonthByDepartment(employeesInDepartment) / employeesInDepartment.size();}
        return 0;
    }

    private static void indexingSalariesInDepartment(List<Employee> employeesInDepartment,double index) {
                 for (Employee employee : employeesInDepartment) {
            employee.setSalary(Math.ceil(employee.getSalary() * (1 + (index) / 100)));
        }
    }


    public static void printDepartmentEmployees(int targetDepartment, List<Employee> employeesInDepartment) {
        System.out.println("\nОтдел №" + targetDepartment);
        if (employeesInDepartment != null && !employeesInDepartment.isEmpty()) {
            for (Employee employee : employeesInDepartment) {
                System.out.println("id:" + employee.getId() + " | " + employee.getFullName() + " | зарплата = " + employee.getSalary());
            }
        } else {
            System.out.println("В отделе №" + targetDepartment + " нет сотрудников.");
        }
    }


    private static Employee[] filterWithLowestSalary( int salary) {
        List<Employee> filteredEmployees = new ArrayList<>();
       // if (EMPLOYEES!=null)
        {
            for (Employee employee : EMPLOYEES) {
                if (employee != null && employee.getSalary() <salary) {
                    filteredEmployees.add(employee);
                }
            }
        }
        return filteredEmployees.toArray(new Employee[0]);
    }

    private static void printFilteredEmployeesWithLowestSalary( List<Employee> filteredEmployees, int salary) {
        System.out.println("\nПоиск сотрудников  с зарплатой меньше "+salary+" :");
        if (filteredEmployees != null && !filteredEmployees.isEmpty()) {
            for (Employee employee : filteredEmployees) {
                System.out.println("id:" + employee.getId() + " | " + employee.getFullName() + " | зарплата = " + employee.getSalary());
            }
        } else {
            System.out.println("\nСотрудников, с зарплатой, удовлетворяющей параметрам поиска, не нашлось");
        }
    }

    private static Employee[] filterWithHighestSalary( int salary) {
        List<Employee> filteredEmployees = new ArrayList<>();
        //if (EMPLOYEES!=null)
        {
            for (Employee employee : EMPLOYEES) {
                if (employee != null && employee.getSalary() >=salary) {
                    filteredEmployees.add(employee);
                }
            }
        }
        return filteredEmployees.toArray(new Employee[0]);
    }

    private static void printFilteredEmployeesWithHighestSalary( List<Employee> filteredEmployees, int salary) {
        System.out.println("\nПоиск сотрудников  с зарплатой больше или равной "+salary+" :");
        if (filteredEmployees != null && !filteredEmployees.isEmpty()) {
            for (Employee employee : filteredEmployees) {
                System.out.println("id:" + employee.getId() + " | " + employee.getFullName() + " | зарплата = " + employee.getSalary());
            }
        } else {
            System.out.println("\nСотрудников, с зарплатой, удовлетворяющей параметрам поиска, не нашлось");
        }
    }
}





