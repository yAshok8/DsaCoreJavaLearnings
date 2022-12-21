package core_java_only.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByDemo {
    public static void main(String[] args) {
        Student s1 = new Student("ashok", 1);
        Student s2 = new Student("mukesh", 2);
        Student s3 = new Student("jayesh", 3);
        Student s4 = new Student("ashok", 4);
        Student s5 = new Student("kashyap", 5);
        Student s6 = new Student("ashok", 6);
        Student s7 = new Student("ashok", 7);

        List<Student> studentList = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);

        Map<String, List<Student>> nameGroup =
                studentList.stream().collect(groupingBy(Student::getName));

        for (Map.Entry<String, List<Student>> student: nameGroup.entrySet()) {
            System.out.println(student);
        }

        //to create a map of id with student name
        Map<Integer, String> id_name = studentList
                .stream()
                .collect(Collectors.toMap(Student::getId, Student::getName));

        System.out.println(id_name);
    }
}
