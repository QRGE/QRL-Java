package qr.algorithm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: QR
 * @Date: 2021/7/28-15:04
 */
@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{

    private int score;
    private int age;

    private String name;

    public Student(int score, int age) {
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        return age - s.age;
    }
}
