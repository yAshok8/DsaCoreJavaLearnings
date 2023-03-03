package core_java_only.java8.functional_interface;

import core_java_only.java8.Employee;

@FunctionalInterface
public interface EmployeeServiceInterface {
    public Employee getEmployeeById(int id);
}
