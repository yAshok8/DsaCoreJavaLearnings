package core_java_only.Sorting;

import core_java_only.java8.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class SortingDemo {
    public static void main(String[] args) {
        Student s1 = new Student(10, "Amar", "Verma", "Mumbai");
        Student s2 = new Student(9, "Ujala", "Chauhan", "Dehradun");
        Student s3 = new Student(12, "Mia", "Chaudhary", "Gwalior");
        Student s4 = new Student(6, "Lisa", "Gupta", "Varanasi");
        Student s5 = new Student(6, "Lisa", "Bakshi", "Varanasi");
        Student s6 = new Student(6, "Mia", "Bakshi", "Varanasi");

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        System.out.println();

//        sortUsingJava7(new ArrayList<>(studentList));
//        sortUsingJava8(new ArrayList<>(studentList));
//        sortUsingJava8TwoFields(new ArrayList<>(studentList));
        sortStringsCaseInsensitive();
    }

    private static void sortStringsCaseInsensitive() {
        List<String> list = Arrays.asList("Pineapple", "apple", "banana");
        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
    }

    private static void sortUsingJava8TwoFields(ArrayList<Student> students) {
        Comparator<Student> firstNameComparator = Comparator.comparing(Student::getFirstName);
        Comparator<Student> lastNameComparator = Comparator.comparing(Student::getLastName);
        Comparator<Student> fullNameComparison = firstNameComparator.thenComparing(lastNameComparator);
        students.sort(fullNameComparison);
        students.forEach(student -> {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        });

    }

    private static void sortUsingJava7(ArrayList<Student> students) {
        System.out.println("Before sorting");
        students.forEach(s -> System.out.print(s.rollNo + " " + s.firstName + " | "));
        System.out.println("\nSort using roll number");
        students.sort(new SortStudByRoll());
        students.forEach(s -> System.out.print(s.rollNo + " " + s.firstName + " | "));
    }

    private static void sortUsingJava8(ArrayList<Student> students) {
        System.out.println("\n\nBefore sorting");
        students.forEach(s -> System.out.print(s.rollNo + " " + s.firstName + " | "));
        System.out.println("\nSort using Name");
        List<Student> sortedStudentsByName = students.stream()
                .sorted(Comparator.comparing(student -> student.firstName))
                .collect(Collectors.toList());
        sortedStudentsByName.forEach(s -> System.out.print(s.rollNo + " " + s.firstName + " | "));
    }



}
