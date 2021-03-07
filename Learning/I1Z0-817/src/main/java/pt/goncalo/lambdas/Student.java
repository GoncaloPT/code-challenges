package pt.goncalo.lambdas;

public class Student {
    private final String name;
    private double mark;

    public Student(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student(String name) {
        this.name = name;
    }

    double getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
