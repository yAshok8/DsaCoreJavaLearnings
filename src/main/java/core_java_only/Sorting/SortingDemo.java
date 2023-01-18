package core_java_only.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDemo {
    public static void main(String[] args) {
        Student s1 = new Student(10, "Amar", "Mumbai");
        Student s2 = new Student(9, "Ujala", "Dehradun");
        Student s3 = new Student(12, "Mia", "Gwalior");
        Student s4 = new Student(6, "Lisa", "Varanasi");

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        System.out.println();

        sortUsingJava7(new ArrayList<>(studentList));
        sortUsingJava8(new ArrayList<>(studentList));
    }

    private static void sortUsingJava7(ArrayList<Student> students) {
        System.out.println("Before sorting");
        students.forEach(s -> System.out.print(s.rollNo + " " + s.name + " | "));
        System.out.println("\nSort using roll number");
        students.sort(new SortStudByRoll());
        students.forEach(s -> System.out.print(s.rollNo + " " + s.name + " | "));
    }

    private static void sortUsingJava8(ArrayList<Student> students) {
        System.out.println("\n\nBefore sorting");
        students.forEach(s -> System.out.print(s.rollNo + " " + s.name + " | "));
        System.out.println("\nSort using Name");
        List<Student> sortedStudentsByName = students.stream()
                .sorted(Comparator.comparing(student -> student.name))
                .collect(Collectors.toList());
        sortedStudentsByName.forEach(s -> System.out.print(s.rollNo + " " + s.name + " | "));
    }



}
