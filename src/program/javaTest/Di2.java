package program.javaTest;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Di2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10));
        students.add(new Student(18));
        students.add(new Student(15));
        Collections.sort(students);
        System.out.println(students.get(1).age);
    }
}



class Student implements Comparable<Student>{
    Integer age;

    public Student(Integer age) {
        this.age = age;
        long l = (long) Math.pow(2,2);
    }

    @Override
    public int compareTo(Student o) {
        return o.age.compareTo(this.age);
    }
}
