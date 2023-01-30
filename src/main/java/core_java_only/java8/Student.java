package core_java_only.java8;

public class Student {

    private String name;
    private int id;
    private int age;

    private String city;

    public Student(String name, int id, int age, String city) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
