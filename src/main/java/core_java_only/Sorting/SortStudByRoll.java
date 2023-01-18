package core_java_only.Sorting;

import java.util.Comparator;

class SortStudByRoll implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
            return o1.rollNo - o2.rollNo;
        }
}
