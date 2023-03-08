package core_java_only.Sorting;

public class Student {

    int rollNo;
    String firstName, lastName, address;

    public Student(int rollNo, String firstName, String lastName, String address) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + firstName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
