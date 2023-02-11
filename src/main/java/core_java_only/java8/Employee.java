package core_java_only.java8;

public class Employee {

    private int empId;
    private String empName;
    private double salary;
    private String address;
    private String department;

    public Employee(int empId, String empName, double salary, String address, String department) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.address = address;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
