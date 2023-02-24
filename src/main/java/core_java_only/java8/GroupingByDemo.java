package core_java_only.java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Ashok", 1, 30, "Mumbai");
        Student s2 = new Student("Mukesh", 2, 32, "Banglore");
        Student s3 = new Student("jayesh", 3, 32, "Lucknow");
        Student s4 = new Student("Ashok", 4, 18, "Banglore");
        Student s5 = new Student("kashyap", 5, 30, "Mumbai");
        Student s6 = new Student("Ashok", 6, 35, "Chennai");
        Student s7 = new Student("pooja", 7, 18, "Chennai");
        Student s8 = new Student("Definate", 8, 15, "Banglore");
        Student s9 = new Student("Tengent", 10, 20, "Mumbai");
        Student s10 = new Student("Parpendicular", 9, 24, "Lucknow");
        Student s11 = new Student("Sardaar Khan", 12, 30, "Mumbai");
        Student s12 = new Student("Faizal", 11, 24, "Chennai");

        List<Student> studentList = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12);


        toMapDemo(studentList);
        simpleGroupingBy(studentList);
        groupingByNonList(studentList);
        groupingByReducingDemo(studentList);

        //find sorted student names per city
        groupingByCityAndSortedStudentObjects(studentList);
        groupingByCityAndSortedStudentNames(studentList);

        groupingByAgeClass(studentList);
        multilevelGrouping(studentList);
    }

    /**
     * Group as per the city and age class
     * @param studentList the input
     */
    private static void multilevelGrouping(List<Student> studentList) {
        System.out.println("\nGroup with city names and then find population corresponding to various age class");
        Map<String, Map<String, Long>> multilevel = studentList.stream()
                .collect(Collectors.groupingBy(Student::getCity, Collectors.groupingBy(student -> {
                    if (student.getAge() < 20) {
                        return "Young";
                    } else if (student.getAge() <= 20 || student.getAge() < 30) {
                        return "Mid";
                    } else {
                        return "Old";
                    }
                }, Collectors.counting())));
        System.out.println(multilevel);
    }

    /**
     * Classify the students list depending upon the age.
     * < 20 : "Young"
     * <= 20 < 30: "Mid"
     * <= 30: "Old"
     * @param studentList input
     */
    private static void groupingByAgeClass(List<Student> studentList) {
        Map<String, List<String>> ageClassMap = studentList.stream().collect(Collectors.groupingBy(
                student -> {
                    if (student.getAge() < 20) {
                        return "Young";
                    } else if (student.getAge() <= 20 || student.getAge() < 30) {
                        return "Mid";
                    } else {
                        return "Old";
                    }
                }, Collectors.mapping(Student::getName, Collectors.toList())
        ));
        System.out.println(ageClassMap);
    }

    private static void groupingByCityAndSortedStudentNames(List<Student> studentList) {
        System.out.println("\nFind student city to sorted name list map");
        Map<String, List<String>> ans1 = studentList.stream()
                .collect(groupingBy(Student::getCity, Collectors.mapping(Student::getName, Collectors.toList())));
        ans1.values().forEach(list -> list.sort(Comparator.naturalOrder()));
        System.out.println(ans1);
    }

    /**
     * Get Map of city and List.
     * Each list should be sorted in ascending order of city names.
     * @param studentList the input
     */
    private static void groupingByCityAndSortedStudentObjects(List<Student> studentList) {
        System.out.println("\nFind student names map with sorted cities");
        //use this to solve this issue.
        //https://stackoverflow.com/questions/35872236/sorting-lists-after-groupingby

        //perform groupBy operation
        Map<String, List<Student>> studentMapList = studentList.stream()
                .collect(Collectors.groupingBy(Student::getCity));
        studentMapList.values().forEach(list -> list.sort(Comparator.comparing(Student::getName)));
        System.out.println(studentMapList);
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
     * Instead of list, you want a set
     * @param studentList the input
     */
    private static void groupingByNonList(List<Student> studentList) {
        System.out.println("\nName to set mapping with groupingBy()");
        Map<String, Set<Student>> ans = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.toSet()));
        System.out.println(ans);
    }


    /**
     * Suppose you want map of age and name of the students
     * @param studentList the input
     */
    private static void groupingByReducingDemo(List<Student> studentList) {
        System.out.println("\nAge to List<Name> mapping with groupingBy()");
        Map<Integer, List<String>> res = studentList
                .stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(res);
    }



}
