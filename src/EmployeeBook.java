import java.util.Random;

public class EmployeeBook {
    private final Employee[] EMPLOYEES;

    private final  Random RANDOM = new Random();
    private final  String[] NAMES = {"Сергей", "Иван", "Владимир", "Фёдор", "Степан"};
    private final  String[] PATRONYMICS = {"Иванович", "Петрович", "Сергеевич", "Ильич", "Кузьмич"};
    private final  String[] SURNAMES = {"Петров", "Ленин", "Иванов", "Сидоров", "Ильф"};

    private final static int[] DEPARTMENTS = {1, 2, 3, 4, 5};

    public EmployeeBook() {
        this.EMPLOYEES = new Employee[10];
    }

    public void initializationEmployees() {


        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i]==null) {

                String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                        NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                        PATRONYMICS[RANDOM.nextInt(0, PATRONYMICS.length)];

                int department = DEPARTMENTS[RANDOM.nextInt(0, DEPARTMENTS.length)];

                double salary = RANDOM.nextInt(50_000, 100_000);

                EMPLOYEES[i] = new Employee(fullName, department, salary);
            }
        }
    }

     void printEmployees() {

         for (Employee employee : EMPLOYEES) {
             if (employee==null) {
                 System.out.println("Сотрудников нет");
                 return;
             }
        }
        for (Employee employee : EMPLOYEES) {
            if (employee!=null){
            System.out.println(employee);
                        }
        }
    }

    double salaryCostsInMonth() {
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

     Employee lookingEmployeeWithLowestSalary() {
        Employee employeeWithLowestSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithLowestSalary == null || employee.getSalary() < employeeWithLowestSalary.getSalary()) {
                employeeWithLowestSalary = employee;
            }
        }
        return employeeWithLowestSalary;
    }

    Employee lookingEmployeeWithHighestSalary() {
        Employee employeeWithHighestSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithHighestSalary == null || employee.getSalary() > employeeWithHighestSalary.getSalary()) {
                employeeWithHighestSalary = employee;
            }
        }
        return employeeWithHighestSalary;
    }


   double calculateAverageSalaryInMonth() {

        return salaryCostsInMonth() / EMPLOYEES.length;
    }

    void indexingAllSalaries(double indexPercentage) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary(Math.ceil(employee.getSalary() * (1 + (indexPercentage) / 100)));
        }
    }


    Employee lookingEmployeeWithLowestSalaryInDepartment(int departmentNumber) {
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


    Employee lookingEmployeeWithHighestSalaryInDepartment(int departmentNumber) {
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


    double salaryCostsInMonthByDepartment(int departmentNumber) {
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    double calculateAverageSalaryInMonthByDepartment(int departmentNumber) {
        int employeeInDepartment = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employeeInDepartment++;
            }
        }
        return salaryCostsInMonthByDepartment(departmentNumber) / employeeInDepartment;
    }


    void indexingSalariesInDepartment(int departmentNumber, double indexPercentage) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employee.setSalary(Math.ceil(employee.getSalary() * (1 + (indexPercentage) / 100)));
            }
        }
    }

    void printDepartmentEmployees(int department) {
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


    void printFilteredEmployeesWithLowestSalary(int salary) {
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


     void printFilteredEmployeesWithHighestSalary(int salary) {
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

    void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

    private boolean findFreeIndex() {
        for (Employee employee : EMPLOYEES) {
            if (employee == null) return true;
        }
        return false;
    }

    private boolean isNameAlreadyExists(String fullName) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                return true;
            }
        }
        return false;
    }

    public void createEmployee(String fullName, int department, int salary){
        if (isNameAlreadyExists(fullName)) {
            System.out.println("\nСотрудник с именем " + fullName + " уже существует.");
            return;
        }

        if (findFreeIndex()) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {
                EMPLOYEES[i] = new Employee(fullName, department, salary);
                return;
            }
            }

            }else {
            System.out.println("Вакантных мест нет. "+fullName+" не может быть нанят на работу.");
        }
    }

    public void deleteEmployee(int id){

        for (int i = 0; i< EMPLOYEES.length; i++)
            if (EMPLOYEES[i]!=null && id == EMPLOYEES[i].getId()) {
                EMPLOYEES[i] = null;
            }

    }

    public Employee searchEmployeeById (int id){
        Employee seachingEmployee = null;
            for (Employee employee:EMPLOYEES){
            if (employee!=null&& employee.getId()==id){
               seachingEmployee = employee;
            }
        } return seachingEmployee;
            }


    public void printFilteredEmployeeById(Employee employee) {
        if (employee == null) {
            System.out.println("Сотрудник не найден");
        } else {
            System.out.println(employee);
        }
    }
}
