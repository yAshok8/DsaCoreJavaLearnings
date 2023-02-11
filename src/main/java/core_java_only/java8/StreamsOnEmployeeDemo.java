package core_java_only.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsOnEmployeeDemo {
    public static void main(String[] args) {
        List<Employee> empList = getEmployees();
        //getEmployee with highest salary
        getHighestSalaryEmpl(empList);

    }

    private static void getHighestSalaryEmpl(List<Employee> empList) {
        Optional<Employee> maxSalEmployee = empList
                .stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("The employee with maxSalary : " + maxSalEmployee.get());
    }

    private static List<Employee> getEmployees() {
        Employee emp1 = new Employee(1, "Ashok", 10000000, "Mira Road", "Backend Developer");
        Employee emp2 = new Employee(4, "Mukesh", 1300000, "Kandivali", "Mechanical");
        Employee emp3 = new Employee(3, "Vinod", 6000000, "Swedwn", "Consulting");
        Employee emp4 = new Employee(2, "Jayesh", 4800000, "Nallasopara", "Full Stack Developer");
        return Arrays.asList(emp1, emp2, emp3, emp4);
    }
}
