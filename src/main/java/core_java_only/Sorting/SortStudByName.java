package core_java_only.Sorting;

import java.util.Comparator;

class SortStudByName implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.firstName.compareTo(o2.firstName);
        }
    }
