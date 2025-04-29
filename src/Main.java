public class Main {

    public static void main(String[] args) {

        EmployeeBook book1 = new EmployeeBook();
        book1.initializationEmployees();
        book1.printEmployees();


        System.out.println("\nСумма затрат на ЗП в месяц = " + book1.salaryCostsInMonth());
        System.out.println("\nСотрудник с наименьшей зарплатой это - " + book1.lookingEmployeeWithLowestSalary());
        System.out.println("\nСотрудник с наибольшей зарплатой это - " + book1.lookingEmployeeWithHighestSalary());
        System.out.println("\nСреднее значение зарплат за месяц =  " + book1.calculateAverageSalaryInMonth());
        System.out.println();
        book1.printFullName();
        System.out.println();
        int percentageOfSalaryIndexation = 10; // Процент индексации ЗП всех сотрудников
        book1.indexingAllSalaries(percentageOfSalaryIndexation);
        book1.printEmployees();

        int targetDepartment = 4; // Номер отдела для анализа
        System.out.println("\n Сотрудник с наименьшей зарплатой в отделе №" + targetDepartment + " это - "
                + book1.lookingEmployeeWithLowestSalaryInDepartment(targetDepartment));
        System.out.println("\n Сотрудник с наибольшей зарплатой в отделе №" + targetDepartment + " это - "
                + book1.lookingEmployeeWithHighestSalaryInDepartment(targetDepartment));

        System.out.println("\nСумма затрат на ЗП в отделе №" + targetDepartment + " в месяц = "
                + book1.salaryCostsInMonthByDepartment(targetDepartment));

        System.out.println("\nСреднее значение зарплат в отделе №" + targetDepartment + " в месяц = "
                + book1.calculateAverageSalaryInMonthByDepartment(targetDepartment));

        book1.printDepartmentEmployees(targetDepartment);
        percentageOfSalaryIndexation = 20; // Процент индексации зп в отделе
        book1.indexingSalariesInDepartment(targetDepartment, percentageOfSalaryIndexation);
        book1.printDepartmentEmployees(targetDepartment);

        int targetSalary = 150000; // число для вывода сотрудников с меньшей и большей или равной этому числу ЗП
        book1.printFilteredEmployeesWithLowestSalary(targetSalary);
        book1.printFilteredEmployeesWithHighestSalary(targetSalary);



       book1.createEmployee("Иванов Иван Иванович",2, 79000);

       book1.deleteEmployee(7);
       book1.deleteEmployee(5);
       System.out.println(" \nРаспечатываем книгу сотрудников с учётом удалённых сотрудников:\n");
       book1.printEmployees();

       book1.createEmployee("Иванов Иван Иванович",3, 99000);
       book1.createEmployee("Иванов Иван Иванович",2, 95000);
       book1.createEmployee("Петров Пётр Петрович",1, 91000);

       System.out.println(" \nРаспечатываем книгу сотрудников с учётом добавленных сотрудников:\n");
       book1.printEmployees();
       book1.printFilteredEmployeeById(book1.searchEmployeeById(3));
    }


}





