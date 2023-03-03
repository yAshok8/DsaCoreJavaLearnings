package core_java_only.java8.functional_interface;

import core_java_only.java8.Employee;

public class EmployeeServiceDemo {
    public static void main(String[] args) {
        EmployeeServiceInterface lambda = (int num) -> new Employee(num, "Ashok", 20000, "Mira Road", "Tech");
        Employee emp1 = getMeEmployee(22, lambda);
        System.out.println(emp1);
    }

    private static Employee getMeEmployee(int empId, EmployeeServiceInterface lambda) {
        return lambda.getEmployeeById(empId);
    }
}
