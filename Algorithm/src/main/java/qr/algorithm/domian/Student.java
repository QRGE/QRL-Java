package qr.algorithm.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @Author: QR
 * @Date: 2021/7/28-15:04
 */
@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{

    private int score;
    private int age;


    @Override
    public int compareTo(@NotNull Student s) {
        return age - s.age;
    }
}
