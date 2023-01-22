package core_java_only.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByDemo {
    public static void main(String[] args) {
        Student s1 = new Student("ashok", 1, 30);
        Student s2 = new Student("mukesh", 2, 32);
        Student s3 = new Student("jayesh", 3, 32);
        Student s4 = new Student("ashok", 4, 18);
        Student s5 = new Student("kashyap", 5, 30);
        Student s6 = new Student("ashok", 6, 35);
        Student s7 = new Student("pooja", 7, 18);

        List<Student> studentList = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);

        toMapDemo(studentList);
        simpleGroupingBy(studentList);
        groupingByReducingDemo(studentList);

        //collectors.mapping()
    }

    private static void toMapDemo(List<Student> studentList) {
        System.out.println("\nInt (roll num) to String (Name) mapping with toMap()");
        //to create a map of id with student name
        Map<Integer, String> id_name = studentList
                .stream()
                .collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println(id_name);
    }

    /**
     * Simple grouping by always gives Map<T, List<> in return.
     * @param students the input
     */
    private static void simpleGroupingBy(List<Student> students) {
        System.out.println("\nName to list mapping with groupingBy()");
        Map<String, List<Student>> nameGroup =
                students.stream().collect(groupingBy(Student::getName));
        for (Map.Entry<String, List<Student>> student: nameGroup.entrySet()) {
            System.out.println(student);
        }
    }

    /**
     * Suppose you want map of age and name of the students
     * @param studentList
     */
    private static void groupingByReducingDemo(List<Student> studentList) {
        System.out.println("\nAge to List<Name> mapping with groupingBy()");
        Map<Integer, List<String>> res = studentList
                .stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(res);
    }



}
